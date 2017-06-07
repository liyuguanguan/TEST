package com.ygjt.gdn.ftisp.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 认证token表
 * auth_access_token
 */
public class AccessTokenDo implements Serializable {
    /**
     * id
     * auth_access_token.id
     */
    private Integer id;

    /**
     * token id
     * auth_access_token.token_id
     */
    private String tokenId;

    /**
     * 认证id
     * auth_access_token.authentication_id
     */
    private String authenticationId;

    /**
     * 用户名
     * auth_access_token.user_name
     */
    private String userName;

    /**
     * 终端id
     * auth_access_token.client_id
     */
    private String clientId;

    /**
     * 刷新token
     * auth_access_token.refresh_token
     */
    private String refreshToken;

    /**
     * 创建人
     * auth_access_token.created_by
     */
    private Integer createdBy;

    /**
     * 创建时间
     * auth_access_token.created_dt
     */
    private Date createdDt;

    /**
     * 最后更新人
     * auth_access_token.last_update_by
     */
    private Integer lastUpdateBy;

    /**
     * 最后更新时间
     * auth_access_token.last_update_dt
     */
    private Date lastUpdateDt;

    /**
     * 状态
     * auth_access_token.sts
     */
    private String sts;

    /**
     * auth_access_token
     */
    private static final long serialVersionUID = 1L;

    /**
     * auth_access_token.id
     * @return the value of auth_access_token.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * auth_access_token.id
     * @param id the value for auth_access_token.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * auth_access_token.token_id
     * @return the value of auth_access_token.token_id
     */
    public String getTokenId() {
        return tokenId;
    }

    /**
     * auth_access_token.token_id
     * @param tokenId the value for auth_access_token.token_id
     */
    public void setTokenId(String tokenId) {
        this.tokenId = tokenId == null ? null : tokenId.trim();
    }

    /**
     * auth_access_token.authentication_id
     * @return the value of auth_access_token.authentication_id
     */
    public String getAuthenticationId() {
        return authenticationId;
    }

    /**
     * auth_access_token.authentication_id
     * @param authenticationId the value for auth_access_token.authentication_id
     */
    public void setAuthenticationId(String authenticationId) {
        this.authenticationId = authenticationId == null ? null : authenticationId.trim();
    }

    /**
     * auth_access_token.user_name
     * @return the value of auth_access_token.user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * auth_access_token.user_name
     * @param userName the value for auth_access_token.user_name
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * auth_access_token.client_id
     * @return the value of auth_access_token.client_id
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * auth_access_token.client_id
     * @param clientId the value for auth_access_token.client_id
     */
    public void setClientId(String clientId) {
        this.clientId = clientId == null ? null : clientId.trim();
    }

    /**
     * auth_access_token.refresh_token
     * @return the value of auth_access_token.refresh_token
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * auth_access_token.refresh_token
     * @param refreshToken the value for auth_access_token.refresh_token
     */
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken == null ? null : refreshToken.trim();
    }

    /**
     * auth_access_token.created_by
     * @return the value of auth_access_token.created_by
     */
    public Integer getCreatedBy() {
        return createdBy;
    }

    /**
     * auth_access_token.created_by
     * @param createdBy the value for auth_access_token.created_by
     */
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * auth_access_token.created_dt
     * @return the value of auth_access_token.created_dt
     */
    public Date getCreatedDt() {
        return createdDt;
    }

    /**
     * auth_access_token.created_dt
     * @param createdDt the value for auth_access_token.created_dt
     */
    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    /**
     * auth_access_token.last_update_by
     * @return the value of auth_access_token.last_update_by
     */
    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    /**
     * auth_access_token.last_update_by
     * @param lastUpdateBy the value for auth_access_token.last_update_by
     */
    public void setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    /**
     * auth_access_token.last_update_dt
     * @return the value of auth_access_token.last_update_dt
     */
    public Date getLastUpdateDt() {
        return lastUpdateDt;
    }

    /**
     * auth_access_token.last_update_dt
     * @param lastUpdateDt the value for auth_access_token.last_update_dt
     */
    public void setLastUpdateDt(Date lastUpdateDt) {
        this.lastUpdateDt = lastUpdateDt;
    }

    /**
     * auth_access_token.sts
     * @return the value of auth_access_token.sts
     */
    public String getSts() {
        return sts;
    }

    /**
     * auth_access_token.sts
     * @param sts the value for auth_access_token.sts
     */
    public void setSts(String sts) {
        this.sts = sts == null ? null : sts.trim();
    }

    /**
     * auth_access_token
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
        AccessTokenDo other = (AccessTokenDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTokenId() == null ? other.getTokenId() == null : this.getTokenId().equals(other.getTokenId()))
            && (this.getAuthenticationId() == null ? other.getAuthenticationId() == null : this.getAuthenticationId().equals(other.getAuthenticationId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getClientId() == null ? other.getClientId() == null : this.getClientId().equals(other.getClientId()))
            && (this.getRefreshToken() == null ? other.getRefreshToken() == null : this.getRefreshToken().equals(other.getRefreshToken()))
            && (this.getCreatedBy() == null ? other.getCreatedBy() == null : this.getCreatedBy().equals(other.getCreatedBy()))
            && (this.getCreatedDt() == null ? other.getCreatedDt() == null : this.getCreatedDt().equals(other.getCreatedDt()))
            && (this.getLastUpdateBy() == null ? other.getLastUpdateBy() == null : this.getLastUpdateBy().equals(other.getLastUpdateBy()))
            && (this.getLastUpdateDt() == null ? other.getLastUpdateDt() == null : this.getLastUpdateDt().equals(other.getLastUpdateDt()))
            && (this.getSts() == null ? other.getSts() == null : this.getSts().equals(other.getSts()));
    }

    /**
     * auth_access_token
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTokenId() == null) ? 0 : getTokenId().hashCode());
        result = prime * result + ((getAuthenticationId() == null) ? 0 : getAuthenticationId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getClientId() == null) ? 0 : getClientId().hashCode());
        result = prime * result + ((getRefreshToken() == null) ? 0 : getRefreshToken().hashCode());
        result = prime * result + ((getCreatedBy() == null) ? 0 : getCreatedBy().hashCode());
        result = prime * result + ((getCreatedDt() == null) ? 0 : getCreatedDt().hashCode());
        result = prime * result + ((getLastUpdateBy() == null) ? 0 : getLastUpdateBy().hashCode());
        result = prime * result + ((getLastUpdateDt() == null) ? 0 : getLastUpdateDt().hashCode());
        result = prime * result + ((getSts() == null) ? 0 : getSts().hashCode());
        return result;
    }
}