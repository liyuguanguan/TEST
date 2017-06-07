package com.ygjt.gdn.ftisp.persistence;

import com.ygjt.gdn.ftisp.model.NewsDo;
import com.ygjt.gdn.ftisp.model.Query.NewsQuery;

import java.util.HashMap;
import java.util.List;

import com.ygjt.gdn.ftisp.model.vo.NewsListVO;
import com.ygjt.gdn.ftisp.model.vo.NewsPictureVO;
import org.apache.ibatis.annotations.Param;

public interface NewsDao {
    /**
     * crm_news
     */
    long countByQuery(NewsQuery example);

    /**
     * crm_news
     */
    int deleteByQuery(NewsQuery example);

    /**
     * crm_news
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * crm_news
     */
    int insert(NewsDo record);

    /**
     * crm_news
     */
    int insertSelective(NewsDo record);

    /**
     * crm_news
     */
    List<NewsDo> selectByQueryWithBLOBs(NewsQuery example);

    /**
     * crm_news
     */
    List<NewsDo> selectByQuery(NewsQuery example);

    /**
     * crm_news
     */
    NewsDo selectByPrimaryKey(Integer id);

    /**
     * crm_news
     */
    int updateByQuerySelective(@Param("record") NewsDo record, @Param("example") NewsQuery example);

    /**
     * crm_news
     */
    int updateByQueryWithBLOBs(@Param("record") NewsDo record, @Param("example") NewsQuery example);

    /**
     * crm_news
     */
    int updateByQuery(@Param("record") NewsDo record, @Param("example") NewsQuery example);

    /**
     * crm_news
     */
    int updateByPrimaryKeySelective(NewsDo record);

    /**
     * crm_news
     */
    int updateByPrimaryKeyWithBLOBs(NewsDo record);

    /**
     * crm_news
     */
    int updateByPrimaryKey(NewsDo record);

    List<NewsListVO> selectListByQuery(HashMap<String,Object> param);

    List<NewsPictureVO> selectSliderPicture(HashMap<String,Object> param);
}