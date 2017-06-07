package com.ygjt.gdn.ftisp.model.vo.po;

import com.ygjt.gdn.ftisp.common.IPO;
import com.ygjt.gdn.ftisp.common.annotation.IsDate;
import com.ygjt.gdn.ftisp.common.annotation.IsInteger;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import java.util.List;

/**
 * 新增订单PO
 * Created by linx on 2016/10/28.
 */
public class CreateOrderInfoPO implements IPO {
    private String id;
    @IsInteger(message = "{crm.createorder.check.logisticsid.error}")
    private String logisticsId;
    @IsInteger(message = "{crm.createorder.check.collectWarehouseid.error}")
    private String collectWarehouseId;
    @IsInteger(message = "{crm.createorder.check.toWarehouseid.error}")
    private String toWarehouseId;
    @IsInteger(message = "{crm.createorder.check.logisticsplanid.error}")
    private String logisticsPlanId;
    @IsInteger(message = "{crm.createorder.check.importerid.error}")
    private String importerId;
    @IsInteger(message = "{crm.createorder.check.exporterid.error}")
    private String exporterId;
    @IsInteger(notNull = false,message = "{valid.createorderinfopo.pickupaddressid.notnull}")
    private String pickupAddressId;
    private String customOrderNo;
    private String pickupType;
    @IsDate(format="yyyy-MM-dd",message = "{crm.createorder.check.pickupdate.error}")
    private String pickupDate;
    private String pickupTime;
    private String expressProviderName;
    private String expressNo;
    private String instoreAdd_table_length;
    /**自抬头 统一报关*/
    private String isSelfDeclare;
    /*** 报关名称*/
    private String declareName;
    @Valid
    @NotEmpty(message = "包裹不能为空")
    private List<CreateOrderBoxPo> boxes;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getCollectWarehouseId() {
        return collectWarehouseId;
    }

    public void setCollectWarehouseId(String collectWarehouseId) {
        this.collectWarehouseId = collectWarehouseId;
    }

    public String getToWarehouseId() {
        return toWarehouseId;
    }

    public void setToWarehouseId(String toWarehouseId) {
        this.toWarehouseId = toWarehouseId;
    }

    public String getLogisticsPlanId() {
        return logisticsPlanId;
    }

    public void setLogisticsPlanId(String logisticsPlanId) {
        this.logisticsPlanId = logisticsPlanId;
    }

    public String getImporterId() {
        return importerId;
    }

    public void setImporterId(String importerId) {
        this.importerId = importerId;
    }

    public String getExporterId() {
        return exporterId;
    }

    public void setExporterId(String exporterId) {
        this.exporterId = exporterId;
    }

    public String getPickupAddressId() {
        return pickupAddressId;
    }

    public void setPickupAddressId(String pickupAddressId) {
        this.pickupAddressId = pickupAddressId;
    }

    public String getCustomOrderNo() {
        return customOrderNo;
    }

    public void setCustomOrderNo(String customOrderNo) {
        this.customOrderNo = customOrderNo;
    }

    public String getPickupType() {
        return pickupType;
    }

    public void setPickupType(String pickupType) {
        this.pickupType = pickupType;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getExpressProviderName() {
        return expressProviderName;
    }

    public void setExpressProviderName(String expressProviderName) {
        this.expressProviderName = expressProviderName;
    }

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }

    public String getIsSelfDeclare() {
        return isSelfDeclare;
    }

    public void setIsSelfDeclare(String isSelfDeclare) {
        this.isSelfDeclare = isSelfDeclare;
    }

    public String getDeclareName() {
        return declareName;
    }

    public void setDeclareName(String declareName) {
        this.declareName = declareName;
    }
    public String getInstoreAdd_table_length() {
        return instoreAdd_table_length;
    }

    public void setInstoreAdd_table_length(String instoreAdd_table_length) {
        this.instoreAdd_table_length = instoreAdd_table_length;
    }

    public List<CreateOrderBoxPo> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<CreateOrderBoxPo> boxes) {
        this.boxes = boxes;
    }
}
