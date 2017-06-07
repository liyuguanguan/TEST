package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.model.vo.OutroomOrderListVO;
import com.ygjt.gdn.ftisp.model.vo.po.OutroomOrderIdPO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhongb on 2017/4/28.
 */
@Service
public class OutRoomOrderDeleteService extends AbstractB2S2CInfService<List<OutroomOrderIdPO>,ResultData<?>> implements InterService<List<OutroomOrderIdPO>,ResultData<?>> {
    private static final Logger logger = Logger.getLogger(OutRoomOrderDeleteService.class);

    @Value("#{configProperties['api.b2s2c.outRoomOrder.delete.url']}")
    protected String            API_B2S2C_OUTROOMORDER_DELETE_URL;
    @Override
    public ResultData<?> call(List<OutroomOrderIdPO> req) {
        return null;
    }
    @Override
    public ResultData<?> call( List<OutroomOrderIdPO> req, String token) {
        try{
            String resp = invoke(null,req,token, API_B2S2C_URL+API_B2S2C_OUTROOMORDER_DELETE_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData<?> respModel = new ResultData<List<Integer>>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData<?> handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,ResultData.class);
        }
        return null;
    }
}
