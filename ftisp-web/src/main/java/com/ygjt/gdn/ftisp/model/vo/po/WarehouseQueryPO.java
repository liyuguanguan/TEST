package com.ygjt.gdn.ftisp.model.vo.po;

import javax.validation.constraints.NotNull;

/**
 * Created by linx on 2016/11/1.
 */
public class WarehouseQueryPO {
    private String logisticsId;
    @NotNull(message = "{commons.warehousequery.check.warehousetype.notnull}")
    private String warehouseType;
    private String inspectionWarehouseCode;
    private String warehouseName;

    public String getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getWarehouseType() {
        return warehouseType;
    }

    public void setWarehouseType(String warehouseType) {
        this.warehouseType = warehouseType;
    }

    public String getInspectionWarehouseCode() {
        return inspectionWarehouseCode;
    }

    public void setInspectionWarehouseCode(String inspectionWarehouseCode) {
        this.inspectionWarehouseCode = inspectionWarehouseCode;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }
}
