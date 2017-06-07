package com.ygjt.gdn.ftisp.model.vo.po;


import com.ygjt.gdn.ftisp.common.Constants;

/**
 * Created by linx on 2016/11/2.
 */
public class StockRecordPO {
    private Integer page;
    private Integer rows;
    private String sort;
    private String order;
    private String goodsCode;
    private String orderNo;
    private String type;
    private String starDate; // 开始日期
    private String endDate;  //结束日期

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getPage() {
        return page==null? Constants.DEFAULT_PAGE:page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows==null?Constants.DEFAULT_ROWZISE:rows;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
