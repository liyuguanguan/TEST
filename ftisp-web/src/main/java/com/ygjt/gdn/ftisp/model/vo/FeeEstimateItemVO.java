package com.ygjt.gdn.ftisp.model.vo;

/**
 * Created by linx on 2017-01-21.
 */
public class FeeEstimateItemVO {
    private String billProdName;//  "billProdName": "揽收费",
    private String productCatalogName;//          "productCatalogName": "揽收",
    private Double amount;//          "amount": 300,
    private String currency;//          "currency": "CNY"

    public String getBillProdName() {
        return billProdName;
    }

    public void setBillProdName(String billProdName) {
        this.billProdName = billProdName;
    }

    public String getProductCatalogName() {
        return productCatalogName;
    }

    public void setProductCatalogName(String productCatalogName) {
        this.productCatalogName = productCatalogName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
