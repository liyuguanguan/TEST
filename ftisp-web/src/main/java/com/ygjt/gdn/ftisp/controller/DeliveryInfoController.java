package com.ygjt.gdn.ftisp.controller;

import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.WarehouseDeliveryQueryService;

import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.common.ResultFactory;
import com.ygjt.gdn.ftisp.model.vo.po.DeliveryInfoOptPO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzy on 2016/11/10.
 */
@Controller
@RequestMapping("/api/v1/p/ftisp/warehouseDelivery")
public class DeliveryInfoController extends BaseController{
    private static final Logger logger = Logger.getLogger(DeliveryInfoController.class);
    @Autowired
    WarehouseDeliveryQueryService warehouseDeliveryQueryService;

    @RequestMapping("/query")
    @ResponseBody
    public ResultData<?> queryOption(@Valid DeliveryInfoOptPO po, BindingResult result, HttpServletRequest request){
        List<String> errorList = new ArrayList<String>() ;
        if(result.hasErrors()){
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errorList.add(fieldError.getDefaultMessage());
            }
        }
        //po字段验证
        if(errorList.size() > 0 ) {
            return ResultFactory.createFailResultData(Constants.RESULT_MESSAGE_PARAM_ERROR, errorList);
        }
        try {
            return warehouseDeliveryQueryService.call(po,getToken(request));
        } catch (Exception e) {
            logger.error("发货方式查询异常：" ,e);
            return ResultFactory.createFailResultData("发货方式查询异常");
        }
    }

}
