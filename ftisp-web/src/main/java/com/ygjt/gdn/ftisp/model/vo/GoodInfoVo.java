package com.ygjt.gdn.ftisp.model.vo;

/**
 * Created by wyh on 2016/10/27.
 */
public class GoodInfoVo {
    private Integer id;//商品ID
    private String code;//商品编码
    private String chName;//中文名称
    private String enName;//英文名称
    private String spec;//规格
    private String model;//型号
    private double factLength;//确认长
    private double factWidth;//确认宽
    private double factHigh;//确认高
    private double factGrossWeight;// 确认重量
    private String isFoam;//是否泡货
    private double feeWeight;//计费重量
    private String sts;//商品状态
    private String orderAuditSts;//商品审核状态
    private String orderRejectReason;//失败原因
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

    public double getFactLength() {
        return factLength;
    }

    public void setFactLength(double factLength) {
        this.factLength = factLength;
    }

    public double getFactWidth() {
        return factWidth;
    }

    public void setFactWidth(double factWidth) {
        this.factWidth = factWidth;
    }

    public double getFactHigh() {
        return factHigh;
    }

    public void setFactHigh(double factHigh) {
        this.factHigh = factHigh;
    }

    public double getFactGrossWeight() {
        return factGrossWeight;
    }

    public void setFactGrossWeight(double factGrossWeight) {
        this.factGrossWeight = factGrossWeight;
    }

    public String getIsFoam() {
        return isFoam;
    }

    public void setIsFoam(String isFoam) {
        this.isFoam = isFoam;
    }

    public double getFeeWeight() {
        return feeWeight;
    }

    public void setFeeWeight(double feeWeight) {
        this.feeWeight = feeWeight;
    }

    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public String getOrderAuditSts() {
        return orderAuditSts;
    }

    public void setOrderAuditSts(String orderAuditSts) {
        this.orderAuditSts = orderAuditSts;
    }

    public String getOrderRejectReason() {
        return orderRejectReason;
    }

    public void setOrderRejectReason(String orderRejectReason) {
        this.orderRejectReason = orderRejectReason;
    }
}
