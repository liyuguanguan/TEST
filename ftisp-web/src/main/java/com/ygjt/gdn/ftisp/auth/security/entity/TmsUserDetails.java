package com.ygjt.gdn.ftisp.auth.security.entity;

import com.ygjt.gdn.ftisp.model.AuthorityDo;
import com.ygjt.gdn.ftisp.model.UserDo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Je on 2016/10/14.
 */
public class TmsUserDetails implements UserDetails {

    private UserDo                    userDo;
    private Collection<TmsGrantedAuthority> authorities;

    public TmsUserDetails(UserDo userDo, List<AuthorityDo> authDos) {
        this.userDo = userDo;
        List<TmsGrantedAuthority> list = new ArrayList<>();
        for (AuthorityDo authDo : authDos) {
            list.add(new TmsGrantedAuthority(authDo));
        }
        this.authorities = list;
    }

    public UserDo getUserDo() {
        return userDo;
    }

    public void setUserDo(UserDo userDo) {
        this.userDo = userDo;
    }

    public void setAuthorities(Collection<TmsGrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return userDo.getPassword();
    }

    @Override
    public String getUsername() {
        return userDo.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
