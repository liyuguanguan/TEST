package com.ygjt.gdn.ftisp.controller;

import com.github.pagehelper.Page;
import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.LogisticsChannelPlanQueryOptionService;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.common.ResultFactory;
import com.ygjt.gdn.ftisp.model.vo.LogisticsChannelPlanListOptVO;

import com.ygjt.gdn.ftisp.model.vo.po.LogisticsChannelPlanListOptPO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zzy on 2016/10/29.
 */
@Controller
@RequestMapping("/api/v1/p/ftisp/logisticsChannelPlan")
public class LogisticsChannelPlanController extends BaseController{
    private static final Logger logger = Logger.getLogger(LogisticsChannelPlanController.class);
    @Autowired
    LogisticsChannelPlanQueryOptionService logisticsChannelPlanQueryOptionService;


    /**
     * 物流计划查询page
     * @param po
     * @return
     */
    @RequestMapping("/queryOption")
    @ResponseBody
    public ResultData<List<LogisticsChannelPlanListOptVO>> queryListOption(LogisticsChannelPlanListOptPO po, HttpServletRequest request){
        try {
            return   logisticsChannelPlanQueryOptionService.call(po,getToken(request));
            //调用物流计划查询服务
        } catch (Exception e) {
            logger.error("物流计划查询option异常",e);
            return ResultFactory.createFailResultData("物流计划查询option异常:");
        }
    }

    @RequestMapping("/query")
    @ResponseBody
    public ResultData<List<LogisticsChannelPlanListOptVO>> query(LogisticsChannelPlanListOptPO po, HttpServletRequest request){
            return   queryListOption(po, request);

    }
}
