package com.ygjt.gdn.ftisp.model.vo.po;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by wyh on 2016/10/27.
 */
public class GoodInfoPo implements Serializable {
    @NotNull(message = "{crm.goodinfo.check.page.notnull}")
    private Integer page;//当前页
    @NotNull(message = "{crm.goodinfo.check.rows.notnull}")
    private Integer rows;//请求行
    private String sort;//排序字段
    private String order;//排序方式

    private Integer id;//商品ID
    private String code;//商品编码
    private String chName;//中文名称
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
    private double regLength;//产品包装长(CM)
    private double regWidth;//产品包装宽(CM)
    private double regHeight;//产品包装高(CM)
    private double regGrossWeight;//产品包装重量(KG)
    private String hsCode;//HS编码
    private String manageType;//监管证书代码
    private String exportGoodsTax;//出口退税率
    private String importCountry ;//进口国
    private double declaredPrice;//出口申报价
    private double importGoodsPrice;//进口申报价
    private double deliveryCycle;//交货周期
    private String detailWebsite;// 商品网址
    private String summary;//备注
    private String sendAuditSts;

    private Integer createBy;//创建人
    private Date createDt;//创建时间
    private Integer lastUpdateBy;//最近更新人
    private Date lastUpdateDt;//最近更新时间
    private String orderAuditSts;//下单审核状态

    //打印参数
      //商品编码
    private String count;//打印数量
    private String size;//打印尺寸

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public void setHasHranded(String hasHranded) {
        this.hasHranded = hasHranded;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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

    public void setBasHranded(String basHranded) {
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

    public String getImportCountry() {
        return importCountry;
    }

    public void setImportCountry(String importCountry) {
        this.importCountry = importCountry;
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

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSendAuditSts() {
        return sendAuditSts;
    }

    public void setSendAuditSts(String sendAuditSts) {
        this.sendAuditSts = sendAuditSts;
    }
}
