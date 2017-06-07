package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.model.vo.OrderBoxQueryVo;
import com.ygjt.gdn.ftisp.model.vo.po.BoxPrintBasePO;
import com.ygjt.gdn.ftisp.model.vo.po.BoxPrintPO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 包裹标签打印
 * Created by linx on 2017-04-24.
 */
@Service
public class BoxPrintService extends AbstractB2S2CInfService<BoxPrintPO,ResultData<String>> implements InterService<BoxPrintPO,ResultData<String>> {
    private static final Logger logger = Logger.getLogger(BoxPrintService.class);

    @Value("#{configProperties['api.b2s2c.box.print.url']}")
    protected String            API_B2S2C_BOX_PRINT_URL;
    @Override
    public ResultData<String> call(BoxPrintPO req) {
       return null;
    }
    @Override
    public ResultData<String> call( BoxPrintPO req, String token) {
        try{
            String resp = invoke(null,req,token, API_B2S2C_URL+API_B2S2C_BOX_PRINT_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData<String> respModel = new ResultData<String>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData<String> handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,new TypeReference<ResultData<String>>(){});
        }
        return null;
    }
}
