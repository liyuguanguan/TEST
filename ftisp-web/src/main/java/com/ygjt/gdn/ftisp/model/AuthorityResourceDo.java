package com.ygjt.gdn.ftisp.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 认证权限资源表
 * auth_authority_resource
 */
public class AuthorityResourceDo implements Serializable {
    /**
     * ID
     * auth_authority_resource.ID
     */
    private Integer id;

    /**
     * 资源ID
     * auth_authority_resource.RESOURCE_ID
     */
    private Integer resourceId;

    /**
     * 权限ID
     * auth_authority_resource.AUTHORITY_ID
     */
    private Integer authorityId;

    /**
     * 创建时间
     * auth_authority_resource.CREATED_DT
     */
    private Date createdDt;

    /**
     * create_dt
     * auth_authority_resource.create_dt
     */
    private Date createDt;

    /**
     * create_by
     * auth_authority_resource.create_by
     */
    private Integer createBy;

    /**
     * 最后更新时间
     * auth_authority_resource.last_update_dt
     */
    private Date lastUpdateDt;

    /**
     * 最后更新人
     * auth_authority_resource.last_update_by
     */
    private Integer lastUpdateBy;

    /**
     * 状态
     * auth_authority_resource.sts
     */
    private String sts;

    /**
     * auth_authority_resource
     */
    private static final long serialVersionUID = 1L;

    /**
     * auth_authority_resource.ID
     * @return the value of auth_authority_resource.ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * auth_authority_resource.ID
     * @param id the value for auth_authority_resource.ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * auth_authority_resource.RESOURCE_ID
     * @return the value of auth_authority_resource.RESOURCE_ID
     */
    public Integer getResourceId() {
        return resourceId;
    }

    /**
     * auth_authority_resource.RESOURCE_ID
     * @param resourceId the value for auth_authority_resource.RESOURCE_ID
     */
    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * auth_authority_resource.AUTHORITY_ID
     * @return the value of auth_authority_resource.AUTHORITY_ID
     */
    public Integer getAuthorityId() {
        return authorityId;
    }

    /**
     * auth_authority_resource.AUTHORITY_ID
     * @param authorityId the value for auth_authority_resource.AUTHORITY_ID
     */
    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    /**
     * auth_authority_resource.CREATED_DT
     * @return the value of auth_authority_resource.CREATED_DT
     */
    public Date getCreatedDt() {
        return createdDt;
    }

    /**
     * auth_authority_resource.CREATED_DT
     * @param createdDt the value for auth_authority_resource.CREATED_DT
     */
    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    /**
     * auth_authority_resource.create_dt
     * @return the value of auth_authority_resource.create_dt
     */
    public Date getCreateDt() {
        return createDt;
    }

    /**
     * auth_authority_resource.create_dt
     * @param createDt the value for auth_authority_resource.create_dt
     */
    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    /**
     * auth_authority_resource.create_by
     * @return the value of auth_authority_resource.create_by
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * auth_authority_resource.create_by
     * @param createBy the value for auth_authority_resource.create_by
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * auth_authority_resource.last_update_dt
     * @return the value of auth_authority_resource.last_update_dt
     */
    public Date getLastUpdateDt() {
        return lastUpdateDt;
    }

    /**
     * auth_authority_resource.last_update_dt
     * @param lastUpdateDt the value for auth_authority_resource.last_update_dt
     */
    public void setLastUpdateDt(Date lastUpdateDt) {
        this.lastUpdateDt = lastUpdateDt;
    }

    /**
     * auth_authority_resource.last_update_by
     * @return the value of auth_authority_resource.last_update_by
     */
    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    /**
     * auth_authority_resource.last_update_by
     * @param lastUpdateBy the value for auth_authority_resource.last_update_by
     */
    public void setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    /**
     * auth_authority_resource.sts
     * @return the value of auth_authority_resource.sts
     */
    public String getSts() {
        return sts;
    }

    /**
     * auth_authority_resource.sts
     * @param sts the value for auth_authority_resource.sts
     */
    public void setSts(String sts) {
        this.sts = sts == null ? null : sts.trim();
    }

    /**
     * auth_authority_resource
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
        AuthorityResourceDo other = (AuthorityResourceDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getResourceId() == null ? other.getResourceId() == null : this.getResourceId().equals(other.getResourceId()))
            && (this.getAuthorityId() == null ? other.getAuthorityId() == null : this.getAuthorityId().equals(other.getAuthorityId()))
            && (this.getCreatedDt() == null ? other.getCreatedDt() == null : this.getCreatedDt().equals(other.getCreatedDt()))
            && (this.getCreateDt() == null ? other.getCreateDt() == null : this.getCreateDt().equals(other.getCreateDt()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getLastUpdateDt() == null ? other.getLastUpdateDt() == null : this.getLastUpdateDt().equals(other.getLastUpdateDt()))
            && (this.getLastUpdateBy() == null ? other.getLastUpdateBy() == null : this.getLastUpdateBy().equals(other.getLastUpdateBy()))
            && (this.getSts() == null ? other.getSts() == null : this.getSts().equals(other.getSts()));
    }

    /**
     * auth_authority_resource
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getResourceId() == null) ? 0 : getResourceId().hashCode());
        result = prime * result + ((getAuthorityId() == null) ? 0 : getAuthorityId().hashCode());
        result = prime * result + ((getCreatedDt() == null) ? 0 : getCreatedDt().hashCode());
        result = prime * result + ((getCreateDt() == null) ? 0 : getCreateDt().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getLastUpdateDt() == null) ? 0 : getLastUpdateDt().hashCode());
        result = prime * result + ((getLastUpdateBy() == null) ? 0 : getLastUpdateBy().hashCode());
        result = prime * result + ((getSts() == null) ? 0 : getSts().hashCode());
        return result;
    }
}