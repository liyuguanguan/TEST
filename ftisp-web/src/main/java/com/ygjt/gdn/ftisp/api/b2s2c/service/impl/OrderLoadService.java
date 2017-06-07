package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.model.vo.FeeEstimateVO;
import com.ygjt.gdn.ftisp.model.vo.OrderDetailVo;
import com.ygjt.gdn.ftisp.model.vo.OrderInfoVO;
import com.ygjt.gdn.ftisp.model.vo.po.OrderInfoPO;
import com.ygjt.gdn.ftisp.model.vo.po.OrderNo;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhongb on 2017/4/27.
 */
@Service
public class OrderLoadService extends AbstractB2S2CInfService<String,ResultData<OrderDetailVo>> implements InterService<String,ResultData<OrderDetailVo>> {
    private static final Logger logger = Logger.getLogger(OrderLoadService.class);

    @Value("#{configProperties['api.b2s2c.order.load.url']}")
    protected String            API_B2S2C_ORDER_LOAD_URL;
    @Override
    public ResultData<OrderDetailVo> call(String orderNo) {
        return null;
    }
    @Override
    public ResultData<OrderDetailVo> call( String orderNo, String token) {
        try{
            OrderNo req = new OrderNo();
            req.setOrderNo(orderNo);
            String resp = invoke(req,null,token, API_B2S2C_URL+API_B2S2C_ORDER_LOAD_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData<OrderDetailVo> respModel = new ResultData<OrderDetailVo>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData<OrderDetailVo> handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,new TypeReference<ResultData<OrderDetailVo>>(){});
        }
        return null;
    }
}
