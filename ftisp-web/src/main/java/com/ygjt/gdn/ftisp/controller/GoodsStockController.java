package com.ygjt.gdn.ftisp.controller;

import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.GoodsStockListService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.GoodsStockQueryGoodsNotSubCodeService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.GoodsStockQueryGoodsService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.StockRecordListService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.common.ResultFactory;
import com.ygjt.gdn.ftisp.model.vo.GoodsStockQueryGoodsVO;
import com.ygjt.gdn.ftisp.model.vo.GoodsStockVO;
import com.ygjt.gdn.ftisp.model.vo.po.GoodsStockPO;
import com.ygjt.gdn.ftisp.model.vo.po.GoodsStockQueryGoodsPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by linx on 2016/10/27.
 */
@Controller
@RequestMapping("/api/v1/p")
public class GoodsStockController extends BaseController{
    @Autowired
    private GoodsStockListService goodsStockListService;
    @Autowired
    private GoodsStockQueryGoodsService goodsStockQueryGoodsService;
    @Autowired
    private GoodsStockQueryGoodsNotSubCodeService goodsStockQueryGoodsNotSubCodeService;

    @RequestMapping({"/ftisp/stock/list"})
    @ResponseBody
    public ResultData<?> query(@Valid GoodsStockPO goodsStockPO, BindingResult result, HttpServletRequest request) {
        List<String> errorList = new ArrayList<String>();
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errorList.add(fieldError.getDefaultMessage());
            }
        }
        if (errorList.size() > 0) {
            return new ResultData<List<?>>(Constants.RESULT_CODE_FAIL, Constants.RESULT_MESSAGE_PARAM_ERROR, errorList);
        }
        return goodsStockListService.call(goodsStockPO,getToken(request));
    }
    /**
     *
     * @param po
     * @param result
     * @return
     */
    @RequestMapping("/ftisp/goodsStock/queryGoods")
    @ResponseBody
    public ResultData<?> queryGoods(@Valid GoodsStockQueryGoodsPO po, BindingResult result,HttpServletRequest request){
        List<String> errorList = new ArrayList<String>();
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errorList.add(fieldError.getDefaultMessage());
            }
        }
        if (errorList.size() > 0) {
            return new ResultData<List<?>>(Constants.RESULT_CODE_FAIL, Constants.RESULT_MESSAGE_PARAM_ERROR, errorList);
        }
        try {
            return goodsStockQueryGoodsService.call(po,getToken(request));
        } catch (Exception e) {
            return ResultFactory.createFailResultData("商品信息异常！");
        }
    }
    /**
     * zzy
     * @param po
     * @param result
     * @return
     */
    @RequestMapping("/ftisp/goodsStock/queryGoodsNotSubCode")
    @ResponseBody
    public ResultData<?> queryGoodsByCode(@Valid GoodsStockQueryGoodsPO po, BindingResult result,HttpServletRequest request){
        List<String> errorList = new ArrayList<String>();
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errorList.add(fieldError.getDefaultMessage());
            }
        }
        if (errorList.size() > 0) {
            return new ResultData<List<?>>(Constants.RESULT_CODE_FAIL, Constants.RESULT_MESSAGE_PARAM_ERROR, errorList);
        }
        try {
            return goodsStockQueryGoodsNotSubCodeService.call(po,getToken(request));
        } catch (Exception e) {
            return ResultFactory.createFailResultData("查询商品列表失败");
        }
    }
}
