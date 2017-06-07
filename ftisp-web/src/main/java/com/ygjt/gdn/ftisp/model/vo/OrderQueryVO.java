package com.ygjt.gdn.ftisp.model.vo;

import com.ygjt.gdn.ftisp.common.IVO;

import java.util.Date;

/**
 * 企业端订单列表查询显示数据
 * Created by linx on 2016/10/29.
 */
public class OrderQueryVO implements IVO {
    private Integer id;
    private String orderNo;
    private String orderStatus;
    private Date    createDt;
    private String collectWarehouseName;
    private String toWarehouseName;
    private String logisticsName;
    private Double tVolumn;
    private Double tWeight;
    private Double tNums;
    private Double tGoodsNums;
    private Double tFeeWeight;
    private Double cWeight;
    private Double cVolumn;
    private Double cGoodsNums;
    private Double cNums;
    private Double cFeeWeight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public String getCollectWarehouseName() {
        return collectWarehouseName;
    }

    public void setCollectWarehouseName(String collectWarehouseName) {
        this.collectWarehouseName = collectWarehouseName;
    }

    public String getToWarehouseName() {
        return toWarehouseName;
    }

    public void setToWarehouseName(String toWarehouseName) {
        this.toWarehouseName = toWarehouseName;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
    }

    public Double gettVolumn() {
        return tVolumn;
    }

    public void settVolumn(Double tVolumn) {
        this.tVolumn = tVolumn;
    }

    public Double gettWeight() {
        return tWeight;
    }

    public void settWeight(Double tWeight) {
        this.tWeight = tWeight;
    }

    public Double gettNums() {
        return tNums;
    }

    public void settNums(Double tNums) {
        this.tNums = tNums;
    }

    public Double gettGoodsNums() {
        return tGoodsNums;
    }

    public void settGoodsNums(Double tGoodsNums) {
        this.tGoodsNums = tGoodsNums;
    }

    public Double gettFeeWeight() {
        return tFeeWeight;
    }

    public void settFeeWeight(Double tFeeWeight) {
        this.tFeeWeight = tFeeWeight;
    }

    public Double getcWeight() {
        return cWeight;
    }

    public void setcWeight(Double cWeight) {
        this.cWeight = cWeight;
    }

    public Double getcVolumn() {
        return cVolumn;
    }

    public void setcVolumn(Double cVolumn) {
        this.cVolumn = cVolumn;
    }

    public Double getcGoodsNums() {
        return cGoodsNums;
    }

    public void setcGoodsNums(Double cGoodsNums) {
        this.cGoodsNums = cGoodsNums;
    }

    public Double getcNums() {
        return cNums;
    }

    public void setcNums(Double cNums) {
        this.cNums = cNums;
    }

    public Double getcFeeWeight() {
        return cFeeWeight;
    }

    public void setcFeeWeight(Double cFeeWeight) {
        this.cFeeWeight = cFeeWeight;
    }
}
