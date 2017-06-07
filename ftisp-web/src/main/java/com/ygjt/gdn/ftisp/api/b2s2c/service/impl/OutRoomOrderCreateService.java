package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.model.vo.DeliveryInfoOptVO;
import com.ygjt.gdn.ftisp.model.vo.OutroomOrderCreateVO;
import com.ygjt.gdn.ftisp.model.vo.OutroomOrderListVO;
import com.ygjt.gdn.ftisp.model.vo.po.DeliveryInfoOptPO;
import com.ygjt.gdn.ftisp.model.vo.po.OutroomOrderCreatePO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhongb on 2017/4/28.
 */
@Service
public class OutRoomOrderCreateService extends AbstractB2S2CInfService<OutroomOrderCreatePO,ResultData<OutroomOrderCreateVO>> implements InterService<OutroomOrderCreatePO,ResultData<OutroomOrderCreateVO>> {
    private static final Logger logger = Logger.getLogger(OutRoomOrderCreateService.class);

    @Value("#{configProperties['api.b2s2c.outRoomOrder.create.url']}")
    protected String            API_B2S2C_OUTROOMORDER_CREATE_URL;
    @Override
    public ResultData<OutroomOrderCreateVO> call(OutroomOrderCreatePO req) {
        return null;
    }
    @Override
    public ResultData<OutroomOrderCreateVO> call( OutroomOrderCreatePO req, String token) {
        try{
            String resp = invoke(null,req,token, API_B2S2C_URL+API_B2S2C_OUTROOMORDER_CREATE_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData<OutroomOrderCreateVO> respModel = new ResultData<OutroomOrderCreateVO>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData<OutroomOrderCreateVO> handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,new TypeReference<ResultData<OutroomOrderCreateVO>>(){});
        }
        return null;
    }
}
