package com.ygjt.gdn.ftisp.persistence;

import com.ygjt.gdn.ftisp.model.AuthCodeDo;
import com.ygjt.gdn.ftisp.model.Query.AuthCodeQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthCodeDao {
    /**
     * auth_code
     */
    long countByQuery(AuthCodeQuery example);

    /**
     * auth_code
     */
    int deleteByQuery(AuthCodeQuery example);

    /**
     * auth_code
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * auth_code
     */
    int insert(AuthCodeDo record);

    /**
     * auth_code
     */
    int insertSelective(AuthCodeDo record);

    /**
     * auth_code
     */
    List<AuthCodeDo> selectByQueryWithBLOBs(AuthCodeQuery example);

    /**
     * auth_code
     */
    List<AuthCodeDo> selectByQuery(AuthCodeQuery example);

    /**
     * auth_code
     */
    AuthCodeDo selectByPrimaryKey(Integer id);

    /**
     * auth_code
     */
    int updateByQuerySelective(@Param("record") AuthCodeDo record, @Param("example") AuthCodeQuery example);

    /**
     * auth_code
     */
    int updateByQueryWithBLOBs(@Param("record") AuthCodeDo record, @Param("example") AuthCodeQuery example);

    /**
     * auth_code
     */
    int updateByQuery(@Param("record") AuthCodeDo record, @Param("example") AuthCodeQuery example);

    /**
     * auth_code
     */
    int updateByPrimaryKeySelective(AuthCodeDo record);

    /**
     * auth_code
     */
    int updateByPrimaryKeyWithBLOBs(AuthCodeDo record);

    /**
     * auth_code
     */
    int updateByPrimaryKey(AuthCodeDo record);
}