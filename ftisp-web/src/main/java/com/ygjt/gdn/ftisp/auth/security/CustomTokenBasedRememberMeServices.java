package com.ygjt.gdn.ftisp.auth.security;

import com.ygjt.gdn.ftisp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.InvalidCookieException;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * Created by Je on 2016/11/15.
 */
public class CustomTokenBasedRememberMeServices extends TokenBasedRememberMeServices implements MessageSourceAware {


    protected MessageSourceAccessor message;

    @Autowired
    private UserService userService;

    private boolean rootPah = false;

    public boolean isRootPah() {
        return rootPah;
    }

    public void setRootPah(boolean rootPah) {
        this.rootPah = rootPah;
    }

    @Override
    protected UserDetails processAutoLoginCookie(String[] cookieTokens, HttpServletRequest request, HttpServletResponse response) {
        if(cookieTokens.length != 3) {
            throw new InvalidCookieException("Cookie token did not contain 3 tokens, but contained \'" + Arrays.asList(cookieTokens) + "\'");
        }
        //校验是否拥有当前系统访问权限
        if(!userService.hasSystemPermistion(cookieTokens[0],request.getRequestURI(),request.getContextPath())){
            throw new AccessDeniedException(this.message.getMessage("custom.error.auth.system.error"
                    ,new String[]{cookieTokens[0]}));
        }
        return super.processAutoLoginCookie(cookieTokens, request, response);
    }

    @Override
    protected void setCookie(String[] tokens, int maxAge, HttpServletRequest request, HttpServletResponse response) {
        String cookieValue = this.encodeCookie(tokens);
        Cookie cookie = new Cookie(this.getCookieName(), cookieValue);
        if(hasRememberMeParam(request,this.getParameter())) {
            cookie.setMaxAge(maxAge);
        }
        if(this.rootPah){
            cookie.setPath("/");
        }else {
            cookie.setPath(this.getCookiePath(request));
        }
        if (maxAge < 1) {
            cookie.setVersion(1);
        }
        cookie.setSecure(request.isSecure());
        //ReflectionUtils.invokeMethod(this.setHttpOnlyMethod, cookie, new Object[]{Boolean.TRUE});
        response.addCookie(cookie);
    }
    @Override
    protected void cancelCookie(HttpServletRequest request, HttpServletResponse response) {
        this.logger.debug("Cancelling cookie");
        Cookie cookie = new Cookie(this.getCookieName(), (String)null);
        cookie.setMaxAge(0);
        if(this.rootPah) {
            cookie.setPath("/");
        }else{
            cookie.setPath(this.getCookiePath(request));
        }
        response.addCookie(cookie);
    }

    protected boolean hasRememberMeParam(HttpServletRequest request, String parameter) {
        String paramValue = request.getParameter(parameter);
        if(paramValue != null && (paramValue.equalsIgnoreCase("true") || paramValue.equalsIgnoreCase("on") || paramValue.equalsIgnoreCase("yes") || paramValue.equals("1"))) {
            return true;
        } else {
            return false;
        }
    }
    private String getCookiePath(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        return contextPath.length() > 0?contextPath:"/";
    }
    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.message = new MessageSourceAccessor(messageSource) ;
    }
}
