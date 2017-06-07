package com.ygjt.gdn.ftisp.model.vo;

import java.util.Date;

/**
 * Created by linx on 2016/11/2.
 */
public class StockRecordVO {
    private Integer id;
    private String goodsCode;
    private String orderNo;
    private String   goodsName;
    private Date lastupdateDt;
    private String   type;
    private Double   initStockNums;
    private Double   nums;
    private Double   endStockNums;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Date getLastupdateDt() {
        return lastupdateDt;
    }

    public void setLastupdateDt(Date lastupdateDt) {
        this.lastupdateDt = lastupdateDt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getInitStockNums() {
        return initStockNums;
    }

    public void setInitStockNums(Double initStockNums) {
        this.initStockNums = initStockNums;
    }

    public Double getNums() {
        return nums;
    }

    public void setNums(Double nums) {
        this.nums = nums;
    }

    public Double getEndStockNums() {
        return endStockNums;
    }

    public void setEndStockNums(Double endStockNums) {
        this.endStockNums = endStockNums;
    }
}
