package com.ygjt.gdn.ftisp.auth.security.oauth;

import com.ygjt.gdn.ftisp.auth.security.oauth.entity.TmsClientDetails;
import com.ygjt.gdn.ftisp.model.ClientDetailsDo;
import com.ygjt.gdn.ftisp.model.Query.ClientDetailsQuery;
import com.ygjt.gdn.ftisp.persistence.ClientDetailsDao;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

import java.util.List;

/**
 * Created by Je on 2016/10/20.
 */
public class CustomClientDetailsService implements ClientDetailsService {

    protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();
    @Autowired
    private ClientDetailsDao clientDetailsDao;
    @Override
    public ClientDetails loadClientByClientId(String client) throws ClientRegistrationException {
        ClientDetailsQuery query = new ClientDetailsQuery();
        query.createCriteria().andClientIdEqualTo(client).andStsEqualTo("Y");
        List<ClientDetailsDo> clientDetailsDos = clientDetailsDao.selectByQuery(query);

        if(CollectionUtils.isNotEmpty(clientDetailsDos)){
            return new TmsClientDetails(clientDetailsDos.get(0)) ;
        }else{
            throw new UsernameNotFoundException(this.messages.getMessage("DigestAuthenticationFilter.usernameNotFound",new Object[]{client}, "Client {0} not found"));
        }
    }
}
