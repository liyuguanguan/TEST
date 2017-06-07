package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ygjt.gdn.ftisp.api.b2s2c.model.UserReq;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.mail.service.impl.ForgetMailService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by linx on 2017-04-24.
 */
@Service
public class RegisterService extends AbstractB2S2CInfService<UserReq,Result> implements InterService<UserReq,Result> {
    private static final Logger logger = Logger.getLogger(RegisterService.class);

    @Value("#{configProperties['api.b2s2c.register.url']}")
    protected String            API_B2S2C_REGISTER_URL;
    @Override
    public Result call( UserReq req) {
        try{
            req.setUserSource(Constants.SYSTEM_FTISP);
            String resp = invoke(req, API_B2S2C_URL+API_B2S2C_REGISTER_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            Result respModel = new Result();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }

    @Override
    public Result call(UserReq req,  String token) {
        return null;
    }

    @Override
    public Result handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,Result.class);
        }
        return null;
    }
}
