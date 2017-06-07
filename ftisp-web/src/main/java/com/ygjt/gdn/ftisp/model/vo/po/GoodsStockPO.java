package com.ygjt.gdn.ftisp.model.vo.po;


import com.ygjt.gdn.ftisp.common.Constants;

/**
 * Created by linx on 2016/11/1.
 */
public class GoodsStockPO {
    private Integer page;
    private Integer rows;
    private String sort;
    private String order;
    private String warehouseId;
    private String goodsName;
    private String goodsEName;
    private String goodsCode;
    private String type;

    public Integer getPage() {
        return page==null? Constants.DEFAULT_PAGE:page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows==null?Constants.DEFAULT_ROWZISE:rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsEName() {
        return goodsEName;
    }

    public void setGoodsEName(String goodsEName) {
        this.goodsEName = goodsEName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
