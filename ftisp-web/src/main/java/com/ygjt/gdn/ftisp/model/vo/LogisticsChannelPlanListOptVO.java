package com.ygjt.gdn.ftisp.model.vo;


import java.util.Date;

/**
 * Created by zzy on 2016/11/1.
 */
public class LogisticsChannelPlanListOptVO {
    private Integer id;
    private String name;
    private Date estimateLeaveDt;
    private Date lastOrderDt;
    private Date lastCollectDt;
    private String voyageNo;
    private String startPort;
    private String destPort;
    private String providerName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEstimateLeaveDt() {
        return estimateLeaveDt;
    }

    public void setEstimateLeaveDt(Date estimateLeaveDt) {
        this.estimateLeaveDt = estimateLeaveDt;
    }

    public Date getLastOrderDt() {
        return lastOrderDt;
    }

    public void setLastOrderDt(Date lastOrderDt) {
        this.lastOrderDt = lastOrderDt;
    }

    public Date getLastCollectDt() {
        return lastCollectDt;
    }

    public void setLastCollectDt(Date lastCollectDt) {
        this.lastCollectDt = lastCollectDt;
    }

    public String getVoyageNo() {
        return voyageNo;
    }

    public void setVoyageNo(String voyageNo) {
        this.voyageNo = voyageNo;
    }

    public String getStartPort() {
        return startPort;
    }

    public void setStartPort(String startPort) {
        this.startPort = startPort;
    }

    public String getDestPort() {
        return destPort;
    }

    public void setDestPort(String destPort) {
        this.destPort = destPort;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}
