package com.ygjt.gdn.ftisp.model.vo;

/**
 * Created by linx on 2016/11/1.
 */
public class GoodsStockVO {
    private Integer id;
    private String warehouseName;// "warehouseName": "HK WAREHOUSE",
    private Integer goodsId;
    private String goodsName;//   "goodsName": "联想笔记本电脑 T440p",
    private String goodsEName;//商品英文名称
    private String customerName;//货主
    private String goodsCode;// "goodsName": "联想笔记本电脑 T440p",
    private String spec;// "spec": "T440",
    private Double stockNums;//    "stockNums": 100,
    private Double frozenNums;
    private Double wayNums;//  "wayNums": 200,
    private Double totalSales;//   "totalSales": 1000

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Double getFrozenNums() {
        return frozenNums;
    }

    public void setFrozenNums(Double frozenNums) {
        this.frozenNums = frozenNums;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
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

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Double getStockNums() {
        return stockNums;
    }

    public void setStockNums(Double stockNums) {
        this.stockNums = stockNums;
    }

    public Double getWayNums() {
        return wayNums;
    }

    public void setWayNums(Double wayNums) {
        this.wayNums = wayNums;
    }

    public Double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Double totalSales) {
        this.totalSales = totalSales;
    }

    public String getGoodsEName() {
        return goodsEName;
    }

    public void setGoodsEName(String goodsEName) {
        this.goodsEName = goodsEName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
