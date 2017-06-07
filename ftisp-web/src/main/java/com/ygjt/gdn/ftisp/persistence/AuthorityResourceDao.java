package com.ygjt.gdn.ftisp.persistence;

import com.ygjt.gdn.ftisp.model.AuthorityResourceDo;
import com.ygjt.gdn.ftisp.model.Query.AuthorityResourceQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthorityResourceDao {
    /**
     * auth_authority_resource
     */
    long countByQuery(AuthorityResourceQuery example);

    /**
     * auth_authority_resource
     */
    int deleteByQuery(AuthorityResourceQuery example);

    /**
     * auth_authority_resource
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * auth_authority_resource
     */
    int insert(AuthorityResourceDo record);

    /**
     * auth_authority_resource
     */
    int insertSelective(AuthorityResourceDo record);

    /**
     * auth_authority_resource
     */
    List<AuthorityResourceDo> selectByQuery(AuthorityResourceQuery example);

    /**
     * auth_authority_resource
     */
    AuthorityResourceDo selectByPrimaryKey(Integer id);

    /**
     * auth_authority_resource
     */
    int updateByQuerySelective(@Param("record") AuthorityResourceDo record, @Param("example") AuthorityResourceQuery example);

    /**
     * auth_authority_resource
     */
    int updateByQuery(@Param("record") AuthorityResourceDo record, @Param("example") AuthorityResourceQuery example);

    /**
     * auth_authority_resource
     */
    int updateByPrimaryKeySelective(AuthorityResourceDo record);

    /**
     * auth_authority_resource
     */
    int updateByPrimaryKey(AuthorityResourceDo record);
}