package com.ygjt.gdn.ftisp.service;

import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.EmailCodeDo;
import com.ygjt.gdn.ftisp.model.EntInfoDo;
import com.ygjt.gdn.ftisp.model.UserDo;
import com.ygjt.gdn.ftisp.model.vo.po.RegisterPO;
import com.ygjt.gdn.ftisp.model.vo.po.SendEmailPO;
import com.ygjt.gdn.ftisp.model.vo.po.UserPwdPO;
import com.ygjt.gdn.ftisp.model.vo.po.ValidEmailPO;

/**
 * Created by linx on 2017-04-13.
 */
public interface UserService {
    /**
     *
     * @param userName
     * @param requestUrl
     * @param basePath
     * @return
     */
    boolean hasSystemPermistion(String userName, String requestUrl, String basePath);

    /**
     * 发送邮件
     * @param po
     * @throws ServiceException
     */
    void sendEmail(SendEmailPO po)throws ServiceException;

    /**
     * 校验激活码
     * @param code
     * @throws ServiceException
     */
    EmailCodeDo validEmail(String code)throws ServiceException;

    /**
     * 注册逻辑
      * @param po
     */
    void doRegister(RegisterPO po)throws ServiceException;

    /**
     * 重置密码
     * @param po
     */
    void modifyPwd(UserPwdPO po)throws ServiceException;

    UserDo  getUserByEmail(String email)throws ServiceException;;

    UserDo getToken(UserDo userDo);
}
