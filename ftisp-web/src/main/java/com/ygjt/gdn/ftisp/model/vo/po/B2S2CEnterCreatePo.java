package com.ygjt.gdn.ftisp.model.vo.po;


import com.ygjt.gdn.ftisp.model.vo.B2S2CPicInfos;
import com.ygjt.gdn.ftisp.model.vo.PicInfos;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by wyh on 2016/11/22.
 */
public class B2S2CEnterCreatePo implements Serializable{
    private String linkTel1;

    private List<B2S2CPicInfos> picInfos;
    private Integer id;
    @NotNull(message = "{crm.enterprise.check.name.notnull}")
    private String name;
    @NotNull(message = "{crm.enterprise.check.busilicense.notnull}")
    private String busiLicense;

    private String corpSocialNo;
    @NotNull(message = "{crm.enterprise.check.type.notnull}")
    private String type;
    @NotNull(message = "{crm.enterprise.check.linkphone.notnull}")
    private String linkPhone;
    @NotNull(message = "{crm.enterprise.check.linkman.notnull}")
    private String linkMan;

    private String linkTel;

    private Integer countryId;

    private Integer provinceId;

    private Integer cityId;

    private Integer areaId;

    private String address;

    private String qq;
    @NotNull(message = "{crm.enterprise.check.email.notnull}")
    private String email;

    private String fax;
    @NotNull(message = "{crm.enterprise.check.zipcode.notnull}")
    private String zipcode;
    @NotNull(message = "{crm.enterprise.check.emergencylinkman.notnull}")
    private String emergencyLinkMan;
    @NotNull(message = "{crm.enterprise.check.emergencylinktel.notnull}")
    private String emergencyLinkTel;

    @NotNull(message = "{crm.enterprise.check.linkmanduty.notnull}")
    private String linkmanDuty;

    private String saleEmail;

    private Integer userId;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLinkTel1() {
        return linkTel1;
    }

    public void setLinkTel1(String linkTel1) {
        this.linkTel1 = linkTel1;
    }


    public List<B2S2CPicInfos> getPicInfos() {
        return picInfos;
    }

    public void setPicInfos(List<B2S2CPicInfos> picInfos) {
        this.picInfos = picInfos;
    }

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
