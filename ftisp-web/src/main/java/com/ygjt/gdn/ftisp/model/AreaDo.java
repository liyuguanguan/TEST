package com.ygjt.gdn.ftisp.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 平台区域信息
 * p_area
 */
public class AreaDo implements Serializable {
    /**
     * ID
     * p_area.id
     */
    private Integer id;

    /**
     * 地区编码
     * p_area.code
     */
    private String code;

    /**
     * 地区中文名称
     * p_area.name
     */
    private String name;

    /**
     * 地区英文名称
     * p_area.name_en
     */
    private String nameEn;

    /**
     * 层级
     * p_area.level
     */
    private Integer level;

    /**
     * 父级
     * p_area.parent_id
     */
    private Integer parentId;

    /**
     * 国家二字码
     * p_area.code_two
     */
    private String codeTwo;

    /**
     * 国家三字码
     * p_area.code_three
     */
    private String codeThree;

    /**
     * 创建时间
     * p_area.created_dt
     */
    private Date createdDt;

    /**
     * 创建人
     * p_area.created_by
     */
    private Integer createdBy;

    /**
     * 最后更新时间
     * p_area.last_update_dt
     */
    private Date lastUpdateDt;

    /**
     * 最后更新人
     * p_area.last_update_by
     */
    private Integer lastUpdateBy;

    /**
     * 状态
     * p_area.sts
     */
    private String sts;

    /**
     * p_area
     */
    private static final long serialVersionUID = 1L;

    /**
     * p_area.id
     * @return the value of p_area.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * p_area.id
     * @param id the value for p_area.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * p_area.code
     * @return the value of p_area.code
     */
    public String getCode() {
        return code;
    }

    /**
     * p_area.code
     * @param code the value for p_area.code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * p_area.name
     * @return the value of p_area.name
     */
    public String getName() {
        return name;
    }

    /**
     * p_area.name
     * @param name the value for p_area.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * p_area.name_en
     * @return the value of p_area.name_en
     */
    public String getNameEn() {
        return nameEn;
    }

    /**
     * p_area.name_en
     * @param nameEn the value for p_area.name_en
     */
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    /**
     * p_area.level
     * @return the value of p_area.level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * p_area.level
     * @param level the value for p_area.level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * p_area.parent_id
     * @return the value of p_area.parent_id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * p_area.parent_id
     * @param parentId the value for p_area.parent_id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * p_area.code_two
     * @return the value of p_area.code_two
     */
    public String getCodeTwo() {
        return codeTwo;
    }

    /**
     * p_area.code_two
     * @param codeTwo the value for p_area.code_two
     */
    public void setCodeTwo(String codeTwo) {
        this.codeTwo = codeTwo == null ? null : codeTwo.trim();
    }

    /**
     * p_area.code_three
     * @return the value of p_area.code_three
     */
    public String getCodeThree() {
        return codeThree;
    }

    /**
     * p_area.code_three
     * @param codeThree the value for p_area.code_three
     */
    public void setCodeThree(String codeThree) {
        this.codeThree = codeThree == null ? null : codeThree.trim();
    }

    /**
     * p_area.created_dt
     * @return the value of p_area.created_dt
     */
    public Date getCreatedDt() {
        return createdDt;
    }

    /**
     * p_area.created_dt
     * @param createdDt the value for p_area.created_dt
     */
    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    /**
     * p_area.created_by
     * @return the value of p_area.created_by
     */
    public Integer getCreatedBy() {
        return createdBy;
    }

    /**
     * p_area.created_by
     * @param createdBy the value for p_area.created_by
     */
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * p_area.last_update_dt
     * @return the value of p_area.last_update_dt
     */
    public Date getLastUpdateDt() {
        return lastUpdateDt;
    }

    /**
     * p_area.last_update_dt
     * @param lastUpdateDt the value for p_area.last_update_dt
     */
    public void setLastUpdateDt(Date lastUpdateDt) {
        this.lastUpdateDt = lastUpdateDt;
    }

    /**
     * p_area.last_update_by
     * @return the value of p_area.last_update_by
     */
    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    /**
     * p_area.last_update_by
     * @param lastUpdateBy the value for p_area.last_update_by
     */
    public void setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    /**
     * p_area.sts
     * @return the value of p_area.sts
     */
    public String getSts() {
        return sts;
    }

    /**
     * p_area.sts
     * @param sts the value for p_area.sts
     */
    public void setSts(String sts) {
        this.sts = sts == null ? null : sts.trim();
    }

    /**
     * p_area
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
        AreaDo other = (AreaDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getNameEn() == null ? other.getNameEn() == null : this.getNameEn().equals(other.getNameEn()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getCodeTwo() == null ? other.getCodeTwo() == null : this.getCodeTwo().equals(other.getCodeTwo()))
            && (this.getCodeThree() == null ? other.getCodeThree() == null : this.getCodeThree().equals(other.getCodeThree()))
            && (this.getCreatedDt() == null ? other.getCreatedDt() == null : this.getCreatedDt().equals(other.getCreatedDt()))
            && (this.getCreatedBy() == null ? other.getCreatedBy() == null : this.getCreatedBy().equals(other.getCreatedBy()))
            && (this.getLastUpdateDt() == null ? other.getLastUpdateDt() == null : this.getLastUpdateDt().equals(other.getLastUpdateDt()))
            && (this.getLastUpdateBy() == null ? other.getLastUpdateBy() == null : this.getLastUpdateBy().equals(other.getLastUpdateBy()))
            && (this.getSts() == null ? other.getSts() == null : this.getSts().equals(other.getSts()));
    }

    /**
     * p_area
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getNameEn() == null) ? 0 : getNameEn().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getCodeTwo() == null) ? 0 : getCodeTwo().hashCode());
        result = prime * result + ((getCodeThree() == null) ? 0 : getCodeThree().hashCode());
        result = prime * result + ((getCreatedDt() == null) ? 0 : getCreatedDt().hashCode());
        result = prime * result + ((getCreatedBy() == null) ? 0 : getCreatedBy().hashCode());
        result = prime * result + ((getLastUpdateDt() == null) ? 0 : getLastUpdateDt().hashCode());
        result = prime * result + ((getLastUpdateBy() == null) ? 0 : getLastUpdateBy().hashCode());
        result = prime * result + ((getSts() == null) ? 0 : getSts().hashCode());
        return result;
    }
}