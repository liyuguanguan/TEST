package com.ygjt.gdn.ftisp.persistence;

import com.ygjt.gdn.ftisp.model.AreaDo;
import com.ygjt.gdn.ftisp.model.Query.AreaQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AreaDao {
    /**
     * p_area
     */
    long countByQuery(AreaQuery example);

    /**
     * p_area
     */
    int deleteByQuery(AreaQuery example);

    /**
     * p_area
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * p_area
     */
    int insert(AreaDo record);

    /**
     * p_area
     */
    int insertSelective(AreaDo record);

    /**
     * p_area
     */
    List<AreaDo> selectByQuery(AreaQuery example);

    /**
     * p_area
     */
    AreaDo selectByPrimaryKey(Integer id);

    /**
     * p_area
     */
    int updateByQuerySelective(@Param("record") AreaDo record, @Param("example") AreaQuery example);

    /**
     * p_area
     */
    int updateByQuery(@Param("record") AreaDo record, @Param("example") AreaQuery example);

    /**
     * p_area
     */
    int updateByPrimaryKeySelective(AreaDo record);

    /**
     * p_area
     */
    int updateByPrimaryKey(AreaDo record);
}