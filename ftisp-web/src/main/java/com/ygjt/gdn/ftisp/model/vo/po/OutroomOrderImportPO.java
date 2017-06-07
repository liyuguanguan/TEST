package com.ygjt.gdn.ftisp.model.vo.po;

import com.ygjt.gdn.ftisp.common.IPO;
import com.ygjt.gdn.ftisp.utils.excel.Excel;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * Created by zzy on 2016/11/3.
 */
public class OutroomOrderImportPO implements IPO {
    @Excel(exportName = "*订单号")
    @NotEmpty(message = "订单号不能为空")
    private String orderNo;
    @Excel(exportName = "*海外仓")
    @NotEmpty(message = "海外仓不能为空")
    private String warehouseName;
    @Excel(exportName = "*电商平台")
    @NotEmpty(message = "电商平台不能为空")
    private String platType;
    @Excel(exportName = "电商平台订单号")
    private String platOrderNo;
    @Excel(exportName = "*收件人")
    @NotEmpty(message = "收件人不能为空")
    private String recipientName;
    @Excel(exportName = "*国家")
    @NotEmpty(message = "国家不能为空")
    private String recipientCountryName;
    @Excel(exportName = "*州")
    @NotEmpty(message = "州不能为空")
    private String recipientRegionName;
    @Excel(exportName = "*城市")
    @NotEmpty(message = "城市不能为空")
    private String recipientCityName;
    @Excel(exportName = "*邮编")
    @NotEmpty(message = "邮编不能为空")
    @Pattern(regexp = "(([0-9]|([1-9][0-9]+))(\\.[0-9]{1,3}))|([0-9])|([1-9][0-9]+)",message = "邮编存在非法字符")
    private String recipientZipcode;
    @Excel(exportName = "*地址1")
    @NotEmpty(message = "地址1不能为空")
    private String recipientAddress1;
    @Excel(exportName = "地址2")
    private String recipientAddress2;
    @Excel(exportName = "*联系电话")
    @NotEmpty(message = "联系电话不能为空")
    private String recipientPhone;
    @Excel(exportName = "*商品编码")
    @NotEmpty(message = "商品编码不能为空")
    private String code;
    @Excel(exportName = "*数量")
    @NotEmpty(message = "数量不能为空")
    @Pattern(regexp = "(([0-9]|([1-9][0-9]+))(\\.[0-9]{1,3}))|([0-9])|([1-9][0-9]+)",message = "数量存在非法字符")
    private String nums;
    @Excel(exportName = "*发货方式")
    @NotEmpty(message = "提货方式不能为空")
    private String deliveryWay;
    @Excel(exportName = "自提区域")
    private String doorplatenumbers;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getPlatType() {
        return platType;
    }

    public void setPlatType(String platType) {
        this.platType = platType;
    }

    public String getPlatOrderNo() {
        return platOrderNo;
    }

    public void setPlatOrderNo(String platOrderNo) {
        this.platOrderNo = platOrderNo;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientCountryName() {
        return recipientCountryName;
    }

    public void setRecipientCountryName(String recipientCountryName) {
        this.recipientCountryName = recipientCountryName;
    }

    public String getRecipientRegionName() {
        return recipientRegionName;
    }

    public void setRecipientRegionName(String recipientRegionName) {
        this.recipientRegionName = recipientRegionName;
    }

    public String getRecipientCityName() {
        return recipientCityName;
    }

    public void setRecipientCityName(String recipientCityName) {
        this.recipientCityName = recipientCityName;
    }

    public String getRecipientZipcode() {
        return recipientZipcode;
    }

    public void setRecipientZipcode(String recipientZipcode) {
        this.recipientZipcode = recipientZipcode;
    }

    public String getRecipientAddress1() {
        return recipientAddress1;
    }

    public void setRecipientAddress1(String recipientAddress1) {
        this.recipientAddress1 = recipientAddress1;
    }

    public String getRecipientAddress2() {
        return recipientAddress2;
    }

    public void setRecipientAddress2(String recipientAddress2) {
        this.recipientAddress2 = recipientAddress2;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNums() {
        return nums;
    }

    public void setNums(String nums) {
        this.nums = nums;
    }

    public String getDeliveryWay() {
        return deliveryWay;
    }

    public void setDeliveryWay(String deliveryWay) {
        this.deliveryWay = deliveryWay;
    }

    public String getDoorplatenumbers() {
        return doorplatenumbers;
    }

    public void setDoorplatenumbers(String doorplatenumbers) {
        this.doorplatenumbers = doorplatenumbers;
    }
}
