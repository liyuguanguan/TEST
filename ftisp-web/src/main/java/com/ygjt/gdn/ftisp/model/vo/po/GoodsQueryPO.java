package com.ygjt.gdn.ftisp.model.vo.po;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by linx on 2016/11/14.
 */
public class GoodsQueryPO implements Serializable{
    @NotNull(message = "{crm.goodsquery.check.query.notnull}")
    private String query;
    @NotNull(message = "{crm.goodsquery.check.towarehouseid.notnull}")
    private Integer toWarehouseId;
    private Integer toWarehouseCountryId;
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getToWarehouseId() {
        return toWarehouseId;
    }

    public void setToWarehouseId(Integer toWarehouseId) {
        this.toWarehouseId = toWarehouseId;
    }

    public Integer getToWarehouseCountryId() {
        return toWarehouseCountryId;
    }

    public void setToWarehouseCountryId(Integer toWarehouseCountryId) {
        this.toWarehouseCountryId = toWarehouseCountryId;
    }
}
