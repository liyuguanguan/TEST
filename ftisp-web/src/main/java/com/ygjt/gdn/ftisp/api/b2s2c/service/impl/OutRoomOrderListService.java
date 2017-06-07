package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.model.vo.OutroomOrderListVO;
import com.ygjt.gdn.ftisp.model.vo.po.OutroomOrderListPO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by zhongb on 2017/4/28.
 */
@Service
public class OutRoomOrderListService extends AbstractB2S2CInfService<OutroomOrderListPO,ResultData<PageVO<OutroomOrderListVO>>> implements InterService<OutroomOrderListPO,ResultData<PageVO<OutroomOrderListVO>>> {
    private static final Logger logger = Logger.getLogger(OutRoomOrderListService.class);

    @Value("#{configProperties['api.b2s2c.outRoomOrder.list.url']}")
    protected String            API_B2S2C_OUTROOMORDER_LIST_URL;
    @Override
    public ResultData<PageVO<OutroomOrderListVO>> call(OutroomOrderListPO req) {
        return null;
    }
    @Override
    public ResultData<PageVO<OutroomOrderListVO>> call( OutroomOrderListPO req, String token) {
        try{
            String resp = invoke(req,null,token, API_B2S2C_URL+API_B2S2C_OUTROOMORDER_LIST_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData<PageVO<OutroomOrderListVO>> respModel = new ResultData<PageVO<OutroomOrderListVO>>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData<PageVO<OutroomOrderListVO>> handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,new TypeReference<ResultData<PageVO<OutroomOrderListVO>>>(){});
        }
        return null;
    }
}
