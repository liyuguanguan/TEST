package com.ygjt.gdn.ftisp.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.SqlUtil;

import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.CreateEntService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.common.ResultFactory;
import com.ygjt.gdn.ftisp.enums.EntEnum;
import com.ygjt.gdn.ftisp.enums.FileObjectTypeEnum;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.EntInfoDo;
import com.ygjt.gdn.ftisp.model.Query.EntInfoQuery;
import com.ygjt.gdn.ftisp.model.SystemAttachFileDo;
import com.ygjt.gdn.ftisp.model.UserDo;
import com.ygjt.gdn.ftisp.model.vo.B2S2CPicInfos;
import com.ygjt.gdn.ftisp.model.vo.EnterPriseInfoVO;
import com.ygjt.gdn.ftisp.model.vo.EnterPriseSimpleVo;
import com.ygjt.gdn.ftisp.model.vo.po.*;
import com.ygjt.gdn.ftisp.persistence.EntInfoDao;
import com.ygjt.gdn.ftisp.persistence.SystemAttachFileDao;
import com.ygjt.gdn.ftisp.persistence.UserDao;
import com.ygjt.gdn.ftisp.service.EntInfoService;
import com.ygjt.gdn.ftisp.service.SystemAttachFileService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by wyh on 2016/10/28.
 */
@Service
public class EntInfoServiceImpl implements EntInfoService {
    private static final Logger logger = Logger.getLogger(EntInfoServiceImpl.class);

    @Autowired
    private EntInfoDao entInfoDao;
    @Autowired
    private UserDao userDao;


    @Autowired
    private SystemAttachFileService systemAttachFileService;
    @Autowired
    CreateEntService createEntService;

    @Override
    public EntInfoDo getEntByUserId(Integer id) {
        EntInfoDo entInfoDo = entInfoDo = entInfoDao.getByUserId(id);
        return entInfoDo;
    }

    @Override
    public List<EnterPriseInfoVO> selectByEnt(EnterPriseInfoPo po, Page<EnterPriseInfoVO> page) {
        if (page == null) {
            page = PageHelper.startPage(po.getPage() == null ? 1 : po.getPage(), po.getRows() == null ? 20 : po.getRows());
        }
        SqlUtil.setLocalPage(page);
        po.setSort("create_dt desc");
        entInfoDao.queryEnterPrise(po);
        return page;
    }

    @Override
    public EnterPriseInfoVO selectEntById(Integer id) {
        EnterPriseInfoVO enterPriseInfoVO = new EnterPriseInfoVO();
        EntInfoDo entInfoDo = entInfoDao.selectByPrimaryKey(id);
        BeanUtils.copyProperties(entInfoDo, enterPriseInfoVO);
        return enterPriseInfoVO;
    }

