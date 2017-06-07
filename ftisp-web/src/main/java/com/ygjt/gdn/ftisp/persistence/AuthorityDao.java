package com.ygjt.gdn.ftisp.persistence;

import com.ygjt.gdn.ftisp.model.AuthorityDo;
import com.ygjt.gdn.ftisp.model.Query.AuthorityQuery;
import java.util.List;

import com.ygjt.gdn.ftisp.model.vo.AuthorityListVo;
import com.ygjt.gdn.ftisp.model.vo.QueryAuthorityVo;
import com.ygjt.gdn.ftisp.model.vo.po.AuthorityListPo;
import org.apache.ibatis.annotations.Param;

public interface AuthorityDao {
    /**
     * auth_authority
     */
    long countByQuery(AuthorityQuery example);

    /**
     * auth_authority
     */
    int deleteByQuery(AuthorityQuery example);

    /**
     * auth_authority
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * auth_authority
     */
    int insert(AuthorityDo record);

    /**
     * auth_authority
     */
    int insertSelective(AuthorityDo record);

    /**
     * auth_authority
     */
    List<AuthorityDo> selectByQuery(AuthorityQuery example);

    /**
     * auth_authority
     */
    AuthorityDo selectByPrimaryKey(Integer id);

    /**
     * auth_authority
     */
    int updateByQuerySelective(@Param("record") AuthorityDo record, @Param("example") AuthorityQuery example);

    /**
     * auth_authority
     */
    int updateByQuery(@Param("record") AuthorityDo record, @Param("example") AuthorityQuery example);

    /**
     * auth_authority
     */
    int updateByPrimaryKeySelective(AuthorityDo record);

    /**
     * auth_authority
     */
    int updateByPrimaryKey(AuthorityDo record);

    List<AuthorityDo> selectByUserId(Integer id);

    List<AuthorityDo> selectByResourcePath(String path);

    List<AuthorityListVo> queryRole(AuthorityListPo po);

    List<QueryAuthorityVo> simpleSelect(Integer systemId);
}