package com.ygjt.gdn.ftisp.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 认证模块表
 * auth_module
 */
public class ModuleDo implements Serializable {
    /**
     * id
     * auth_module.ID
     */
    private Integer id;

    /**
     * 图标
     * auth_module.ICON
     */
    private String icon;

    /**
     * 模块名称
     * auth_module.MODULE_NAME
     */
    private String moduleName;

    /**
     * 模块描述
     * auth_module.MODULE_DESC
     */
    private String moduleDesc;

    /**
     * 模块类型
     * auth_module.MODULE_TYPE
     */
    private String moduleType;

    /**
     * 父级模块
     * auth_module.PARENT
     */
    private String parent;

    /**
     * 模块路径
     * auth_module.MODULE_URL
     */
    private String moduleUrl;

    /**
     * 模块级别
     * auth_module.I_LEVEL
     */
    private Integer iLevel;

    /**
     * LEAF
     * auth_module.LEAF
     */
    private Integer leaf;

    /**
     * CONTROLLER
     * auth_module.CONTROLLER
     */
    private String controller;

    /**
     * 优先级
     * auth_module.PRIORITY
     */
    private Integer priority;

    /**
     * 应用
     * auth_module.APPLICATION
     */
    private String application;

    /**
     * 系统ID
     * auth_module.SYSTEM_ID
     */
    private Integer systemId;

    /**
     * create_dt
     * auth_module.create_dt
     */
    private Date createDt;

    /**
     * create_by
     * auth_module.create_by
     */
    private Integer createBy;

    /**
     * 最后更新时间
     * auth_module.last_update_dt
     */
    private Date lastUpdateDt;

    /**
     * 最后更新人
     * auth_module.last_update_by
     */
    private Integer lastUpdateBy;

    /**
     * 状态
     * auth_module.sts
     */
    private String sts;

    /**
     * auth_module
     */
    private static final long serialVersionUID = 1L;

    /**
     * auth_module.ID
     * @return the value of auth_module.ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * auth_module.ID
     * @param id the value for auth_module.ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * auth_module.ICON
     * @return the value of auth_module.ICON
     */
    public String getIcon() {
        return icon;
    }

    /**
     * auth_module.ICON
     * @param icon the value for auth_module.ICON
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * auth_module.MODULE_NAME
     * @return the value of auth_module.MODULE_NAME
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * auth_module.MODULE_NAME
     * @param moduleName the value for auth_module.MODULE_NAME
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    /**
     * auth_module.MODULE_DESC
     * @return the value of auth_module.MODULE_DESC
     */
    public String getModuleDesc() {
        return moduleDesc;
    }

    /**
     * auth_module.MODULE_DESC
     * @param moduleDesc the value for auth_module.MODULE_DESC
     */
    public void setModuleDesc(String moduleDesc) {
        this.moduleDesc = moduleDesc == null ? null : moduleDesc.trim();
    }

    /**
     * auth_module.MODULE_TYPE
     * @return the value of auth_module.MODULE_TYPE
     */
    public String getModuleType() {
        return moduleType;
    }

    /**
     * auth_module.MODULE_TYPE
     * @param moduleType the value for auth_module.MODULE_TYPE
     */
    public void setModuleType(String moduleType) {
        this.moduleType = moduleType == null ? null : moduleType.trim();
    }

    /**
     * auth_module.PARENT
     * @return the value of auth_module.PARENT
     */
    public String getParent() {
        return parent;
    }

    /**
     * auth_module.PARENT
     * @param parent the value for auth_module.PARENT
     */
    public void setParent(String parent) {
        this.parent = parent == null ? null : parent.trim();
    }

    /**
     * auth_module.MODULE_URL
     * @return the value of auth_module.MODULE_URL
     */
    public String getModuleUrl() {
        return moduleUrl;
    }

