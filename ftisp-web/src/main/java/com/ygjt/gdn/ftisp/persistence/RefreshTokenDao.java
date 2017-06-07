package com.ygjt.gdn.ftisp.persistence;

import com.ygjt.gdn.ftisp.model.Query.RefreshTokenQuery;
import com.ygjt.gdn.ftisp.model.RefreshTokenDo;
import com.ygjt.gdn.ftisp.model.RefreshTokenWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RefreshTokenDao {
    /**
     * auth_refresh_token
     */
    long countByQuery(RefreshTokenQuery example);

    /**
     * auth_refresh_token
     */
    int deleteByQuery(RefreshTokenQuery example);

    /**
     * auth_refresh_token
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * auth_refresh_token
     */
    int insert(RefreshTokenWithBLOBs record);

    /**
     * auth_refresh_token
     */
    int insertSelective(RefreshTokenWithBLOBs record);

    /**
     * auth_refresh_token
     */
    List<RefreshTokenWithBLOBs> selectByQueryWithBLOBs(RefreshTokenQuery example);

    /**
     * auth_refresh_token
     */
    List<RefreshTokenDo> selectByQuery(RefreshTokenQuery example);

    /**
     * auth_refresh_token
     */
    RefreshTokenWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * auth_refresh_token
     */
    int updateByQuerySelective(@Param("record") RefreshTokenWithBLOBs record, @Param("example") RefreshTokenQuery example);

    /**
     * auth_refresh_token
     */
    int updateByQueryWithBLOBs(@Param("record") RefreshTokenWithBLOBs record, @Param("example") RefreshTokenQuery example);

    /**
     * auth_refresh_token
     */
    int updateByQuery(@Param("record") RefreshTokenDo record, @Param("example") RefreshTokenQuery example);

    /**
     * auth_refresh_token
     */
    int updateByPrimaryKeySelective(RefreshTokenWithBLOBs record);

    /**
     * auth_refresh_token
     */
    int updateByPrimaryKeyWithBLOBs(RefreshTokenWithBLOBs record);

    /**
     * auth_refresh_token
     */
    int updateByPrimaryKey(RefreshTokenDo record);
}