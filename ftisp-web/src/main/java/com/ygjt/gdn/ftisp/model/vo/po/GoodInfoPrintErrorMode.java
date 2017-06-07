package com.ygjt.gdn.ftisp.model.vo.po;


import com.ygjt.gdn.ftisp.utils.excel.Excel;

import javax.validation.constraints.NotNull;

/**
 * Created by wyh on 2016/12/16.
 */
public class GoodInfoPrintErrorMode {
    @Excel(exportName = "*商品编码")
    @NotNull(message = "{crm.goodinfoprinterrormode.check.code.notnull}")
    private String code;
    @Excel(exportName = "*数量")
    @NotNull(message = "{crm.goodinfoprinterrormode.check.num.notnull}")
    private String num;
    @Excel(exportName = "errorMsg")
    private String errorMsg;
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

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
