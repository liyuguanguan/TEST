package com.ygjt.gdn.ftisp.auth.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by linx on 2016/10/20.
 */
public class CaptchaException extends AuthenticationException {
    public CaptchaException(String msg, Throwable t) {
        super(msg, t);
    }

    public CaptchaException(String msg) {
        super(msg);
    }
}
