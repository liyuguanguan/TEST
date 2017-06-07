package com.ygjt.gdn.ftisp.auth.security;

import com.ygjt.gdn.ftisp.auth.security.entity.TmsGrantedAuthority;
import com.ygjt.gdn.ftisp.auth.security.entity.TmsUserDetails;
import com.ygjt.gdn.ftisp.model.AuthorityDo;
import com.ygjt.gdn.ftisp.model.Query.UserQuery;
import com.ygjt.gdn.ftisp.model.UserDo;
import com.ygjt.gdn.ftisp.persistence.AuthorityDao;
import com.ygjt.gdn.ftisp.persistence.UserDao;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linx on 2016/10/17.
 */
public class DefaultUserDetailsService implements UserDetailsService {

    protected       MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();
    protected final Log                   logger   = LogFactory.getLog(getClass());

    @Autowired
    UserDao      userDao;
    @Autowired
    AuthorityDao authorityDao;
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        //TODO  待优化
        UserQuery sysUsersQuery = new UserQuery();
        sysUsersQuery.createCriteria().andUsernameEqualTo(username).andStsEqualTo("Y");
        List<UserDo> userDos = userDao.selectByQuery(sysUsersQuery);
        if(CollectionUtils.isEmpty(userDos)){
            throw new BadCredentialsException(this.messages.getMessage("DigestAuthenticationFilter.usernameNotFound",new Object[]{username}, "Username {0} not found"));
        }
        UserDo userDo = userDos.get(0);
        List<AuthorityDo> authorityDos = authorityDao.selectByUserId(userDo.getId());

        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        for (AuthorityDo authority : authorityDos) {
            GrantedAuthority grantedAuthority = new TmsGrantedAuthority(authority);
            auths.add(grantedAuthority);
        }
        TmsUserDetails userDetails = new TmsUserDetails(userDo,authorityDos);
        return userDetails;
    }

}
