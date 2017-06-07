package com.ygjt.gdn.ftisp.persistence;

import com.ygjt.gdn.ftisp.model.Query.RoleQuery;
import com.ygjt.gdn.ftisp.model.RoleDo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleDao {
    /**
     * auth_role
     */
    long countByQuery(RoleQuery example);

    /**
     * auth_role
     */
    int deleteByQuery(RoleQuery example);

    /**
     * auth_role
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * auth_role
     */
    int insert(RoleDo record);

    /**
     * auth_role
     */
    int insertSelective(RoleDo record);

    /**
     * auth_role
     */
    List<RoleDo> selectByQuery(RoleQuery example);

    /**
     * auth_role
     */
    RoleDo selectByPrimaryKey(Integer id);

    /**
     * auth_role
     */
    int updateByQuerySelective(@Param("record") RoleDo record, @Param("example") RoleQuery example);

    /**
     * auth_role
     */
    int updateByQuery(@Param("record") RoleDo record, @Param("example") RoleQuery example);

    /**
     * auth_role
     */
    int updateByPrimaryKeySelective(RoleDo record);

    /**
     * auth_role
     */
    int updateByPrimaryKey(RoleDo record);
}