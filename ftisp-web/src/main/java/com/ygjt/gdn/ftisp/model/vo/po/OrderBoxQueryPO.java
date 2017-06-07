package com.ygjt.gdn.ftisp.model.vo.po;

import com.ygjt.gdn.ftisp.common.IPO;
import org.apache.commons.lang.StringUtils;

import javax.validation.constraints.NotNull;

/**
 * Created by linx on 2016/10/29.
 */
public class OrderBoxQueryPO implements IPO {

    @NotNull(message = "{crm.orderboxquery.check.orderid.notnull}")
    private String orderId ;
//    @NotNull(message = "页数不能为空")
//    @Digits(integer =11,fraction = 0,message = "页数参数有误")
    private String page;
    //@NotNull(message = "条数不能为空")
    //@Digits(integer =11,fraction = 0,message = "条数参数有误")
    private String rows;
    private String sort;
    private String order;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

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
}
