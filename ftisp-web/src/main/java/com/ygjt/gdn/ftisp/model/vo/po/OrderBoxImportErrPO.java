package com.ygjt.gdn.ftisp.model.vo.po;

import com.ygjt.gdn.ftisp.utils.excel.Excel;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**包裹批量导入错误信息
 * Created by linx on 2016/11/3.
 */
public class OrderBoxImportErrPO {

    @Excel(exportName = "箱号")
    @NotEmpty(message = "箱号不能为空")
    private String boxNo;
    @Excel(exportName = "重量")
    @NotEmpty(message = "重量不能为空")
    @Pattern(regexp = "(([0-9]|([1-9][0-9]+))(\\.[0-9]{1,3}))|([0-9])|([1-9][0-9]+)",message = "重量存在非法字符")
    private String regWeight;
    @Excel(exportName = "长")
    @NotEmpty(message = "长不能为空")
    @Pattern(regexp = "(([0-9]|([1-9][0-9]+))(\\.[0-9]{1,3}))|([0-9])|([1-9][0-9]+)",message = "长存在非法字符")
    private String regLength;
    @Excel(exportName = "宽")
    @NotEmpty(message = "宽不能为空")
    @Pattern(regexp = "(([0-9]|([1-9][0-9]+))(\\.[0-9]{1,3}))|([0-9])|([1-9][0-9]+)",message = "宽存在非法字符")
    private String regWidth;
    @Excel(exportName = "高")
    @NotEmpty(message = "高不能为空")
    @Pattern(regexp = "(([0-9]|([1-9][0-9]+))(\\.[0-9]{1,3}))|([0-9])|([1-9][0-9]+)",message = "高存在非法字符")
    private String regHeight;
    @Excel(exportName = "商品编码")
    @NotEmpty(message = "商品编码不能为空")
    private String goodsCode;
    @Excel(exportName = "数量")
    @NotEmpty(message = "数量不能为空")
    @Pattern(regexp = "(([0-9]|([1-9][0-9]+))(\\.[0-9]{1,3}))|([0-9])|([1-9][0-9]+)",message = "数量存在非法字符")
    private String num;
    @Excel(exportName = "错误信息")
    private String message;

    public String getBoxNo() {
        return boxNo;
    }

    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo;
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

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
