package com.ygjt.gdn.ftisp.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 认证资源表
 * auth_resource
 */
public class ResourceDo implements Serializable {
    /**
     * 资源ID
     * auth_resource.ID
     */
    private Integer id;

    /**
     * 资源类型
     * auth_resource.RESOURCE_TYPE
     */
    private String resourceType;

    /**
     * 资源名称
     * auth_resource.RESOURCE_NAME
     */
    private String resourceName;

    /**
     * 资源描述
     * auth_resource.RESOURCE_DESC
     */
    private String resourceDesc;

    /**
     * 资源路径
     * auth_resource.RESOURCE_PATH
     */
    private String resourcePath;

    /**
     * 优先次序
     * auth_resource.PRIORITY
     */
    private String priority;

    /**
     * ENABLE
     * auth_resource.ENABLE
     */
    private String enable;

    /**
     * ISSYS
     * auth_resource.ISSYS
     */
    private String issys;

    /**
     * 模块ID
     * auth_resource.MODULE_ID
     */
    private String moduleId;

    /**
     * create_dt
     * auth_resource.create_dt
     */
    private Date createDt;

    /**
     * create_by
     * auth_resource.create_by
     */
    private Integer createBy;

    /**
     * 最后更新时间
     * auth_resource.last_update_dt
     */
    private Date lastUpdateDt;

    /**
     * 最后更新人
     * auth_resource.last_update_by
     */
    private Integer lastUpdateBy;

    /**
     * 状态
     * auth_resource.sts
     */
    private String sts;

    /**
     * 系统ID
     * auth_resource.SYSTEM_ID
     */
    private Integer systemId;

    /**
     * auth_resource
     */
    private static final long serialVersionUID = 1L;

    /**
     * auth_resource.ID
     * @return the value of auth_resource.ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * auth_resource.ID
     * @param id the value for auth_resource.ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * auth_resource.RESOURCE_TYPE
     * @return the value of auth_resource.RESOURCE_TYPE
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     * auth_resource.RESOURCE_TYPE
     * @param resourceType the value for auth_resource.RESOURCE_TYPE
     */
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType == null ? null : resourceType.trim();
    }

    /**
     * auth_resource.RESOURCE_NAME
     * @return the value of auth_resource.RESOURCE_NAME
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * auth_resource.RESOURCE_NAME
     * @param resourceName the value for auth_resource.RESOURCE_NAME
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    /**
     * auth_resource.RESOURCE_DESC
     * @return the value of auth_resource.RESOURCE_DESC
     */
    public String getResourceDesc() {
        return resourceDesc;
    }

    /**
     * auth_resource.RESOURCE_DESC
     * @param resourceDesc the value for auth_resource.RESOURCE_DESC
     */
    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc == null ? null : resourceDesc.trim();
    }

    /**
     * auth_resource.RESOURCE_PATH
     * @return the value of auth_resource.RESOURCE_PATH
     */
    public String getResourcePath() {
        return resourcePath;
    }

    /**
     * auth_resource.RESOURCE_PATH
     * @param resourcePath the value for auth_resource.RESOURCE_PATH
     */
    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath == null ? null : resourcePath.trim();
    }

    /**
     * auth_resource.PRIORITY
     * @return the value of auth_resource.PRIORITY
     */
    public String getPriority() {
        return priority;
    }

    /**
     * auth_resource.PRIORITY
     * @param priority the value for auth_resource.PRIORITY
     */
    public void setPriority(String priority) {
        this.priority = priority == null ? null : priority.trim();
    }

    /**
     * auth_resource.ENABLE
     * @return the value of auth_resource.ENABLE
     */
    public String getEnable() {
        return enable;
    }

    /**
     * auth_resource.ENABLE
     * @param enable the value for auth_resource.ENABLE
     */
    public void setEnable(String enable) {
        this.enable = enable == null ? null : enable.trim();
    }

    /**
     * auth_resource.ISSYS
     * @return the value of auth_resource.ISSYS
     */
    public String getIssys() {
        return issys;
    }

    /**
     * auth_resource.ISSYS
     * @param issys the value for auth_resource.ISSYS
     */
    public void setIssys(String issys) {
        this.issys = issys == null ? null : issys.trim();
    }

    /**
     * auth_resource.MODULE_ID
     * @return the value of auth_resource.MODULE_ID
     */
    public String getModuleId() {
        return moduleId;
    }

    /**
     * auth_resource.MODULE_ID
     * @param moduleId the value for auth_resource.MODULE_ID
     */
    public void setModuleId(String moduleId) {
        this.moduleId = moduleId == null ? null : moduleId.trim();
    }

    /**
     * auth_resource.create_dt
     * @return the value of auth_resource.create_dt
     */
    public Date getCreateDt() {
        return createDt;
    }

    /**
     * auth_resource.create_dt
     * @param createDt the value for auth_resource.create_dt
     */
    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    /**
     * auth_resource.create_by
     * @return the value of auth_resource.create_by
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * auth_resource.create_by
     * @param createBy the value for auth_resource.create_by
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * auth_resource.last_update_dt
     * @return the value of auth_resource.last_update_dt
     */
    public Date getLastUpdateDt() {
        return lastUpdateDt;
    }

    /**
     * auth_resource.last_update_dt
     * @param lastUpdateDt the value for auth_resource.last_update_dt
     */
    public void setLastUpdateDt(Date lastUpdateDt) {
        this.lastUpdateDt = lastUpdateDt;
    }

    /**
     * auth_resource.last_update_by
     * @return the value of auth_resource.last_update_by
     */
    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    /**
     * auth_resource.last_update_by
     * @param lastUpdateBy the value for auth_resource.last_update_by
     */
    public void setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    /**
     * auth_resource.sts
     * @return the value of auth_resource.sts
     */
    public String getSts() {
        return sts;
    }

    /**
     * auth_resource.sts
     * @param sts the value for auth_resource.sts
     */
    public void setSts(String sts) {
        this.sts = sts == null ? null : sts.trim();
    }

    /**
     * auth_resource.SYSTEM_ID
     * @return the value of auth_resource.SYSTEM_ID
     */
    public Integer getSystemId() {
        return systemId;
    }

    /**
     * auth_resource.SYSTEM_ID
     * @param systemId the value for auth_resource.SYSTEM_ID
     */
    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    /**
     * auth_resource
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
        ResourceDo other = (ResourceDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getResourceType() == null ? other.getResourceType() == null : this.getResourceType().equals(other.getResourceType()))
            && (this.getResourceName() == null ? other.getResourceName() == null : this.getResourceName().equals(other.getResourceName()))
            && (this.getResourceDesc() == null ? other.getResourceDesc() == null : this.getResourceDesc().equals(other.getResourceDesc()))
            && (this.getResourcePath() == null ? other.getResourcePath() == null : this.getResourcePath().equals(other.getResourcePath()))
            && (this.getPriority() == null ? other.getPriority() == null : this.getPriority().equals(other.getPriority()))
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
     * auth_resource
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getResourceType() == null) ? 0 : getResourceType().hashCode());
        result = prime * result + ((getResourceName() == null) ? 0 : getResourceName().hashCode());
        result = prime * result + ((getResourceDesc() == null) ? 0 : getResourceDesc().hashCode());
        result = prime * result + ((getResourcePath() == null) ? 0 : getResourcePath().hashCode());
        result = prime * result + ((getPriority() == null) ? 0 : getPriority().hashCode());
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