package com.ygjt.gdn.ftisp.auth.security;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.ygjt.gdn.ftisp.model.ResourceAuthDo;
import com.ygjt.gdn.ftisp.persistence.ResourceDao;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by linx on 2016/10/17.
 */
public class URLFilterInvocationSecurityMetadataSource implements
        FilterInvocationSecurityMetadataSource,InitializingBean {
    protected       MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();
    protected final Log                   logger   = LogFactory.getLog(getClass());

    //权限集合
    private Map<RequestMatcher, Collection<ConfigAttribute>> ALL_RESOURCE_AUTHORITIS;

    @Autowired
    private ResourceDao resourceDao;

    /* (non-Javadoc)
     * @see org.springframework.security.access.SecurityMetadataSource#getAttributes(java.lang.Object)
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException {
        final HttpServletRequest request = ((FilterInvocation) object).getRequest();

        Collection<ConfigAttribute> attrs = Lists.newArrayList();

        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : ALL_RESOURCE_AUTHORITIS.entrySet()) {
            if (entry.getKey().matches(request)) {
                attrs.addAll(entry.getValue());
            }
        }
        logger.info("URL资源："+request.getRequestURI()+ " -> " + attrs);
        if(CollectionUtils.isEmpty(attrs)){
            throw new AccessDeniedException(this.messages.getMessage("AbstractAccessDecisionManager.accessDenied", "Access is denied"));
        }
        return attrs;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.access.SecurityMetadataSource#getAllConfigAttributes()
     */
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();
        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : ALL_RESOURCE_AUTHORITIS.entrySet()) {
            allAttributes.addAll(entry.getValue());
        }
        return allAttributes;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.access.SecurityMetadataSource#supports(java.lang.Class)
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }


    private Map<RequestMatcher, Collection<ConfigAttribute>> getResourceAuthoritis(){
        Map<RequestMatcher, Collection<ConfigAttribute>> resultMap = Maps.newHashMap();
        List<ResourceAuthDo> list = resourceDao.listAllResourceAuths();
        for (ResourceAuthDo resourceAuthDo : list) {
            CustomAntPathRequestMatcher matcher = new CustomAntPathRequestMatcher(resourceAuthDo.getResourcePath(),resourceAuthDo.getSystemUrl());
            if(resultMap.containsKey(matcher)){
                resultMap.get(matcher).add(new SecurityConfig(resourceAuthDo.getAuthorityMark()));
            }else{
                resultMap.put(matcher, SecurityConfig.createList(resourceAuthDo.getAuthorityMark()));
            }
        }
        return resultMap;
    }
    /* (non-Javadoc)
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     * 初始化权限列表
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        refreshResourceAuthoritis();
    }

    public void refreshResourceAuthoritis(){
        this.ALL_RESOURCE_AUTHORITIS = this.getResourceAuthoritis();
    }
}
