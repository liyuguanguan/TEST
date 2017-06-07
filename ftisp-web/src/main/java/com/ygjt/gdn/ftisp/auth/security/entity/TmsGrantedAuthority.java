package com.ygjt.gdn.ftisp.auth.security.entity;

import com.ygjt.gdn.ftisp.model.AuthorityDo;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Je on 2016/10/14.
 */
public class TmsGrantedAuthority implements GrantedAuthority {
    private AuthorityDo authorityDo;

    public TmsGrantedAuthority(AuthorityDo authorityDo) {
        this.authorityDo = authorityDo;
    }

    @Override
    public String getAuthority() {
        return authorityDo.getAuthorityMark();
    }
}
