package com.ygjt.gdn.ftisp.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 认证角色权限表
 * auth_role_authority
 */
public class RoleAuthorityDo implements Serializable {
    /**
     * ID
     * auth_role_authority.ID
     */
    private Integer id;

    /**
     * 角色ID
     * auth_role_authority.ROLE_ID
     */
    private Integer roleId;

    /**
     * create_dt
     * auth_role_authority.create_dt
     */
    private Date createDt;

    /**
     * create_by
     * auth_role_authority.create_by
     */
    private Integer createBy;

    /**
     * 最后更新时间
     * auth_role_authority.last_update_dt
     */
    private Date lastUpdateDt;

    /**
     * 最后更新人
     * auth_role_authority.last_update_by
     */
    private Integer lastUpdateBy;

    /**
     * 状态
     * auth_role_authority.sts
     */
    private String sts;

    /**
     * 权限ID
     * auth_role_authority.AUTHORITY_ID
     */
    private Integer authorityId;

    /**
     * auth_role_authority
     */
    private static final long serialVersionUID = 1L;

    /**
     * auth_role_authority.ID
     * @return the value of auth_role_authority.ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * auth_role_authority.ID
     * @param id the value for auth_role_authority.ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * auth_role_authority.ROLE_ID
     * @return the value of auth_role_authority.ROLE_ID
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * auth_role_authority.ROLE_ID
     * @param roleId the value for auth_role_authority.ROLE_ID
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * auth_role_authority.create_dt
     * @return the value of auth_role_authority.create_dt
     */
    public Date getCreateDt() {
        return createDt;
    }

    /**
     * auth_role_authority.create_dt
     * @param createDt the value for auth_role_authority.create_dt
     */
    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    /**
     * auth_role_authority.create_by
     * @return the value of auth_role_authority.create_by
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * auth_role_authority.create_by
     * @param createBy the value for auth_role_authority.create_by
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * auth_role_authority.last_update_dt
     * @return the value of auth_role_authority.last_update_dt
     */
    public Date getLastUpdateDt() {
        return lastUpdateDt;
    }

    /**
     * auth_role_authority.last_update_dt
     * @param lastUpdateDt the value for auth_role_authority.last_update_dt
     */
    public void setLastUpdateDt(Date lastUpdateDt) {
        this.lastUpdateDt = lastUpdateDt;
    }

    /**
     * auth_role_authority.last_update_by
     * @return the value of auth_role_authority.last_update_by
     */
    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    /**
     * auth_role_authority.last_update_by
     * @param lastUpdateBy the value for auth_role_authority.last_update_by
     */
    public void setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    /**
     * auth_role_authority.sts
     * @return the value of auth_role_authority.sts
     */
    public String getSts() {
        return sts;
    }

    /**
     * auth_role_authority.sts
     * @param sts the value for auth_role_authority.sts
     */
    public void setSts(String sts) {
        this.sts = sts == null ? null : sts.trim();
    }

    /**
     * auth_role_authority.AUTHORITY_ID
     * @return the value of auth_role_authority.AUTHORITY_ID
     */
    public Integer getAuthorityId() {
        return authorityId;
    }

    /**
     * auth_role_authority.AUTHORITY_ID
     * @param authorityId the value for auth_role_authority.AUTHORITY_ID
     */
    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    /**
     * auth_role_authority
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
        RoleAuthorityDo other = (RoleAuthorityDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getCreateDt() == null ? other.getCreateDt() == null : this.getCreateDt().equals(other.getCreateDt()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getLastUpdateDt() == null ? other.getLastUpdateDt() == null : this.getLastUpdateDt().equals(other.getLastUpdateDt()))
            && (this.getLastUpdateBy() == null ? other.getLastUpdateBy() == null : this.getLastUpdateBy().equals(other.getLastUpdateBy()))
            && (this.getSts() == null ? other.getSts() == null : this.getSts().equals(other.getSts()))
            && (this.getAuthorityId() == null ? other.getAuthorityId() == null : this.getAuthorityId().equals(other.getAuthorityId()));
    }

    /**
     * auth_role_authority
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getCreateDt() == null) ? 0 : getCreateDt().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getLastUpdateDt() == null) ? 0 : getLastUpdateDt().hashCode());
        result = prime * result + ((getLastUpdateBy() == null) ? 0 : getLastUpdateBy().hashCode());
        result = prime * result + ((getSts() == null) ? 0 : getSts().hashCode());
        result = prime * result + ((getAuthorityId() == null) ? 0 : getAuthorityId().hashCode());
        return result;
    }
}