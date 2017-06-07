package com.ygjt.gdn.ftisp.service;

import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.AuthSystemDo;
import com.ygjt.gdn.ftisp.model.EmailCodeDo;

/**
 * Created by linx on 2017-04-25.
 */
public interface SystemService {
    AuthSystemDo getSystemByName(String systemName)throws ServiceException;
}
