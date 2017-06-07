package com.ygjt.gdn.ftisp.model.vo;



/**
 * Created by wyh on 2016/10/26.
 */
public class AddressInfoVo {
    //新增国家、省市区名称字段
    private String country;
    private String province;
    private String city;
    private String area;
    /**
     * id
     * crm_ent_address.id
     */
    private Integer id;
    /**
     * 编号
     * crm_ent_address.code
     */
    private String code;

    /**
     * 类型
     * crm_ent_address.type
     */
    private String type;

    /**
     * 国家
     * crm_ent_address.country_id
     */
    private Integer countryId;

    /**
     * 省
     * crm_ent_address.province_id
     */
    private Integer provinceId;

    /**
     * 市
     * crm_ent_address.city_id
     */
    private Integer cityId;

    /**
     * 区
     * crm_ent_address.area_id
     */
    private Integer areaId;

    /**
     * 地址（不包含国家省市区）
     * crm_ent_address.address
     */
    private String address;

    /**
     * 联系人
     * crm_ent_address.link_man
     */
    private String linkMan;

    /**
     * 联系电话
     * crm_ent_address.link_phone
     */
    private String linkPhone;

    /**
     * 邮箱
     * crm_ent_address.email
     */
    private String email;

    /**
     * 邮编
     * crm_ent_address.zip_code
     */
    private String zipCode;

    /**
     * 是否默认地址
     * crm_ent_address.is_default
     */
    private String isDefault;

    /**
     * 企业状态
     * crm_ent_address.sts
     */
    private String sts;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
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

    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
