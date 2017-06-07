package com.ygjt.gdn.ftisp.controller;

import com.github.pagehelper.Page;

import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.AreaQueryService;
import com.ygjt.gdn.ftisp.auth.tools.VelocitySecurityUtil;
import com.ygjt.gdn.ftisp.common.*;
import com.ygjt.gdn.ftisp.common.annotation.ParamBind;
import com.ygjt.gdn.ftisp.enums.FileObjectTypeEnum;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.EntInfoDo;
import com.ygjt.gdn.ftisp.model.Query.SystemAttachFileQuery;
import com.ygjt.gdn.ftisp.model.SystemAttachFileDo;
import com.ygjt.gdn.ftisp.model.UserDo;
import com.ygjt.gdn.ftisp.model.vo.AreaVO;
import com.ygjt.gdn.ftisp.model.vo.EnterPics;
import com.ygjt.gdn.ftisp.model.vo.EnterPriseInfoVO;
import com.ygjt.gdn.ftisp.model.vo.po.*;
import com.ygjt.gdn.ftisp.service.EntInfoService;
import com.ygjt.gdn.ftisp.service.SystemAttachFileService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
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
import java.util.Objects;

/**
 * Created by wyh on 2016/10/29.
 */
@Controller
@RequestMapping("/api/v1/p")
public class EnterPriseController extends BaseController {
    private static final Logger logger = Logger.getLogger(EnterPriseController.class);

    @Autowired
    private EntInfoService entInfoService;

    @Autowired
    private SystemAttachFileService systemAttachFileService;
    @Autowired
    private AreaQueryService areaQueryService;



    /**
     * 后台查询企业信息列表
     * @param enterPriseInfoPo
     * @return
     * @Author wangyh
     * 2016年10月29日11:38:39
     */
    @RequestMapping("/ftisp/manage/enterpriseInfo/list")
    @ResponseBody
    public ResultData<?> list(@Valid EnterPriseInfoPo enterPriseInfoPo, BindingResult result){
        List<String> errorList = new ArrayList<String>();
        try {

            if (result.hasErrors()) {
                List<FieldError> fieldErrors = result.getFieldErrors();
                for (FieldError fieldError : fieldErrors) {
                    errorList.add(fieldError.getDefaultMessage());
                }
            }
            //企业状态“有效”
            enterPriseInfoPo.setSts(Constants.TABLE_STS_YES);
            if(errorList.size() > 0 ) {
                return new ResultData<List<?>>(Constants.RESULT_CODE_FAIL,Constants.RESULT_MESSAGE_PARAM_ERROR,errorList) ;
            }
            Page<EnterPriseInfoVO> page = new Page<EnterPriseInfoVO>(enterPriseInfoPo.getPage(), enterPriseInfoPo.getRows());
            List<EnterPriseInfoVO> list = entInfoService.selectByEnt(enterPriseInfoPo,page);
            PageVO<EnterPriseInfoVO> pageVO = new PageVO<EnterPriseInfoVO>(page.getPageNum(),page.getPageSize(),page.getTotal(),list);
            return new ResultData<PageVO<EnterPriseInfoVO>>(Constants.RESULT_CODE_SUCCESS,Constants.RESULT_MESSAGE_SUCCESS,pageVO);
        }catch (Exception e){
            logger.error("列表查询异常",e);
            return ResultFactory.createFailResultData("列表查询异常");
        }
    }


    /**
     * 后台企业审核
     * @param po
     * @param result
     * @return
     */
    @RequestMapping("/ftisp/manage/enterpriseInfo/auditEnt")
    @ResponseBody
    public Result auditEnt(@Valid @RequestBody EntAuditPo po, BindingResult result,HttpServletRequest request){
        try {
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

            return entInfoService.auditEnt(po, VelocitySecurityUtil.getUserDo(),getToken(request));
        }catch (ServiceException e){
            logger.error("企业审核ServiceException：",e);
            return ResultFactory.createFailResultData(e.getMessage());
        }catch (Exception e){
            logger.error("企业审核异常",e);
            return ResultFactory.createFailResultData("企业审核异常");
        }
    }

