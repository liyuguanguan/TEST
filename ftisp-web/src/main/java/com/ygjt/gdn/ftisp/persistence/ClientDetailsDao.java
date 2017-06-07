package com.ygjt.gdn.ftisp.persistence;

import com.ygjt.gdn.ftisp.model.ClientDetailsDo;
import com.ygjt.gdn.ftisp.model.Query.ClientDetailsQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClientDetailsDao {
    /**
     * auth_client_details
     */
    long countByQuery(ClientDetailsQuery example);

    /**
     * auth_client_details
     */
    int deleteByQuery(ClientDetailsQuery example);

    /**
     * auth_client_details
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * auth_client_details
     */
    int insert(ClientDetailsDo record);

    /**
     * auth_client_details
     */
    int insertSelective(ClientDetailsDo record);

    /**
     * auth_client_details
     */
    List<ClientDetailsDo> selectByQuery(ClientDetailsQuery example);

    /**
     * auth_client_details
     */
    ClientDetailsDo selectByPrimaryKey(Integer id);

    /**
     * auth_client_details
     */
    int updateByQuerySelective(@Param("record") ClientDetailsDo record, @Param("example") ClientDetailsQuery example);

    /**
     * auth_client_details
     */
    int updateByQuery(@Param("record") ClientDetailsDo record, @Param("example") ClientDetailsQuery example);

    /**
     * auth_client_details
     */
    int updateByPrimaryKeySelective(ClientDetailsDo record);

    /**
     * auth_client_details
     */
    int updateByPrimaryKey(ClientDetailsDo record);
}