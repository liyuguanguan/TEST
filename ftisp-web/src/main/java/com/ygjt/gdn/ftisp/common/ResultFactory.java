package com.ygjt.gdn.ftisp.common;

import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.common.ResultData;

/**
 * Created by yhj on 16/10/23.
 */
public class ResultFactory {



    public static  <T> ResultData<T> createSuccessResultData(T data){

        return new ResultData<T>(Constants.RESULT_CODE_SUCCESS,Constants.RESULT_MESSAGE_SUCCESS,data);
    }




    public static  <T> ResultData<T> createWarmingResultData(T data){

        return new ResultData<T>(Constants.RESULT_CODE_SUCCESS,Constants.RESULT_MESSAGE_SUCCESS,data);
    }




    public static <T> ResultData<T> createWarmingResultData(String message , T data){

        return new ResultData<T>(Constants.RESULT_CODE_WARMING,message,data);
    }


    public static <T> ResultData<T> createFailResultData(String message , T data){

        return new ResultData<T>(Constants.RESULT_CODE_FAIL,message,data);
    }

    public static <T> ResultData<T> createFailResultData(String message){

        return new ResultData<T>(Constants.RESULT_CODE_FAIL,message,null);
    }

    public static <T> ResultData<T> createResultData(Result result,T object){

        return new ResultData<T>(result.getCode(),result.getMessage(),object);
    }




}