    /**
     * 根据企业ID查询企业详情
     * @param id
     * @return
     * @Author wangyh
     * 2016年10月29日11:50:41
     */
    @RequestMapping({"/ftisp/enterpriseInfo/load","/ftisp/manage/enterpriseInfo/load"})
    @ResponseBody
    public ResultData<EnterPriseInfoVO> load(Integer id, HttpServletRequest request){
        try {
            if(id==null){
                //获取用户信息
                UserDo userDo = VelocitySecurityUtil.getUserDo();
                //根据用户id获取对应的企业ID
                EntInfoDo entInfoDo = entInfoService.getEntByUserId(userDo.getId());
                if (null == entInfoDo) {
                    return ResultFactory.createSuccessResultData(null);
                }
                id=entInfoDo.getId();
            }
            EnterPriseInfoVO enterPriseInfoVO = entInfoService.selectEntById(id);
            String token = getToken(request);
            //查询国家、省市区name
            if(null != enterPriseInfoVO && null != enterPriseInfoVO.getCountryId()){
                AreaQueryOptionPO req =new AreaQueryOptionPO();
                req.setId(enterPriseInfoVO.getCountryId());
                ResultData<?> call = areaQueryService.call(req, token);
                if(!Objects.equals(call.getCode(),Constants.RESULT_CODE_SUCCESS)){
                    return new ResultData<EnterPriseInfoVO>(Constants.RESULT_CODE_FAIL,"企业所对应的国家不存在，请联系管理员!",null);
                }
                List<AreaVO> data = (List<AreaVO>) call.getData();
                if(CollectionUtils.isNotEmpty(data)){
                    enterPriseInfoVO.setCountry(data.get(0).getName());
                }
            }
            if(null != enterPriseInfoVO && null != enterPriseInfoVO.getProvinceId()){
                AreaQueryOptionPO req =new AreaQueryOptionPO();
                req.setId(enterPriseInfoVO.getProvinceId());
                ResultData<?> call = areaQueryService.call(req, token);
                if(!Objects.equals(call.getCode(),Constants.RESULT_CODE_SUCCESS)){
                    return new ResultData<EnterPriseInfoVO>(Constants.RESULT_CODE_FAIL,"企业所对应的州不存在，请联系管理员!",null);
                }
                List<AreaVO> data = (List<AreaVO>) call.getData();
                if(CollectionUtils.isNotEmpty(data)){
                    enterPriseInfoVO.setProvince(data.get(0).getName());
                }
            }
            if(null != enterPriseInfoVO && null != enterPriseInfoVO.getCityId()){
                AreaQueryOptionPO req =new AreaQueryOptionPO();
                req.setId(enterPriseInfoVO.getCityId());
                ResultData<?> call = areaQueryService.call(req, token);
                if(!Objects.equals(call.getCode(),Constants.RESULT_CODE_SUCCESS)){
                    return new ResultData<EnterPriseInfoVO>(Constants.RESULT_CODE_FAIL,"企业所对应的城市不存在，请联系管理员!",null);
                }
                List<AreaVO> data = (List<AreaVO>) call.getData();
                if(CollectionUtils.isNotEmpty(data)){
                    enterPriseInfoVO.setCity(data.get(0).getName());
                }
            }
            if(null != enterPriseInfoVO && null != enterPriseInfoVO.getAreaId()){
                AreaQueryOptionPO req =new AreaQueryOptionPO();
                req.setId(enterPriseInfoVO.getAreaId());
                ResultData<?> call = areaQueryService.call(req, token);
                if(!Objects.equals(call.getCode(),Constants.RESULT_CODE_SUCCESS)){
                    return new ResultData<EnterPriseInfoVO>(Constants.RESULT_CODE_FAIL,"企业所对应的地区不存在，请联系管理员!",null);
                }
                List<AreaVO> data = (List<AreaVO>) call.getData();
                if(CollectionUtils.isNotEmpty(data)){
                    enterPriseInfoVO.setArea(data.get(0).getName());
                }
            }
            //查询企业图片信息
            SystemAttachFileQuery query = new SystemAttachFileQuery();
            SystemAttachFileQuery.Criteria criteria = query.createCriteria();
            if(null != enterPriseInfoVO && null != enterPriseInfoVO.getId()){
                criteria.andObjectIdEqualTo(enterPriseInfoVO.getId());
            }
            List<String>objectTypes = new ArrayList<String>();
            objectTypes.add(FileObjectTypeEnum.objectType.ENTERBSLICENSE.getValue());
            objectTypes.add(FileObjectTypeEnum.objectType.ENTERTAX.getValue());
            objectTypes.add(FileObjectTypeEnum.objectType.ENTERORGANCODE.getValue());

            criteria.andObjectTypeIn(objectTypes);
            List<EnterPics> enterPicse = new ArrayList<EnterPics>();
            List<SystemAttachFileDo> systemAttachFileDos = systemAttachFileService.selectByQuery(query);
            //循环把Do转为Vo
            if(null != systemAttachFileDos && systemAttachFileDos.size() > 0){
                for (int i = 0; i < systemAttachFileDos.size(); i ++){
                    EnterPics enterPics = new EnterPics();
                    BeanUtils.copyProperties(systemAttachFileDos.get(i),enterPics);
                    enterPicse.add(enterPics);
                }
                enterPriseInfoVO.setEnterPics(enterPicse);
            }
            return new ResultData<EnterPriseInfoVO>(Constants.RESULT_CODE_SUCCESS,Constants.RESULT_MESSAGE_SUCCESS,enterPriseInfoVO);
        }catch (Exception e){
            logger.error("加载企业详情异常",e);
            return ResultFactory.createFailResultData("加载企业详情异常");
        }
    }

