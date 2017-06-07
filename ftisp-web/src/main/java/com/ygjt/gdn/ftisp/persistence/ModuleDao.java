package com.ygjt.gdn.ftisp.persistence;

import com.ygjt.gdn.ftisp.model.ModuleDo;
import com.ygjt.gdn.ftisp.model.Query.ModuleQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModuleDao {
    /**
     * auth_module
     */
    long countByQuery(ModuleQuery example);

    /**
     * auth_module
     */
    int deleteByQuery(ModuleQuery example);

    /**
     * auth_module
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * auth_module
     */
    int insert(ModuleDo record);

    /**
     * auth_module
     */
    int insertSelective(ModuleDo record);

    /**
     * auth_module
     */
    List<ModuleDo> selectByQuery(ModuleQuery example);

    /**
     * auth_module
     */
    ModuleDo selectByPrimaryKey(Integer id);

    /**
     * auth_module
     */
    int updateByQuerySelective(@Param("record") ModuleDo record, @Param("example") ModuleQuery example);

    /**
     * auth_module
     */
    int updateByQuery(@Param("record") ModuleDo record, @Param("example") ModuleQuery example);

    /**
     * auth_module
     */
    int updateByPrimaryKeySelective(ModuleDo record);

    /**
     * auth_module
     */
    int updateByPrimaryKey(ModuleDo record);
}