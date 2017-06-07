package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.model.vo.GoodMoreDetailVo;
import com.ygjt.gdn.ftisp.model.vo.LogisticsChannelPlanListOptVO;
import com.ygjt.gdn.ftisp.model.vo.po.AddreasInfoAddPo;
import com.ygjt.gdn.ftisp.model.vo.po.LogisticsChannelPlanListOptPO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhongb on 2017/4/27.
 */
@Service
public class LogisticsChannelPlanQueryOptionService extends AbstractB2S2CInfService<LogisticsChannelPlanListOptPO,ResultData<List<LogisticsChannelPlanListOptVO>>> implements InterService<LogisticsChannelPlanListOptPO,ResultData<List<LogisticsChannelPlanListOptVO>>> {
    private static final Logger logger = Logger.getLogger(LogisticsChannelPlanQueryOptionService.class);

    @Value("#{configProperties['api.b2s2c.logisticsChannelPlan.queryOption.url']}")
    protected String            API_B2S2C_LOGISTICSCHANNELPLAN_QUERYOPTION_URL;
    @Override
    public ResultData<List<LogisticsChannelPlanListOptVO>> call(LogisticsChannelPlanListOptPO req) {
        return null;
    }
    @Override
    public ResultData<List<LogisticsChannelPlanListOptVO>> call(LogisticsChannelPlanListOptPO req, String token) {
        try{
            String resp = invoke(req,null,token, API_B2S2C_URL+API_B2S2C_LOGISTICSCHANNELPLAN_QUERYOPTION_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData<List<LogisticsChannelPlanListOptVO>> respModel = new ResultData<List<LogisticsChannelPlanListOptVO>>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData<List<LogisticsChannelPlanListOptVO>> handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,new TypeReference<ResultData<List<LogisticsChannelPlanListOptVO>>>(){});
        }
        return null;
    }
}
