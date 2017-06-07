package com.ygjt.gdn.ftisp.persistence;

import com.ygjt.gdn.ftisp.model.AccessTokenDo;
import com.ygjt.gdn.ftisp.model.AccessTokenWithBLOBs;
import com.ygjt.gdn.ftisp.model.Query.AccessTokenQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccessTokenDao {
    /**
     * auth_access_token
     */
    long countByQuery(AccessTokenQuery example);

    /**
     * auth_access_token
     */
    int deleteByQuery(AccessTokenQuery example);

    /**
     * auth_access_token
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * auth_access_token
     */
    int insert(AccessTokenWithBLOBs record);

    /**
     * auth_access_token
     */
    int insertSelective(AccessTokenWithBLOBs record);

    /**
     * auth_access_token
     */
    List<AccessTokenWithBLOBs> selectByQueryWithBLOBs(AccessTokenQuery example);

    /**
     * auth_access_token
     */
    List<AccessTokenDo> selectByQuery(AccessTokenQuery example);

    /**
     * auth_access_token
     */
    AccessTokenWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * auth_access_token
     */
    int updateByQuerySelective(@Param("record") AccessTokenWithBLOBs record, @Param("example") AccessTokenQuery example);

    /**
     * auth_access_token
     */
    int updateByQueryWithBLOBs(@Param("record") AccessTokenWithBLOBs record, @Param("example") AccessTokenQuery example);

    /**
     * auth_access_token
     */
    int updateByQuery(@Param("record") AccessTokenDo record, @Param("example") AccessTokenQuery example);

    /**
     * auth_access_token
     */
    int updateByPrimaryKeySelective(AccessTokenWithBLOBs record);

    /**
     * auth_access_token
     */
    int updateByPrimaryKeyWithBLOBs(AccessTokenWithBLOBs record);

    /**
     * auth_access_token
     */
    int updateByPrimaryKey(AccessTokenDo record);
}