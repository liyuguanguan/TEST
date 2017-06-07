package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.model.vo.po.CreateOrderInfoPO;
import com.ygjt.gdn.ftisp.model.vo.po.IdPo;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhongb on 2017/4/27.
 */
@Service
public class OrderCommitService extends AbstractB2S2CInfService<IdPo,ResultData> implements InterService<IdPo,ResultData> {
    private static final Logger logger = Logger.getLogger(OrderCreateService.class);

    @Value("#{configProperties['api.b2s2c.order.commit.url']}")
    protected String            API_B2S2C_ORDER_COMMIT_URL;
    @Override
    public ResultData call(IdPo req) {
        return null;
    }
    @Override
    public ResultData call( IdPo req, String token) {
        try{
            String resp = invoke(req,null,token, API_B2S2C_URL+API_B2S2C_ORDER_COMMIT_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData respModel = new ResultData();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,ResultData.class);
        }
        return null;
    }
}
