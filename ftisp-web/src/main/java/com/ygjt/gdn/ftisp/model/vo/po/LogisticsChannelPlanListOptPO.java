package com.ygjt.gdn.ftisp.model.vo.po;


/**
 * Created by zzy on 2016/11/1.
 */
public class LogisticsChannelPlanListOptPO {
    private Integer logisticsId;//物流产品id
    private Integer fromWarehouseId;//国内仓仓库id
    private Integer toWarehouseId;//海外目的仓库id

    public Integer getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(Integer logisticsId) {
        this.logisticsId = logisticsId;
    }

    public Integer getFromWarehouseId() {
        return fromWarehouseId;
    }

    public void setFromWarehouseId(Integer fromWarehouseId) {
        this.fromWarehouseId = fromWarehouseId;
    }

    public Integer getToWarehouseId() {
        return toWarehouseId;
    }

    public void setToWarehouseId(Integer toWarehouseId) {
        this.toWarehouseId = toWarehouseId;
    }
}
