package com.ygjt.gdn.ftisp.model.vo;

import java.util.Date;
import java.util.List;

/**
 * Created by linx on 2016/11/1.
 */
public class OrderDetailVo {
    private Integer id;
    private Date createDt ;
    private String orderStatus;
    private Double tNums;
    private Double skuNums;
    private Double tGoodsNums;
    private String pickupType;
    private Date pickupDate;
    private String pickupTime;
    private String logisticsName;
    private Integer logisticsId;
    private String address;
    private Integer pickupAddressId;
    private Integer logisticsPlanId;
    private String logisticsPlanName;
    private Integer collectWarehouseId;
    private String collectWarehouseName;
    private Integer toWarehouseId;
    private String toWarehouseName;
    private String orderNo;
    private String customOrderNo;
    private Integer importerId;
    private Integer exporterId;
    private String importerName;
    private String exporterName;
    private String expressProviderName;
    private String expressNo;
    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }

    public String getImporterName() {
        return importerName;
    }

    public void setImporterName(String importerName) {
        this.importerName = importerName;
    }

    public String getExporterName() {
        return exporterName;
    }

    public void setExporterName(String exporterName) {
        this.exporterName = exporterName;
    }

    public String getExpressProviderName() {
        return expressProviderName;
    }

    public void setExpressProviderName(String expressProviderName) {
        this.expressProviderName = expressProviderName;
    }

    public String getCustomOrderNo() {
        return customOrderNo;
    }

    public void setCustomOrderNo(String customOrderNo) {
        this.customOrderNo = customOrderNo;
    }

    public Integer getImporterId() {
        return importerId;
    }

    public void setImporterId(Integer importerId) {
        this.importerId = importerId;
    }

    public Integer getExporterId() {
        return exporterId;
    }

    public void setExporterId(Integer exporterId) {
        this.exporterId = exporterId;
    }

    public Integer getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(Integer logisticsId) {
        this.logisticsId = logisticsId;
    }

    public Integer getPickupAddressId() {
        return pickupAddressId;
    }

    public void setPickupAddressId(Integer pickupAddressId) {
        this.pickupAddressId = pickupAddressId;
    }

    public Integer getLogisticsPlanId() {
        return logisticsPlanId;
    }

    public void setLogisticsPlanId(Integer logisticsPlanId) {
        this.logisticsPlanId = logisticsPlanId;
    }

    public Integer getCollectWarehouseId() {
        return collectWarehouseId;
    }

    public void setCollectWarehouseId(Integer collectWarehouseId) {
        this.collectWarehouseId = collectWarehouseId;
    }

    public Integer getToWarehouseId() {
        return toWarehouseId;
    }

    public void setToWarehouseId(Integer toWarehouseId) {
        this.toWarehouseId = toWarehouseId;
    }

    private List<OrderInfoOptVO> orderOpts;

    public Double getSkuNums() {
        return skuNums;
    }

    public void setSkuNums(Double skuNums) {
        this.skuNums = skuNums;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public List<OrderInfoOptVO> getOrderOpts() {
        return orderOpts;
    }

    public void setOrderOpts(List<OrderInfoOptVO> orderOpts) {
        this.orderOpts = orderOpts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
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

    public String getPickupType() {
        return pickupType;
    }

    public void setPickupType(String pickupType) {
        this.pickupType = pickupType;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogisticsPlanName() {
        return logisticsPlanName;
    }

    public void setLogisticsPlanName(String logisticsPlanName) {
        this.logisticsPlanName = logisticsPlanName;
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
}
