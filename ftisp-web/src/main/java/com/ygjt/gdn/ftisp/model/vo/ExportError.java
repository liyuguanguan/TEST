package com.ygjt.gdn.ftisp.model.vo;


import com.ygjt.gdn.ftisp.utils.excel.Excel;

/**
 * Created by wyh on 2016/11/24.
 */
public class ExportError {
    @Excel(exportName = "code")
    protected Integer code ;
    @Excel(exportName = "message")
    protected String message ;

    public ExportError() {

    }

    public ExportError(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
