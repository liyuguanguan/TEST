package com.ygjt.gdn.ftisp.auth.security.filter;

import com.ygjt.gdn.ftisp.auth.security.DefaultAccessDeniedHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by Je on 2016/11/16.
 */
public class InternationalizationFilter extends OncePerRequestFilter {
    private Logger log         = Logger.getLogger(InternationalizationFilter.class);
    private String localeParam = "Language";
    private LocaleResolver localeResolver;

    @Autowired
    private DefaultAccessDeniedHandler accessDeniedHandler;

    public InternationalizationFilter(String localeParam, LocaleResolver localeResolver) {
        this.localeParam = localeParam;
        this.localeResolver = localeResolver;
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void doFilterInternal(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final FilterChain filterChain)
            throws ServletException, IOException {
        if (localeResolver == null) {
            throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
        } else {
            final String newLocale = request.getParameter(localeParam);
            if (newLocale != null) {
                final Locale locale = StringUtils.parseLocaleString(newLocale.toLowerCase());
                LocaleContextHolder.setLocale(locale);
                LocaleEditor localeEditor = new LocaleEditor();
                localeEditor.setAsText(newLocale);
                localeResolver.setLocale(request, response, (Locale) localeEditor.getValue());
                log.debug("change locale to " +
                        locale.getLanguage() + "_" + locale.getCountry() +
                        " at Thread" + Thread.currentThread().getId());
            } else {
                final Locale locale = localeResolver.resolveLocale(request);
                LocaleContextHolder.setLocale(locale);
                log.debug("restore locale to " +
                        locale.getLanguage() + "_" + locale.getCountry() +
                        " at Thread" + Thread.currentThread().getId());
            }
            try {
                filterChain.doFilter(request, response);
            } catch (AccessDeniedException e){
                accessDeniedHandler.handle(request,response,e);
            } finally {
                LocaleContextHolder.resetLocaleContext();
            }
        }
    }

}
