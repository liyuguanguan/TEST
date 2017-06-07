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
import com.ygjt.gdn.ftisp.model.vo.OutroomOrderLoadVO;
import com.ygjt.gdn.ftisp.model.vo.po.OutroomOrderLoadPO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by zhongb on 2017/4/28.
 */
@Service
public class OutRoomOrderLoadService extends AbstractB2S2CInfService<OutroomOrderLoadPO,ResultData<OutroomOrderLoadVO>> implements InterService<OutroomOrderLoadPO,ResultData<OutroomOrderLoadVO>> {
    private static final Logger logger = Logger.getLogger(OutRoomOrderLoadService.class);

    @Value("#{configProperties['api.b2s2c.outRoomOrder.load.url']}")
    protected String            API_B2S2C_OUTROOMORDER_LOAD_URL;
    @Override
    public ResultData<OutroomOrderLoadVO> call(OutroomOrderLoadPO req) {
        return null;
    }
    @Override
    public ResultData<OutroomOrderLoadVO> call( OutroomOrderLoadPO req, String token) {
        try{
            String resp = invoke(req,null,token, API_B2S2C_URL+API_B2S2C_OUTROOMORDER_LOAD_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData<OutroomOrderLoadVO> respModel = new ResultData<OutroomOrderLoadVO>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData<OutroomOrderLoadVO> handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,new TypeReference<ResultData<OutroomOrderLoadVO>>(){});
        }
        return null;
    }
}
