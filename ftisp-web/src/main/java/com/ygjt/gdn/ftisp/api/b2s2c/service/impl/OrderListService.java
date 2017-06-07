package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.model.vo.LogisticsVo;
import com.ygjt.gdn.ftisp.model.vo.OrderDetailVo;
import com.ygjt.gdn.ftisp.model.vo.OrderQueryVO;
import com.ygjt.gdn.ftisp.model.vo.po.OrderQueryPO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhongb on 2017/4/27.
 */
@Service
public class OrderListService extends AbstractB2S2CInfService<OrderQueryPO,ResultData<PageVO<OrderQueryVO>>> implements InterService<OrderQueryPO,ResultData<PageVO<OrderQueryVO>>> {
    private static final Logger logger = Logger.getLogger(OrderListService.class);

    @Value("#{configProperties['api.b2s2c.order.list.url']}")
    protected String            API_B2S2C_ORDER_LIST_URL;
    @Override
    public ResultData<PageVO<OrderQueryVO>> call(OrderQueryPO req) {
        return null;
    }
    @Override
    public ResultData<PageVO<OrderQueryVO>> call( OrderQueryPO req, String token) {
        try{
            String resp = invoke(req,null,token, API_B2S2C_URL+API_B2S2C_ORDER_LIST_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData<PageVO<OrderQueryVO>> respModel = new ResultData<PageVO<OrderQueryVO>>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData<PageVO<OrderQueryVO>> handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,new TypeReference<ResultData<PageVO<OrderQueryVO>>>(){});
        }
        return null;
    }
}
