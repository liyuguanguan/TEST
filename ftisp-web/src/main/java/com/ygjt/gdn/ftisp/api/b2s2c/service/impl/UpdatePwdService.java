package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ygjt.gdn.ftisp.api.b2s2c.model.UserReq;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.model.vo.GoodInfoVo;
import com.ygjt.gdn.ftisp.model.vo.po.B2S2CUserPwdPO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 修改密码
 * Created by linx on 2017-04-24.
 */
@Service
public class UpdatePwdService extends AbstractB2S2CInfService<B2S2CUserPwdPO,Result> implements InterService<B2S2CUserPwdPO,Result> {
    private static final Logger logger = Logger.getLogger(UpdatePwdService.class);

    @Value("#{configProperties['api.b2s2c.update.pwd.url']}")
    protected String            API_B2S2C_UPDATE_PWD_URL;
    @Override
    public Result call( B2S2CUserPwdPO req) {
        return null;
    }

    @Override
    public Result call( B2S2CUserPwdPO req, String token) {
        try{
            String resp = invoke(null,req,token, API_B2S2C_URL+API_B2S2C_UPDATE_PWD_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData<PageVO<GoodInfoVo>> respModel = new ResultData<PageVO<GoodInfoVo>>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }

    @Override
    public Result handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,Result.class);
        }
        return null;
    }
}
