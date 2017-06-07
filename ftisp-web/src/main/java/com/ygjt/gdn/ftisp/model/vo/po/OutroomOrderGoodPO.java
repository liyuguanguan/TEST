package com.ygjt.gdn.ftisp.model.vo.po;


import com.ygjt.gdn.ftisp.common.IPO;

/**
 * Created by zzy on 2016/10/29.
 */
public class OutroomOrderGoodPO implements IPO{
    private Integer goodsId;//"goodsId": 12,
    private Integer nums;//"nums": 12,
    private String spec;//"spec": "string"
    private String code;
    private String chName;
    private double weightKg;
    private double weightLbs;

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

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }
}
