package com.ygjt.gdn.ftisp.controller;

import com.alibaba.fastjson.JSON;
import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.*;
import com.ygjt.gdn.ftisp.auth.tools.VelocitySecurityUtil;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.common.ResultFactory;
import com.ygjt.gdn.ftisp.common.annotation.ParamBind;
import com.ygjt.gdn.ftisp.exception.ExcelException;
import com.ygjt.gdn.ftisp.exception.ImportOutNumException;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.UserDo;
import com.ygjt.gdn.ftisp.model.vo.ExportError;
import com.ygjt.gdn.ftisp.model.vo.GoodMoreDetailVo;
import com.ygjt.gdn.ftisp.model.vo.IdVo;
import com.ygjt.gdn.ftisp.model.vo.po.*;
import com.ygjt.gdn.ftisp.service.GoodsService;
import com.ygjt.gdn.ftisp.service.SystemAttachFileService;
import com.ygjt.gdn.ftisp.utils.StringUtil;
import com.ygjt.gdn.ftisp.utils.excel.OutExcelUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Created by wyh on 2016/10/27.
 */
@Controller
@RequestMapping("/api/v1/p")
public class GoodsController extends BaseController {
    private static final Logger logger = Logger.getLogger(GoodsController.class);
    @Value("#{configProperties['upload.path']}")
    private String uploadPath;

