package com.ygjt.gdn.ftisp.model.vo.po;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by ZZY on 2016/10/29.
 */
public class OutroomOrderCreatePO {
    @NotNull(message = "{crm.outroomordercreate.check.warehouseid.notnull}")
    private Integer warehouseId;//"warehouseId": 1,
    private String platType;//"platType": "string",
    private String platOrderNo;//"platOrderNo": 1,
    @NotNull(message = "{crm.outroomordercreate.check.deliverywayid.notnull}")
    private Integer deliveryWayId;//"deliveryWayId": 1,
    private String doorplatenumbers;//"doorplateNumbers": 1,
    @NotNull(message = "{crm.outroomordercreate.check.recipientname.notnull}")
    private String recipientName;//"recipientName": "string",
    @NotNull(message = "{crm.outroomordercreate.check.recipientaddress1.notnull}")
    private String recipientAddress1;//"recipientAddress1": "string",
    private String recipientAddress2;//"recipientAddress2": "string",
    @NotNull(message = "{crm.outroomordercreate.check.recipientcountryid.notnull}")
    private Integer recipientCountryId;//"recipientCountryId": 0,
    @NotNull(message = "{crm.outroomordercreate.check.recipientregionname.notnull}")
    private String recipientRegionName;//"recipientRegionId": 0,
    @NotNull(message = "{crm.outroomordercreate.check.recipientcityname.notnull}")
    private String recipientCityName;//"recipientCityId": 0,
    @NotNull(message = "{crm.outroomordercreate.check.recipientzipcode.notnull}")
    private String recipientZipcode;//"recipientZipcode": "string",
    @NotNull(message = "{crm.outroomordercreate.check.recipientphone.notnull}")
    private String recipientPhone;//"recipientPhone": "string",
    private Integer outstore_table_length;
    private String nameFirst;
    private String nameSecond;
    private List<OutroomOrderGoodPO> goods;//"goods":

    public String getDoorplatenumbers() {
        return doorplatenumbers;
    }

    public void setDoorplatenumbers(String doorplatenumbers) {
        this.doorplatenumbers = doorplatenumbers;
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

    public Integer getOutstore_table_length() {
        return outstore_table_length;
    }

    public void setOutstore_table_length(Integer outstore_table_length) {
        this.outstore_table_length = outstore_table_length;
    }

    public String getPlatOrderNo() {
        return platOrderNo;
    }

    public void setPlatOrderNo(String platOrderNo) {
        this.platOrderNo = platOrderNo;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
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

    public List<OutroomOrderGoodPO> getGoods() {
        return goods;
    }

    public void setGoods(List<OutroomOrderGoodPO> goods) {
        this.goods = goods;
    }
}
