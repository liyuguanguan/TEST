package com.ygjt.gdn.ftisp.model.vo.po;

import com.ygjt.gdn.ftisp.common.annotation.IsInteger;
import com.ygjt.gdn.ftisp.utils.excel.Excel;

import javax.validation.constraints.NotNull;

/**
 * Created by linx on 2016/11/17.
 */
public class GoodsPrintPO {
    @Excel(exportName = "*商品编码")
    @NotNull(message = "{crm.goods.check.code.notnull}")
    private String code;
    @Excel(exportName = "*数量")
    @IsInteger
    private String num;
    private String labelSize;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getLabelSize() {
        return labelSize;
    }

    public void setLabelSize(String labelSize) {
        this.labelSize = labelSize;
    }
}
