package com.ygjt.gdn.ftisp.persistence;

import com.ygjt.gdn.ftisp.model.Query.UserRoleQuery;
import com.ygjt.gdn.ftisp.model.UserRoleDo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleDao {
    /**
     * auth_user_role
     */
    long countByQuery(UserRoleQuery example);

    /**
     * auth_user_role
     */
    int deleteByQuery(UserRoleQuery example);

    /**
     * auth_user_role
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * auth_user_role
     */
    int insert(UserRoleDo record);

    /**
     * auth_user_role
     */
    int insertSelective(UserRoleDo record);

    /**
     * auth_user_role
     */
    List<UserRoleDo> selectByQuery(UserRoleQuery example);

    /**
     * auth_user_role
     */
    UserRoleDo selectByPrimaryKey(Integer id);

    /**
     * auth_user_role
     */
    int updateByQuerySelective(@Param("record") UserRoleDo record, @Param("example") UserRoleQuery example);

    /**
     * auth_user_role
     */
    int updateByQuery(@Param("record") UserRoleDo record, @Param("example") UserRoleQuery example);

    /**
     * auth_user_role
     */
    int updateByPrimaryKeySelective(UserRoleDo record);

    /**
     * auth_user_role
     */
    int updateByPrimaryKey(UserRoleDo record);
}