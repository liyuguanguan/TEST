package com.ygjt.gdn.ftisp.service;

import com.github.pagehelper.Page;
import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.EntInfoDo;
import com.ygjt.gdn.ftisp.model.UserDo;
import com.ygjt.gdn.ftisp.model.vo.EnterPriseInfoVO;
import com.ygjt.gdn.ftisp.model.vo.EnterPriseSimpleVo;
import com.ygjt.gdn.ftisp.model.vo.po.*;


import java.util.List;

/**
 * Created by wyh on 2016/10/28.
 */
public interface EntInfoService {
    /**
     * 根据用户ID查询企业信息
     * @param id
     * @return
     * @author wnagyh
     * 2016年10月28日10:01:50
     */
    public EntInfoDo getEntByUserId(Integer id);

    /**
     * 查询企业信息列表
     * @param enterPriseInfoPo
     * @return
     * @Author wangyh
     * 2016年10月29日11:24:35
     */
    public List<EnterPriseInfoVO> selectByEnt(EnterPriseInfoPo enterPriseInfoPo, Page<EnterPriseInfoVO> page);

    /**
     * 查询企业信息详情
     * @param id
     * @return
     * @Author wangyh
     * 2016年10月29日11:45:19
     */
    public EnterPriseInfoVO selectEntById(Integer id);

    /**
     * 创建企业信息
     * @param enterPriseCreatePo
     * @param userDo
     * @return
     * @Author wangyh
     * 2016年10月29日14:09:13
     */
    public Result createEnt(EnterPriseCreatePo enterPriseCreatePo, UserDo userDo);

    /**
     * 编辑企业信息
     * @param enterPriseUpdatePo
     * @param userDo
     * @return
     * @Author wangyh
     * 2016年10月29日14:55:05
     */
    public Result updateEntById(EnterPriseUpdatePo enterPriseUpdatePo, UserDo userDo);

    /**
     * 批量删除企业信息
     * @param ids
     * @return
     * @Author wangyh
     * 2016年10月29日15:26:16
     */
    public int deleteEntByIds(UserDo userDo, List<IdPo> ids);

    /**
     * 查询简单企业信息
     * @param
     * @return
     * @author wangyh
     * 2016年12月15日18:05:19
     */
    public List<EnterPriseSimpleVo> querySimpleEnt() throws ServiceException;

    /**
     * 企业审核
     * @param po
     * @param userDo
     * @return
     */
    Result auditEnt(EntAuditPo po, UserDo userDo,String token)throws ServiceException;
}
