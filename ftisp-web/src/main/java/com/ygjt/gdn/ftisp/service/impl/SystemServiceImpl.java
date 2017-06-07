package com.ygjt.gdn.ftisp.service.impl;

import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.AuthSystemDo;
import com.ygjt.gdn.ftisp.model.AuthSystemDo;
import com.ygjt.gdn.ftisp.model.Query.AuthSystemQuery;
import com.ygjt.gdn.ftisp.persistence.AuthSystemDao;
import com.ygjt.gdn.ftisp.service.SystemService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by linx on 2017-04-25.
 */
@Service
public class SystemServiceImpl implements SystemService{
    @Autowired
    AuthSystemDao authSystemDao;
    @Override
    public AuthSystemDo getSystemByName(String systemName) throws ServiceException {
        AuthSystemQuery query = new AuthSystemQuery();
         query.createCriteria().andStsEqualTo(Constants.TABLE_STS_YES).andNameEqualTo(systemName);
        List<AuthSystemDo> authSystemDos = authSystemDao.selectByQuery(query);
        if(CollectionUtils.isEmpty(authSystemDos)){
            return null;
        }
        if( authSystemDos.size()>1){
            throw new ServiceException("存在多条该系统名称信息");
        }
        return authSystemDos.get(0);
    }
}
