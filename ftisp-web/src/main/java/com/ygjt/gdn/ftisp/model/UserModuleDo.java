package com.ygjt.gdn.ftisp.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 认证用户模块表
 * auth_user_module
 */
public class UserModuleDo implements Serializable {
    /**
     * ID
     * auth_user_module.ID
     */
    private Integer id;

    /**
     * 模块ID
     * auth_user_module.MODULE_ID
     */
    private Integer moduleId;

    /**
     * 用户ID
     * auth_user_module.USER_ID
     */
    private Integer userId;

    /**
     * create_dt
     * auth_user_module.create_dt
     */
    private Date createDt;

    /**
     * create_by
     * auth_user_module.create_by
     */
    private Integer createBy;

    /**
     * 最后更新时间
     * auth_user_module.last_update_dt
     */
    private Date lastUpdateDt;

    /**
     * 最后更新人
     * auth_user_module.last_update_by
     */
    private Integer lastUpdateBy;

    /**
     * 状态
     * auth_user_module.sts
     */
    private String sts;

    /**
     * auth_user_module
     */
    private static final long serialVersionUID = 1L;

    /**
     * auth_user_module.ID
     * @return the value of auth_user_module.ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * auth_user_module.ID
     * @param id the value for auth_user_module.ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * auth_user_module.MODULE_ID
     * @return the value of auth_user_module.MODULE_ID
     */
    public Integer getModuleId() {
        return moduleId;
    }

    /**
     * auth_user_module.MODULE_ID
     * @param moduleId the value for auth_user_module.MODULE_ID
     */
    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * auth_user_module.USER_ID
     * @return the value of auth_user_module.USER_ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * auth_user_module.USER_ID
     * @param userId the value for auth_user_module.USER_ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * auth_user_module.create_dt
     * @return the value of auth_user_module.create_dt
     */
    public Date getCreateDt() {
        return createDt;
    }

    /**
     * auth_user_module.create_dt
     * @param createDt the value for auth_user_module.create_dt
     */
    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    /**
     * auth_user_module.create_by
     * @return the value of auth_user_module.create_by
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * auth_user_module.create_by
     * @param createBy the value for auth_user_module.create_by
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * auth_user_module.last_update_dt
     * @return the value of auth_user_module.last_update_dt
     */
    public Date getLastUpdateDt() {
        return lastUpdateDt;
    }

    /**
     * auth_user_module.last_update_dt
     * @param lastUpdateDt the value for auth_user_module.last_update_dt
     */
    public void setLastUpdateDt(Date lastUpdateDt) {
        this.lastUpdateDt = lastUpdateDt;
    }

    /**
     * auth_user_module.last_update_by
     * @return the value of auth_user_module.last_update_by
     */
    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    /**
     * auth_user_module.last_update_by
     * @param lastUpdateBy the value for auth_user_module.last_update_by
     */
    public void setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    /**
     * auth_user_module.sts
     * @return the value of auth_user_module.sts
     */
    public String getSts() {
        return sts;
    }

    /**
     * auth_user_module.sts
     * @param sts the value for auth_user_module.sts
     */
    public void setSts(String sts) {
        this.sts = sts == null ? null : sts.trim();
    }

    /**
     * auth_user_module
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
        UserModuleDo other = (UserModuleDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getModuleId() == null ? other.getModuleId() == null : this.getModuleId().equals(other.getModuleId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCreateDt() == null ? other.getCreateDt() == null : this.getCreateDt().equals(other.getCreateDt()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getLastUpdateDt() == null ? other.getLastUpdateDt() == null : this.getLastUpdateDt().equals(other.getLastUpdateDt()))
            && (this.getLastUpdateBy() == null ? other.getLastUpdateBy() == null : this.getLastUpdateBy().equals(other.getLastUpdateBy()))
            && (this.getSts() == null ? other.getSts() == null : this.getSts().equals(other.getSts()));
    }

    /**
     * auth_user_module
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getModuleId() == null) ? 0 : getModuleId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCreateDt() == null) ? 0 : getCreateDt().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getLastUpdateDt() == null) ? 0 : getLastUpdateDt().hashCode());
        result = prime * result + ((getLastUpdateBy() == null) ? 0 : getLastUpdateBy().hashCode());
        result = prime * result + ((getSts() == null) ? 0 : getSts().hashCode());
        return result;
    }
}