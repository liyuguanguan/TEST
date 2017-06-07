package com.ygjt.gdn.ftisp.model.vo.po;

/**
 * Created by zzy on 2016/10/28.
 */
public class OutroomOrderListPO {
    private String orderNo;
    private Integer warehouseId;
    private String platType;
    private String status;
    private String orderCreateFromDt;
    private String orderCreateToDt;
    private Integer page;//当前页码
    private Integer rows;//每页行数
    private String sort;//排序字段
    private String order;//排序方式


    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getPlatType() {
        return platType;
    }

    public void setPlatType(String platType) {
        this.platType = platType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderCreateFromDt() {
        return orderCreateFromDt;
    }

    public void setOrderCreateFromDt(String orderCreateFromDt) {
        this.orderCreateFromDt = orderCreateFromDt;
    }

    public String getOrderCreateToDt() {
        return orderCreateToDt;
    }

    public void setOrderCreateToDt(String orderCreateToDt) {
        this.orderCreateToDt = orderCreateToDt;
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

}
