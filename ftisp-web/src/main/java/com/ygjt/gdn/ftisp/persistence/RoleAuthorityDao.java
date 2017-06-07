package com.ygjt.gdn.ftisp.persistence;

import com.ygjt.gdn.ftisp.model.Query.RoleAuthorityQuery;
import com.ygjt.gdn.ftisp.model.RoleAuthorityDo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleAuthorityDao {
    /**
     * auth_role_authority
     */
    long countByQuery(RoleAuthorityQuery example);

    /**
     * auth_role_authority
     */
    int deleteByQuery(RoleAuthorityQuery example);

    /**
     * auth_role_authority
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * auth_role_authority
     */
    int insert(RoleAuthorityDo record);

    /**
     * auth_role_authority
     */
    int insertSelective(RoleAuthorityDo record);

    /**
     * auth_role_authority
     */
    List<RoleAuthorityDo> selectByQuery(RoleAuthorityQuery example);

    /**
     * auth_role_authority
     */
    RoleAuthorityDo selectByPrimaryKey(Integer id);

    /**
     * auth_role_authority
     */
    int updateByQuerySelective(@Param("record") RoleAuthorityDo record, @Param("example") RoleAuthorityQuery example);

    /**
     * auth_role_authority
     */
    int updateByQuery(@Param("record") RoleAuthorityDo record, @Param("example") RoleAuthorityQuery example);

    /**
     * auth_role_authority
     */
    int updateByPrimaryKeySelective(RoleAuthorityDo record);

    /**
     * auth_role_authority
     */
    int updateByPrimaryKey(RoleAuthorityDo record);
}