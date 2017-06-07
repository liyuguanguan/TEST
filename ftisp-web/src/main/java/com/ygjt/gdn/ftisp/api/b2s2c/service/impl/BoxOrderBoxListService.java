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
import com.ygjt.gdn.ftisp.model.vo.OrderDetailVo;
import com.ygjt.gdn.ftisp.model.vo.po.CreateOrderInfoPO;
import com.ygjt.gdn.ftisp.model.vo.po.OrderBoxQueryPO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhongb on 2017/4/27.
 */
@Service
public class BoxOrderBoxListService extends AbstractB2S2CInfService<OrderBoxQueryPO,ResultData<PageVO<OrderBoxQueryVo>>> implements InterService<OrderBoxQueryPO,ResultData<PageVO<OrderBoxQueryVo>>> {
    private static final Logger logger = Logger.getLogger(BoxOrderBoxListService.class);

    @Value("#{configProperties['api.b2s2c.box.orderBoxList.url']}")
    protected String            API_B2S2C_BOX_ORDERBOXLIST_URL;
    @Override
    public ResultData<PageVO<OrderBoxQueryVo>> call(OrderBoxQueryPO req) {
        return null;
    }
    @Override
    public ResultData<PageVO<OrderBoxQueryVo>> call( OrderBoxQueryPO req, String token) {
        try{
            String resp = invoke(req,null,token, API_B2S2C_URL+API_B2S2C_BOX_ORDERBOXLIST_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData<PageVO<OrderBoxQueryVo>> respModel = new ResultData<PageVO<OrderBoxQueryVo>>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData<PageVO<OrderBoxQueryVo>> handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,new TypeReference<ResultData<PageVO<OrderBoxQueryVo>>>(){});
        }
        return null;
    }
}
