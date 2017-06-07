package com.ygjt.gdn.ftisp.model.vo;

import com.ygjt.gdn.ftisp.common.IVO;

import java.util.List;

/**
 * Created by zzy on 2016/10/31.
 */
public class OutroomOrderGoodsLoadVO implements IVO{
    private Integer goodsId;
    private String code;//"code": "string",
    private String chName;//"chName": "string",
    private String model;//"model": "string",
    private String memo;//"memo": "string",
    private Integer nums;//"nums": 12,
    private double weightKg;//"weightKg": 12,
    private double weightLbs;//"weightLbs": 12,
    private String spec;//"spec": "string"
    private List<InCode> inCodeList;//商品的内包装条码

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getChName() {
        return chName;
    }

    public void setChName(String chName) {
        this.chName = chName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    public double getWeightLbs() {
        return weightLbs;
    }

    public void setWeightLbs(double weightLbs) {
        this.weightLbs = weightLbs;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public List<InCode> getInCodeList() {
        return inCodeList;
    }

    public void setInCodeList(List<InCode> inCodeList) {
        this.inCodeList = inCodeList;
    }
}
