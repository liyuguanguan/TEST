package com.ygjt.gdn.ftisp.auth.security.oauth.entity;

import com.ygjt.gdn.ftisp.model.ClientDetailsDo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by Je on 2016/10/20.
 */
public class TmsClientDetails implements ClientDetails{

    private ClientDetailsDo clientDetailsDo;

    public TmsClientDetails(ClientDetailsDo clientDetailsDo) {
        this.clientDetailsDo = clientDetailsDo;
    }

    @Override
    public String getClientId() {
        return clientDetailsDo.getClientId();
    }

    @Override
    public Set<String> getResourceIds() {
        return null;
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public String getClientSecret() {
        return clientDetailsDo.getClientSecret();
    }

    @Override
    public boolean isScoped() {
        return true;
    }

    @Override
    public Set<String> getScope() {
        if(!StringUtils.isEmpty(clientDetailsDo.getScope())){
            String[] split = clientDetailsDo.getScope().split(",");
            Set<String> s = new HashSet<>();
            Collections.addAll(s,split);
            return s;
        }else {
            return new HashSet<>();
        }

    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        if(!StringUtils.isEmpty(clientDetailsDo.getAuthorizedGrantTypes())){
            String[] split = clientDetailsDo.getAuthorizedGrantTypes().split(",");
            Set<String> s = new HashSet<>();
            Collections.addAll(s,split);
            return s;
        }else {
            return new HashSet<>();
        }
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return null;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_CLIENT");
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(authority);
        return list;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return null;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return null;
    }

    @Override
    public boolean isAutoApprove(String s) {
        return false;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
