package com.ygjt.gdn.ftisp.model.vo;

import java.util.Date;

/**
 * 订单物流轨迹详情
 * Created by linx on 2016/10/29.
 */
public class OrderInfoOptVO {
    private Date optDt;//:操作时间 string
    private String opsStatus;//:操作状态 string
    private String warehouseName;//:仓库名称 string

    public Date getOptDt() {
        return optDt;
    }

    public void setOptDt(Date optDt) {
        this.optDt = optDt;
    }

    public String getOpsStatus() {
        return opsStatus;
    }

    public void setOpsStatus(String opsStatus) {
        this.opsStatus = opsStatus;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }
}
