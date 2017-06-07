package com.ygjt.gdn.ftisp.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * 认证代码码
 * auth_code
 */
public class AuthCodeDo implements Serializable {
    /**
     * id
     * auth_code.id
     */
    private Integer id;

    /**
     * auth_code.code
     */
    private String code;

    /**
     * 创建人
     * auth_code.created_by
     */
    private Integer createdBy;

    /**
     * 创建时间
     * auth_code.created_dt
     */
    private Date createdDt;

    /**
     * 最后更新人
     * auth_code.last_update_by
     */
    private Integer lastUpdateBy;

    /**
     * 最后更新时间
     * auth_code.last_update_dt
     */
    private Date lastUpdateDt;

    /**
     * 状态
     * auth_code.sts
     */
    private String sts;

    /**
     * auth_code.authentication
     */
    private byte[] authentication;

    /**
     * auth_code
     */
    private static final long serialVersionUID = 1L;

    /**
     * auth_code.id
     * @return the value of auth_code.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * auth_code.id
     * @param id the value for auth_code.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * auth_code.code
     * @return the value of auth_code.code
     */
    public String getCode() {
        return code;
    }

    /**
     * auth_code.code
     * @param code the value for auth_code.code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * auth_code.created_by
     * @return the value of auth_code.created_by
     */
    public Integer getCreatedBy() {
        return createdBy;
    }

    /**
     * auth_code.created_by
     * @param createdBy the value for auth_code.created_by
     */
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * auth_code.created_dt
     * @return the value of auth_code.created_dt
     */
    public Date getCreatedDt() {
        return createdDt;
    }

    /**
     * auth_code.created_dt
     * @param createdDt the value for auth_code.created_dt
     */
    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    /**
     * auth_code.last_update_by
     * @return the value of auth_code.last_update_by
     */
    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    /**
     * auth_code.last_update_by
     * @param lastUpdateBy the value for auth_code.last_update_by
     */
    public void setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    /**
     * auth_code.last_update_dt
     * @return the value of auth_code.last_update_dt
     */
    public Date getLastUpdateDt() {
        return lastUpdateDt;
    }

    /**
     * auth_code.last_update_dt
     * @param lastUpdateDt the value for auth_code.last_update_dt
     */
    public void setLastUpdateDt(Date lastUpdateDt) {
        this.lastUpdateDt = lastUpdateDt;
    }

    /**
     * auth_code.sts
     * @return the value of auth_code.sts
     */
    public String getSts() {
        return sts;
    }

    /**
     * auth_code.sts
     * @param sts the value for auth_code.sts
     */
    public void setSts(String sts) {
        this.sts = sts == null ? null : sts.trim();
    }

    /**
     * auth_code.authentication
     * @return the value of auth_code.authentication
     */
    public byte[] getAuthentication() {
        return authentication;
    }

    /**
     * auth_code.authentication
     * @param authentication the value for auth_code.authentication
     */
    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }

    /**
     * auth_code
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
        AuthCodeDo other = (AuthCodeDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getCreatedBy() == null ? other.getCreatedBy() == null : this.getCreatedBy().equals(other.getCreatedBy()))
            && (this.getCreatedDt() == null ? other.getCreatedDt() == null : this.getCreatedDt().equals(other.getCreatedDt()))
            && (this.getLastUpdateBy() == null ? other.getLastUpdateBy() == null : this.getLastUpdateBy().equals(other.getLastUpdateBy()))
            && (this.getLastUpdateDt() == null ? other.getLastUpdateDt() == null : this.getLastUpdateDt().equals(other.getLastUpdateDt()))
            && (this.getSts() == null ? other.getSts() == null : this.getSts().equals(other.getSts()))
            && (Arrays.equals(this.getAuthentication(), other.getAuthentication()));
    }

    /**
     * auth_code
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getCreatedBy() == null) ? 0 : getCreatedBy().hashCode());
        result = prime * result + ((getCreatedDt() == null) ? 0 : getCreatedDt().hashCode());
        result = prime * result + ((getLastUpdateBy() == null) ? 0 : getLastUpdateBy().hashCode());
        result = prime * result + ((getLastUpdateDt() == null) ? 0 : getLastUpdateDt().hashCode());
        result = prime * result + ((getSts() == null) ? 0 : getSts().hashCode());
        result = prime * result + (Arrays.hashCode(getAuthentication()));
        return result;
    }
}