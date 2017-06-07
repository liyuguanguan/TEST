package com.ygjt.gdn.ftisp.model.vo;

import com.ygjt.gdn.ftisp.common.IVO;

/**
 * Created by zzy on 2016/11/29.
 */
public class GoodsStockQueryGoodsVO implements IVO{
    private Integer id;
    private String chName;
    private String enName;
    private String code;
    private Integer stockNums;//可用数量
    private Integer frozenNums;//
    private Integer wayNums;

    public Integer getFrozenNums() {
        return frozenNums;
    }

    public void setFrozenNums(Integer frozenNums) {
        this.frozenNums = frozenNums;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChName() {
        return chName;
    }

    public void setChName(String chName) {
        this.chName = chName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStockNums() {
        return stockNums;
    }

    public void setStockNums(Integer stockNums) {
        this.stockNums = stockNums;
    }

    public Integer getWayNums() {
        return wayNums;
    }

    public void setWayNums(Integer wayNums) {
        this.wayNums = wayNums;
    }
}
