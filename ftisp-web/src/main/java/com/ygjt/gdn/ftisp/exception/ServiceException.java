package com.ygjt.gdn.ftisp.exception;


import com.ygjt.gdn.ftisp.common.Result;

/**
 * Created by linx on 2016/10/28.
 */
public class ServiceException extends RuntimeException {

    private Integer code ;
    private String message ;
    private Object data ;
    public ServiceException(String message) {
        super(message);
        this.message = message ;
    }
    public ServiceException(String message, Integer code) {
        super(message);
        this.message = message ;
        this.code = code;
    }

    public ServiceException(Throwable cause, Integer code, String message) {
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