package com.ygjt.gdn.ftisp.model.vo.po;

import com.ygjt.gdn.ftisp.common.IPO;
import com.ygjt.gdn.ftisp.common.annotation.IsDate;
import com.ygjt.gdn.ftisp.common.annotation.IsInteger;
import org.apache.commons.lang.StringUtils;

import javax.validation.constraints.Size;

/**
 * 企业端 列表查询参数类
 * Created by linx on 2016/11/2.
 */
public class OrderQueryPO implements IPO {

    private String page;
    private String rows;
    private String sort;
    private String order;

    @IsDate(format="yyyy-MM-dd",message = "{valid.orderquerypo.stardate.isdate}")
    private String starDate; // 开始日期
    @IsDate(format="yyyy-MM-dd")
    private String endDate;  //结束日期
    @Size(max = 100,message="{crm.orderquerypo.check.orderno.size}")
    private String orderNo;  //入库单号
    //@InList(fields = {"abc","123","null"})
    private String orderStatus;  //仓库状态
    //@Digits(integer =11,fraction = 0,message = "海外仓Id参数有误")
    @IsInteger(notNull = false,message = "{crm.orderquerypo.check.towarehouseid.isinteger}")
    private String toWarehouseId; // 目的仓Id
    //@Digits(integer =11,fraction = 0,message = "集货仓Id参数有误")
    @IsInteger(notNull = false,message = "{crm.orderquerypo.check.collectWarehouseid.isinteger}")
    private String collectWarehouseId; // 收货仓ID
    //@Digits(integer =11,fraction = 0,message = "物流产品Id参数有误")
    @IsInteger(notNull = false,message = "{crm.orderquerypo.check.logisticsid.isinteger}")
    private String logisticsId; // 物流产品Id


    public String getPage() {
        return StringUtils.isNotBlank(page)?page:"1";
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getRows() {
        return StringUtils.isNotBlank(rows)?rows:"20";
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getToWarehouseId() {
        return toWarehouseId;
    }

    public void setToWarehouseId(String toWarehouseId) {
        this.toWarehouseId = toWarehouseId;
    }

    public String getCollectWarehouseId() {
        return collectWarehouseId;
    }

    public void setCollectWarehouseId(String collectWarehouseId) {
        this.collectWarehouseId = collectWarehouseId;
    }

    public String getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId;
    }
}
