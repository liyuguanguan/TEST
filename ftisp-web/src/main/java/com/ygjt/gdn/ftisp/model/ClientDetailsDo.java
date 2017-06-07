package com.ygjt.gdn.ftisp.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 认证client配置表
 * auth_client_details
 */
public class ClientDetailsDo implements Serializable {
    /**
     * id
     * auth_client_details.id
     */
    private Integer id;

    /**
     * 终端码
     * auth_client_details.client_id
     */
    private String clientId;

    /**
     * 资源id
     * auth_client_details.resource_ids
     */
    private String resourceIds;

    /**
     * 终端密钥
     * auth_client_details.client_secret
     */
    private String clientSecret;

    /**
     * scope
     * auth_client_details.scope
     */
    private String scope;

    /**
     * 授权类型
     * auth_client_details.authorized_grant_types
     */
    private String authorizedGrantTypes;

    /**
     * 跳转地址
     * auth_client_details.web_server_redirect_uri
     */
    private String webServerRedirectUri;

    /**
     * 权限
     * auth_client_details.authorities
     */
    private String authorities;

    /**
     * auth_client_details.access_token_validity
     */
    private Integer accessTokenValidity;

    /**
     * auth_client_details.refresh_token_validity
     */
    private Integer refreshTokenValidity;

    /**
     * auth_client_details.additional_information
     */
    private String additionalInformation;

    /**
     * auth_client_details.archived
     */
    private Byte archived;

    /**
     * auth_client_details.trusted
     */
    private Byte trusted;

    /**
     * auth_client_details.autoapprove
     */
    private String autoapprove;

    /**
     * 创建人
     * auth_client_details.created_by
     */
    private Integer createdBy;

    /**
     * 创建时间
     * auth_client_details.created_dt
     */
    private Date createdDt;

    /**
     * 最后更新人
     * auth_client_details.last_update_by
     */
    private Integer lastUpdateBy;

    /**
     * 最后更新时间
     * auth_client_details.last_update_dt
     */
    private Date lastUpdateDt;

    /**
     * 状态
     * auth_client_details.sts
     */
    private String sts;

    /**
     * auth_client_details
     */
    private static final long serialVersionUID = 1L;

    /**
     * auth_client_details.id
     * @return the value of auth_client_details.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * auth_client_details.id
     * @param id the value for auth_client_details.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * auth_client_details.client_id
     * @return the value of auth_client_details.client_id
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * auth_client_details.client_id
     * @param clientId the value for auth_client_details.client_id
     */
    public void setClientId(String clientId) {
        this.clientId = clientId == null ? null : clientId.trim();
    }

    /**
     * auth_client_details.resource_ids
     * @return the value of auth_client_details.resource_ids
     */
    public String getResourceIds() {
        return resourceIds;
    }

