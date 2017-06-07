package com.ygjt.gdn.ftisp.common;

/**
 * Created by yhj on 16/10/21.
 */
public class ResultData<T> extends Result {

    protected T data ;

    public ResultData() {

    }

    public ResultData(Integer code, String message, T data) {
        super(code, message);
        this.data = data;
    }



    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
