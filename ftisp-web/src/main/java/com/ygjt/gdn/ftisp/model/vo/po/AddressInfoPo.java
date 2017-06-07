package com.ygjt.gdn.ftisp.model.vo.po;


import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by wyh on 2016/10/26.
 */
public class AddressInfoPo {
    @NotNull(message = "{crm.entaddress.check.linkman.notnull}")
    private String linkMan;//联系人
    @NotNull(message = "{crm.entaddress.check.type.notnull}")
    private String type;//地址类别(pickup:提货地址)

    /**
     * 编号
     * crm_ent_address.id
     */
    @NotNull(message = "{crm.entaddress.check.id.notnull}")
    private Integer id;

    /**
     * 编号
     * crm_ent_address.code
     */
    private String code;

    /**
     * 国家
     * crm_ent_address.country_id
     */
    @NotNull(message = "{crm.entaddress.check.countryid.notnull}")
    private Integer countryId;

    /**
     * 省
     * crm_ent_address.province_id
     */
    @NotNull(message = "{crm.entaddress.check.provinced.notnull}")
    private Integer provinceId;

    /**
     * 市
     * crm_ent_address.city_id
     */
    @NotNull(message = "{crm.entaddress.check.cityid.notnull}")
    private Integer cityId;

    /**
     * 区
     * crm_ent_address.area_id
     */
    @NotNull(message = "{crm.entaddress.check.areaid.notnull}")
    private Integer areaId;

    /**
     * 地址（不包含国家省市区）
     * crm_ent_address.address
     */
    @NotNull(message = "{crm.entaddress.check.address.notnull}")
    private String address;

    /**
     * 联系电话
     * crm_ent_address.link_phone
     */
    @NotNull(message = "{crm.entaddress.check.linkphone.notnull}")
    private String linkPhone;

    /**
     * 邮箱
     * crm_ent_address.email
     */
    @NotNull(message = "{crm.entaddress.check.email.notnull}")
    private String email;

    /**
     * 邮编
     * crm_ent_address.zip_code
     */
    @NotNull(message = "{crm.entaddress.check.zipcode.notnull}")
    private String zipCode;

    /**
     * 是否默认地址
     * crm_ent_address.is_default
     */
    private String isDefault;

    /**
     * 企业ID
     * crm_ent_address.ent_id
     */
    private Integer entId;

    /**
     * 创建人
     * crm_ent_address.create_by
     */
    private Integer createBy;

    /**
     * 创建时间
     * crm_ent_address.create_dt
     */
    private Date createDt;

    /**
     * 最后更新人
     * crm_ent_address.last_update_by
     */
    private Integer lastUpdateBy;

    /**
     * 最后更新时间
     * crm_ent_address.last_update_dt
     */
    private Date lastUpdateDt;

    /**
     * 企业状态
     * crm_ent_address.sts
     */
    private String sts;

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getEntId() {
        return entId;
    }

    public void setEntId(Integer entId) {
        this.entId = entId;
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
}
