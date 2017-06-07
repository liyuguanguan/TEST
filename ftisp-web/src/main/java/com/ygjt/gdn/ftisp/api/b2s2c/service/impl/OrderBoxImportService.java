package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.model.vo.CreateOrderBoxVo;
import com.ygjt.gdn.ftisp.model.vo.GoodInfoVo;
import com.ygjt.gdn.ftisp.model.vo.OrderBoxQueryVo;
import com.ygjt.gdn.ftisp.model.vo.po.OrderBoxImportErrPO;
import com.ygjt.gdn.ftisp.model.vo.po.OrderBoxImportPO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 查询商品列表
 * Created by linx on 2017-04-24.
 */
@Service
public class OrderBoxImportService extends AbstractB2S2CInfService<OrderBoxImportPO,ResultData<?>> implements InterService<OrderBoxImportPO,ResultData<?>> {
    private static final Logger logger = Logger.getLogger(OrderBoxImportService.class);

    @Value("#{configProperties['api.b2s2c.order.box.import.url']}")
    protected String            API_B2S2C_ORDER_BOX_IMPORT_URL;
    @Override
    public ResultData<?> call(OrderBoxImportPO req) {
       return null;
    }
    @Override
    public ResultData<?> call( OrderBoxImportPO req, String token) {
        try{
            String resp = invoke(null,req,token, API_B2S2C_URL+API_B2S2C_ORDER_BOX_IMPORT_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData<?> respModel = new ResultData<>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData<?> handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            ResultData<List<OrderBoxImportErrPO>> listResultData = JSONObject.parseObject(resp, new TypeReference<ResultData<List<OrderBoxImportErrPO>>>() {
            });
            if(Objects.equals(listResultData.getCode(),Constants.RESULT_CODE_SUCCESS)){
                return JSONObject.parseObject(resp, new TypeReference<ResultData<List<CreateOrderBoxVo>>>() {});
            }else{
                return listResultData;
            }


        }
        return null;
    }
}
