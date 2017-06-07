package com.ygjt.gdn.ftisp.model.vo.po;


import com.ygjt.gdn.ftisp.common.annotation.InList;
import com.ygjt.gdn.ftisp.model.vo.PicInfos;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by wyh on 2016/10/29.
 */
public class EnterPriseInfoPo implements Serializable {
    @NotNull(message = "{crm.enterprise.check.page.notnull}")
    private Integer page;//当前页
    @NotNull(message = "{crm.enterprise.check.rows.notnull}")
    private Integer rows;//请求行
    private String sort;//排序字段
    private String order;//排序方式

    private String linkTel1;

    private String auditSts ;
    private List<PicInfos> picInfos;

    public String getAuditSts() {
        return auditSts;
    }

    public void setAuditSts(String auditSts) {
        this.auditSts = auditSts;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public List<PicInfos> getPicInfos() {
        return picInfos;
    }

    public void setPicInfos(List<PicInfos> picInfos) {
        this.picInfos = picInfos;
    }

    public String getLinkTel1() {
        return linkTel1;
    }

    public void setLinkTel1(String linkTel1) {
        this.linkTel1 = linkTel1;
    }

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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusiLicense() {
        return busiLicense;
    }

    public void setBusiLicense(String busiLicense) {
        this.busiLicense = busiLicense;
    }

    public String getCorpSocialNo() {
        return corpSocialNo;
    }

    public void setCorpSocialNo(String corpSocialNo) {
        this.corpSocialNo = corpSocialNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getLinkTel() {
        return linkTel;
    }

    public void setLinkTel(String linkTel) {
        this.linkTel = linkTel;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getEmergencyLinkMan() {
        return emergencyLinkMan;
    }

    public void setEmergencyLinkMan(String emergencyLinkMan) {
        this.emergencyLinkMan = emergencyLinkMan;
    }

    public String getEmergencyLinkTel() {
        return emergencyLinkTel;
    }

    public void setEmergencyLinkTel(String emergencyLinkTel) {
        this.emergencyLinkTel = emergencyLinkTel;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Date getLastUpdateDt() {
        return lastUpdateDt;
    }

    public void setLastUpdateDt(Date lastUpdateDt) {
        this.lastUpdateDt = lastUpdateDt;
    }

    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public String getLinkmanDuty() {
        return linkmanDuty;
    }

    public void setLinkmanDuty(String linkmanDuty) {
        this.linkmanDuty = linkmanDuty;
    }

    public String getSaleEmail() {
        return saleEmail;
    }

    public void setSaleEmail(String saleEmail) {
        this.saleEmail = saleEmail;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
