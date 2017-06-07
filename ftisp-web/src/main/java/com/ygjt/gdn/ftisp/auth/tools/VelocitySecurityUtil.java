package com.ygjt.gdn.ftisp.auth.tools;

import com.ygjt.gdn.ftisp.auth.security.entity.TmsUserDetails;
import com.ygjt.gdn.ftisp.model.UserDo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Je on 2016/10/14.
 */
public class VelocitySecurityUtil {

    public static String getPrincipal() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null){
            Object obj = authentication.getPrincipal();
            if (obj instanceof UserDetails) {
                return ((UserDetails) obj).getUsername();
            }
        }
        return "anonymous";
    }

    public static Authentication getAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static boolean isAuthenticated() {
        return !getPrincipal().equals("anonymous");
    }

    public static boolean allGranted(String[] checkForAuths) {
        Set<String> userAuths = getUserAuthorities();
        for (String auth : checkForAuths) {
            if (userAuths.contains(auth))
                continue;
            return false;
        }
        return true;
    }

    public static boolean anyGranted(String[] checkForAuths) {
        Set<String> userAuths = getUserAuthorities();
        for (String auth : checkForAuths) {
            if (userAuths.contains(auth))
                return true;
        }
        return false;
    }

    public static boolean noneGranted(String[] checkForAuths) {
        Set<String> userAuths = getUserAuthorities();
        for (String auth : checkForAuths) {
            if (userAuths.contains(auth))
                return false;
        }
        return true;
    }

    private static Set<String> getUserAuthorities() {
        Object obj = SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Set<String> roles = new HashSet<String>();
        if (obj instanceof UserDetails) {
            @SuppressWarnings("unchecked")
            Collection<GrantedAuthority> gas = (Collection<GrantedAuthority>) ((UserDetails) obj)
                    .getAuthorities();
            for (GrantedAuthority ga : gas) {
                roles.add(ga.getAuthority());
            }
        }
        return roles;
    }

    public static String getUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    public static UserDo getUserDo(){
        UserDo userDo = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null) {
            Object userDetails = authentication.getPrincipal();
            if (userDetails != null && userDetails instanceof TmsUserDetails) {
                userDo = ((TmsUserDetails) userDetails).getUserDo();
            }
        }
        return userDo;
    }

}