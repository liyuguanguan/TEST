package com.ygjt.gdn.ftisp.service.impl;

import com.google.common.base.Preconditions;
import com.ygjt.gdn.ftisp.api.b2s2c.model.GetTokenReq;
import com.ygjt.gdn.ftisp.api.b2s2c.model.GetTokenResp;
import com.ygjt.gdn.ftisp.api.b2s2c.model.RefreshTokenReq;
import com.ygjt.gdn.ftisp.api.b2s2c.model.UserReq;
import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.GetTokenService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.RefreshTokenService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.RegisterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.enums.EmailCodeEnum;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.*;
import com.ygjt.gdn.ftisp.model.Query.RoleQuery;
import com.ygjt.gdn.ftisp.model.Query.UserQuery;
import com.ygjt.gdn.ftisp.model.vo.po.RegisterPO;
import com.ygjt.gdn.ftisp.model.vo.po.SendEmailPO;
import com.ygjt.gdn.ftisp.model.vo.po.UserPwdPO;
import com.ygjt.gdn.ftisp.persistence.*;
import com.ygjt.gdn.ftisp.service.EmailCodeService;
import com.ygjt.gdn.ftisp.service.SystemService;
import com.ygjt.gdn.ftisp.service.UserService;
import com.ygjt.gdn.ftisp.utils.BCryptUtil;
import com.ygjt.gdn.ftisp.utils.DateUtils;
import com.ygjt.gdn.ftisp.utils.StringUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by linx on 2017-04-13.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;
    @Autowired
    AuthSystemDao authSystemDao;
    @Autowired
    EmailCodeService emailCodeService;
    @Autowired
    UserRoleDao userRoleDao;
    @Autowired
    RoleDao roleDao;
    @Autowired
    EntInfoDao entInfoDao;
    @Autowired
    RegisterService registerService;
    @Autowired
    SystemService systemService;
    @Autowired
    GetTokenService getTokenService;
    @Autowired
    RefreshTokenService refreshTokenService;

    @Override
    public boolean hasSystemPermistion(String userName, String requestUrl, String basePath) {
        Preconditions.checkArgument(StringUtils.isNotBlank(userName),"user name cannot be null!");
        UserQuery userQuery = new UserQuery();
        userQuery.createCriteria().andUsernameEqualTo(userName.trim()).andStsEqualTo(Constants.TABLE_STS_YES);
        List<UserDo> userDos = userDao.selectByQuery(userQuery);
        if(CollectionUtils.isNotEmpty(userDos)){
            Integer systemId = userDos.get(0).getSystemId();
            //用户未配置系统默认能登陆所有系统
            if(systemId!=null){
                AuthSystemDo authSystemDo = authSystemDao.selectByPrimaryKey(systemId);
                if(authSystemDo!=null){
                    String systemUrl = authSystemDo.getUrl();
                    if(StringUtils.startsWith(systemUrl,"/")){
                        //网址配置“/”开头的系统比较上下文路径
                        if (!StringUtils.equals(basePath,systemUrl)) {
                            return false;
                        }
                    }else{
                        //其他比较全网址是否以系统配置的网址开头
                        if(!StringUtils.startsWith(requestUrl,systemUrl)){
                            return false;
                        }
                    }
                }
            }
        }else{
            //用户不存在 返回无权限
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public void sendEmail(SendEmailPO po) throws ServiceException {
        //校验请求参数
        validSendEmailPO(po);
        emailCodeService.sendMail(po.getEmail(),po.getMailType());
    }

    /**
     * 业务数据校验
     * @param po
     * @throws ServiceException
     */
    private void validSendEmailPO(SendEmailPO po)  throws ServiceException {
       if(!StringUtil.checkEmail(po.getEmail())){
           throw new ServiceException("邮箱格式有误");
       }
       if(isExistEmail(po.getEmail())&& StringUtils.equals(EmailCodeEnum.TYPE.EMAIL_TYPE_REGISTER.getFront_value(),po.getMailType())){
            throw new ServiceException("该邮箱已注册，请更换邮箱");
       }
       if(!isExistEmail(po.getEmail())&& StringUtils.equals(EmailCodeEnum.TYPE.EMAIL_TYPE_FORGET_PWD.getFront_value(),po.getMailType())){
            throw new ServiceException("该邮箱对应用户未注册，请更换邮箱");
       }

    }

    /**
     * 用户表中是否该邮箱
     * @param email
     * @return
     */
    private boolean isExistEmail(String email) {
        UserDo userDo = getUserByEmail(email);
        if(userDo !=null){
            return  true;
        }else {
            return false;
        }

    }

    @Override
    public EmailCodeDo validEmail(String code) throws ServiceException {
        EmailCodeDo emailCodeDo = emailCodeService.getEmailCodeByCode(code);
        if(emailCodeDo==null){
            throw new ServiceException("邮箱验证失败，请重新发送邮件");
        }
        //失效时间晚于当前时间的数据，且未激活状态
        if(DateUtils.isCodeExpire(emailCodeDo.getExpireDate())){
            throw new ServiceException("邮箱验证码已失效，请重新发送邮件");
        }
        if(!StringUtils.equals(emailCodeDo.getActived(), EmailCodeEnum.ACTIVED.N.name())){
            throw new ServiceException("邮箱验证码已使用，请重新发送邮件");
        }
        return emailCodeDo;
    }

    @Override
    @Transactional
    public void doRegister(RegisterPO po) throws ServiceException{
        EmailCodeDo emailCodeDo = validEmail(po.getCode());
        emailCodeDo.setActived(EmailCodeEnum.ACTIVED.Y.name());
        emailCodeDo.setRecentSendDate(new Date());
        emailCodeService.saveEmaiCode(emailCodeDo);

        if(isExistEmail(emailCodeDo.getEmail())){
            throw new ServiceException("该邮箱已注册，请更换邮箱");
        }
        UserDo userDo =new UserDo();
        userDo.setEmail(emailCodeDo.getEmail());
        userDo.setUsername(emailCodeDo.getEmail());
        userDo.setName(po.getName());
        userDo.setMobile(po.getMobile());
        userDo.setPassword(BCryptUtil.encode2BCryptPassword(po.getPassword()));
        userDo.setCreateDt(new Date());
        userDo.setSts(Constants.TABLE_STS_YES);
        AuthSystemDo authSystem = systemService.getSystemByName(Constants.SYSTEM_FTISP);
        if(authSystem==null){
            throw new ServiceException("系统不存在,系统名为："+Constants.SYSTEM_FTISP);
        }
        userDo.setSystemId(authSystem.getId());
        userDao.insertSelective(userDo);

        RoleQuery example = new RoleQuery();
        example.createCriteria().andRoleNameEqualTo(Constants.ROLE_DEFAULT);
        List<RoleDo> roles = roleDao.selectByQuery(example);
        if(roles != null && roles.get(0) != null){
            UserRoleDo userRole = new UserRoleDo();
            userRole.setRoleId(roles.get(0).getId());
            userRole.setUserId(userDo.getId());
            userRole.setCreateDt(new Date());
            userRole.setCreateBy(userDo.getId());
            userRole.setSts(Constants.TABLE_STS_YES);
            userRoleDao.insertSelective(userRole);
        }

        //如果有企业名称不为空 保存企业信息
        if(StringUtils.isNotBlank(po.getEntName())){
            EntInfoDo ent =new EntInfoDo();
            ent.setName(po.getEntName());
            ent.setFax(po.getFax());
            ent.setType(po.getType());
            entInfoDao.insertSelective(ent);
        }

        //同步用户信息到B2S2C
        UserReq req= new UserReq();
        req.setUsername(userDo.getUsername());
        req.setPassword(po.getPassword());
        req.setEmail(userDo.getEmail());
        Result call = registerService.call(req);
        if(call==null || !Objects.equals(call.getCode(),Constants.RESULT_CODE_SUCCESS)){
            throw  new ServiceException("同步用户信息失败");
        }

        GetTokenReq getTokenReq = new GetTokenReq();
        getTokenReq.setUsername(userDo.getUsername());
        getTokenReq.setPassword(po.getPassword());
        GetTokenResp getTokenResp = getTokenService.call(getTokenReq);
        if(getTokenResp==null || StringUtils.isBlank(getTokenResp.getRefresh_token())){
            throw  new ServiceException("获取refresh_token失败");
        }
        userDo.setRefreshToken(getTokenResp.getRefresh_token());
        userDao.updateByPrimaryKeySelective(userDo);
    }

    @Override
    @Transactional
    public void modifyPwd(UserPwdPO po)throws ServiceException {
        EmailCodeDo emailCodeDo = validEmail(po.getCode());
        emailCodeDo.setActived(EmailCodeEnum.ACTIVED.Y.name());
        emailCodeDo.setRecentSendDate(new Date());
        emailCodeService.saveEmaiCode(emailCodeDo);

        UserDo userDo = getUserByEmail(emailCodeDo.getEmail());
        userDo.setPassword(BCryptUtil.encode2BCryptPassword(po.getPassword()));
        userDao.updateByPrimaryKeySelective(userDo);



    }

    @Override
    public UserDo getUserByEmail(String email) throws ServiceException {
        UserQuery query = new UserQuery();
        query.createCriteria().andEmailEqualTo(email).andStsEqualTo(Constants.TABLE_STS_YES);
        List<UserDo> userDos = userDao.selectByQuery(query);
        if(CollectionUtils.isEmpty(userDos)){
            return null;
        }
        if( userDos.size()>1){
            throw new ServiceException("存在多条用户信息");
        }
        return userDos.get(0);
    }


    @Override
    public UserDo getToken(UserDo userDo) {
        if(userDo==null){
            throw new ServiceException("用户未登陆");
        }
        if(StringUtils.isNotBlank(userDo.getAccessToken()) && new Date().before(userDo.getAccessExpireDt())){
            return userDo;
        }
        if(StringUtils.isNotBlank(userDo.getRefreshToken())){
            //过期了
            RefreshTokenReq req = new RefreshTokenReq();
            req.setRefresh_token(userDo.getRefreshToken());
            GetTokenResp resp = refreshTokenService.call(req);
            userDo.setAccessToken(resp.getAccess_token());
            userDo.setAccessExpireDt(resp.getExpire_time());
            userDao.updateByPrimaryKeySelective(userDo);
        }
        return userDo;
    }
}
