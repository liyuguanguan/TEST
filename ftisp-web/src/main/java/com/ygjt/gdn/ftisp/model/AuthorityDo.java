package com.ygjt.gdn.ftisp.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 认证权限表
 * auth_authority
 */
public class AuthorityDo implements Serializable {
    /**
     * ID
     * auth_authority.ID
     */
    private Integer id;

    /**
     * 权限标示
     * auth_authority.AUTHORITY_MARK
     */
    private String authorityMark;

    /**
     * 权限名称
     * auth_authority.AUTHORITY_NAME
     */
    private String authorityName;

    /**
     * 权限描述
     * auth_authority.AUTHORITY_DESC
     */
    private String authorityDesc;

    /**
     * 提示信息
     * auth_authority.MESSAGE
     */
    private String message;

    /**
     * ENABLE
     * auth_authority.ENABLE
     */
    private String enable;

    /**
     * ISSYS
     * auth_authority.ISSYS
     */
    private String issys;

    /**
     * 模块ID
     * auth_authority.MODULE_ID
     */
    private Integer moduleId;

    /**
     * create_dt
     * auth_authority.create_dt
     */
    private Date createDt;

    /**
     * create_by
     * auth_authority.create_by
     */
    private Integer createBy;

    /**
     * 最后更新时间
     * auth_authority.last_update_dt
     */
    private Date lastUpdateDt;

    /**
     * 最后更新人
     * auth_authority.last_update_by
     */
    private Integer lastUpdateBy;

    /**
     * 状态
     * auth_authority.sts
     */
    private String sts;

    /**
     * 系统ID
     * auth_authority.SYSTEM_ID
     */
    private Integer systemId;

    /**
     * auth_authority
     */
    private static final long serialVersionUID = 1L;

    /**
     * auth_authority.ID
     * @return the value of auth_authority.ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * auth_authority.ID
     * @param id the value for auth_authority.ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * auth_authority.AUTHORITY_MARK
     * @return the value of auth_authority.AUTHORITY_MARK
     */
    public String getAuthorityMark() {
        return authorityMark;
    }

    /**
     * auth_authority.AUTHORITY_MARK
     * @param authorityMark the value for auth_authority.AUTHORITY_MARK
     */
    public void setAuthorityMark(String authorityMark) {
        this.authorityMark = authorityMark == null ? null : authorityMark.trim();
    }

    /**
     * auth_authority.AUTHORITY_NAME
     * @return the value of auth_authority.AUTHORITY_NAME
     */
    public String getAuthorityName() {
        return authorityName;
    }

    /**
     * auth_authority.AUTHORITY_NAME
     * @param authorityName the value for auth_authority.AUTHORITY_NAME
     */
    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName == null ? null : authorityName.trim();
    }

    /**
     * auth_authority.AUTHORITY_DESC
     * @return the value of auth_authority.AUTHORITY_DESC
     */
    public String getAuthorityDesc() {
        return authorityDesc;
    }

    /**
     * auth_authority.AUTHORITY_DESC
     * @param authorityDesc the value for auth_authority.AUTHORITY_DESC
     */
    public void setAuthorityDesc(String authorityDesc) {
        this.authorityDesc = authorityDesc == null ? null : authorityDesc.trim();
    }

    /**
     * auth_authority.MESSAGE
     * @return the value of auth_authority.MESSAGE
     */
    public String getMessage() {
        return message;
    }

    /**
     * auth_authority.MESSAGE
     * @param message the value for auth_authority.MESSAGE
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    /**
     * auth_authority.ENABLE
     * @return the value of auth_authority.ENABLE
     */
    public String getEnable() {
        return enable;
    }

    /**
     * auth_authority.ENABLE
     * @param enable the value for auth_authority.ENABLE
     */
    public void setEnable(String enable) {
        this.enable = enable == null ? null : enable.trim();
    }

    /**
     * auth_authority.ISSYS
     * @return the value of auth_authority.ISSYS
     */
    public String getIssys() {
        return issys;
    }

    /**
     * auth_authority.ISSYS
     * @param issys the value for auth_authority.ISSYS
     */
    public void setIssys(String issys) {
        this.issys = issys == null ? null : issys.trim();
    }

    /**
     * auth_authority.MODULE_ID
     * @return the value of auth_authority.MODULE_ID
     */
    public Integer getModuleId() {
        return moduleId;
    }

    /**
     * auth_authority.MODULE_ID
     * @param moduleId the value for auth_authority.MODULE_ID
     */
    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * auth_authority.create_dt
     * @return the value of auth_authority.create_dt
     */
    public Date getCreateDt() {
        return createDt;
    }

    /**
     * auth_authority.create_dt
     * @param createDt the value for auth_authority.create_dt
     */
    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    /**
     * auth_authority.create_by
     * @return the value of auth_authority.create_by
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * auth_authority.create_by
     * @param createBy the value for auth_authority.create_by
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * auth_authority.last_update_dt
     * @return the value of auth_authority.last_update_dt
     */
    public Date getLastUpdateDt() {
        return lastUpdateDt;
    }

    /**
     * auth_authority.last_update_dt
     * @param lastUpdateDt the value for auth_authority.last_update_dt
     */
    public void setLastUpdateDt(Date lastUpdateDt) {
        this.lastUpdateDt = lastUpdateDt;
    }

    /**
     * auth_authority.last_update_by
     * @return the value of auth_authority.last_update_by
     */
    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    /**
     * auth_authority.last_update_by
     * @param lastUpdateBy the value for auth_authority.last_update_by
     */
    public void setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    /**
     * auth_authority.sts
     * @return the value of auth_authority.sts
     */
    public String getSts() {
        return sts;
    }

    /**
     * auth_authority.sts
     * @param sts the value for auth_authority.sts
     */
    public void setSts(String sts) {
        this.sts = sts == null ? null : sts.trim();
    }

    /**
     * auth_authority.SYSTEM_ID
     * @return the value of auth_authority.SYSTEM_ID
     */
    public Integer getSystemId() {
        return systemId;
    }

    /**
     * auth_authority.SYSTEM_ID
     * @param systemId the value for auth_authority.SYSTEM_ID
     */
    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    /**
     * auth_authority
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
        AuthorityDo other = (AuthorityDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAuthorityMark() == null ? other.getAuthorityMark() == null : this.getAuthorityMark().equals(other.getAuthorityMark()))
            && (this.getAuthorityName() == null ? other.getAuthorityName() == null : this.getAuthorityName().equals(other.getAuthorityName()))
            && (this.getAuthorityDesc() == null ? other.getAuthorityDesc() == null : this.getAuthorityDesc().equals(other.getAuthorityDesc()))
            && (this.getMessage() == null ? other.getMessage() == null : this.getMessage().equals(other.getMessage()))
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
     * auth_authority
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAuthorityMark() == null) ? 0 : getAuthorityMark().hashCode());
        result = prime * result + ((getAuthorityName() == null) ? 0 : getAuthorityName().hashCode());
        result = prime * result + ((getAuthorityDesc() == null) ? 0 : getAuthorityDesc().hashCode());
        result = prime * result + ((getMessage() == null) ? 0 : getMessage().hashCode());
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