package com.ygjt.gdn.ftisp.model.vo.po;

import com.ygjt.gdn.ftisp.common.IPO;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by yhj on 16/10/22.
 */
public class OrderInfoPO implements IPO {

    @NotNull
    private String type ; // 查询类型(no_receive:未收货;collected:已揽收;received:已收货;checked:已验货;outed:已出库;)
    @NotNull
    private Integer page;
    @NotNull
    private Integer rows;
    private String sort;
    private String order;
    private String entName;  //客户名称
    private String starDate; // 开始日期
    private String endDate;  //结束日期
    private String orderNo;  //入库单号
    private String pickupType;  // 提货方式(pickup：上门取件,delivery ：客户送件,transport：集货转运)
    private String isCollectPrint; // 是否已经打印（Y:打印；N未打印）
    private Integer toWarehouseId; // 目的仓Id
    private Integer collectWarehouseId; // 收货仓ID
    private Integer logisticsId; // 物流产品Id


    private List<String> orderStatus ;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPickupType() {
        return pickupType;
    }

    public void setPickupType(String pickupType) {
        this.pickupType = pickupType;
    }

    public String getIsCollectPrint() {
        return isCollectPrint;
    }

    public void setIsCollectPrint(String isCollectPrint) {
        this.isCollectPrint = isCollectPrint;
    }

    public Integer getToWarehouseId() {
        return toWarehouseId;
    }

    public void setToWarehouseId(Integer toWarehouseId) {
        this.toWarehouseId = toWarehouseId;
    }

    public Integer getCollectWarehouseId() {
        return collectWarehouseId;
    }

    public void setCollectWarehouseId(Integer collectWarehouseId) {
        this.collectWarehouseId = collectWarehouseId;
    }

    public Integer getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(Integer logisticsId) {
        this.logisticsId = logisticsId;
    }

    public List<String> getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(List<String> orderStatus) {
        this.orderStatus = orderStatus;
    }
}
