package com.ygjt.gdn.ftisp.exception;


import com.ygjt.gdn.ftisp.common.Result;

/**
 * Created by wyh on 2016/11/29.
 */
public class ImportOutNumException extends RuntimeException{
    private Integer code ;
    private String message ;
    private Object data ;
    public ImportOutNumException(String message) {
        super(message);
        this.message = message ;
    }
    public ImportOutNumException(String message, Integer code) {
        super(message);
        this.message = message ;
        this.code = code;
    }

    public ImportOutNumException(Throwable cause, Integer code, String message) {
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
