package com.ygjt.gdn.ftisp.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 认证系统表
 * auth_system
 */
public class AuthSystemDo implements Serializable {
    /**
     * ID
     * auth_system.ID
     */
    private Integer id;

    /**
     * 系统名称
     * auth_system.NAME
     */
    private String name;

    /**
     * 系统地址
     * auth_system.URL
     */
    private String url;

    /**
     * 描述
     * auth_system.description
     */
    private String description;

    /**
     * create_dt
     * auth_system.create_dt
     */
    private Date createDt;

    /**
     * create_by
     * auth_system.create_by
     */
    private Integer createBy;

    /**
     * 最后更新时间
     * auth_system.last_update_dt
     */
    private Date lastUpdateDt;

    /**
     * 最后更新人
     * auth_system.last_update_by
     */
    private Integer lastUpdateBy;

    /**
     * 状态
     * auth_system.sts
     */
    private String sts;

    /**
     * auth_system
     */
    private static final long serialVersionUID = 1L;

    /**
     * auth_system.ID
     * @return the value of auth_system.ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * auth_system.ID
     * @param id the value for auth_system.ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * auth_system.NAME
     * @return the value of auth_system.NAME
     */
    public String getName() {
        return name;
    }

    /**
     * auth_system.NAME
     * @param name the value for auth_system.NAME
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * auth_system.URL
     * @return the value of auth_system.URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * auth_system.URL
     * @param url the value for auth_system.URL
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * auth_system.description
     * @return the value of auth_system.description
     */
    public String getDescription() {
        return description;
    }

    /**
     * auth_system.description
     * @param description the value for auth_system.description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * auth_system.create_dt
     * @return the value of auth_system.create_dt
     */
    public Date getCreateDt() {
        return createDt;
    }

    /**
     * auth_system.create_dt
     * @param createDt the value for auth_system.create_dt
     */
    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    /**
     * auth_system.create_by
     * @return the value of auth_system.create_by
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * auth_system.create_by
     * @param createBy the value for auth_system.create_by
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * auth_system.last_update_dt
     * @return the value of auth_system.last_update_dt
     */
    public Date getLastUpdateDt() {
        return lastUpdateDt;
    }

    /**
     * auth_system.last_update_dt
     * @param lastUpdateDt the value for auth_system.last_update_dt
     */
    public void setLastUpdateDt(Date lastUpdateDt) {
        this.lastUpdateDt = lastUpdateDt;
    }

    /**
     * auth_system.last_update_by
     * @return the value of auth_system.last_update_by
     */
    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    /**
     * auth_system.last_update_by
     * @param lastUpdateBy the value for auth_system.last_update_by
     */
    public void setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    /**
     * auth_system.sts
     * @return the value of auth_system.sts
     */
    public String getSts() {
        return sts;
    }

    /**
     * auth_system.sts
     * @param sts the value for auth_system.sts
     */
    public void setSts(String sts) {
        this.sts = sts == null ? null : sts.trim();
    }

    /**
     * auth_system
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
        AuthSystemDo other = (AuthSystemDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCreateDt() == null ? other.getCreateDt() == null : this.getCreateDt().equals(other.getCreateDt()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getLastUpdateDt() == null ? other.getLastUpdateDt() == null : this.getLastUpdateDt().equals(other.getLastUpdateDt()))
            && (this.getLastUpdateBy() == null ? other.getLastUpdateBy() == null : this.getLastUpdateBy().equals(other.getLastUpdateBy()))
            && (this.getSts() == null ? other.getSts() == null : this.getSts().equals(other.getSts()));
    }

    /**
     * auth_system
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCreateDt() == null) ? 0 : getCreateDt().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getLastUpdateDt() == null) ? 0 : getLastUpdateDt().hashCode());
        result = prime * result + ((getLastUpdateBy() == null) ? 0 : getLastUpdateBy().hashCode());
        result = prime * result + ((getSts() == null) ? 0 : getSts().hashCode());
        return result;
    }
}