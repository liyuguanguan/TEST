package com.ygjt.gdn.ftisp.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业信息
 * crm_ent_info
 */
public class EntInfoDo implements Serializable {
    /**
     * ID
     * crm_ent_info.id
     */
    private Integer id;

    /**
     * 客户名称
     * crm_ent_info.name
     */
    private String name;

    /**
     * 营业执照
     * crm_ent_info.busi_license
     */
    private String busiLicense;

    /**
     * 社会征信号
     * crm_ent_info.corp_social_no
     */
    private String corpSocialNo;

    /**
     * 开户类型
            E:企业客户
            P:个人客户
     * crm_ent_info.type
     */
    private String type;

    /**
     * 手机号码
     * crm_ent_info.link_phone
     */
    private String linkPhone;

    /**
     * 联系人
     * crm_ent_info.link_man
     */
    private String linkMan;

    /**
     * 固定电话
     * crm_ent_info.link_tel
     */
    private String linkTel;

    /**
     * 国家
     * crm_ent_info.country_id
     */
    private Integer countryId;

    /**
     * 省
     * crm_ent_info.province_id
     */
    private Integer provinceId;

    /**
     * 市
     * crm_ent_info.city_id
     */
    private Integer cityId;

    /**
     * 区
     * crm_ent_info.area_id
     */
    private Integer areaId;

    /**
     * 地址
     * crm_ent_info.address
     */
    private String address;

    /**
     * QQ
     * crm_ent_info.qq
     */
    private String qq;

    /**
     * 联系邮箱
     * crm_ent_info.email
     */
    private String email;

    /**
     * 联系传真
     * crm_ent_info.fax
     */
    private String fax;

    /**
     * 邮政编号
     * crm_ent_info.zipcode
     */
    private String zipcode;

    /**
     * 紧急联系人
     * crm_ent_info.emergency_link_man
     */
    private String emergencyLinkMan;

    /**
     * 紧急联系人电话
     * crm_ent_info.emergency_link_tel
     */
    private String emergencyLinkTel;

    /**
     * 创建人
     * crm_ent_info.create_by
     */
    private Integer createBy;

    /**
     * 创建时间
     * crm_ent_info.create_dt
     */
    private Date createDt;

    /**
     * 最后更新人
     * crm_ent_info.last_update_by
     */
    private Integer lastUpdateBy;

    /**
     * 最后更新时间
     * crm_ent_info.last_update_dt
     */
    private Date lastUpdateDt;

    /**
     * 状态
     * crm_ent_info.sts
     */
    private String sts;

    /**
     * 联系人职务
     * crm_ent_info.linkman_duty
     */
    private String linkmanDuty;

    /**
     * 销售代表邮箱
     * crm_ent_info.sale_email
     */
    private String saleEmail;

    /**
     * 所属用户账号
     * crm_ent_info.user_id
     */
    private Integer userId;

    /**
     * 审核状态 新建 U 待审核 C 审核通过P 审核失败R
     * crm_ent_info.audit_sts
     */
    private String auditSts;

    /**
     * 退回原因
     * crm_ent_info.reject_reason
     */
    private String rejectReason;

    /**
     * crm_ent_info
     */
    private static final long serialVersionUID = 1L;

    /**
     * crm_ent_info.id
     * @return the value of crm_ent_info.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * crm_ent_info.id
     * @param id the value for crm_ent_info.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * crm_ent_info.name
     * @return the value of crm_ent_info.name
     */
    public String getName() {
        return name;
    }

    /**
     * crm_ent_info.name
     * @param name the value for crm_ent_info.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * crm_ent_info.busi_license
     * @return the value of crm_ent_info.busi_license
     */
    public String getBusiLicense() {
        return busiLicense;
    }

    /**
     * crm_ent_info.busi_license
     * @param busiLicense the value for crm_ent_info.busi_license
     */
    public void setBusiLicense(String busiLicense) {
        this.busiLicense = busiLicense == null ? null : busiLicense.trim();
    }

    /**
     * crm_ent_info.corp_social_no
     * @return the value of crm_ent_info.corp_social_no
     */
    public String getCorpSocialNo() {
        return corpSocialNo;
    }

