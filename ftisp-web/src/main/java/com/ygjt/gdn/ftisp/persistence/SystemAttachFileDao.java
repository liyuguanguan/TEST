package com.ygjt.gdn.ftisp.persistence;

import com.ygjt.gdn.ftisp.model.Query.SystemAttachFileQuery;
import com.ygjt.gdn.ftisp.model.SystemAttachFileDo;
import java.util.List;

import com.ygjt.gdn.ftisp.model.vo.SystemAttachFileSimple;
import org.apache.ibatis.annotations.Param;

public interface SystemAttachFileDao {
    /**
     * p_system_attach_file
     */
    long countByQuery(SystemAttachFileQuery example);

    /**
     * p_system_attach_file
     */
    int deleteByQuery(SystemAttachFileQuery example);

    /**
     * p_system_attach_file
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * p_system_attach_file
     */
    int insert(SystemAttachFileDo record);

    /**
     * p_system_attach_file
     */
    int insertSelective(SystemAttachFileDo record);

    /**
     * p_system_attach_file
     */
    List<SystemAttachFileDo> selectByQuery(SystemAttachFileQuery example);

    /**
     * p_system_attach_file
     */
    SystemAttachFileDo selectByPrimaryKey(Integer id);

    /**
     * p_system_attach_file
     */
    int updateByQuerySelective(@Param("record") SystemAttachFileDo record, @Param("example") SystemAttachFileQuery example);

    /**
     * p_system_attach_file
     */
    int updateByQuery(@Param("record") SystemAttachFileDo record, @Param("example") SystemAttachFileQuery example);

    /**
     * p_system_attach_file
     */
    int updateByPrimaryKeySelective(SystemAttachFileDo record);

    /**
     * p_system_attach_file
     */
    int updateByPrimaryKey(SystemAttachFileDo record);

    List<SystemAttachFileDo> selectByGoodId(SystemAttachFileDo systemAttachFileDo);

    List<SystemAttachFileSimple> selectSimpleByQuery(SystemAttachFileQuery query);
}