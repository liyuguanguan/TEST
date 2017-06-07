package com.ygjt.gdn.ftisp.controller;

import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.common.ResultFactory;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.vo.po.RegisterPO;
import com.ygjt.gdn.ftisp.model.vo.po.SendEmailPO;
import com.ygjt.gdn.ftisp.model.vo.po.UserPwdPO;
import com.ygjt.gdn.ftisp.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 不用登录即可调用的一些接口
 * Created by linx on 2016/11/3.
 */
@Controller
@RequestMapping("/api/v1/p/ftisp")
public class UnLoginController {
    private static final Logger logger = Logger.getLogger(UnLoginController.class);

    @Autowired
    UserService userService;

    /**
     * 发送邮件
     * @param po
     * @param result
     * @return
     */
    @RequestMapping("/unlogin/sendEmail")
    @ResponseBody
    public Result sendEmail(@Valid @RequestBody SendEmailPO po, BindingResult result) {
        List<String> errorList = new ArrayList<String>();
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errorList.add(fieldError.getDefaultMessage());
            }
        }
        if (errorList.size() > 0) {
            return new ResultData<List<?>>(Constants.RESULT_CODE_FAIL, errorList.get(0), errorList);
        }
        try {
            userService.sendEmail(po);
            return ResultFactory.createSuccessResultData(null);
        }catch (ServiceException e){
            logger.error("邮件发送异常ServiceException：",e);
            return ResultFactory.createFailResultData(e.getMessage());
        }catch (Exception e){
            logger.error("邮件发送异常：",e);
            return ResultFactory.createFailResultData("邮件发送异常");
        }

    }




    @RequestMapping("/unlogin/register")
    @ResponseBody
    public Result register(@Valid @RequestBody RegisterPO po, BindingResult result) {
        List<String> errorList = new ArrayList<String>();
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errorList.add(fieldError.getDefaultMessage());
            }
        }
        if (errorList.size() > 0) {
            return new ResultData<List<?>>(Constants.RESULT_CODE_FAIL, errorList.get(0), errorList);
        }
        try {
            userService.doRegister(po);
            return ResultFactory.createSuccessResultData(null);
        }catch (ServiceException e){
            logger.error("注册失败ServiceException：",e);
            return ResultFactory.createFailResultData(e.getMessage());
        }catch (Exception e){
            logger.error("注册失败：",e);
            return ResultFactory.createFailResultData("注册失败");
        }

    }

    @RequestMapping("/unlogin/modifyPwd")
    @ResponseBody
    public Result modifyPwd(@Valid @RequestBody UserPwdPO po, BindingResult result) {
        List<String> errorList = new ArrayList<String>();
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errorList.add(fieldError.getDefaultMessage());
            }
        }
        if (errorList.size() > 0) {
            return new ResultData<List<?>>(Constants.RESULT_CODE_FAIL, errorList.get(0), errorList);
        }
        try {
            userService.modifyPwd(po);
            return ResultFactory.createSuccessResultData(null);
        }catch (ServiceException e){
            logger.error("重置密码失败ServiceException：",e);
            return ResultFactory.createFailResultData(e.getMessage());
        }catch (Exception e){
            logger.error("重置密码失败失败：",e);
            return ResultFactory.createFailResultData("重置密码失败失败");
        }

    }

}
