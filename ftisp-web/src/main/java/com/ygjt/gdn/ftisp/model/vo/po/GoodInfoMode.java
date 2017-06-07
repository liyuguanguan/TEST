package com.ygjt.gdn.ftisp.model.vo.po;

import com.ygjt.gdn.ftisp.utils.excel.Excel;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * Created by wyh on 2016/11/3.
 */
public class GoodInfoMode {
    @Excel(exportName = "*中文品名")
    @NotEmpty(message = "中文品名不能为空")
    private String chName;//中文名称
    @Excel(exportName = "*英文品名")
    @NotEmpty(message = "英文品名不能为空")
    private String enName;//英文名称
    @Excel(exportName = "*商品编码")
    @NotEmpty(message = "商品编码不能为空")
    private String code;//商品编码
    @Excel(exportName = "规格")
    private String spec;//规格
    @Excel(exportName = "型号")
    private String model;//型号
    @Excel(exportName = "品牌")
    private String brand;//品牌
    @Excel(exportName = "是否带电")
    private String hasBattery;//是否有电池
    @Excel(exportName = "电池类型")
    private String batteryType;//电池类型
    @Excel(exportName = "关键词")
    private String keywords;//关键字
    @Excel(exportName = "*重量(Kg)")
    @NotEmpty(message = "重量不能为空")
//    @Pattern(regexp = "^[1-9]\\\\d*\\\\.\\\\d*|0\\\\.\\\\d*[1-9]\\\\d*|0?\\\\.0+|0$",message = "重量存在非法字符")
    private String regGrossWeight;//产品包装重量(KG)
    @Excel(exportName = "*长(cm)")
    @NotEmpty(message = "长不能为空")
//    @Pattern(regexp = "^[1-9]\\\\d*\\\\.\\\\d*|0\\\\.\\\\d*[1-9]\\\\d*|0?\\\\.0+|0$",message = "长存在非法字符")
    private String regLength;//产品包装长(CM)
    @Excel(exportName = "*宽(cm)")
    @NotEmpty(message = "宽不能为空")
//    @Pattern(regexp = "^[1-9]\\\\d*\\\\.\\\\d*|0\\\\.\\\\d*[1-9]\\\\d*|0?\\\\.0+|0$",message = "宽存在非法字符")
    private String regWidth;//产品包装宽(CM)
    @Excel(exportName = "*高(cm)")
    @NotEmpty(message = "高不能为空")
//    @Pattern(regexp = "^[1-9]\\\\d*\\\\.\\\\d*|0\\\\.\\\\d*[1-9]\\\\d*|0?\\\\.0+|0$",message = "高存在非法字符")
    private String regHeight;//产品包装高(CM)
    @Pattern(regexp = "^[0-9]*$",message = "H.S编码格式不正确，应为数字")
    @Excel(exportName = "H.S编码")
    private String hsCode;//HS编码
    @Excel(exportName = "监管证书代码")
    private String manageType;//监管证书代码
    @Excel(exportName = "出口退税率")
    private String exportGoodsTax;//出口退税率
    @Excel(exportName = "*进口国")
    @NotEmpty(message = "进口国不能为空")
    private String importCountry ;//进口国
    @Excel(exportName = "*出口申报价(USD)")
    @NotEmpty(message = "出口申报价不能为空")
//    @Pattern(regexp = "^[1-9]\\\\d*\\\\.\\\\d*|0\\\\.\\\\d*[1-9]\\\\d*|0?\\\\.0+|0$", message = "出口申报价存在非法字符")
    private String declaredPrice;//出口申报价
    @Excel(exportName = "*进口申报价(USD)")
    @NotEmpty(message = "进口申报价不能为空")
//    @Pattern(regexp = "^[1-9]\\\\d*\\\\.\\\\d*|0\\\\.\\\\d*[1-9]\\\\d*|0?\\\\.0+|0$", message = "进口申报价存在非法字符")
    private String importGoodsPrice;//进口申报价
    @Excel(exportName = "交货周期")
    private String deliveryCycle;//交货周期
    @Excel(exportName = "*商品网址")
    @NotEmpty(message = "商品网址不能为空")
    @Pattern(regexp = "^((http|https):\\/\\/(\\w+:{0,1}\\w*@)?(\\S+)|)(:[0-9]+)?(\\/|\\/([\\w#!:.?+=&%@!\\-\\/]))?$",message = "商品网址格式不正确")
    private String detailWebsite;// 商品网址
    @Excel(exportName = "备注")
    private String summary;//备注


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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getHasBattery() {
        return hasBattery;
    }

    public void setHasBattery(String hasBattery) {
        this.hasBattery = hasBattery;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getRegGrossWeight() {
        return regGrossWeight;
    }

    public void setRegGrossWeight(String regGrossWeight) {
        this.regGrossWeight = regGrossWeight;
    }

    public String getRegLength() {
        return regLength;
    }

    public void setRegLength(String regLength) {
        this.regLength = regLength;
    }

    public String getRegWidth() {
        return regWidth;
    }

    public void setRegWidth(String regWidth) {
        this.regWidth = regWidth;
    }

    public String getRegHeight() {
        return regHeight;
    }

    public void setRegHeight(String regHeight) {
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

    public String getExportGoodsTax() {
        return exportGoodsTax;
    }

    public void setExportGoodsTax(String exportGoodsTax) {
        this.exportGoodsTax = exportGoodsTax;
    }

    public String getImportCountry() {
        return importCountry;
    }

    public void setImportCountry(String importCountry) {
        this.importCountry = importCountry;
    }

    public String getDeclaredPrice() {
        return declaredPrice;
    }

    public void setDeclaredPrice(String declaredPrice) {
        this.declaredPrice = declaredPrice;
    }

    public String getImportGoodsPrice() {
        return importGoodsPrice;
    }

    public void setImportGoodsPrice(String importGoodsPrice) {
        this.importGoodsPrice = importGoodsPrice;
    }

    public String getDeliveryCycle() {
        return deliveryCycle;
    }

    public void setDeliveryCycle(String deliveryCycle) {
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
}
