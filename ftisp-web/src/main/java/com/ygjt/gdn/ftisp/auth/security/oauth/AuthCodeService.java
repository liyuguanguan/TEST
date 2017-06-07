package com.ygjt.gdn.ftisp.auth.security.oauth;

import com.ygjt.gdn.ftisp.model.AuthCodeDo;
import com.ygjt.gdn.ftisp.model.Query.AuthCodeQuery;
import com.ygjt.gdn.ftisp.persistence.AuthCodeDao;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.security.oauth2.common.util.SerializationUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Je on 2016/10/20.
 */
public class AuthCodeService extends RandomValueAuthorizationCodeServices {


    @Resource
    private AuthCodeDao authCodeDao;

    @Override
    protected void store(String code, OAuth2Authentication oAuth2Authentication) {
        AuthCodeDo authCodeDo = new AuthCodeDo();
        authCodeDo.setCode(code);
        authCodeDo.setAuthentication(SerializationUtils.serialize(oAuth2Authentication));

        authCodeDao.insert(authCodeDo);
    }

    @Override
    protected OAuth2Authentication remove(String code) {
        OAuth2Authentication authentication=null;
        AuthCodeQuery query = new AuthCodeQuery();
        query.createCriteria().andCodeEqualTo(code);
        List<AuthCodeDo> authCodeDos = authCodeDao.selectByQueryWithBLOBs(query);
        if(CollectionUtils.isNotEmpty(authCodeDos)){
            authentication = SerializationUtils.deserialize(authCodeDos.get(0).getAuthentication());
            if(authentication!=null){
                authCodeDao.deleteByPrimaryKey(authCodeDos.get(0).getId());
            }

        }
        return authentication;
    }
}
