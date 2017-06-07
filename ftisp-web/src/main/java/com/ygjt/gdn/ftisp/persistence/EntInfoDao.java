package com.ygjt.gdn.ftisp.persistence;

import com.ygjt.gdn.ftisp.model.EntInfoDo;
import com.ygjt.gdn.ftisp.model.Query.EntInfoQuery;
import java.util.List;

import com.ygjt.gdn.ftisp.model.vo.EnterPriseSimpleVo;
import com.ygjt.gdn.ftisp.model.vo.po.EnterPriseInfoPo;
import com.ygjt.gdn.ftisp.model.vo.po.IdPo;
import org.apache.ibatis.annotations.Param;

public interface EntInfoDao {
    /**
     * crm_ent_info
     */
    long countByQuery(EntInfoQuery example);

    /**
     * crm_ent_info
     */
    int deleteByQuery(EntInfoQuery example);

    /**
     * crm_ent_info
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * crm_ent_info
     */
    int insert(EntInfoDo record);

    /**
     * crm_ent_info
     */
    int insertSelective(EntInfoDo record);

    /**
     * crm_ent_info
     */
    List<EntInfoDo> selectByQuery(EntInfoQuery example);

    /**
     * crm_ent_info
     */
    EntInfoDo selectByPrimaryKey(Integer id);

    /**
     * crm_ent_info
     */
    int updateByQuerySelective(@Param("record") EntInfoDo record, @Param("example") EntInfoQuery example);

    /**
     * crm_ent_info
     */
    int updateByQuery(@Param("record") EntInfoDo record, @Param("example") EntInfoQuery example);

    /**
     * crm_ent_info
     */
    int updateByPrimaryKeySelective(EntInfoDo record);

    /**
     * crm_ent_info
     */
    int updateByPrimaryKey(EntInfoDo record);

    /**
     * 根据用户Id获取相应的企业信息
     * @param id
     * @return
     * @author wangyh
     * 2016年10月28日9:39:35
     */
    EntInfoDo getByUserId(Integer id);

    /**
     * 查询企业信息列表
     * @param po
     * @return
     * @Author wangyh
     * 2016年10月29日11:28:12
     *
     */
    List<EntInfoDo> queryEnterPrise(EnterPriseInfoPo po);



    /**
     * 查询简单企业信息
     * @param enterPriseInfoPo
     * @return
     * @author wangyh
     * 2016年12月15日18:10:36
     */
    List<EnterPriseSimpleVo> querySimpleEnt(EnterPriseInfoPo enterPriseInfoPo);

}