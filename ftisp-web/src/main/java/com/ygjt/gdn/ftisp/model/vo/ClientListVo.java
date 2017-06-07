package com.ygjt.gdn.ftisp.model.vo;

/**
 * Created by wyh on 2017/1/16.
 */
public class ClientListVo {
    private Integer id;// (integer, optional): client配置ID ,
    private String clientId;// (string, optional): 终端码 ,
    private String resourceIds;// (string, optional): 资源id ,
    private String clientSecret;// (string, optional): 终端密钥 ,
    private String scope;// (string, optional): scope ,
    private String authorizedGrantTypes;// (string, optional): 授权类型 ,
    private String webServerRedirectUri;// (string, optional): 跳转地址 ,
    private String authorities;// (string, optional): 权限

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}
