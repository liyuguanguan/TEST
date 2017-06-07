package com.ygjt.gdn.ftisp.persistence;

import com.ygjt.gdn.ftisp.model.EmailCodeDo;
import com.ygjt.gdn.ftisp.model.Query.EmailCodeQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmailCodeDao {
    /**
     * p_email_code
     */
    long countByQuery(EmailCodeQuery example);

    /**
     * p_email_code
     */
    int deleteByQuery(EmailCodeQuery example);

    /**
     * p_email_code
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * p_email_code
     */
    int insert(EmailCodeDo record);

    /**
     * p_email_code
     */
    int insertSelective(EmailCodeDo record);

    /**
     * p_email_code
     */
    List<EmailCodeDo> selectByQuery(EmailCodeQuery example);

    /**
     * p_email_code
     */
    EmailCodeDo selectByPrimaryKey(Integer id);

    /**
     * p_email_code
     */
    int updateByQuerySelective(@Param("record") EmailCodeDo record, @Param("example") EmailCodeQuery example);

    /**
     * p_email_code
     */
    int updateByQuery(@Param("record") EmailCodeDo record, @Param("example") EmailCodeQuery example);

    /**
     * p_email_code
     */
    int updateByPrimaryKeySelective(EmailCodeDo record);

    /**
     * p_email_code
     */
    int updateByPrimaryKey(EmailCodeDo record);
}