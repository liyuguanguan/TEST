package com.ygjt.gdn.ftisp.common;

/**
 * Created by yhj on 16/10/21.
 */
public class Result implements IVO {

    protected Integer code ;
    protected String message ;

    public Result() {
    }

    public Result(Integer code, String message) {
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
