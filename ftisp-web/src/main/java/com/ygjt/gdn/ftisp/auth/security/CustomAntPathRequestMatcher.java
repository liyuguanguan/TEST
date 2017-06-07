package com.ygjt.gdn.ftisp.auth.security;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Je on 2016/11/30.
 */
public class CustomAntPathRequestMatcher implements RequestMatcher {

    private final String         pattern;
    private final String         basePath;
    private final HttpMethod     httpMethod;
    private final boolean        caseSensitive;
    private final AntPathMatcher matcher;

    public CustomAntPathRequestMatcher(String pattern) {
        this(pattern, null);

    }

    public CustomAntPathRequestMatcher(String pattern, String basePath) {
        this(pattern, basePath, null);
    }

    public CustomAntPathRequestMatcher(String pattern, String basePath, String httpMethod) {
        this(pattern, basePath, httpMethod, false);
    }

    public CustomAntPathRequestMatcher(String pattern, String basePath, String httpMethod, boolean caseSensitive) {
        if (!caseSensitive) {
            pattern = pattern.toLowerCase();
        }
        this.pattern = StringUtils.trim(pattern);
        this.basePath = StringUtils.trim(basePath);
        this.httpMethod = StringUtils.isNotBlank(httpMethod) ? HttpMethod.valueOf(httpMethod) : null;
        this.caseSensitive = caseSensitive;
        this.matcher = new AntPathMatcher();
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        if (this.httpMethod != null && request.getMethod() != null && this.httpMethod != valueOf(request.getMethod())) {
            return false;

        }else  {
            if (basePath != null) {
                if(StringUtils.startsWith(basePath,"/")){
                    if (!StringUtils.equals(request.getContextPath(),basePath)) {
                        return false;
                    }
                }else{
                    if(!StringUtils.startsWith(request.getRequestURI(),basePath)){
                        return false;
                    }
                }
            }
            return this.matcher.match(pattern, this.getRequestPath(request));
        }
    }

    private String getRequestPath(HttpServletRequest request) {
        String url = request.getServletPath();
        if (request.getPathInfo() != null) {
            url = url + request.getPathInfo();
        }

        if (!this.caseSensitive) {
            url = url.toLowerCase();
        }

        return url;
    }

    private static HttpMethod valueOf(String method) {
        try {
            return HttpMethod.valueOf(method);
        } catch (IllegalArgumentException var2) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if(!(obj instanceof CustomAntPathRequestMatcher)) {
            return false;
        } else {
            CustomAntPathRequestMatcher other = (CustomAntPathRequestMatcher)obj;
            return this.pattern.equals(other.pattern) && this.httpMethod == other.httpMethod
                    && this.caseSensitive == other.caseSensitive
                    && StringUtils.equals(this.basePath , other.basePath);
        }
    }

    public int hashCode() {
        int code = 31 ^ this.pattern.hashCode();
        if(this.httpMethod != null) {
            code ^= this.httpMethod.hashCode();
        }
        if(this.basePath != null) {
            code ^= this.basePath.hashCode();
        }

        return code;
    }
}
