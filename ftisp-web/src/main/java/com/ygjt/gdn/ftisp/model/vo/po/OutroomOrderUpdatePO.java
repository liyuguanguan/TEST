package com.ygjt.gdn.ftisp.model.vo.po;

import com.ygjt.gdn.ftisp.common.IPO;

import java.util.List;

/**
 * Created by ZZY on 2016/10/31.
 */
public class OutroomOrderUpdatePO implements IPO {
    private Integer id;
    private Integer warehouseId;//"warehouseId": 1,
    private String platType;//"platType": "string",
    private Integer entAddressId;//"entAddressId": 1,
    private String platOrderNo;//"platOrderNo": 1,
    private Integer deliveryWayId;//"deliveryWayId": 1,
    private Integer logisticsId;//"logisticsId": 1,
    private String recipientName;//"recipientName": "string",
    private String recipientAddress1;//"recipientAddress1": "string",
    private String recipientAddress2;//"recipientAddress2": "string",
    private Integer recipientCountryId;//"recipientCountryId": 0,
    private Integer recipientRegionId;//"recipientRegionId": 0,
    private Integer recipientCityId;//"recipientCityId": 0,
    private String recipientZipcode;//"recipientZipcode": "string",
    private String recipientPhone;//"recipientPhone": "string",
    private Integer outstore_table_length;
    private String nameFirst;
    private String nameSecond;
    private String doorplatenumbers;//"doorplateNumbers": 1,

    public String getDoorplatenumbers() {
        return doorplatenumbers;
    }

    public void setDoorplatenumbers(String doorplatenumbers) {
        this.doorplatenumbers = doorplatenumbers;
    }

    public Integer getOutstore_table_length() {
        return outstore_table_length;
    }

    public void setOutstore_table_length(Integer outstore_table_length) {
        this.outstore_table_length = outstore_table_length;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameSecond() {
        return nameSecond;
    }

    public void setNameSecond(String nameSecond) {
        this.nameSecond = nameSecond;
    }

    private List<OutroomOrderGoodPO> goods;//"goods":

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getEntAddressId() {
        return entAddressId;
    }

    public void setEntAddressId(Integer entAddressId) {
        this.entAddressId = entAddressId;
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

    public Integer getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(Integer logisticsId) {
        this.logisticsId = logisticsId;
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

    public Integer getRecipientRegionId() {
        return recipientRegionId;
    }

    public void setRecipientRegionId(Integer recipientRegionId) {
        this.recipientRegionId = recipientRegionId;
    }

    public Integer getRecipientCityId() {
        return recipientCityId;
    }

    public void setRecipientCityId(Integer recipientCityId) {
        this.recipientCityId = recipientCityId;
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

    public List<OutroomOrderGoodPO> getGoods() {
        return goods;
    }

    public void setGoods(List<OutroomOrderGoodPO> goods) {
        this.goods = goods;
    }
}
