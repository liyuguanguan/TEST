package com.ygjt.gdn.ftisp.persistence;

import com.ygjt.gdn.ftisp.model.Query.UserModuleQuery;
import com.ygjt.gdn.ftisp.model.UserModuleDo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserModuleDao {
    /**
     * auth_user_module
     */
    long countByQuery(UserModuleQuery example);

    /**
     * auth_user_module
     */
    int deleteByQuery(UserModuleQuery example);

    /**
     * auth_user_module
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * auth_user_module
     */
    int insert(UserModuleDo record);

    /**
     * auth_user_module
     */
    int insertSelective(UserModuleDo record);

    /**
     * auth_user_module
     */
    List<UserModuleDo> selectByQuery(UserModuleQuery example);

    /**
     * auth_user_module
     */
    UserModuleDo selectByPrimaryKey(Integer id);

    /**
     * auth_user_module
     */
    int updateByQuerySelective(@Param("record") UserModuleDo record, @Param("example") UserModuleQuery example);

    /**
     * auth_user_module
     */
    int updateByQuery(@Param("record") UserModuleDo record, @Param("example") UserModuleQuery example);

    /**
     * auth_user_module
     */
    int updateByPrimaryKeySelective(UserModuleDo record);

    /**
     * auth_user_module
     */
    int updateByPrimaryKey(UserModuleDo record);
}