    /**
     * crm_ent_info.corp_social_no
     * @param corpSocialNo the value for crm_ent_info.corp_social_no
     */
    public void setCorpSocialNo(String corpSocialNo) {
        this.corpSocialNo = corpSocialNo == null ? null : corpSocialNo.trim();
    }

    /**
     * crm_ent_info.type
     * @return the value of crm_ent_info.type
     */
    public String getType() {
        return type;
    }

    /**
     * crm_ent_info.type
     * @param type the value for crm_ent_info.type
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * crm_ent_info.link_phone
     * @return the value of crm_ent_info.link_phone
     */
    public String getLinkPhone() {
        return linkPhone;
    }

    /**
     * crm_ent_info.link_phone
     * @param linkPhone the value for crm_ent_info.link_phone
     */
    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone == null ? null : linkPhone.trim();
    }

    /**
     * crm_ent_info.link_man
     * @return the value of crm_ent_info.link_man
     */
    public String getLinkMan() {
        return linkMan;
    }

    /**
     * crm_ent_info.link_man
     * @param linkMan the value for crm_ent_info.link_man
     */
    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan == null ? null : linkMan.trim();
    }

    /**
     * crm_ent_info.link_tel
     * @return the value of crm_ent_info.link_tel
     */
    public String getLinkTel() {
        return linkTel;
    }

    /**
     * crm_ent_info.link_tel
     * @param linkTel the value for crm_ent_info.link_tel
     */
    public void setLinkTel(String linkTel) {
        this.linkTel = linkTel == null ? null : linkTel.trim();
    }

    /**
     * crm_ent_info.country_id
     * @return the value of crm_ent_info.country_id
     */
    public Integer getCountryId() {
        return countryId;
    }

    /**
     * crm_ent_info.country_id
     * @param countryId the value for crm_ent_info.country_id
     */
    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    /**
     * crm_ent_info.province_id
     * @return the value of crm_ent_info.province_id
     */
    public Integer getProvinceId() {
        return provinceId;
    }

    /**
     * crm_ent_info.province_id
     * @param provinceId the value for crm_ent_info.province_id
     */
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * crm_ent_info.city_id
     * @return the value of crm_ent_info.city_id
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * crm_ent_info.city_id
     * @param cityId the value for crm_ent_info.city_id
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * crm_ent_info.area_id
     * @return the value of crm_ent_info.area_id
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     * crm_ent_info.area_id
     * @param areaId the value for crm_ent_info.area_id
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * crm_ent_info.address
     * @return the value of crm_ent_info.address
     */
    public String getAddress() {
        return address;
    }

    /**
     * crm_ent_info.address
     * @param address the value for crm_ent_info.address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * crm_ent_info.qq
     * @return the value of crm_ent_info.qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * crm_ent_info.qq
     * @param qq the value for crm_ent_info.qq
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    /**
     * crm_ent_info.email
     * @return the value of crm_ent_info.email
     */
    public String getEmail() {
        return email;
    }

    /**
     * crm_ent_info.email
     * @param email the value for crm_ent_info.email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * crm_ent_info.fax
     * @return the value of crm_ent_info.fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * crm_ent_info.fax
     * @param fax the value for crm_ent_info.fax
     */
    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    /**
     * crm_ent_info.zipcode
     * @return the value of crm_ent_info.zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * crm_ent_info.zipcode
     * @param zipcode the value for crm_ent_info.zipcode
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    /**
     * crm_ent_info.emergency_link_man
     * @return the value of crm_ent_info.emergency_link_man
     */
    public String getEmergencyLinkMan() {
        return emergencyLinkMan;
    }

    /**
     * crm_ent_info.emergency_link_man
     * @param emergencyLinkMan the value for crm_ent_info.emergency_link_man
     */
    public void setEmergencyLinkMan(String emergencyLinkMan) {
        this.emergencyLinkMan = emergencyLinkMan == null ? null : emergencyLinkMan.trim();
    }

    /**
     * crm_ent_info.emergency_link_tel
     * @return the value of crm_ent_info.emergency_link_tel
     */
    public String getEmergencyLinkTel() {
        return emergencyLinkTel;
    }

    /**
     * crm_ent_info.emergency_link_tel
     * @param emergencyLinkTel the value for crm_ent_info.emergency_link_tel
     */
    public void setEmergencyLinkTel(String emergencyLinkTel) {
        this.emergencyLinkTel = emergencyLinkTel == null ? null : emergencyLinkTel.trim();
    }

    /**
     * crm_ent_info.create_by
     * @return the value of crm_ent_info.create_by
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * crm_ent_info.create_by
     * @param createBy the value for crm_ent_info.create_by
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * crm_ent_info.create_dt
     * @return the value of crm_ent_info.create_dt
     */
    public Date getCreateDt() {
        return createDt;
    }

    /**
     * crm_ent_info.create_dt
     * @param createDt the value for crm_ent_info.create_dt
     */
    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    /**
     * crm_ent_info.last_update_by
     * @return the value of crm_ent_info.last_update_by
     */
    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    /**
     * crm_ent_info.last_update_by
     * @param lastUpdateBy the value for crm_ent_info.last_update_by
     */
    public void setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    /**
     * crm_ent_info.last_update_dt
     * @return the value of crm_ent_info.last_update_dt
     */
    public Date getLastUpdateDt() {
        return lastUpdateDt;
    }

    /**
     * crm_ent_info.last_update_dt
     * @param lastUpdateDt the value for crm_ent_info.last_update_dt
     */
    public void setLastUpdateDt(Date lastUpdateDt) {
        this.lastUpdateDt = lastUpdateDt;
    }

    /**
     * crm_ent_info.sts
     * @return the value of crm_ent_info.sts
     */
    public String getSts() {
        return sts;
    }

    /**
     * crm_ent_info.sts
     * @param sts the value for crm_ent_info.sts
     */
    public void setSts(String sts) {
        this.sts = sts == null ? null : sts.trim();
    }

    /**
     * crm_ent_info.linkman_duty
     * @return the value of crm_ent_info.linkman_duty
     */
    public String getLinkmanDuty() {
        return linkmanDuty;
    }

    /**
     * crm_ent_info.linkman_duty
     * @param linkmanDuty the value for crm_ent_info.linkman_duty
     */
    public void setLinkmanDuty(String linkmanDuty) {
        this.linkmanDuty = linkmanDuty == null ? null : linkmanDuty.trim();
    }

    /**
     * crm_ent_info.sale_email
     * @return the value of crm_ent_info.sale_email
     */
    public String getSaleEmail() {
        return saleEmail;
    }

    /**
     * crm_ent_info.sale_email
     * @param saleEmail the value for crm_ent_info.sale_email
     */
    public void setSaleEmail(String saleEmail) {
        this.saleEmail = saleEmail == null ? null : saleEmail.trim();
    }

    /**
     * crm_ent_info.user_id
     * @return the value of crm_ent_info.user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * crm_ent_info.user_id
     * @param userId the value for crm_ent_info.user_id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * crm_ent_info.audit_sts
     * @return the value of crm_ent_info.audit_sts
     */
    public String getAuditSts() {
        return auditSts;
    }

    /**
     * crm_ent_info.audit_sts
     * @param auditSts the value for crm_ent_info.audit_sts
     */
    public void setAuditSts(String auditSts) {
        this.auditSts = auditSts == null ? null : auditSts.trim();
    }

    /**
     * crm_ent_info.reject_reason
     * @return the value of crm_ent_info.reject_reason
     */
    public String getRejectReason() {
        return rejectReason;
    }

    /**
     * crm_ent_info.reject_reason
     * @param rejectReason the value for crm_ent_info.reject_reason
     */
    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason == null ? null : rejectReason.trim();
    }

    /**
     * crm_ent_info
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
        EntInfoDo other = (EntInfoDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getBusiLicense() == null ? other.getBusiLicense() == null : this.getBusiLicense().equals(other.getBusiLicense()))
            && (this.getCorpSocialNo() == null ? other.getCorpSocialNo() == null : this.getCorpSocialNo().equals(other.getCorpSocialNo()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getLinkPhone() == null ? other.getLinkPhone() == null : this.getLinkPhone().equals(other.getLinkPhone()))
            && (this.getLinkMan() == null ? other.getLinkMan() == null : this.getLinkMan().equals(other.getLinkMan()))
            && (this.getLinkTel() == null ? other.getLinkTel() == null : this.getLinkTel().equals(other.getLinkTel()))
            && (this.getCountryId() == null ? other.getCountryId() == null : this.getCountryId().equals(other.getCountryId()))
            && (this.getProvinceId() == null ? other.getProvinceId() == null : this.getProvinceId().equals(other.getProvinceId()))
            && (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()))
            && (this.getAreaId() == null ? other.getAreaId() == null : this.getAreaId().equals(other.getAreaId()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getQq() == null ? other.getQq() == null : this.getQq().equals(other.getQq()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getFax() == null ? other.getFax() == null : this.getFax().equals(other.getFax()))
            && (this.getZipcode() == null ? other.getZipcode() == null : this.getZipcode().equals(other.getZipcode()))
            && (this.getEmergencyLinkMan() == null ? other.getEmergencyLinkMan() == null : this.getEmergencyLinkMan().equals(other.getEmergencyLinkMan()))
            && (this.getEmergencyLinkTel() == null ? other.getEmergencyLinkTel() == null : this.getEmergencyLinkTel().equals(other.getEmergencyLinkTel()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateDt() == null ? other.getCreateDt() == null : this.getCreateDt().equals(other.getCreateDt()))
            && (this.getLastUpdateBy() == null ? other.getLastUpdateBy() == null : this.getLastUpdateBy().equals(other.getLastUpdateBy()))
            && (this.getLastUpdateDt() == null ? other.getLastUpdateDt() == null : this.getLastUpdateDt().equals(other.getLastUpdateDt()))
            && (this.getSts() == null ? other.getSts() == null : this.getSts().equals(other.getSts()))
            && (this.getLinkmanDuty() == null ? other.getLinkmanDuty() == null : this.getLinkmanDuty().equals(other.getLinkmanDuty()))
            && (this.getSaleEmail() == null ? other.getSaleEmail() == null : this.getSaleEmail().equals(other.getSaleEmail()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAuditSts() == null ? other.getAuditSts() == null : this.getAuditSts().equals(other.getAuditSts()))
            && (this.getRejectReason() == null ? other.getRejectReason() == null : this.getRejectReason().equals(other.getRejectReason()));
    }

    /**
     * crm_ent_info
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getBusiLicense() == null) ? 0 : getBusiLicense().hashCode());
        result = prime * result + ((getCorpSocialNo() == null) ? 0 : getCorpSocialNo().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getLinkPhone() == null) ? 0 : getLinkPhone().hashCode());
        result = prime * result + ((getLinkMan() == null) ? 0 : getLinkMan().hashCode());
        result = prime * result + ((getLinkTel() == null) ? 0 : getLinkTel().hashCode());
        result = prime * result + ((getCountryId() == null) ? 0 : getCountryId().hashCode());
        result = prime * result + ((getProvinceId() == null) ? 0 : getProvinceId().hashCode());
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        result = prime * result + ((getAreaId() == null) ? 0 : getAreaId().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getFax() == null) ? 0 : getFax().hashCode());
        result = prime * result + ((getZipcode() == null) ? 0 : getZipcode().hashCode());
        result = prime * result + ((getEmergencyLinkMan() == null) ? 0 : getEmergencyLinkMan().hashCode());
        result = prime * result + ((getEmergencyLinkTel() == null) ? 0 : getEmergencyLinkTel().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateDt() == null) ? 0 : getCreateDt().hashCode());
        result = prime * result + ((getLastUpdateBy() == null) ? 0 : getLastUpdateBy().hashCode());
        result = prime * result + ((getLastUpdateDt() == null) ? 0 : getLastUpdateDt().hashCode());
        result = prime * result + ((getSts() == null) ? 0 : getSts().hashCode());
        result = prime * result + ((getLinkmanDuty() == null) ? 0 : getLinkmanDuty().hashCode());
        result = prime * result + ((getSaleEmail() == null) ? 0 : getSaleEmail().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAuditSts() == null) ? 0 : getAuditSts().hashCode());
        result = prime * result + ((getRejectReason() == null) ? 0 : getRejectReason().hashCode());
        return result;
    }
}