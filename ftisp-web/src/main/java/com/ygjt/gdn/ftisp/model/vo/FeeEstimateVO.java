package com.ygjt.gdn.ftisp.model.vo;

import java.util.List;

/**
 * 入库单费用预估
 * Created by linx on 2017-01-21.
 */
public class FeeEstimateVO {
    private String  currency;//"currency": "CNY",
    private String    totalAmount  ;//    "totalAmount": 100,
    private List<FeeEstimateItemVO> rows;  //      "rows": [

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public List<FeeEstimateItemVO> getRows() {
        return rows;
    }

    public void setRows(List<FeeEstimateItemVO> rows) {
        this.rows = rows;
    }
}
