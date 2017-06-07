package com.ygjt.gdn.ftisp.model.vo;

import com.ygjt.gdn.ftisp.model.vo.InCode;

import java.util.List;

/**
 * Created by linx on 2016/10/29.
 */
public class OrderBoxGoodsQueryVo {
    private Integer id; //  (integer, optional): id ,
    private Integer goodsId; //  (integer, optional): id ,
    private Integer boxId; //  (string, optional): 包裹条形码 ,
    private String goodsCode; //  (string, optional): 商品编码 ,
    private String goodsName; //  (string, optional): 中文名 ,
    private String spec;
    private String model;
    private Double factNums; //  实收数量 ,
    private Double shelveNum; //  实收数量 ,
    private Double num;// 100
    private List<InCode> inCodeList;

    public Double getShelveNum() {
        return shelveNum;
    }

    public void setShelveNum(Double shelveNum) {
        this.shelveNum = shelveNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getBoxId() {
        return boxId;
    }

    public void setBoxId(Integer boxId) {
        this.boxId = boxId;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getFactNums() {
        return factNums;
    }

    public void setFactNums(Double factNums) {
        this.factNums = factNums;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public List<InCode> getInCodeList() {
        return inCodeList;
    }

    public void setInCodeList(List<InCode> inCodeList) {
        this.inCodeList = inCodeList;
    }
}
