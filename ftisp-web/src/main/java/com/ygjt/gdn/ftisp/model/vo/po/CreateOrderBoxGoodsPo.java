package com.ygjt.gdn.ftisp.model.vo.po;

import com.ygjt.gdn.ftisp.common.annotation.IsInteger;

import javax.validation.constraints.NotNull;

/**
 * 新增订单包裹下商品PO
 * Created by linx on 2016/10/28.
 */
public class CreateOrderBoxGoodsPo {
    private String id;
    private String boxId;
    @IsInteger(notNull = false,message = "{crm.createorderboxgoods.check.goodsid.error}")
    private String goodsId;
    @NotNull(message = "{crm.createorderboxgoods.check.goodscode.notnull}")
    private String goodsCode;
    private String goodsName;
    @IsInteger(message = "{crm.createorderboxgoods.check.num.error}")
    private String num;
    private String model;
    private String spec;
    private String factNums;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getFactNums() {
        return factNums;
    }

    public void setFactNums(String factNums) {
        this.factNums = factNums;
    }

    public String getBoxId() {
        return boxId;
    }

    public void setBoxId(String boxId) {
        this.boxId = boxId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
