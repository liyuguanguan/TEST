package com.ygjt.gdn.ftisp.model.vo;


import com.ygjt.gdn.ftisp.model.EntInfoDo;

import java.util.List;

/**
 * Created by wyh on 2016/10/29.
 */
public class EnterPriseInfoVO extends EntInfoDo {
    //企业图片信息
    private List<EnterPics> enterPics;

    //国家、省市区name
    private String country;
    private String province;
    private String city;
    private String area;

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

    public List<EnterPics> getEnterPics() {
        return enterPics;
    }

    public void setEnterPics(List<EnterPics> enterPics) {
        this.enterPics = enterPics;
    }
}
