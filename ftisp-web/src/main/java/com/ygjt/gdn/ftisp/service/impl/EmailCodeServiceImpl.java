package com.ygjt.gdn.ftisp.service.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.enums.EmailCodeEnum;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.mail.model.ForgetPwdData;
import com.ygjt.gdn.ftisp.mail.model.RegisterData;
import com.ygjt.gdn.ftisp.mail.service.impl.ForgetMailService;
import com.ygjt.gdn.ftisp.mail.service.impl.RegisterMailService;
import com.ygjt.gdn.ftisp.model.EmailCodeDo;
import com.ygjt.gdn.ftisp.model.Query.EmailCodeQuery;
import com.ygjt.gdn.ftisp.persistence.EmailCodeDao;
import com.ygjt.gdn.ftisp.service.EmailCodeService;
import com.ygjt.gdn.ftisp.utils.DateUtils;
import com.ygjt.gdn.ftisp.utils.MD5Util;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by linx on 2017-04-17.
 */
@Service
public class EmailCodeServiceImpl implements EmailCodeService{
    @Autowired
    EmailCodeDao emailCodeDao;
    @Value("#{configProperties['mail.code.interval.time']}")
    private Integer intervalTime;//邮件发送间隔 以秒为单位
    @Value("#{configProperties['mail.code.expire.hours']}")
    private Integer expireAfterHours;//邮件失效时间 以小时为单位
    @Value("#{configProperties['system.host']}")
    private String systemHost;
    @Value("#{configProperties['mail.valid.register.url']}")
    private String registerUrl;
    @Value("#{configProperties['mail.valid.forget.pwd.url']}")
    private String forgetPwdUrl;

    @Autowired
    RegisterMailService registerMailService;
    @Autowired
    ForgetMailService forgetMailService;

    @Override
    public EmailCodeDo getEmailCodeByEmail(String email,String mailType) throws ServiceException{
        return getEmailCodeDo(email, mailType,null);
    }

    /**
     * 根据邮箱 邮箱类型 激活码查询激活码信息
     * @param email
     * @param mailType
     * @param code
     * @return
     */
    private EmailCodeDo getEmailCodeDo(String email, String mailType,String code) {
        EmailCodeQuery query = new EmailCodeQuery();
        EmailCodeQuery.Criteria criteria = query.createCriteria();
        if(StringUtils.isNotBlank(email)){
            criteria.andEmailEqualTo(email);
        }
        if(StringUtils.isNotBlank(mailType)){
            criteria.andTypeEqualTo(EmailCodeEnum.TYPE.parse(mailType).getValue());
        }
        if(StringUtils.isNotBlank(code)){
            criteria.andCodeEqualTo(code);
        }

        criteria.andStsEqualTo(Constants.TABLE_STS_YES);
        List<EmailCodeDo> emailCodeDos = emailCodeDao.selectByQuery(query);
        if(CollectionUtils.isEmpty(emailCodeDos)){
            return null;
        }
        if( emailCodeDos.size()>1){
            throw new ServiceException("存在多条该类型码信息");
        }
        return emailCodeDos.get(0);
    }

    /**
     * 发送邮件
     * @param email
     * @param mailType
     * @return
     * @throws ServiceException
     */
    @Override
    @Transactional
    public boolean sendMail(String email, String mailType) throws ServiceException {
        EmailCodeDo emailCodeDo = getEmailCodeByEmail(email, mailType);
        String code = "";
        //该邮箱未发送过激活码
        if(emailCodeDo==null){
            //保存激活码信息
            code =randomCode(email);
            EmailCodeDo newEmailCode = new EmailCodeDo();
            newEmailCode.setEmail(email);
            newEmailCode.setCode(code);
            newEmailCode.setActived(EmailCodeEnum.ACTIVED.N.name());
            newEmailCode.setExpireDate(DateUtils.addHour(new Date(),expireAfterHours));
            newEmailCode.setSendNum(1);
            newEmailCode.setRecentSendDate(new Date());
            newEmailCode.setType(EmailCodeEnum.TYPE.parse(mailType).getValue());
            saveEmaiCode(newEmailCode);
        }else{
            //校验最近发送时间

            checkLastSendTime(emailCodeDo.getRecentSendDate(),intervalTime);
            code = emailCodeDo.getCode();
            //校验激活码是否失效
            if(DateUtils.isCodeExpire(emailCodeDo.getExpireDate())){
                //已失效 更新p_email_code激活码、激活状态为未激活，失效时间为24小时之后，发送次数+1 更新p_email_code最近发送时间，
                code =randomCode(email);
                emailCodeDo.setCode(code);

            }
            //更新激活码信息
            emailCodeDo.setRecentSendDate(new Date());
            emailCodeDo.setActived(EmailCodeEnum.ACTIVED.N.name());
            emailCodeDo.setExpireDate(DateUtils.addHour(new Date(),expireAfterHours));
            emailCodeDo.setSendNum(emailCodeDo.getSendNum()+1);
            emailCodeDao.updateByPrimaryKeySelective(emailCodeDo);
        }
        //发送注册邮件
        if(StringUtils.equals(mailType,EmailCodeEnum.TYPE.EMAIL_TYPE_REGISTER.getFront_value())){
            RegisterData registerData =new RegisterData();
            registerData.setUrl(registerUrl+code);
            registerData.setTo(email);
            registerData.setUsername(email);
            registerData.setEmail(email);
            registerData.setHost(systemHost);
            if(!registerMailService.send(registerData)){
                throw new ServiceException("邮件发送失败，请检查邮箱地址是否正确");
            }
        }else{
            //发送找回密码邮件
            ForgetPwdData registerData =new ForgetPwdData();
            registerData.setUrl(forgetPwdUrl+code);
            registerData.setTo(email);
            registerData.setUsername(email);
            registerData.setEmail(email);
            registerData.setHost(systemHost);
            if(!forgetMailService.send(registerData)){
                throw new ServiceException("邮件发送失败，请检查邮箱地址是否正确");
            }
        }
        return true;
    }



    private void checkLastSendTime(Date recentSendDate, Integer intervalTime) throws ServiceException{
        long recentSendTime = recentSendDate.getTime()+intervalTime*1000;
        long nowTime = System.currentTimeMillis();
        if((nowTime-recentSendTime)<0){
            throw new ServiceException("请求过于频繁，请稍后再试");
        }
    }


    /**
     * 保存或更新邮件激活码信息
     * @param emailCode
     * @return
     * @throws ServiceException
     */
    @Override
    @Transactional
    public EmailCodeDo saveEmaiCode(EmailCodeDo emailCode) throws ServiceException {
        if(emailCode.getId()==null){
            EmailCodeDo newEmailCode = new EmailCodeDo();
            newEmailCode.setEmail(emailCode.getEmail());
            newEmailCode.setCode(emailCode.getCode());
            newEmailCode.setActived(EmailCodeEnum.ACTIVED.N.name());
            newEmailCode.setExpireDate(DateUtils.addHour(new Date(),expireAfterHours));
            newEmailCode.setSendNum(1);
            newEmailCode.setRecentSendDate(new Date());
            newEmailCode.setType(emailCode.getType());
            emailCodeDao.insertSelective(newEmailCode);
            return newEmailCode;
        }else{
            emailCodeDao.updateByPrimaryKeySelective(emailCode);
            return emailCode;
        }
    }

    private String randomCode(String email){
        String uuid = UUID.randomUUID().toString();
        return MD5Util.MD5Encode(uuid+email,"UTF-8");
    }

    @Override
    public EmailCodeDo getEmailCodeByCode(String code) {
        return getEmailCodeDo(null, null,code);
    }
}