    @Override
    @Transactional
    public Result createEnt(EnterPriseCreatePo enterPriseCreatePo, UserDo userDo) {
        Result result = null;
        EntInfoDo entInfoDo = new EntInfoDo();
        BeanUtils.copyProperties(enterPriseCreatePo, entInfoDo);
        //1、保存企业信息
        entInfoDo.setCreateBy(userDo.getId());
        entInfoDo.setCreateDt(new Date());
        entInfoDo.setLastUpdateBy(userDo.getId());
        entInfoDo.setLastUpdateDt(new Date());
        entInfoDo.setUserId(userDo.getId());
        entInfoDo.setSts(Constants.TABLE_STS_YES);
        entInfoDao.insertSelective(entInfoDo);

        //2、如果存在图片
        if (null != enterPriseCreatePo.getPicInfos() && enterPriseCreatePo.getPicInfos().size() > 0) {
            //2、根据返回的企业id、图片信息，更新图片所属信息
            result = systemAttachFileService.updateFileByIds(entInfoDo.getId(), JSONArray.toJSONString(enterPriseCreatePo.getPicInfos()), userDo.getId());
        }
        return new Result(Constants.RESULT_CODE_SUCCESS, Constants.RESULT_MESSAGE_SUCCESS);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public Result updateEntById(EnterPriseUpdatePo enterPriseUpdatePo, UserDo userDo) {
        EntInfoDo entInfoDo = new EntInfoDo();
        BeanUtils.copyProperties(enterPriseUpdatePo, entInfoDo);
        //1、保存企业信息
        entInfoDo.setLastUpdateBy(userDo.getId());
        entInfoDo.setLastUpdateDt(new Date());

        entInfoDao.updateByPrimaryKeySelective(entInfoDo);
        //2、根据返回的图片ids、类型，查询数据是否为零。如果不是，则不进行任何操作；若果是，则进行更新操作
        Result result = systemAttachFileService.updateFileByIds(entInfoDo.getId(), JSONArray.toJSONString(enterPriseUpdatePo.getPicInfos()), userDo.getId());
        if (result.getCode().equals(Constants.RESULT_CODE_FAIL)) {
            return result;
        } else {
            return new Result(Constants.RESULT_CODE_SUCCESS, Constants.RESULT_MESSAGE_SUCCESS);
        }

    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public int deleteEntByIds(UserDo userDo, List<IdPo> ids) {
        //更改信息
        EntInfoDo entInfoDo = new EntInfoDo();
        entInfoDo.setSts("N");
        entInfoDo.setLastUpdateDt(new Date());
        entInfoDo.setLastUpdateBy(userDo.getId());
        //参数信息
        EntInfoQuery query = new EntInfoQuery();
        EntInfoQuery.Criteria criteria = query.createCriteria();
        List<Integer> list = new ArrayList<Integer>();
        if (ids.size() > 0) {
            for (int i = 0; i < ids.size(); i++) {
                list.add(Integer.parseInt(ids.get(i).getId()));
            }
            criteria.andIdIn(list);
        }
        return entInfoDao.updateByQuerySelective(entInfoDo, query);

    }

    @Override
    public List<EnterPriseSimpleVo> querySimpleEnt() throws ServiceException {
        EnterPriseInfoPo po = new EnterPriseInfoPo();
        List<EnterPriseSimpleVo> vos = entInfoDao.querySimpleEnt(po);
        return vos;
    }

    @Override
    @Transactional
    public Result auditEnt(EntAuditPo po, UserDo userDo,String token)throws ServiceException {
        //1、查询企业信息，
        //2、修改企业状态
        //3、查询企业图片 同步至crm
        if(userDo==null){
            throw new ServiceException("请登录后操作");
        }
        EnterPriseInfoVO infoVO =selectEntById (Integer.parseInt(po.getId()));
        if(infoVO==null){
            throw new ServiceException("企业不存在");
        }

        //根据审核状态 是否同步至crm
        if(StringUtils.equals(po.getAuditSts(), EntEnum.AUDIT_STS.P.name())){
            List<SystemAttachFileDo> licensePics = systemAttachFileService.selectByObjectIdAndType(infoVO.getId(), FileObjectTypeEnum.objectType.ENTERBSLICENSE.getValue());
            List<SystemAttachFileDo> taxPics = systemAttachFileService.selectByObjectIdAndType(infoVO.getId(), FileObjectTypeEnum.objectType.ENTERTAX.getValue());
            List<SystemAttachFileDo> organcodePics = systemAttachFileService.selectByObjectIdAndType(infoVO.getId(), FileObjectTypeEnum.objectType.ENTERORGANCODE.getValue());
            B2S2CEnterCreatePo createPO= new B2S2CEnterCreatePo();
            BeanUtils.copyProperties(infoVO,createPO);
            List<B2S2CPicInfos> picInfos = new ArrayList<>();
            List<SystemAttachFileDo> entPics = new ArrayList<>();
            if(CollectionUtils.isNotEmpty(licensePics)){
                entPics.addAll(licensePics);
            }
            if(CollectionUtils.isNotEmpty(taxPics)){
                entPics.addAll(taxPics);
            }
            if(CollectionUtils.isNotEmpty(organcodePics)){
                entPics.addAll(organcodePics);
            }
            if(CollectionUtils.isNotEmpty(entPics)){
                for (SystemAttachFileDo licensePic : entPics) {
                    B2S2CPicInfos pic = new B2S2CPicInfos();
                    String base64Str = systemAttachFileService.getBase64ById(licensePic.getId());
                    if(StringUtils.isBlank(base64Str)){
                        continue;
                    }
                    pic.setPic(base64Str);
                    pic.setPicType(FileObjectTypeEnum.objectType.ENTERBSLICENSE.getValue());
                    picInfos.add(pic);
                }
            }
            UserDo entUser = userDao.selectByPrimaryKey(infoVO.getUserId());
            createPO.setUsername(entUser.getUsername());
            createPO.setPicInfos(picInfos);
            ResultData<Integer> call = createEntService.call(createPO, token);
            if(call==null || !Objects.equals(call.getCode(),Constants.RESULT_CODE_SUCCESS)){
                throw new ServiceException("同步企业失败");
            }


        }
        EntInfoDo entInfoDo = new EntInfoDo();
        entInfoDo.setId(infoVO.getId());
        entInfoDo.setAuditSts(po.getAuditSts());
        entInfoDo.setRejectReason(po.getRejectReason());
        entInfoDo.setLastUpdateBy(userDo.getId());
        entInfoDao.updateByPrimaryKeySelective(entInfoDo);
        return ResultFactory.createSuccessResultData(null);
    }
}
