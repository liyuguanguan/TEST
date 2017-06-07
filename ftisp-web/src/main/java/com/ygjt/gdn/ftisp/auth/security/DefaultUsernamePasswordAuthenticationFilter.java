package com.ygjt.gdn.ftisp.auth.security;

import com.octo.captcha.service.CaptchaServiceException;
import com.ygjt.gdn.ftisp.auth.security.exception.CaptchaException;
import com.ygjt.gdn.ftisp.utils.jcapcha.CaptchaServiceSingleton;
import com.ygjt.gdn.ftisp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by linx on 2016/10/20.
 */
public class DefaultUsernamePasswordAuthenticationFilter
        extends UsernamePasswordAuthenticationFilter implements MessageSourceAware {

    protected MessageSourceAccessor message;

    @Autowired
    private UserService userService;
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try {
            if (!CaptchaServiceSingleton.getInstance().validateResponseForID(request.getSession().getId(), request.getParameter("validateCode"))) {
                throw new CaptchaException(this.message.getMessage("custom.error.auth.badCaptcha"));
            }
        } catch (CaptchaServiceException e) {
            throw new CaptchaException(this.message.getMessage("custom.error.auth.badCaptcha"));
        }
        //校验是否拥有当前系统访问权限
        if(!userService.hasSystemPermistion(this.obtainUsername(request),request.getRequestURI(),request.getContextPath())){
            throw new AuthenticationServiceException(this.message.getMessage("custom.error.auth.system.error",new String[]{this.obtainUsername(request)}));
        }
        return super.attemptAuthentication(request, response);
    }

    public DefaultUsernamePasswordAuthenticationFilter() {
        super();
    }

    @Override
    protected String obtainPassword(HttpServletRequest request) {
        return super.obtainPassword(request);
    }

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        return super.obtainUsername(request);
    }

    @Override
    protected void setDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest) {
        super.setDetails(request, authRequest);
    }

    @Override
    public void setUsernameParameter(String usernameParameter) {
        super.setUsernameParameter(usernameParameter);
    }

    @Override
    public void setPasswordParameter(String passwordParameter) {
        super.setPasswordParameter(passwordParameter);
    }

    @Override
    public void setPostOnly(boolean postOnly) {
        super.setPostOnly(postOnly);
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.message = new MessageSourceAccessor(messageSource) ;
    }
}
