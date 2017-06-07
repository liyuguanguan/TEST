package com.ygjt.gdn.ftisp.model.vo;

import java.util.List;

/**
 * Created by linx on 2016/10/29.
 */
public class OrderBoxQueryVo {
    private Integer id;
    private Integer orderId;
    private String boxNo;
    private Double regWeight;
    private Double regLength;
    private Double regWidth;
    private Double regHeight;
    private Double factWeight;
    private Double factLength;
    private Double factWidth;
    private Double factHeight;
    private Double volumeWeight;
    private Double feeWeight;
    private String boxCode;
    private List<OrderBoxGoodsQueryVo> goods;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBoxNo() {
        return boxNo;
    }

    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo;
    }


    public Double getRegWeight() {
        return regWeight;
    }

    public void setRegWeight(Double regWeight) {
        this.regWeight = regWeight;
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

    public Double getFactWeight() {
        return factWeight;
    }

    public void setFactWeight(Double factWeight) {
        this.factWeight = factWeight;
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

    public Double getFactHeight() {
        return factHeight;
    }

    public void setFactHeight(Double factHeight) {
        this.factHeight = factHeight;
    }

    public Double getVolumeWeight() {
        return volumeWeight;
    }

    public void setVolumeWeight(Double volumeWeight) {
        this.volumeWeight = volumeWeight;
    }


    public Double getFeeWeight() {
        return feeWeight;
    }

    public void setFeeWeight(Double feeWeight) {
        this.feeWeight = feeWeight;
    }

    public String getBoxCode() {
        return boxCode;
    }

    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }

    public List<OrderBoxGoodsQueryVo> getGoods() {
        return goods;
    }

    public void setGoods(List<OrderBoxGoodsQueryVo> goods) {
        this.goods = goods;
    }
}
