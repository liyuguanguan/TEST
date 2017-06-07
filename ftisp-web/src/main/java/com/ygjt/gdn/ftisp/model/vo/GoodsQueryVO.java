package com.ygjt.gdn.ftisp.model.vo;

/**
 * Created by linx on 2016/11/14.
 */
public class GoodsQueryVO {
     private Integer goodsId;//"goodsId": 1,
     private String   goodsName;//       "goodsName": "联想笔记本电脑",
     private String   goodsCode;//       "goodsCode": "OW01010343"

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
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
}
