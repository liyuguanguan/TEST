package com.ygjt.gdn.ftisp.model.vo;

import com.ygjt.gdn.ftisp.common.IVO;

import java.util.List;

/**
 * Created by zzy on 2016/10/31.
 */
public class OutroomOrderLoadVO implements IVO{
    private Integer id;
    private String orderNo;
    private Integer warehouseId;//"warehouseId": 1,
    private String platType;//"platType": "string",
    private String platOrderNo;//"platOrderNo": 1,
    private Integer deliveryWayId;//"deliveryWayId": 1,
    private String recipientName;//"recipientName": "string",
    private String recipientAddress1;//"recipientAddress1": "string",
    private String recipientAddress2;//"recipientAddress2": "string",
    private Integer recipientCountryId;//"recipientCountryId": 0,
    private String recipientRegionName;//"recipientRegionId": 0,
    private String recipientCityName;//"recipientCityId": 0,
    private String recipientZipcode;//"recipientZipcode": "string",
    private String recipientPhone;//"recipientPhone": "string",
    private String doorplatenumbers;//"doorplateNumbers": "string",
    private String status;
    private String outroomDate;
    private String deliveryCode;
    private List<OutroomOrderGoodsLoadVO> goods;//"goods":

    public String getOutroomDate() {
        return outroomDate;
    }

    public void setOutroomDate(String outroomDate) {
        this.outroomDate = outroomDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDoorplatenumbers() {
        return doorplatenumbers;
    }

    public void setDoorplatenumbers(String doorplatenumbers) {
        this.doorplatenumbers = doorplatenumbers;
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

    public String getDeliveryCode() {
        return deliveryCode;
    }

    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    public String getPlatOrderNo() {
        return platOrderNo;
    }

    public void setPlatOrderNo(String platOrderNo) {
        this.platOrderNo = platOrderNo;
    }

    public Integer getDeliveryWayId() {
        return deliveryWayId;
    }

    public void setDeliveryWayId(Integer deliveryWayId) {
        this.deliveryWayId = deliveryWayId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientAddress1() {
        return recipientAddress1;
    }

    public void setRecipientAddress1(String recipientAddress1) {
        this.recipientAddress1 = recipientAddress1;
    }

    public String getRecipientAddress2() {
        return recipientAddress2;
    }

    public void setRecipientAddress2(String recipientAddress2) {
        this.recipientAddress2 = recipientAddress2;
    }

    public Integer getRecipientCountryId() {
        return recipientCountryId;
    }

    public void setRecipientCountryId(Integer recipientCountryId) {
        this.recipientCountryId = recipientCountryId;
    }

    public String getRecipientRegionName() {
        return recipientRegionName;
    }

    public void setRecipientRegionName(String recipientRegionName) {
        this.recipientRegionName = recipientRegionName;
    }

    public String getRecipientCityName() {
        return recipientCityName;
    }

    public void setRecipientCityName(String recipientCityName) {
        this.recipientCityName = recipientCityName;
    }

    public String getRecipientZipcode() {
        return recipientZipcode;
    }

    public void setRecipientZipcode(String recipientZipcode) {
        this.recipientZipcode = recipientZipcode;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public List<OutroomOrderGoodsLoadVO> getGoods() {
        return goods;
    }

    public void setGoods(List<OutroomOrderGoodsLoadVO> goods) {
        this.goods = goods;
    }
}
