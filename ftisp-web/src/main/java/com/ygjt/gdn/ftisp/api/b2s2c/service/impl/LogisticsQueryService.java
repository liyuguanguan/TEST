package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.model.vo.GoodMoreDetailVo;
import com.ygjt.gdn.ftisp.model.vo.LogisticsVo;
import com.ygjt.gdn.ftisp.model.vo.MerchantSimpleVo;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhongb on 2017/4/27.
 */
@Service
public class LogisticsQueryService extends AbstractB2S2CInfService<String,ResultData<List<LogisticsVo>>> implements InterService<String,ResultData<List<LogisticsVo>>>{
    private static final Logger logger = Logger.getLogger(LogisticsQueryService.class);

    @Value("#{configProperties['api.b2s2c.logistics.query.url']}")
    protected String            API_B2S2C_LOGISTICS_QUERY_URL;
    @Override
    public ResultData<List<LogisticsVo>> call(java.lang.String id) {
        return null;
    }
    @Override
    public ResultData<List<LogisticsVo>> call(String type, String token) {
        try{
            String resp = invoke(new LogisticsType(type),null,token, API_B2S2C_URL+API_B2S2C_LOGISTICS_QUERY_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData<List<LogisticsVo>> respModel = new ResultData<List<LogisticsVo>>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData<List<LogisticsVo>> handleResult(java.lang.String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,new TypeReference<ResultData<List<LogisticsVo>>>(){});
        }
        return null;
    }
    class LogisticsType{
        private String type;

        public LogisticsType() {
        }
        public LogisticsType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
