package com.ygjt.gdn.ftisp.auth.security;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.util.Assert;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Je on 2016/11/15.
 */
public class CustomCookieClearingLogoutHandler implements LogoutHandler {
    private String splitChar ="/";
    private final List<String> cookiesToClear;

    public CustomCookieClearingLogoutHandler(String... cookiesToClear) {
        Assert.notNull(cookiesToClear, "List of cookies cannot be null");
        this.cookiesToClear = Arrays.asList(cookiesToClear);
    }

    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        Iterator i$ = this.cookiesToClear.iterator();

        while(i$.hasNext()) {
            String cookieName = (String)i$.next();
            String cookiePath = request.getContextPath();

            if(StringUtils.indexOf(cookieName, splitChar)>0){
                cookiePath = cookieName.split(splitChar)[1];
                cookieName = cookieName.split(splitChar)[0];
            }

            Cookie cookie = new Cookie(cookieName, (String)null);

            cookie.setPath(cookiePath);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

    }
    private String getCookiePath(HttpServletRequest request,String cookieName){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie!=null && StringUtils.equals(cookieName,cookie.getName())){
                if(StringUtils.isNotBlank(cookie.getPath())){
                    return cookie.getPath();
                }
            }
        }
        return "/";
    }

    public void setSplitChar(String splitChar) {
        this.splitChar = splitChar;
    }
}
