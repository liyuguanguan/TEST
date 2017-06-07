package com.ygjt.gdn.ftisp.model.vo;

/**
 * Created by zhongb on 2017/4/25.
 */
public class GoodDetailVo {
    private Integer id;//商品ID
    private String code;//商品编码
    private String chName;//中文名称
    private String enName;//英文名称
    private String spec;//规格
    private String model;//型号
    private String brand;//品牌
    private String hasBranded;//是否有品牌
    private String hasBattery;//是否有电池
    private String batteryType;//电池类型
    private Double regGrossWeight;//产品包装重量
    private Double regLength;
    private Double regWidth;
    private Double regHeight;
    private Double factLength;
    private Double factWidth;
    private Double factHigh;
    private Double factGrossWeight; //实测重量
    private String hsCode;//H.S.编码
    private String manageType;//监管证书代码
    private Double exportGoodsTax;//出口退税率
    private Integer importCountryId;//进口国
    private Double declaredPrice;//出口申报价
    private Double importGoodsPrice;//进口申报价
    private Double deliveryCycle;//交货周期
    private String detailWebsite;//商品网址;
    private String summary;//备注
    private String orderAuditSts;//审核状态

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
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

    public String getChName() {
        return chName;
    }

    public void setChName(String chName) {
        this.chName = chName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getHasBranded() {
        return hasBranded;
    }

    public void setHasBranded(String hasBranded) {
        this.hasBranded = hasBranded;
    }

    public String getHasBattery() {
        return hasBattery;
    }

    public void setHasBattery(String hasBattery) {
        this.hasBattery = hasBattery;
    }

    public Double getRegGrossWeight() {
        return regGrossWeight;
    }

    public void setRegGrossWeight(Double regGrossWeight) {
        this.regGrossWeight = regGrossWeight;
    }

    public Double getRegLength() {
        return regLength;
    }

    public void setRegLength(Double regLength) {
        this.regLength = regLength;
    }

    public Double getRegWidth() {
        return regWidth;
    }

    public void setRegWidth(Double regWidth) {
        this.regWidth = regWidth;
    }

    public Double getRegHeight() {
        return regHeight;
    }

    public void setRegHeight(Double regHeight) {
        this.regHeight = regHeight;
    }

    public String getHsCode() {
        return hsCode;
    }

    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }

    public String getManageType() {
        return manageType;
    }

    public void setManageType(String manageType) {
        this.manageType = manageType;
    }

    public Double getExportGoodsTax() {
        return exportGoodsTax;
    }

    public void setExportGoodsTax(Double exportGoodsTax) {
        this.exportGoodsTax = exportGoodsTax;
    }

    public Integer getImportCountryId() {
        return importCountryId;
    }

    public void setImportCountryId(Integer importCountryId) {
        this.importCountryId = importCountryId;
    }

    public Double getDeclaredPrice() {
        return declaredPrice;
    }

    public void setDeclaredPrice(Double declaredPrice) {
        this.declaredPrice = declaredPrice;
    }

    public Double getImportGoodsPrice() {
        return importGoodsPrice;
    }

    public void setImportGoodsPrice(Double importGoodsPrice) {
        this.importGoodsPrice = importGoodsPrice;
    }

    public Double getDeliveryCycle() {
        return deliveryCycle;
    }

    public void setDeliveryCycle(Double deliveryCycle) {
        this.deliveryCycle = deliveryCycle;
    }

    public String getDetailWebsite() {
        return detailWebsite;
    }

    public void setDetailWebsite(String detailWebsite) {
        this.detailWebsite = detailWebsite;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Double getFactGrossWeight() {
        return factGrossWeight;
    }

    public void setFactGrossWeight(Double factGrossWeight) {
        this.factGrossWeight = factGrossWeight;
    }

    public String getOrderAuditSts() {
        return orderAuditSts;
    }

    public void setOrderAuditSts(String orderAuditSts) {
        this.orderAuditSts = orderAuditSts;
    }

    public Double getFactLength() {
        return factLength;
    }

    public void setFactLength(Double factLength) {
        this.factLength = factLength;
    }

    public Double getFactWidth() {
        return factWidth;
    }

    public void setFactWidth(Double factWidth) {
        this.factWidth = factWidth;
    }

    public Double getFactHigh() {
        return factHigh;
    }

    public void setFactHigh(Double factHigh) {
        this.factHigh = factHigh;
    }
}
