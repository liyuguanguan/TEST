package com.ygjt.gdn.ftisp.service;

import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.EmailCodeDo;

/**
 * Created by linx on 2017-04-17.
 */
public interface EmailCodeService {
    EmailCodeDo getEmailCodeByEmail(String email,String mailType)throws ServiceException;

    boolean sendMail(String email,String mailType)throws ServiceException;

    EmailCodeDo saveEmaiCode(EmailCodeDo emailCodeDo)throws ServiceException;

    EmailCodeDo getEmailCodeByCode(String code);

}
