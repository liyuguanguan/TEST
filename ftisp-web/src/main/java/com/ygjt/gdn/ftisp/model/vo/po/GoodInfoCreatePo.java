package com.ygjt.gdn.ftisp.model.vo.po;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by zhongb on 2017/4/26.
 */
public class GoodInfoCreatePo implements Serializable{
    private Integer id;//商品ID
    @NotNull(message = "{crm.goods.check.code.notnull}")
    private String code;//商品编码
    @NotNull(message = "{crm.goods.check.chname.notnull}")
    private String chName;//中文名称
    @NotNull(message = "{crm.goods.check.enname.notnull}")
    private String enName;//英文品名
    private String sts;//商品状态
    private String isFoam;//是否泡货
    private Integer entId;//所属企业
    private String spec;//规格
    private String model;// 型号
    private String brand;//品牌
    private String hasHranded;//是否有品牌(Y:有,N:无)
    private String hasBattery;//是否有电池(Y:有,N:无)
    private String batteryType;//电池类型(0:碱性电池，不含汞,1:锂电池)
    private List<String> keywords;//关键字
    private String keyWord;
    private List<String> picIds;//商品图片ID
    private String mainPic;//图片
    @NotNull(message = "{crm.goods.check.reglength.notnull}")
    private double regLength;//产品包装长(CM)
    @NotNull(message = "{crm.goods.check.regwidth.notnull}")
    private double regWidth;//产品包装宽(CM)
    @NotNull(message = "{crm.goods.check.regheight.notnull}")
//    @Pattern(regexp = "^(([0-9]|([1-9][0-9]+))(\\.[0-9]{1,3}))|([0-9])|([1-9][0-9]+)$",message = "产品包装高格式不正确")
    private double regHeight;//产品包装高(CM)
    @NotNull(message = "{crm.goods.check.reggrossweight.notnull}")
    private double regGrossWeight;//产品包装重量(KG)
    private String hsCode;//HS编码
    private String manageType;//监管证书代码
    private String exportGoodsTax;//出口退税率
    @NotNull(message = "{crm.goods.check.importcountry.notnull}")
    private String importCountryId ;//进口国
    @NotNull(message = "{crm.goods.check.declaredprice.notnull}")
    private double declaredPrice;//出口申报价
    @NotNull(message = "{crm.goods.check.importgoodsprice.notnull}")
    private double importGoodsPrice;//进口申报价
    private double deliveryCycle;//交货周期
    @NotNull(message = "{crm.goods.check.detailwebsite.notnull}")
    @Pattern(regexp = "^((http|https):\\/\\/(\\w+:{0,1}\\w*@)?(\\S+)|)(:[0-9]+)?(\\/|\\/([\\w#!:.?+=&%@!\\-\\/]))?$",message = "商品网址格式不正确")
    private String detailWebsite;// 商品网址
    private String summary;//备注
    private String sendAuditSts;

    private Integer createBy;//创建人
    private Date createDt;//创建时间
    private Integer lastUpdateBy;//最近更新人
    private Date lastUpdateDt;//最近更新时间
    private String orderAuditSts;//下单审核状态

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

    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public String getIsFoam() {
        return isFoam;
    }

    public void setIsFoam(String isFoam) {
        this.isFoam = isFoam;
    }

    public Integer getEntId() {
        return entId;
    }

    public void setEntId(Integer entId) {
        this.entId = entId;
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

    public String getHasHranded() {
        return hasHranded;
    }

    public void setHasHranded(String hasHranded) {
        this.hasHranded = hasHranded;
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

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public List<String> getPicIds() {
        return picIds;
    }

    public void setPicIds(List<String> picIds) {
        this.picIds = picIds;
    }

    public String getMainPic() {
        return mainPic;
    }

    public void setMainPic(String mainPic) {
        this.mainPic = mainPic;
    }

    public double getRegLength() {
        return regLength;
    }

    public void setRegLength(double regLength) {
        this.regLength = regLength;
    }

    public double getRegWidth() {
        return regWidth;
    }

    public void setRegWidth(double regWidth) {
        this.regWidth = regWidth;
    }

    public double getRegHeight() {
        return regHeight;
    }

    public void setRegHeight(double regHeight) {
        this.regHeight = regHeight;
    }

    public double getRegGrossWeight() {
        return regGrossWeight;
    }

    public void setRegGrossWeight(double regGrossWeight) {
        this.regGrossWeight = regGrossWeight;
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

    public String getImportCountryId() {
        return importCountryId;
    }

    public void setImportCountryId(String importCountryId) {
        this.importCountryId = importCountryId;
    }

    public double getDeclaredPrice() {
        return declaredPrice;
    }

    public void setDeclaredPrice(double declaredPrice) {
        this.declaredPrice = declaredPrice;
    }

    public double getImportGoodsPrice() {
        return importGoodsPrice;
    }

    public void setImportGoodsPrice(double importGoodsPrice) {
        this.importGoodsPrice = importGoodsPrice;
    }

    public double getDeliveryCycle() {
        return deliveryCycle;
    }

    public void setDeliveryCycle(double deliveryCycle) {
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

    public String getSendAuditSts() {
        return sendAuditSts;
    }

    public void setSendAuditSts(String sendAuditSts) {
        this.sendAuditSts = sendAuditSts;
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

    public String getOrderAuditSts() {
        return orderAuditSts;
    }

    public void setOrderAuditSts(String orderAuditSts) {
        this.orderAuditSts = orderAuditSts;
    }
}