    /**
     * auth_client_details.resource_ids
     * @param resourceIds the value for auth_client_details.resource_ids
     */
    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds == null ? null : resourceIds.trim();
    }

    /**
     * auth_client_details.client_secret
     * @return the value of auth_client_details.client_secret
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * auth_client_details.client_secret
     * @param clientSecret the value for auth_client_details.client_secret
     */
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret == null ? null : clientSecret.trim();
    }

    /**
     * auth_client_details.scope
     * @return the value of auth_client_details.scope
     */
    public String getScope() {
        return scope;
    }

    /**
     * auth_client_details.scope
     * @param scope the value for auth_client_details.scope
     */
    public void setScope(String scope) {
        this.scope = scope == null ? null : scope.trim();
    }

    /**
     * auth_client_details.authorized_grant_types
     * @return the value of auth_client_details.authorized_grant_types
     */
    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    /**
     * auth_client_details.authorized_grant_types
     * @param authorizedGrantTypes the value for auth_client_details.authorized_grant_types
     */
    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes == null ? null : authorizedGrantTypes.trim();
    }

    /**
     * auth_client_details.web_server_redirect_uri
     * @return the value of auth_client_details.web_server_redirect_uri
     */
    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    /**
     * auth_client_details.web_server_redirect_uri
     * @param webServerRedirectUri the value for auth_client_details.web_server_redirect_uri
     */
    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri == null ? null : webServerRedirectUri.trim();
    }

    /**
     * auth_client_details.authorities
     * @return the value of auth_client_details.authorities
     */
    public String getAuthorities() {
        return authorities;
    }

    /**
     * auth_client_details.authorities
     * @param authorities the value for auth_client_details.authorities
     */
    public void setAuthorities(String authorities) {
        this.authorities = authorities == null ? null : authorities.trim();
    }

    /**
     * auth_client_details.access_token_validity
     * @return the value of auth_client_details.access_token_validity
     */
    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    /**
     * auth_client_details.access_token_validity
     * @param accessTokenValidity the value for auth_client_details.access_token_validity
     */
    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    /**
     * auth_client_details.refresh_token_validity
     * @return the value of auth_client_details.refresh_token_validity
     */
    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    /**
     * auth_client_details.refresh_token_validity
     * @param refreshTokenValidity the value for auth_client_details.refresh_token_validity
     */
    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    /**
     * auth_client_details.additional_information
     * @return the value of auth_client_details.additional_information
     */
    public String getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * auth_client_details.additional_information
     * @param additionalInformation the value for auth_client_details.additional_information
     */
    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation == null ? null : additionalInformation.trim();
    }

    /**
     * auth_client_details.archived
     * @return the value of auth_client_details.archived
     */
    public Byte getArchived() {
        return archived;
    }

    /**
     * auth_client_details.archived
     * @param archived the value for auth_client_details.archived
     */
    public void setArchived(Byte archived) {
        this.archived = archived;
    }

    /**
     * auth_client_details.trusted
     * @return the value of auth_client_details.trusted
     */
    public Byte getTrusted() {
        return trusted;
    }

    /**
     * auth_client_details.trusted
     * @param trusted the value for auth_client_details.trusted
     */
    public void setTrusted(Byte trusted) {
        this.trusted = trusted;
    }

    /**
     * auth_client_details.autoapprove
     * @return the value of auth_client_details.autoapprove
     */
    public String getAutoapprove() {
        return autoapprove;
    }

    /**
     * auth_client_details.autoapprove
     * @param autoapprove the value for auth_client_details.autoapprove
     */
    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove == null ? null : autoapprove.trim();
    }

    /**
     * auth_client_details.created_by
     * @return the value of auth_client_details.created_by
     */
    public Integer getCreatedBy() {
        return createdBy;
    }

    /**
     * auth_client_details.created_by
     * @param createdBy the value for auth_client_details.created_by
     */
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * auth_client_details.created_dt
     * @return the value of auth_client_details.created_dt
     */
    public Date getCreatedDt() {
        return createdDt;
    }

    /**
     * auth_client_details.created_dt
     * @param createdDt the value for auth_client_details.created_dt
     */
    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    /**
     * auth_client_details.last_update_by
     * @return the value of auth_client_details.last_update_by
     */
    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    /**
     * auth_client_details.last_update_by
     * @param lastUpdateBy the value for auth_client_details.last_update_by
     */
    public void setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    /**
     * auth_client_details.last_update_dt
     * @return the value of auth_client_details.last_update_dt
     */
    public Date getLastUpdateDt() {
        return lastUpdateDt;
    }

    /**
     * auth_client_details.last_update_dt
     * @param lastUpdateDt the value for auth_client_details.last_update_dt
     */
    public void setLastUpdateDt(Date lastUpdateDt) {
        this.lastUpdateDt = lastUpdateDt;
    }

    /**
     * auth_client_details.sts
     * @return the value of auth_client_details.sts
     */
    public String getSts() {
        return sts;
    }

    /**
     * auth_client_details.sts
     * @param sts the value for auth_client_details.sts
     */
    public void setSts(String sts) {
        this.sts = sts == null ? null : sts.trim();
    }

    /**
     * auth_client_details
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ClientDetailsDo other = (ClientDetailsDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getClientId() == null ? other.getClientId() == null : this.getClientId().equals(other.getClientId()))
            && (this.getResourceIds() == null ? other.getResourceIds() == null : this.getResourceIds().equals(other.getResourceIds()))
            && (this.getClientSecret() == null ? other.getClientSecret() == null : this.getClientSecret().equals(other.getClientSecret()))
            && (this.getScope() == null ? other.getScope() == null : this.getScope().equals(other.getScope()))
            && (this.getAuthorizedGrantTypes() == null ? other.getAuthorizedGrantTypes() == null : this.getAuthorizedGrantTypes().equals(other.getAuthorizedGrantTypes()))
            && (this.getWebServerRedirectUri() == null ? other.getWebServerRedirectUri() == null : this.getWebServerRedirectUri().equals(other.getWebServerRedirectUri()))
            && (this.getAuthorities() == null ? other.getAuthorities() == null : this.getAuthorities().equals(other.getAuthorities()))
            && (this.getAccessTokenValidity() == null ? other.getAccessTokenValidity() == null : this.getAccessTokenValidity().equals(other.getAccessTokenValidity()))
            && (this.getRefreshTokenValidity() == null ? other.getRefreshTokenValidity() == null : this.getRefreshTokenValidity().equals(other.getRefreshTokenValidity()))
            && (this.getAdditionalInformation() == null ? other.getAdditionalInformation() == null : this.getAdditionalInformation().equals(other.getAdditionalInformation()))
            && (this.getArchived() == null ? other.getArchived() == null : this.getArchived().equals(other.getArchived()))
            && (this.getTrusted() == null ? other.getTrusted() == null : this.getTrusted().equals(other.getTrusted()))
            && (this.getAutoapprove() == null ? other.getAutoapprove() == null : this.getAutoapprove().equals(other.getAutoapprove()))
            && (this.getCreatedBy() == null ? other.getCreatedBy() == null : this.getCreatedBy().equals(other.getCreatedBy()))
            && (this.getCreatedDt() == null ? other.getCreatedDt() == null : this.getCreatedDt().equals(other.getCreatedDt()))
            && (this.getLastUpdateBy() == null ? other.getLastUpdateBy() == null : this.getLastUpdateBy().equals(other.getLastUpdateBy()))
            && (this.getLastUpdateDt() == null ? other.getLastUpdateDt() == null : this.getLastUpdateDt().equals(other.getLastUpdateDt()))
            && (this.getSts() == null ? other.getSts() == null : this.getSts().equals(other.getSts()));
    }

    /**
     * auth_client_details
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getClientId() == null) ? 0 : getClientId().hashCode());
        result = prime * result + ((getResourceIds() == null) ? 0 : getResourceIds().hashCode());
        result = prime * result + ((getClientSecret() == null) ? 0 : getClientSecret().hashCode());
        result = prime * result + ((getScope() == null) ? 0 : getScope().hashCode());
        result = prime * result + ((getAuthorizedGrantTypes() == null) ? 0 : getAuthorizedGrantTypes().hashCode());
        result = prime * result + ((getWebServerRedirectUri() == null) ? 0 : getWebServerRedirectUri().hashCode());
        result = prime * result + ((getAuthorities() == null) ? 0 : getAuthorities().hashCode());
        result = prime * result + ((getAccessTokenValidity() == null) ? 0 : getAccessTokenValidity().hashCode());
        result = prime * result + ((getRefreshTokenValidity() == null) ? 0 : getRefreshTokenValidity().hashCode());
        result = prime * result + ((getAdditionalInformation() == null) ? 0 : getAdditionalInformation().hashCode());
        result = prime * result + ((getArchived() == null) ? 0 : getArchived().hashCode());
        result = prime * result + ((getTrusted() == null) ? 0 : getTrusted().hashCode());
        result = prime * result + ((getAutoapprove() == null) ? 0 : getAutoapprove().hashCode());
        result = prime * result + ((getCreatedBy() == null) ? 0 : getCreatedBy().hashCode());
        result = prime * result + ((getCreatedDt() == null) ? 0 : getCreatedDt().hashCode());
        result = prime * result + ((getLastUpdateBy() == null) ? 0 : getLastUpdateBy().hashCode());
        result = prime * result + ((getLastUpdateDt() == null) ? 0 : getLastUpdateDt().hashCode());
        result = prime * result + ((getSts() == null) ? 0 : getSts().hashCode());
        return result;
    }
}