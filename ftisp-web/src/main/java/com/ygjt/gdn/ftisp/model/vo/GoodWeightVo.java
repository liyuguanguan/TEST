package com.ygjt.gdn.ftisp.model.vo;

/**
 * Created by wyh on 2016/11/21.
 */
public class GoodWeightVo {
    private Integer id;
    private String code;
    private String chName;
    private String spec;
    private String model;
    private Double regGrossWeight;
    private Double factGrossWeight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getRegGrossWeight() {
        return regGrossWeight;
    }

    public void setRegGrossWeight(Double regGrossWeight) {
        this.regGrossWeight = regGrossWeight;
    }

    public Double getFactGrossWeight() {
        return factGrossWeight;
    }

    public void setFactGrossWeight(Double factGrossWeight) {
        this.factGrossWeight = factGrossWeight;
    }
}
