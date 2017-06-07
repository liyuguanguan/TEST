package com.ygjt.gdn.ftisp.controller;


import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.LogisticsQueryService;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.common.annotation.ParamBind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by linx on 2016/11/1.
 */
@Controller
@RequestMapping({"/api/v1/p","/api/v1/m"})
public class LogiscticsController extends BaseController{
    @Autowired
    private LogisticsQueryService logisticsQueryService;

    @RequestMapping({"/ftisp/logistics/query"})
    @ResponseBody
    public ResultData<?> query(@ParamBind String type, HttpServletRequest request){
        return   logisticsQueryService.call(type,getToken(request));
    }
}
