package com.ygjt.gdn.ftisp.persistence;

import com.ygjt.gdn.ftisp.model.AuthSystemDo;
import com.ygjt.gdn.ftisp.model.Query.AuthSystemQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthSystemDao {
    /**
     * auth_system
     */
    long countByQuery(AuthSystemQuery example);

    /**
     * auth_system
     */
    int deleteByQuery(AuthSystemQuery example);

    /**
     * auth_system
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * auth_system
     */
    int insert(AuthSystemDo record);

    /**
     * auth_system
     */
    int insertSelective(AuthSystemDo record);

    /**
     * auth_system
     */
    List<AuthSystemDo> selectByQuery(AuthSystemQuery example);

    /**
     * auth_system
     */
    AuthSystemDo selectByPrimaryKey(Integer id);

    /**
     * auth_system
     */
    int updateByQuerySelective(@Param("record") AuthSystemDo record, @Param("example") AuthSystemQuery example);

    /**
     * auth_system
     */
    int updateByQuery(@Param("record") AuthSystemDo record, @Param("example") AuthSystemQuery example);

    /**
     * auth_system
     */
    int updateByPrimaryKeySelective(AuthSystemDo record);

    /**
     * auth_system
     */
    int updateByPrimaryKey(AuthSystemDo record);
}