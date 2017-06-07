package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.model.vo.FeeEstimateVO;
import com.ygjt.gdn.ftisp.model.vo.po.CreateOrderInfoPO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by zhongb on 2017/4/27.
 */
@Service
public class OrderFeeEstimateService extends AbstractB2S2CInfService<CreateOrderInfoPO,ResultData<FeeEstimateVO>> implements InterService<CreateOrderInfoPO,ResultData<FeeEstimateVO>> {
    private static final Logger logger = Logger.getLogger(OrderFeeEstimateService.class);

    @Value("#{configProperties['api.b2s2c.order.feeEstimate.url']}")
    protected String            API_B2S2C_ORDER_FEEESTIMATE_URL;
    @Override
    public ResultData<FeeEstimateVO> call(CreateOrderInfoPO req) {
        return null;
    }
    @Override
    public ResultData<FeeEstimateVO> call(CreateOrderInfoPO req, String token) {
        try{
            String resp = invoke(null,req,token, API_B2S2C_URL+API_B2S2C_ORDER_FEEESTIMATE_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData<FeeEstimateVO> respModel = new ResultData<FeeEstimateVO>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData<FeeEstimateVO> handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,new TypeReference<ResultData<FeeEstimateVO>>(){});
        }
        return null;
    }
}
