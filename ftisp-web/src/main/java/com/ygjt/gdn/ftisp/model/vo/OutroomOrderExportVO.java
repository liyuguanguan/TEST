package com.ygjt.gdn.ftisp.model.vo;

/**
 * Created by zzy on 2016/11/2.
 */
public class OutroomOrderExportVO extends OutroomOrderLoadVO{
    private String warehouseName;
    private String recipientCountryName;
    private String recipientRegionName;
    private String recipientCityName;
    private String deliveryWayName;

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getRecipientCountryName() {
        return recipientCountryName;
    }

    public void setRecipientCountryName(String recipientCountryName) {
        this.recipientCountryName = recipientCountryName;
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

    public String getDeliveryWayName() {
        return deliveryWayName;
    }

    public void setDeliveryWayName(String deliveryWayName) {
        this.deliveryWayName = deliveryWayName;
    }
}
