package com.ygjt.gdn.ftisp.model.vo;


import com.ygjt.gdn.ftisp.common.IVO;
import com.ygjt.gdn.ftisp.utils.excel.Excel;

/**
 * Created by zzy on 2016/11/24.
 */
public class OutroomOrderExcelVO implements IVO {
    @Excel(exportName = "订单号")
    private String orderNo;
    @Excel(exportName = "出货仓")
    private String warehouseName;
    @Excel(exportName = "电商平台")
    private String platType;
    @Excel(exportName = "电商平台订单号")
    private String platOrderNo;
    @Excel(exportName = "收件人")
    private String recipientName;
    @Excel(exportName = "国家")
    private String recipientCountryName;
    @Excel(exportName = "州")
    private String recipientRegionName;
    @Excel(exportName = "城市")
    private String recipientCityName;
    @Excel(exportName = "邮编")
    private String recipientZipcode;
    @Excel(exportName = "地址一")
    private String recipientAddress1;
    @Excel(exportName = "地址二")
    private String recipientAddress2;
    @Excel(exportName = "联系电话")
    private String recipientPhone;
    @Excel(exportName = "商品编码")
    private String goodCode;
    @Excel(exportName = "商品名称")
    private String goodChName;
    @Excel(exportName = "规格,型号")
    private String spec;
    private String model;
    @Excel(exportName = "数量")
    private Integer nums;
    @Excel(exportName = "重量(kg)")
    private double weightKg;
    @Excel(exportName = "重量(Lbs)")
    private double weightLbs;
    @Excel(exportName = "发货方式")
    private String deliveryWayName;
    @Excel(exportName = "自提区域")
    private String doorplatenumbers;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getPlatType() {
        return platType;
    }

    public void setPlatType(String platType) {
        this.platType = platType;
    }

    public String getPlatOrderNo() {
        return platOrderNo;
    }

    public void setPlatOrderNo(String platOrderNo) {
        this.platOrderNo = platOrderNo;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientCountryName() {
        return recipientCountryName;
    }

    public void setRecipientCountryName(String recipientCountryName) {
        this.recipientCountryName = recipientCountryName;
    }

    public String getRecipientRegionName() {
        return recipientRegionName;
    }

    public void setRecipientRegionName(String recipientRegionName) {
        this.recipientRegionName = recipientRegionName;
    }

    public String getRecipientCityName() {
        return recipientCityName;
    }

    public void setRecipientCityName(String recipientCityName) {
        this.recipientCityName = recipientCityName;
    }

    public String getRecipientZipcode() {
        return recipientZipcode;
    }

    public void setRecipientZipcode(String recipientZipcode) {
        this.recipientZipcode = recipientZipcode;
    }

    public String getRecipientAddress1() {
        return recipientAddress1;
    }

    public void setRecipientAddress1(String recipientAddress1) {
        this.recipientAddress1 = recipientAddress1;
    }

    public String getRecipientAddress2() {
        return recipientAddress2;
    }

    public void setRecipientAddress2(String recipientAddress2) {
        this.recipientAddress2 = recipientAddress2;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public String getGoodChName() {
        return goodChName;
    }

    public void setGoodChName(String goodChName) {
        this.goodChName = goodChName;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    public double getWeightLbs() {
        return weightLbs;
    }

    public void setWeightLbs(double weightLbs) {
        this.weightLbs = weightLbs;
    }

    public String getDeliveryWayName() {
        return deliveryWayName;
    }

    public void setDeliveryWayName(String deliveryWayName) {
        this.deliveryWayName = deliveryWayName;
    }

    public String getDoorplatenumbers() {
        return doorplatenumbers;
    }

    public void setDoorplatenumbers(String doorplatenumbers) {
        this.doorplatenumbers = doorplatenumbers;
    }
}
