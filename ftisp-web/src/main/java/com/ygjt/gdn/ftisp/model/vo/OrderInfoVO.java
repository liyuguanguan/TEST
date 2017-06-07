package com.ygjt.gdn.ftisp.model.vo;

import com.ygjt.gdn.ftisp.common.IVO;

import java.util.Date;

/**
 * Created by yhj on 16/10/22.
 */
public class OrderInfoVO implements IVO {
    private Integer id;
    private String orderNo;
    private String orderStatus;
    private Date createDt;
    private Integer toWarehouseId;
    private String logisticsName;
    private String logisticsCode;
    private Integer portWarehouseId;
    private Integer collectWarehouseId;
    private Integer importerId;
    private Integer exporterId;
    private String logisticsPlanName;
    private String logisticsPlanCode;
    private Integer entId;
    private String entName;
    private Date  lastCollectDt;
    private String pickupType;
    private Date pickupDate;
    private String pickupTime;
    private String pickupAddressLinkMan;
    private String pickupAddressLinkPhone;
    private String pickupAddress;
    private Date  collectDt;
    private Integer collectBy;
    private Date  receiveDt;
    private Integer receiveBy;
    private Date  checkDt;
    private Integer checkBy;
    private Date  outroomDt;
    private Integer outroomBy;
    private String isCollectPrint;
    private Double tVolumn;
    private Double tWeight;
    private Double tNums;
    private Double tCollectNums;
    private Double tReceiveNums;
    private Double tOutroomNums;

    private Double tCheckNums;
    private String collectWarehouseName;
    private String toWarehouseName;
    private Double tGoodsNums;
    private Double tFeeWeight;
    private Double cWeight;
    private Double cVolumn;
    private Double cGoodsNums;
    private Double cNums;
    private Double cFeeWeight;


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

    public Integer getToWarehouseId() {
        return toWarehouseId;
    }

    public void setToWarehouseId(Integer toWarehouseId) {
        this.toWarehouseId = toWarehouseId;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
    }

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    public Integer getPortWarehouseId() {
        return portWarehouseId;
    }

    public void setPortWarehouseId(Integer portWarehouseId) {
        this.portWarehouseId = portWarehouseId;
    }

    public Integer getCollectWarehouseId() {
        return collectWarehouseId;
    }

    public void setCollectWarehouseId(Integer collectWarehouseId) {
        this.collectWarehouseId = collectWarehouseId;
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

    public String getLogisticsPlanName() {
        return logisticsPlanName;
    }

    public void setLogisticsPlanName(String logisticsPlanName) {
        this.logisticsPlanName = logisticsPlanName;
    }

    public String getLogisticsPlanCode() {
        return logisticsPlanCode;
    }

    public void setLogisticsPlanCode(String logisticsPlanCode) {
        this.logisticsPlanCode = logisticsPlanCode;
    }

    public Integer getEntId() {
        return entId;
    }

    public void setEntId(Integer entId) {
        this.entId = entId;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public Date getLastCollectDt() {
        return lastCollectDt;
    }

    public void setLastCollectDt(Date lastCollectDt) {
        this.lastCollectDt = lastCollectDt;
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

    public String getPickupAddressLinkMan() {
        return pickupAddressLinkMan;
    }

    public void setPickupAddressLinkMan(String pickupAddressLinkMan) {
        this.pickupAddressLinkMan = pickupAddressLinkMan;
    }

    public String getPickupAddressLinkPhone() {
        return pickupAddressLinkPhone;
    }

    public void setPickupAddressLinkPhone(String pickupAddressLinkPhone) {
        this.pickupAddressLinkPhone = pickupAddressLinkPhone;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public Date getCollectDt() {
        return collectDt;
    }

    public void setCollectDt(Date collectDt) {
        this.collectDt = collectDt;
    }

    public Integer getCollectBy() {
        return collectBy;
    }

    public void setCollectBy(Integer collectBy) {
        this.collectBy = collectBy;
    }

    public Date getReceiveDt() {
        return receiveDt;
    }

    public void setReceiveDt(Date receiveDt) {
        this.receiveDt = receiveDt;
    }

    public Integer getReceiveBy() {
        return receiveBy;
    }

    public void setReceiveBy(Integer receiveBy) {
        this.receiveBy = receiveBy;
    }

    public Date getCheckDt() {
        return checkDt;
    }

    public void setCheckDt(Date checkDt) {
        this.checkDt = checkDt;
    }

    public Integer getCheckBy() {
        return checkBy;
    }

    public void setCheckBy(Integer checkBy) {
        this.checkBy = checkBy;
    }

    public Date getOutroomDt() {
        return outroomDt;
    }

    public void setOutroomDt(Date outroomDt) {
        this.outroomDt = outroomDt;
    }

    public Integer getOutroomBy() {
        return outroomBy;
    }

    public void setOutroomBy(Integer outroomBy) {
        this.outroomBy = outroomBy;
    }

    public String getIsCollectPrint() {
        return isCollectPrint;
    }

    public void setIsCollectPrint(String isCollectPrint) {
        this.isCollectPrint = isCollectPrint;
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

    public Double gettCollectNums() {
        return tCollectNums;
    }

    public void settCollectNums(Double tCollectNums) {
        this.tCollectNums = tCollectNums;
    }

    public Double gettReceiveNums() {
        return tReceiveNums;
    }

    public void settReceiveNums(Double tReceiveNums) {
        this.tReceiveNums = tReceiveNums;
    }

    public Double gettCheckNums() {
        return tCheckNums;
    }

    public void settCheckNums(Double tCheckNums) {
        this.tCheckNums = tCheckNums;
    }

    public Double gettOutroomNums() {
        return tOutroomNums;
    }

    public void settOutroomNums(Double tOutroomNums) {
        this.tOutroomNums = tOutroomNums;
    }
}
