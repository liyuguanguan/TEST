package com.ygjt.gdn.ftisp.exception;

import com.ygjt.gdn.ftisp.common.Result;

/**
 * Created by linx on 2016/10/28.
 */
public class ExcelException  extends RuntimeException {

    private Integer code ;
    private String message ;
    private Object data ;
    public ExcelException(String message) {
        super(message);
        this.message = message ;
    }
    public ExcelException(String message, Integer code) {
        super(message);
        this.message = message ;
        this.code = code;
    }

    public ExcelException(Throwable cause, Integer code, String message) {
        super(message,cause);
        this.code = code;
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result getResult(){

        return new Result(code,message) ;
    }
}