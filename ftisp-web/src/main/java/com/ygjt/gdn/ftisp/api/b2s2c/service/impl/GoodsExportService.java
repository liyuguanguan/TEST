package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.model.vo.ExportError;
import com.ygjt.gdn.ftisp.model.vo.GoodInfoVo;
import com.ygjt.gdn.ftisp.model.vo.po.GoodInfoMode;
import com.ygjt.gdn.ftisp.model.vo.po.IdPo;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 商品导出查询
 */
@Service
public class GoodsExportService extends AbstractB2S2CInfService<List<IdPo>,ResultData> implements InterService<List<IdPo>,ResultData> {
    private static final Logger logger = Logger.getLogger(GoodsExportService.class);

    @Value("#{configProperties['api.b2s2c.goods.queryExport.url']}")
    protected String API_B2S2C_GOODS_QUERYEXPORT_URL;
    @Override
    public ResultData call(List<IdPo> req) {
       return null;
    }
    @Override
    public ResultData call( List<IdPo> req, String token) {
        try{
            String resp = invoke(null,req,token, API_B2S2C_URL+ API_B2S2C_GOODS_QUERYEXPORT_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData respModel = new ResultData();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            ResultData resultData = JSONObject.parseObject(resp, ResultData.class);
            if(Objects.equals(resultData.getCode(),Constants.RESULT_CODE_SUCCESS)){
                ResultData<List<GoodInfoMode>> listResultData = JSONObject.parseObject(resp, new TypeReference<ResultData<List<GoodInfoMode>>>() {
                });
                resultData.setData(listResultData.getData());
            }else{
                ResultData<List<ExportError>> listResultData = JSONObject.parseObject(resp, new TypeReference<ResultData<List<ExportError>>>() {
                });
                resultData.setData(listResultData.getData());
            }
            return resultData;
        }
        return null;
    }

//    public T call( String req, String token,Class<T> c) {
//        try{
//            String resp = invoke(req,null,token, API_B2S2C_URL+ API_B2S2C_GOODS_QUERYEXPORT_URL);
//            return handleResult(resp,c);
//        }catch (ApiException e){
//            logger.error("调用接口异常",e);
//            ResultData respModel = new ResultData();
//            respModel.setCode(Constants.RESULT_CODE_FAIL);
//            respModel.setMessage("调用接口异常");
//            return null;
//        }
//    }
//
//    public T handleResult(String resp,Class<T> c) {
//        if(StringUtils.isNotBlank(resp)){
//            return JSONObject.parseObject(resp,c);
//        }
//        return null;
//    }
}
