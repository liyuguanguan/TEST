package com.ygjt.gdn.ftisp.model.vo.po;

import com.ygjt.gdn.ftisp.common.IPO;

import javax.validation.constraints.NotNull;

/**
 * Created by zzy on 2016/11/29.
 */
public class GoodsStockQueryGoodsPO implements IPO {
    @NotNull(message = "{owms.goodsstockquerygoods.check.subcode.notnull}")
    private String subCode;
    @NotNull(message = "{owms.goodsstockquerygoods.check.warehouseid.notnull}")
    private Integer warehouseId;
    private Integer entId;

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getEntId() {
        return entId;
    }

    public void setEntId(Integer entId) {
        this.entId = entId;
    }
}
