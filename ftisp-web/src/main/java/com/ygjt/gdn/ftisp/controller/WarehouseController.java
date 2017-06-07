package com.ygjt.gdn.ftisp.controller;


import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.WarehouseQueryService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.po.WarehouseQueryPO;
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
 * Created by linx on 2016/11/1.
 */
@Controller
@RequestMapping({"/api/v1/p/","/api/v1/m/"})
public class WarehouseController extends BaseController{
    @Autowired
    private WarehouseQueryService warehouseQueryService;

    /**
     * 集货仓 海外仓查询
     * @param warehouseQueryPO
     * @return
     */
    @RequestMapping({"/ftisp/warehouse/query"})
    @ResponseBody
    public ResultData<?> query(@Valid WarehouseQueryPO warehouseQueryPO, BindingResult result,HttpServletRequest request) {
        List<String> errorList = new ArrayList<String>();
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errorList.add(fieldError.getDefaultMessage());
            }
        }
        if (errorList.size() > 0) {
            return new ResultData<List<?>>(Constants.RESULT_CODE_FAIL, Constants.RESULT_MESSAGE_PARAM_ERROR, errorList);
        }
        return  warehouseQueryService.call(warehouseQueryPO,getToken(request)) ;
    }


}
