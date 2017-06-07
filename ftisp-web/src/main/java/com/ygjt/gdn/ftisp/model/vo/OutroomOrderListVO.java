package com.ygjt.gdn.ftisp.model.vo;

import com.ygjt.gdn.ftisp.common.IVO;

/**
 * Created by zzy on 2016/10/28.
 */
public class OutroomOrderListVO implements IVO{
    private Integer id;// (integer, optional): 订单id ,
    private String orderNo;// orderNo (string, optional): 订单号 ,
    private String warehouseName; //(string, optional): 出货仓库名 ,
    private String platType; //(string, optional): 电商平台 ,
    private String recipientName;// (string, optional): 收件人姓名 ,
    private Integer deliveryWayId;// (integer, optional): 发货方式 ,
    private String deliveryWayName;// (integer, optional): 发货方式 ,
    private String deliveryCode;// (string, optional): 物流单号 ,
    private String status;// (string, optional): 出库单状态 ,
    private String createDt;// (string, optional): 下单时间 ,
    private String outroomDate;// (string, optional): 出库时间 ,
    private Double deliveryWeight;

    public String getDeliveryWayName() {
        return deliveryWayName;
    }

    public void setDeliveryWayName(String deliveryWayName) {
        this.deliveryWayName = deliveryWayName;
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

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getPlatType() {
        return platType;
    }

    public void setPlatType(String platType) {
        this.platType = platType;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public Integer getDeliveryWayId() {
        return deliveryWayId;
    }

    public void setDeliveryWayId(Integer deliveryWayId) {
        this.deliveryWayId = deliveryWayId;
    }

    public String getDeliveryCode() {
        return deliveryCode;
    }

    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateDt() {
        return createDt;
    }

    public void setCreateDt(String createDt) {
        this.createDt = createDt;
    }

    public String getOutroomDate() {
        return outroomDate;
    }

    public void setOutroomDate(String outroomDate) {
        this.outroomDate = outroomDate;
    }

    public Double getDeliveryWeight() {
        return deliveryWeight;
    }

    public void setDeliveryWeight(Double deliveryWeight) {
        this.deliveryWeight = deliveryWeight;
    }
}
