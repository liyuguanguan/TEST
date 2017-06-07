package com.ygjt.gdn.ftisp.model.vo.po;

import com.ygjt.gdn.ftisp.common.annotation.IsDouble;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 新增订单包裹PO
 * Created by linx on 2016/10/28.
 */
public class CreateOrderBoxPo {

    private String id;
    @NotNull(message = "{crm.createorderbox.check.boxno.notnull}")
    private String boxNo;
    private String boxCode;
    @IsDouble(message = "{crm.createorderbox.check.regweight.error}")
    private String regWeight;
    @IsDouble(message = "{crm.createorderbox.check.reglength.error}")
    private String regLength;
    @IsDouble(message = "{crm.createorderbox.check.regweith.error}")
    private String regWidth;
    @IsDouble(message = "{crm.createorderbox.check.regheight.error}")
    private String regHeight;

    private String orderId;
    private String factWeight;
    private String factLength;
    private String factWidth;
    private String factHeight;
    private String volumeWeight;
    private String feeWeight;
    @Valid
    @NotEmpty(message = "{crm.createorderbox.check.goods.notnull}")
    private List<CreateOrderBoxGoodsPo> goods;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFactWeight() {
        return factWeight;
    }

    public void setFactWeight(String factWeight) {
        this.factWeight = factWeight;
    }

    public String getFactLength() {
        return factLength;
    }

    public void setFactLength(String factLength) {
        this.factLength = factLength;
    }

    public String getFactWidth() {
        return factWidth;
    }

    public void setFactWidth(String factWidth) {
        this.factWidth = factWidth;
    }

    public String getFactHeight() {
        return factHeight;
    }

    public void setFactHeight(String factHeight) {
        this.factHeight = factHeight;
    }

    public String getVolumeWeight() {
        return volumeWeight;
    }

    public void setVolumeWeight(String volumeWeight) {
        this.volumeWeight = volumeWeight;
    }

    public String getFeeWeight() {
        return feeWeight;
    }

    public void setFeeWeight(String feeWeight) {
        this.feeWeight = feeWeight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBoxNo() {
        return boxNo;
    }

    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo;
    }

    public String getBoxCode() {
        return boxCode;
    }

    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }

    public String getRegWeight() {
        return regWeight;
    }

    public void setRegWeight(String regWeight) {
        this.regWeight = regWeight;
    }

    public String getRegLength() {
        return regLength;
    }

    public void setRegLength(String regLength) {
        this.regLength = regLength;
    }

    public String getRegWidth() {
        return regWidth;
    }

    public void setRegWidth(String regWidth) {
        this.regWidth = regWidth;
    }

    public String getRegHeight() {
        return regHeight;
    }

    public void setRegHeight(String regHeight) {
        this.regHeight = regHeight;
    }

    public List<CreateOrderBoxGoodsPo> getGoods() {
        return goods;
    }

    public void setGoods(List<CreateOrderBoxGoodsPo> goods) {
        this.goods = goods;
    }
}
