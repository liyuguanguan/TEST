package com.ygjt.gdn.ftisp.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 认证角色表
 * auth_role
 */
public class RoleDo implements Serializable {
    /**
     * ID
     * auth_role.ID
     */
    private Integer id;

    /**
     * 角色名称
     * auth_role.ROLE_NAME
     */
    private String roleName;

    /**
     * 角色描述
     * auth_role.ROLE_DESC
     */
    private String roleDesc;

    /**
     * 启用状态
     * auth_role.ENABLE
     */
    private Integer enable;

    /**
     * ISSYS
     * auth_role.ISSYS
     */
    private Integer issys;

    /**
     * 模块ID
     * auth_role.MODULE_ID
     */
    private String moduleId;

    /**
     * create_dt
     * auth_role.create_dt
     */
    private Date createDt;

    /**
     * create_by
     * auth_role.create_by
     */
    private Integer createBy;

    /**
     * 最后更新时间
     * auth_role.last_update_dt
     */
    private Date lastUpdateDt;

    /**
     * 最后更新人
     * auth_role.last_update_by
     */
    private Integer lastUpdateBy;

    /**
     * 状态
     * auth_role.sts
     */
    private String sts;

    /**
     * 系统ID
     * auth_role.SYSTEM_ID
     */
    private Integer systemId;

    /**
     * auth_role
     */
    private static final long serialVersionUID = 1L;

    /**
     * auth_role.ID
     * @return the value of auth_role.ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * auth_role.ID
     * @param id the value for auth_role.ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * auth_role.ROLE_NAME
     * @return the value of auth_role.ROLE_NAME
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * auth_role.ROLE_NAME
     * @param roleName the value for auth_role.ROLE_NAME
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * auth_role.ROLE_DESC
     * @return the value of auth_role.ROLE_DESC
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     * auth_role.ROLE_DESC
     * @param roleDesc the value for auth_role.ROLE_DESC
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    /**
     * auth_role.ENABLE
     * @return the value of auth_role.ENABLE
     */
    public Integer getEnable() {
        return enable;
    }

    /**
     * auth_role.ENABLE
     * @param enable the value for auth_role.ENABLE
     */
    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    /**
     * auth_role.ISSYS
     * @return the value of auth_role.ISSYS
     */
    public Integer getIssys() {
        return issys;
    }

    /**
     * auth_role.ISSYS
     * @param issys the value for auth_role.ISSYS
     */
    public void setIssys(Integer issys) {
        this.issys = issys;
    }

    /**
     * auth_role.MODULE_ID
     * @return the value of auth_role.MODULE_ID
     */
    public String getModuleId() {
        return moduleId;
    }

    /**
     * auth_role.MODULE_ID
     * @param moduleId the value for auth_role.MODULE_ID
     */
    public void setModuleId(String moduleId) {
        this.moduleId = moduleId == null ? null : moduleId.trim();
    }

    /**
     * auth_role.create_dt
     * @return the value of auth_role.create_dt
     */
    public Date getCreateDt() {
        return createDt;
    }

    /**
     * auth_role.create_dt
     * @param createDt the value for auth_role.create_dt
     */
    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    /**
     * auth_role.create_by
     * @return the value of auth_role.create_by
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * auth_role.create_by
     * @param createBy the value for auth_role.create_by
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * auth_role.last_update_dt
     * @return the value of auth_role.last_update_dt
     */
    public Date getLastUpdateDt() {
        return lastUpdateDt;
    }

    /**
     * auth_role.last_update_dt
     * @param lastUpdateDt the value for auth_role.last_update_dt
     */
    public void setLastUpdateDt(Date lastUpdateDt) {
        this.lastUpdateDt = lastUpdateDt;
    }

    /**
     * auth_role.last_update_by
     * @return the value of auth_role.last_update_by
     */
    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    /**
     * auth_role.last_update_by
     * @param lastUpdateBy the value for auth_role.last_update_by
     */
    public void setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    /**
     * auth_role.sts
     * @return the value of auth_role.sts
     */
    public String getSts() {
        return sts;
    }

    /**
     * auth_role.sts
     * @param sts the value for auth_role.sts
     */
    public void setSts(String sts) {
        this.sts = sts == null ? null : sts.trim();
    }

    /**
     * auth_role.SYSTEM_ID
     * @return the value of auth_role.SYSTEM_ID
     */
    public Integer getSystemId() {
        return systemId;
    }

    /**
     * auth_role.SYSTEM_ID
     * @param systemId the value for auth_role.SYSTEM_ID
     */
    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    /**
     * auth_role
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
        RoleDo other = (RoleDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRoleName() == null ? other.getRoleName() == null : this.getRoleName().equals(other.getRoleName()))
            && (this.getRoleDesc() == null ? other.getRoleDesc() == null : this.getRoleDesc().equals(other.getRoleDesc()))
            && (this.getEnable() == null ? other.getEnable() == null : this.getEnable().equals(other.getEnable()))
            && (this.getIssys() == null ? other.getIssys() == null : this.getIssys().equals(other.getIssys()))
            && (this.getModuleId() == null ? other.getModuleId() == null : this.getModuleId().equals(other.getModuleId()))
            && (this.getCreateDt() == null ? other.getCreateDt() == null : this.getCreateDt().equals(other.getCreateDt()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getLastUpdateDt() == null ? other.getLastUpdateDt() == null : this.getLastUpdateDt().equals(other.getLastUpdateDt()))
            && (this.getLastUpdateBy() == null ? other.getLastUpdateBy() == null : this.getLastUpdateBy().equals(other.getLastUpdateBy()))
            && (this.getSts() == null ? other.getSts() == null : this.getSts().equals(other.getSts()))
            && (this.getSystemId() == null ? other.getSystemId() == null : this.getSystemId().equals(other.getSystemId()));
    }

    /**
     * auth_role
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRoleName() == null) ? 0 : getRoleName().hashCode());
        result = prime * result + ((getRoleDesc() == null) ? 0 : getRoleDesc().hashCode());
        result = prime * result + ((getEnable() == null) ? 0 : getEnable().hashCode());
        result = prime * result + ((getIssys() == null) ? 0 : getIssys().hashCode());
        result = prime * result + ((getModuleId() == null) ? 0 : getModuleId().hashCode());
        result = prime * result + ((getCreateDt() == null) ? 0 : getCreateDt().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getLastUpdateDt() == null) ? 0 : getLastUpdateDt().hashCode());
        result = prime * result + ((getLastUpdateBy() == null) ? 0 : getLastUpdateBy().hashCode());
        result = prime * result + ((getSts() == null) ? 0 : getSts().hashCode());
        result = prime * result + ((getSystemId() == null) ? 0 : getSystemId().hashCode());
        return result;
    }
}