    @Value("#{configProperties['file.attachments']}")
    private String attachments;
    @Autowired
    GoodsCreateService goodsCreateService;
    @Autowired
    GoodsListService goodsListService;
    @Autowired
    GoodsPrintService goodsPrintService;
    @Autowired
    GoodsImportService goodsImportService;
    @Autowired
    SystemAttachFileService systemAttachFileService;
    @Autowired
    GoodsUpdateService goodsUpdateService;
    @Autowired
    GoodsLoadService goodsLoadService;
    @Autowired
    GoodsQueryByCodeService goodsQueryByCodeService;
    @Autowired
    GoodsCommitService goodsCommitService;
    @Autowired
    GoodsDeleteService goodsDeleteService;
    @Autowired
    AreaQueryService areaQueryService;
    @Autowired
    GoodsPrintImportService goodsPrintImportService;
    @Autowired
    GoodsExportService goodsExportService;
    @Autowired
    GoodsQueryService goodsQueryService;
    @Autowired
    GoodsService goodsService;
    /**
     * 根据条件查询商品列表
     *
     * @param goodInfoPo
     * @return
     * @author wangyh
     * 2016年10月27日15:09:51
     */
    @RequestMapping("/ftisp/goods/list")
    @ResponseBody
    public ResultData<?> list(@Valid GoodInfoPo goodInfoPo, BindingResult result, HttpServletRequest request) {
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
            return goodsListService.call(goodInfoPo, getToken(request));
        } catch (Exception e) {
            logger.error("商品信息查询异常", e);
            return ResultFactory.createFailResultData("商品信息查询异常");
        }
    }

    /**
     * 打印商品标签
     *
     * @param goodsPrintPO
     * @param response
     */
    @RequestMapping("/ftisp/goods/labelPrint")
    public void labelPrint(@ParamBind GoodsPrintPO goodsPrintPO,HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setHeader("Content-Disposition", "inline;fileName=" + goodsPrintPO.getCode() + ".pdf");
            GoodsPrintListPO po = new GoodsPrintListPO();
            List<GoodsPrintPO> data = new ArrayList<>();
            data.add(goodsPrintPO);
            po.setData(data);
            ResultData<String> call = goodsPrintService.call(po, getToken(request));
            String base64Str = call.getData();
            base64StringToPDF(response,base64Str);

        } catch (Exception e) {
            logger.error("打印异常",e);
            throw new ServiceException("打印异常");
        }
    }
    /**
     * 批量导出商品信息
     *
     * @param jsonString
     * @Author wangyh
     * 2016年11月3日11:24:41
     */
    @RequestMapping("/ftisp/goods/export")
    @ResponseBody
    public void exportGoods(HttpServletResponse response, String jsonString,HttpServletRequest request) throws Exception {
        List<ExportError> errorList = new ArrayList<ExportError>();
        //1、解析json字符串
        List<IdPo> list = new ArrayList<>();
        try {
            if (StringUtil.isEmpty(jsonString)) {

            } else {
                list = JSON.parseArray(jsonString, IdPo.class);
            }
            List<GoodInfoMode> goodInfoModes = new ArrayList<GoodInfoMode>();
            //3、商品信息放入excel
            ResultData<?> call1 = goodsExportService.call(list,getToken(request));
            if (Objects.equals(call1.getCode(), Constants.RESULT_CODE_SUCCESS)) {
                 goodInfoModes = (List<GoodInfoMode>) call1.getData();
            } else {
                errorList = (List<ExportError>) call1.getData();
                throw new ServiceException("导出商品异常");
            }
            OutExcelUtils.outExcel("", "商品信息", goodInfoModes, GoodInfoMode.class, null, response, "商品信息.xls");
        } catch (ServiceException e) {
            logger.error("导出异常", e);
            ExportError result = new ExportError(Constants.RESULT_CODE_FAIL, e.getMessage());
            errorList.add(result);
            OutExcelUtils.outExcel("", "异常信息", errorList, ExportError.class, null, response, "导出异常.xls");
        } catch (Exception e) {
            logger.error("导出异常", e);
            ExportError result = new ExportError(Constants.RESULT_CODE_FAIL, "导出异常");
            errorList.add(result);
            OutExcelUtils.outExcel("", "异常信息", errorList, ExportError.class, null, response, "导出异常.xls");
        }
    }


    /**
     * 新增商品
     *
     * @param po
     * @param result
     */
    @RequestMapping(value = "/ftisp/goods/create", method = RequestMethod.POST)
    @ResponseBody
    public Result create(@Valid @RequestBody GoodInfoCreatePo po, BindingResult result,HttpServletRequest request) {
        try {
            StringBuffer sb = new StringBuffer();
            if (result.hasErrors()) {
                List<FieldError> fieldErrors = result.getFieldErrors();
                for (FieldError fieldError : fieldErrors) {
                    sb.append(fieldError.getDefaultMessage());
                }
            }
            UserDo userDo = VelocitySecurityUtil.getUserDo();
            if(userDo==null){
                return ResultFactory.createFailResultData("请登陆后操作");
            }
            userDo.setAccessToken(getToken(request));
            goodsService.create(po,userDo);
            return ResultFactory.createSuccessResultData(null);
        } catch (Exception e) {
            logger.error("", e);
            return ResultFactory.createFailResultData("", null);
        }
    }

    /**
     * 批量导入商品
     *
     * @param multipartRequest
     * @return
     * @Author wangyh
     * 2016年11月2日14:41:11
     */
    @RequestMapping(value = "/ftisp/goods/import", method = RequestMethod.POST)
    @ResponseBody
    public ResultData<IdVo> importGoods(HttpServletResponse response, MultipartHttpServletRequest multipartRequest, HttpServletRequest request) {
        ResultData<IdVo> resultData = null;
        try {
            logger.info("导入数据开始!");
            //获取用户信息
            UserDo userDo = VelocitySecurityUtil.getUserDo();
            if (null == userDo || null == userDo.getId()) {
                return new ResultData<IdVo>(Constants.RESULT_CODE_FAIL, "", null);
            }
            for (Iterator it = multipartRequest.getFileNames(); it.hasNext(); ) {
                String key = (String) it.next();
                MultipartFile multipartFile = multipartRequest.getFile(key);
                if (multipartFile.getOriginalFilename().length() > 0) {
                    resultData = goodsImportService.importGoods(getToken(request),multipartFile.getInputStream(), userDo, uploadPath, attachments);
                }
            }
            return resultData;
        } catch (ExcelException ee) {
            logger.error(ee.getMessage(), ee);
            return ResultFactory.createFailResultData(ee.getMessage(), null);
        } catch (ImportOutNumException ie) {
            logger.error(ie.getMessage(), ie);
            return ResultFactory.createFailResultData(ie.getMessage(), null);
        } catch (IOException ioe) {
            logger.error(ioe.getMessage(), ioe);
            return ResultFactory.createFailResultData(ioe.getMessage(), null);
        } catch (Exception e) {
            logger.error("导入数据失败!", e);
            return ResultFactory.createFailResultData("导入数据失败!", null);
        }
    }
    /**
     * 批量打印商品时，解析上传文件
     *
     * @param response
     * @param multipartRequest
     * @return
     * @author wangyh
     * 2016年12月21日17:21:37
     */
    @RequestMapping("/ftisp/goods/importPrint")
    @ResponseBody
    public ResultData<?> importPrint(HttpServletResponse response, MultipartHttpServletRequest multipartRequest,HttpServletRequest request) {
        ResultData<IdVo> resultData = null;
        try {
            logger.info("");
            //获取用户信息
            UserDo userDo = VelocitySecurityUtil.getUserDo();
            if (null == userDo || null == userDo.getId()) {
                return new ResultData<IdVo>(Constants.RESULT_CODE_FAIL, "", null);
            }
            for (Iterator it = multipartRequest.getFileNames(); it.hasNext(); ) {
                String key = (String) it.next();
                MultipartFile multipartFile = multipartRequest.getFile(key);
                if (multipartFile.getOriginalFilename().length() > 0) {
                    resultData = goodsPrintImportService.importPrint(getToken(request),multipartFile.getInputStream(), userDo, uploadPath, attachments);
                }
            }
            return resultData;
        } catch (ExcelException ee) {
            logger.error(ee.getMessage(), ee);
            return ResultFactory.createFailResultData(ee.getMessage(), null);
        } catch (ImportOutNumException ie) {
            logger.error(ie.getMessage(), ie);
            return ResultFactory.createFailResultData(ie.getMessage(), null);
        } catch (IOException ioe) {
            logger.error(ioe.getMessage(), ioe);
            return ResultFactory.createFailResultData(ioe.getMessage(), null);
        } catch (Exception e) {
            logger.error("", e);
            return ResultFactory.createFailResultData("", null);
        }
    }

    /**
     * 批量打印商品
     *
     * @param response
     * @param po
     * @param result
     * @author wangyh
     * 2016年12月22日14:15:57
     */
    @RequestMapping("/ftisp/goods/printData")
    public void printData(HttpServletResponse response, @Valid PrintParamPo po, BindingResult result,HttpServletRequest request) {
        StringBuffer sb = new StringBuffer();
        try {
            logger.info("打印商品开始!");
            if (result.hasErrors()) {
                List<FieldError> fieldErrors = result.getFieldErrors();
                for (FieldError fieldError : fieldErrors) {
                    sb.append(fieldError.getDefaultMessage());
                }
            }
            if (sb.length() > 0) {
                throw new ServiceException(sb.toString());
            }
            response.setHeader("Content-Disposition", "inline;fileName=goodsPrint.pdf");

            GoodsPrintListPO printPo = new GoodsPrintListPO();
            List<GoodsPrintPO> data = goodsPrintService.printGoods(po, VelocitySecurityUtil.getUserDo(),uploadPath,attachments);
            printPo.setData(data);
            ResultData<String> call = goodsPrintService.call(printPo, getToken(request));
            String base64Str = call.getData();
            base64StringToPDF(response,base64Str);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
    }
    /**
     * 编辑商品
     *
     * @param goodInfoPo
     * @param result
     */
    @RequestMapping("/ftisp/goods/update")
    @ResponseBody
    public Result update(@Valid @RequestBody GoodInfoUpdatePo goodInfoPo, BindingResult result, HttpServletRequest request) {
        try {
            StringBuffer sb = new StringBuffer();
            if (result.hasErrors()) {
                List<FieldError> fieldErrors = result.getFieldErrors();
                for (FieldError fieldError : fieldErrors) {
                    sb.append(fieldError.getDefaultMessage());
                }
            }
            UserDo userDo = VelocitySecurityUtil.getUserDo();
            if(userDo==null){
                return ResultFactory.createFailResultData("请登陆后操作");
            }
            userDo.setAccessToken(getToken(request));
            goodsService.update(goodInfoPo,userDo);
            return ResultFactory.createSuccessResultData(null);
        } catch (Exception e) {
            logger.error("编辑商品信息异常", e);
            return ResultFactory.createFailResultData("编辑商品信息异常", null);
        }
    }
    /**
     * 根据商品ID查询商品详情
     *
     * @param id
     * @return
     * @Author wangyh
     * 2016年10月28日16:38:31
     */
    @RequestMapping("/ftisp/goods/load")
    @ResponseBody
    public ResultData<GoodMoreDetailVo> load(String id,HttpServletRequest request) {
        try {
            logger.info("商品查询开始!");
            return goodsService.load(id,getToken(request));
        } catch (Exception e) {
            logger.error("商品查询异常", e);
            return ResultFactory.createFailResultData("商品查询异常!", null);
        }
    }
    /**
     * 商品提交
     *
     * @param ids
     * @return
     * @author wangyh
     * 2016年12月5日10:26:17
     */
    @RequestMapping("/ftisp/goods/commit")
    @ResponseBody
    public Result commit(@RequestBody List<IdPo> ids, HttpServletRequest request) {
        try {
            logger.info("商品提交开始！");
            return goodsCommitService.call(ids,getToken(request));
        } catch (Exception e) {
            logger.error("商品提交异常", e);
            return ResultFactory.createFailResultData("商品提交异常", null);
        }
    }
    /**
     * 根据code查商品
     *
     * @param po
     * @return
     * @Author zzy
     * 2016年10月28日18:16:53
     */
    @RequestMapping("/ftisp/goods/queryByCode")
    @ResponseBody
    public ResultData selectByCode(@Valid GoodsQueryByCodePo po, BindingResult result,HttpServletRequest request) {
        List<String> errorList = new ArrayList<String>();
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errorList.add(fieldError.getDefaultMessage());
            }
        }
        //po字段验证
        if (errorList.size() > 0) {
            return ResultFactory.createFailResultData(Constants.RESULT_MESSAGE_PARAM_ERROR, errorList);
        }
        try {
            return goodsQueryByCodeService.call(po,getToken(request));
        }  catch (ServiceException e) {
            logger.error("获取商品失败!",e);
            return ResultFactory.createFailResultData("获取商品失败!");
        }catch (Exception e) {
            logger.error("获取商品失败!",e);
            return ResultFactory.createFailResultData("获取商品失败!");
        }
    }
    @RequestMapping("/ftisp/area/query")
    @ResponseBody
    public ResultData<?> queryOption(@Valid AreaQueryOptionPO po,BindingResult result,HttpServletRequest request){
        List<String> errorList = new ArrayList<String>() ;
        if(result.hasErrors()){
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errorList.add(fieldError.getDefaultMessage());
            }
        }
        //po字段验证
        if(errorList.size() > 0 ) {
            return ResultFactory.createFailResultData(Constants.RESULT_MESSAGE_PARAM_ERROR, errorList);
        }
        try {
            //调用物流计划查询服务

            return areaQueryService.call(po,getToken(request)) ;
        } catch (Exception e) {
            logger.error("地域查询option异常",e);
            return ResultFactory.createFailResultData("地域查询option异常");
        }
    }

    @RequestMapping("/ftisp/goods/query")
    @ResponseBody
    public ResultData<?> query(@Valid GoodsQueryPO goodInfoPo, BindingResult result,HttpServletRequest request) {
        List<String> errorList = new ArrayList<String>();
        try {
            if (result.hasErrors()) {
                List<FieldError> fieldErrors = result.getFieldErrors();
                for (FieldError fieldError : fieldErrors) {
                    errorList.add(fieldError.getDefaultMessage());
                }
            }
            if (errorList.size() > 0) {
                return new ResultData<List<?>>(Constants.RESULT_CODE_FAIL, Constants.RESULT_MESSAGE_PARAM_ERROR, errorList);
            }

            return     goodsQueryService.call(goodInfoPo,getToken(request));
        } catch (ServiceException e) {
            return ResultFactory.createFailResultData(e.getMessage());
        } catch (Exception e) {
            logger.error("商品查询异常", e);
            return ResultFactory.createFailResultData("商品查询异常");
        }
    }
    /**
     * 批量删除商品
     *
     * @param ids
     * @return
     * @Author wangyh
     * 2016年10月28日18:16:53
     */
    @RequestMapping("/ftisp/goods/delete")
    @ResponseBody
    public Result delete(@RequestBody List<IdPo> ids,HttpServletRequest request) {
        try {
            return goodsDeleteService.call(ids, getToken(request));
        } catch (Exception e) {
            logger.error("删除商品异常", e);
            return ResultFactory.createFailResultData("删除商品异常", null);
        }
    }
}
