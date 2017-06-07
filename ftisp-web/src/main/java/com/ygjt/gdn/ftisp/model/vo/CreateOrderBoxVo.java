package com.ygjt.gdn.ftisp.model.vo;

import java.util.List;

/**
 * Created by linx on 2016/10/28.
 */
public class CreateOrderBoxVo {

    private Integer id;
    private String boxNo;
    private String boxCode;
    private Double regWeight;
    private Double regLength;
    private Double regWidth;
    private Double regHeight;
    private List<CreateOrderBoxGoodsVo> goods;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBoxNo() {
        return boxNo;
    }

    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo;
    }

    public String getBoxCode() {
        return boxCode;
    }

    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }

    public Double getRegWeight() {
        return regWeight;
    }

    public void setRegWeight(Double regWeight) {
        this.regWeight = regWeight;
    }

    public Double getRegLength() {
        return regLength;
    }

    public void setRegLength(Double regLength) {
        this.regLength = regLength;
    }

    public Double getRegWidth() {
        return regWidth;
    }

    public void setRegWidth(Double regWidth) {
        this.regWidth = regWidth;
    }

    public Double getRegHeight() {
        return regHeight;
    }

    public void setRegHeight(Double regHeight) {
        this.regHeight = regHeight;
    }

    public List<CreateOrderBoxGoodsVo> getGoods() {
        return goods;
    }

    public void setGoods(List<CreateOrderBoxGoodsVo> goods) {
        this.goods = goods;
    }
}
