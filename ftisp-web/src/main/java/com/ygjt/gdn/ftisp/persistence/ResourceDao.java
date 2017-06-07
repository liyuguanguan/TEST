package com.ygjt.gdn.ftisp.persistence;

import com.ygjt.gdn.ftisp.model.Query.ResourceQuery;
import com.ygjt.gdn.ftisp.model.ResourceAuthDo;
import com.ygjt.gdn.ftisp.model.ResourceDo;
import java.util.List;

import com.ygjt.gdn.ftisp.model.vo.QueryResourceVo;
import com.ygjt.gdn.ftisp.model.vo.ResourceListVo;
import com.ygjt.gdn.ftisp.model.vo.po.ResourceListPo;
import org.apache.ibatis.annotations.Param;

public interface ResourceDao {
    /**
     * auth_resource
     */
    long countByQuery(ResourceQuery example);

    /**
     * auth_resource
     */
    int deleteByQuery(ResourceQuery example);

    /**
     * auth_resource
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * auth_resource
     */
    int insert(ResourceDo record);

    /**
     * auth_resource
     */
    int insertSelective(ResourceDo record);

    /**
     * auth_resource
     */
    List<ResourceDo> selectByQuery(ResourceQuery example);

    /**
     * auth_resource
     */
    ResourceDo selectByPrimaryKey(Integer id);

    /**
     * auth_resource
     */
    int updateByQuerySelective(@Param("record") ResourceDo record, @Param("example") ResourceQuery example);

    /**
     * auth_resource
     */
    int updateByQuery(@Param("record") ResourceDo record, @Param("example") ResourceQuery example);

    /**
     * auth_resource
     */
    int updateByPrimaryKeySelective(ResourceDo record);

    /**
     * auth_resource
     */
    int updateByPrimaryKey(ResourceDo record);

    List<ResourceAuthDo> getURLResourceMapping();

    List<ResourceAuthDo> listAllResourceAuths();

    List<ResourceListVo> queryResource(ResourceListPo po);

    List<QueryResourceVo> simpleSelect(Integer id);
}