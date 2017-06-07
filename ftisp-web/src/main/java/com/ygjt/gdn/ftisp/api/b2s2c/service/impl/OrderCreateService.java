package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.model.vo.CreateOrderInfoVO;
import com.ygjt.gdn.ftisp.model.vo.po.CreateOrderInfoPO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by zhongb on 2017/4/27.
 */
@Service
public class OrderCreateService extends AbstractB2S2CInfService<CreateOrderInfoPO,ResultData<CreateOrderInfoVO>> implements InterService<CreateOrderInfoPO,ResultData<CreateOrderInfoVO>> {
    private static final Logger logger = Logger.getLogger(OrderCreateService.class);

    @Value("#{configProperties['api.b2s2c.order.create.url']}")
    protected String            API_B2S2C_ORDER_CREATE_URL;
    @Override
    public ResultData<CreateOrderInfoVO> call(CreateOrderInfoPO req) {
        return null;
    }
    @Override
    public ResultData<CreateOrderInfoVO> call( CreateOrderInfoPO req, String token) {
        try{
            String resp = invoke(null,req,token, API_B2S2C_URL+API_B2S2C_ORDER_CREATE_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData<CreateOrderInfoVO> respModel = new ResultData<CreateOrderInfoVO>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData<CreateOrderInfoVO> handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,new TypeReference<ResultData<CreateOrderInfoVO>>(){});
        }
        return null;
    }
}