    /**
     * auth_module.MODULE_URL
     * @param moduleUrl the value for auth_module.MODULE_URL
     */
    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl == null ? null : moduleUrl.trim();
    }

    /**
     * auth_module.I_LEVEL
     * @return the value of auth_module.I_LEVEL
     */
    public Integer getiLevel() {
        return iLevel;
    }

    /**
     * auth_module.I_LEVEL
     * @param iLevel the value for auth_module.I_LEVEL
     */
    public void setiLevel(Integer iLevel) {
        this.iLevel = iLevel;
    }

    /**
     * auth_module.LEAF
     * @return the value of auth_module.LEAF
     */
    public Integer getLeaf() {
        return leaf;
    }

    /**
     * auth_module.LEAF
     * @param leaf the value for auth_module.LEAF
     */
    public void setLeaf(Integer leaf) {
        this.leaf = leaf;
    }

    /**
     * auth_module.CONTROLLER
     * @return the value of auth_module.CONTROLLER
     */
    public String getController() {
        return controller;
    }

    /**
     * auth_module.CONTROLLER
     * @param controller the value for auth_module.CONTROLLER
     */
    public void setController(String controller) {
        this.controller = controller == null ? null : controller.trim();
    }

    /**
     * auth_module.PRIORITY
     * @return the value of auth_module.PRIORITY
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * auth_module.PRIORITY
     * @param priority the value for auth_module.PRIORITY
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * auth_module.APPLICATION
     * @return the value of auth_module.APPLICATION
     */
    public String getApplication() {
        return application;
    }

    /**
     * auth_module.APPLICATION
     * @param application the value for auth_module.APPLICATION
     */
    public void setApplication(String application) {
        this.application = application == null ? null : application.trim();
    }

    /**
     * auth_module.SYSTEM_ID
     * @return the value of auth_module.SYSTEM_ID
     */
    public Integer getSystemId() {
        return systemId;
    }

    /**
     * auth_module.SYSTEM_ID
     * @param systemId the value for auth_module.SYSTEM_ID
     */
    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    /**
     * auth_module.create_dt
     * @return the value of auth_module.create_dt
     */
    public Date getCreateDt() {
        return createDt;
    }

    /**
     * auth_module.create_dt
     * @param createDt the value for auth_module.create_dt
     */
    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    /**
     * auth_module.create_by
     * @return the value of auth_module.create_by
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * auth_module.create_by
     * @param createBy the value for auth_module.create_by
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * auth_module.last_update_dt
     * @return the value of auth_module.last_update_dt
     */
    public Date getLastUpdateDt() {
        return lastUpdateDt;
    }

    /**
     * auth_module.last_update_dt
     * @param lastUpdateDt the value for auth_module.last_update_dt
     */
    public void setLastUpdateDt(Date lastUpdateDt) {
        this.lastUpdateDt = lastUpdateDt;
    }

    /**
     * auth_module.last_update_by
     * @return the value of auth_module.last_update_by
     */
    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    /**
     * auth_module.last_update_by
     * @param lastUpdateBy the value for auth_module.last_update_by
     */
    public void setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    /**
     * auth_module.sts
     * @return the value of auth_module.sts
     */
    public String getSts() {
        return sts;
    }

    /**
     * auth_module.sts
     * @param sts the value for auth_module.sts
     */
    public void setSts(String sts) {
        this.sts = sts == null ? null : sts.trim();
    }

    /**
     * auth_module
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
        ModuleDo other = (ModuleDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getModuleName() == null ? other.getModuleName() == null : this.getModuleName().equals(other.getModuleName()))
            && (this.getModuleDesc() == null ? other.getModuleDesc() == null : this.getModuleDesc().equals(other.getModuleDesc()))
            && (this.getModuleType() == null ? other.getModuleType() == null : this.getModuleType().equals(other.getModuleType()))
            && (this.getParent() == null ? other.getParent() == null : this.getParent().equals(other.getParent()))
            && (this.getModuleUrl() == null ? other.getModuleUrl() == null : this.getModuleUrl().equals(other.getModuleUrl()))
            && (this.getiLevel() == null ? other.getiLevel() == null : this.getiLevel().equals(other.getiLevel()))
            && (this.getLeaf() == null ? other.getLeaf() == null : this.getLeaf().equals(other.getLeaf()))
            && (this.getController() == null ? other.getController() == null : this.getController().equals(other.getController()))
            && (this.getPriority() == null ? other.getPriority() == null : this.getPriority().equals(other.getPriority()))
            && (this.getApplication() == null ? other.getApplication() == null : this.getApplication().equals(other.getApplication()))
            && (this.getSystemId() == null ? other.getSystemId() == null : this.getSystemId().equals(other.getSystemId()))
            && (this.getCreateDt() == null ? other.getCreateDt() == null : this.getCreateDt().equals(other.getCreateDt()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getLastUpdateDt() == null ? other.getLastUpdateDt() == null : this.getLastUpdateDt().equals(other.getLastUpdateDt()))
            && (this.getLastUpdateBy() == null ? other.getLastUpdateBy() == null : this.getLastUpdateBy().equals(other.getLastUpdateBy()))
            && (this.getSts() == null ? other.getSts() == null : this.getSts().equals(other.getSts()));
    }

    /**
     * auth_module
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getModuleName() == null) ? 0 : getModuleName().hashCode());
        result = prime * result + ((getModuleDesc() == null) ? 0 : getModuleDesc().hashCode());
        result = prime * result + ((getModuleType() == null) ? 0 : getModuleType().hashCode());
        result = prime * result + ((getParent() == null) ? 0 : getParent().hashCode());
        result = prime * result + ((getModuleUrl() == null) ? 0 : getModuleUrl().hashCode());
        result = prime * result + ((getiLevel() == null) ? 0 : getiLevel().hashCode());
        result = prime * result + ((getLeaf() == null) ? 0 : getLeaf().hashCode());
        result = prime * result + ((getController() == null) ? 0 : getController().hashCode());
        result = prime * result + ((getPriority() == null) ? 0 : getPriority().hashCode());
        result = prime * result + ((getApplication() == null) ? 0 : getApplication().hashCode());
        result = prime * result + ((getSystemId() == null) ? 0 : getSystemId().hashCode());
        result = prime * result + ((getCreateDt() == null) ? 0 : getCreateDt().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getLastUpdateDt() == null) ? 0 : getLastUpdateDt().hashCode());
        result = prime * result + ((getLastUpdateBy() == null) ? 0 : getLastUpdateBy().hashCode());
        result = prime * result + ((getSts() == null) ? 0 : getSts().hashCode());
        return result;
    }
}