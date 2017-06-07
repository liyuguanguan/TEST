package com.ygjt.gdn.ftisp.controller;

import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.*;
import com.ygjt.gdn.ftisp.auth.tools.VelocitySecurityUtil;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.common.ResultFactory;
import com.ygjt.gdn.ftisp.common.annotation.ParamBind;
import com.ygjt.gdn.ftisp.model.UserDo;
import com.ygjt.gdn.ftisp.model.vo.AddressInfoVo;
import com.ygjt.gdn.ftisp.model.vo.po.*;
import com.ygjt.gdn.ftisp.utils.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongb on 2017/4/28.
 */
@Controller
@RequestMapping("/api/v1/p")
public class AddressController extends BaseController{
    private static final Logger logger = Logger.getLogger(AddressController.class);

    @Autowired
    AddressListService addressListService;
    @Autowired
    AddressCreateService addressCreateService;
    @Autowired
    AddressDeleteService addressDeleteService;
    @Autowired
    AddressLoadService addressLoadService;
    @Autowired
    AddressUpdateService addressUpdateService;
    @Autowired
    AddressIsDefaultService addressIsDefaultService;

    /**
     * 根据查询条件查询地址列表
     * @param addressInfoListPo
     * @return
     * 2016年10月26日11:20:02
     * @Author wangyh
     */
    @RequestMapping("/ftisp/address/list")
    @ResponseBody
    public ResultData<?> list(@Valid AddressInfoListPo addressInfoListPo, BindingResult result, HttpServletRequest request){
        List<String> errorList = new ArrayList<String>() ;
        logger.info("查询地址列表开始");
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errorList.add(fieldError.getDefaultMessage());
            }
        }
        if(errorList.size() > 0 ) {
            return new ResultData<List<?>>(Constants.RESULT_CODE_FAIL,Constants.RESULT_MESSAGE_PARAM_ERROR,errorList) ;
        }
        try {
            return addressListService.call(addressInfoListPo,getToken(request));
        }catch (Exception e){
            logger.error("查询地址列表异常",e);
            return ResultFactory.createFailResultData("查询地址列表异常",null);
        }
    }
    /**
     * 地址新增b
     * @param addreasInfoAddPo
     * @return
     * @author wangyh
     * 2016年10月26日14:33:43
     * */
    @RequestMapping("/ftisp/address/create")
    @ResponseBody
    public Result create(@Valid @RequestBody AddreasInfoAddPo addreasInfoAddPo, BindingResult result, HttpServletRequest request){
        try {
            logger.info("地址新增开始");
            StringBuffer sb = new StringBuffer();
            if (result.hasErrors()) {
                List<FieldError> fieldErrors = result.getFieldErrors();
                for (FieldError fieldError : fieldErrors) {
                    sb.append(fieldError.getDefaultMessage());
                }
            }

            return addressCreateService.call(addreasInfoAddPo,getToken(request));
        }catch (Exception e){
            logger.error("地址新增异常",e);
            return ResultFactory.createFailResultData("地址新增异常！",null);
        }
    }
    /**
     * 批量删除地址
     * @param ids
     * @return
     * @author wangyh
     * 2016年10月26日16:38:16
     */
    @RequestMapping("/ftisp/address/delete")
    @ResponseBody
    public Result delete(@RequestBody List<IdPo> ids, HttpServletRequest request){
        try {
            logger.info("批量删除地址开始");
            if(ids.size() > Constants.DELETTE_NUM){
                return new Result(Constants.RESULT_CODE_FAIL,"批量删除数据不能大于"+Constants.DELETTE_NUM);
            }
            //获取用户信息
            UserDo userDo = VelocitySecurityUtil.getUserDo();
            if(null == userDo || null == userDo.getId()){
                return new Result(Constants.RESULT_CODE_FAIL,"获取信息失败，请重新登录");
            }

            return addressDeleteService.call(ids,getToken(request));
        }catch (Exception e){
            logger.error("删除地址异常",e);
            return ResultFactory.createFailResultData("删除地址异常",null);
        }
    }
    /**
     * 查询地址详细信息
     * @param id
     * @return
     * @author wangyh
     * 2016年10月26日16:54:19
     */
    @RequestMapping("/ftisp/address/load")
    @ResponseBody
    public ResultData<?> load(String id,HttpServletRequest request){
        try {
            logger.info("地址查询开始");
            if(StringUtil.isEmpty(id)){
                return new ResultData<AddressInfoVo>(Constants.RESULT_CODE_SUCCESS,Constants.RESULT_MESSAGE_SUCCESS,null);
            }
             return addressLoadService.call(id,getToken(request));
        }catch (Exception e){
            logger.error("地址查询异常",e);
            return ResultFactory.createFailResultData("地址查询异常",null);
        }
    }

    /**
     * 编辑地址信息
     * @param addressInfoPo
     * @return
     * @author wangyh
     * 2016年10月26日17:49:49
     */
    @RequestMapping("/ftisp/address/update")
    @ResponseBody
    public Result update(@Valid @RequestBody AddressInfoPo addressInfoPo, BindingResult result, HttpServletRequest request){
        try {
            logger.info("编辑地址信息开始");
            StringBuffer sb = new StringBuffer();
            if (result.hasErrors()) {
                List<FieldError> fieldErrors = result.getFieldErrors();
                for (FieldError fieldError : fieldErrors) {
                    sb.append(fieldError.getDefaultMessage());
                }
            }
            if(sb.length() > 0){
                return new Result(Constants.RESULT_CODE_FAIL,sb.toString());
            }
            //获取用户信息

            return addressUpdateService.call(addressInfoPo,getToken(request));
        }catch (Exception e){
            logger.error("编辑地址信息异常",e);
            return ResultFactory.createFailResultData("编辑地址信息异常",null);
        }
    }
    /**
     * 设置默认地址
     * @param addressIsDefaultPO
     * @param result
     * @return
     */
    @RequestMapping("/ftisp/address/isDefault")
    @ResponseBody
    public Result isDefault(@Valid @RequestBody AddressIsDefaultPO addressIsDefaultPO,BindingResult result, HttpServletRequest request){
        try {
            logger.info("设置默认地址开始！");
            StringBuffer sb = new StringBuffer();
            if (result.hasErrors()) {
                List<FieldError> fieldErrors = result.getFieldErrors();
                for (FieldError fieldError : fieldErrors) {
                    sb.append(fieldError.getDefaultMessage());
                }
            }
            if(sb.length() > 0){
                return new Result(Constants.RESULT_CODE_FAIL,sb.toString());
            }

            return addressIsDefaultService.call(addressIsDefaultPO,getToken(request));
        }catch (Exception e){
            logger.error("设置默认地址异常",e);
            return ResultFactory.createFailResultData("设置默认地址异常",null);
        }
    }
}