    /**
     * 新增企业
     * @param enterPriseCreatePo
     * @return
     * @author wangyh
     * 2016年10月29日14:51:31
     */
    @RequestMapping("/ftisp/enterpriseInfo/create")
    @ResponseBody
    public Result create(@Valid @RequestBody EnterPriseCreatePo enterPriseCreatePo, BindingResult result){
      try {
          StringBuffer sb = new StringBuffer();
          if (result.hasErrors()) {
              List<FieldError> fieldErrors = result.getFieldErrors();
              for (FieldError fieldError : fieldErrors) {
                  sb.append(fieldError.getDefaultMessage());
              }
          }
          if(sb.length() > 0){
              return new Result(Constants.RESULT_CODE_SUCCESS,sb.toString());
          }
          //获取用户信息
          UserDo userDo = VelocitySecurityUtil.getUserDo();
          if(null == userDo || null == userDo.getId()){
              return new Result(Constants.RESULT_CODE_FAIL,"请登录后操作");
          }
          return entInfoService.createEnt(enterPriseCreatePo,userDo);
      }catch (Exception e){
          logger.error("企业完善信息失败",e);
          return ResultFactory.createFailResultData("企业完善信息失败");
      }
    }

    /**
     * 编辑企业信息
     * @param enterPriseUpdatePo
     * @return
     * @Author wangyh
     * 2016年10月29日14:52:08
     */
    @RequestMapping("/ftisp/enterpriseInfo/update")
    @ResponseBody
    public Result update(@Valid @RequestBody EnterPriseUpdatePo enterPriseUpdatePo, BindingResult result){
        try {
            StringBuffer sb = new StringBuffer();
            if (result.hasErrors()) {
                List<FieldError> fieldErrors = result.getFieldErrors();
                for (FieldError fieldError : fieldErrors) {
                    sb.append(fieldError.getDefaultMessage());
                }
            }
            if(null != enterPriseUpdatePo.getLinkTel() && StringUtils.isNotEmpty(enterPriseUpdatePo.getLinkTel().replace("-",""))){//区号不为空
                if(StringUtils.isEmpty(enterPriseUpdatePo.getLinkTel1())){
                    sb.append("联系方式不能为空");
                }
            }
            if(sb.length() > 0){
                return new Result(Constants.RESULT_CODE_SUCCESS,sb.toString());
            }
            //获取用户信息
            UserDo userDo = VelocitySecurityUtil.getUserDo();
            if(null == userDo || null == userDo.getId()){
                return new Result(Constants.RESULT_CODE_FAIL,"请登录后操作");
            }
            return entInfoService.updateEntById(enterPriseUpdatePo,userDo);
        }catch (Exception e){
            logger.error("企业修改异常",e);
            return ResultFactory.createFailResultData("企业修改异常");
        }
    }

    @RequestMapping("/crm/enterpriseInfo/delete")
    @ResponseBody
    public Result delete(@RequestBody List<IdPo> ids){
        try {

            //获取用户信息
            UserDo userDo = VelocitySecurityUtil.getUserDo();
            if(null == userDo || null == userDo.getId()){
                return new Result(Constants.RESULT_CODE_FAIL,"请登录后操作");
            }
            entInfoService.deleteEntByIds(userDo,ids);
            return new Result(Constants.RESULT_CODE_SUCCESS,Constants.RESULT_MESSAGE_SUCCESS);
        }catch (Exception e){
            logger.error("删除数据异常",e);
            return ResultFactory.createFailResultData("删除数据异常");
        }
    }



}
