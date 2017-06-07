package com.ygjt.gdn.ftisp.persistence;

import com.ygjt.gdn.ftisp.model.Query.RoleModuleQuery;
import com.ygjt.gdn.ftisp.model.RoleModuleDo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleModuleDao {
    /**
     * auth_role_module
     */
    long countByQuery(RoleModuleQuery example);

    /**
     * auth_role_module
     */
    int deleteByQuery(RoleModuleQuery example);

    /**
     * auth_role_module
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * auth_role_module
     */
    int insert(RoleModuleDo record);

    /**
     * auth_role_module
     */
    int insertSelective(RoleModuleDo record);

    /**
     * auth_role_module
     */
    List<RoleModuleDo> selectByQuery(RoleModuleQuery example);

    /**
     * auth_role_module
     */
    RoleModuleDo selectByPrimaryKey(Integer id);

    /**
     * auth_role_module
     */
    int updateByQuerySelective(@Param("record") RoleModuleDo record, @Param("example") RoleModuleQuery example);

    /**
     * auth_role_module
     */
    int updateByQuery(@Param("record") RoleModuleDo record, @Param("example") RoleModuleQuery example);

    /**
     * auth_role_module
     */
    int updateByPrimaryKeySelective(RoleModuleDo record);

    /**
     * auth_role_module
     */
    int updateByPrimaryKey(RoleModuleDo record);
}