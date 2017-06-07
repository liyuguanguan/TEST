package com.ygjt.gdn.ftisp.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 认证授权码表
 * auth_refresh_token
 */
public class RefreshTokenWithBLOBs extends RefreshTokenDo implements Serializable {
    /**
     * auth_refresh_token.token
     */
    private byte[] token;

    /**
     * auth_refresh_token.authentication
     */
    private byte[] authentication;

    /**
     * auth_refresh_token
     */
    private static final long serialVersionUID = 1L;

    /**
     * auth_refresh_token.token
     * @return the value of auth_refresh_token.token
     */
    public byte[] getToken() {
        return token;
    }

    /**
     * auth_refresh_token.token
     * @param token the value for auth_refresh_token.token
     */
    public void setToken(byte[] token) {
        this.token = token;
    }

    /**
     * auth_refresh_token.authentication
     * @return the value of auth_refresh_token.authentication
     */
    public byte[] getAuthentication() {
        return authentication;
    }

    /**
     * auth_refresh_token.authentication
     * @param authentication the value for auth_refresh_token.authentication
     */
    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }

    /**
     * auth_refresh_token
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
        RefreshTokenWithBLOBs other = (RefreshTokenWithBLOBs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTokenId() == null ? other.getTokenId() == null : this.getTokenId().equals(other.getTokenId()))
            && (this.getCreatedBy() == null ? other.getCreatedBy() == null : this.getCreatedBy().equals(other.getCreatedBy()))
            && (this.getCreatedDt() == null ? other.getCreatedDt() == null : this.getCreatedDt().equals(other.getCreatedDt()))
            && (this.getLastUpdateBy() == null ? other.getLastUpdateBy() == null : this.getLastUpdateBy().equals(other.getLastUpdateBy()))
            && (this.getLastUpdateDt() == null ? other.getLastUpdateDt() == null : this.getLastUpdateDt().equals(other.getLastUpdateDt()))
            && (this.getSts() == null ? other.getSts() == null : this.getSts().equals(other.getSts()))
            && (Arrays.equals(this.getToken(), other.getToken()))
            && (Arrays.equals(this.getAuthentication(), other.getAuthentication()));
    }

    /**
     * auth_refresh_token
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTokenId() == null) ? 0 : getTokenId().hashCode());
        result = prime * result + ((getCreatedBy() == null) ? 0 : getCreatedBy().hashCode());
        result = prime * result + ((getCreatedDt() == null) ? 0 : getCreatedDt().hashCode());
        result = prime * result + ((getLastUpdateBy() == null) ? 0 : getLastUpdateBy().hashCode());
        result = prime * result + ((getLastUpdateDt() == null) ? 0 : getLastUpdateDt().hashCode());
        result = prime * result + ((getSts() == null) ? 0 : getSts().hashCode());
        result = prime * result + (Arrays.hashCode(getToken()));
        result = prime * result + (Arrays.hashCode(getAuthentication()));
        return result;
    }
}