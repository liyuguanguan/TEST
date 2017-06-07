package com.ygjt.gdn.ftisp.service;

import com.github.pagehelper.Page;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.NewsDo;
import com.ygjt.gdn.ftisp.model.Query.NewsQuery;
import com.ygjt.gdn.ftisp.model.vo.po.ArticleListPO;

import java.util.List;

/**
 * Created by ZZY on 2016/8/25.
 */
public interface ArticleService {
    /**
     * 新闻分页
     * @return
     */
    Page<NewsDo> list(Page page, ArticleListPO po) throws ServiceException;

    /**
     * 新建新闻
     * @param newsDo
     * @throws ServiceException
     */
    void save(NewsDo newsDo) throws ServiceException;

    /**
     * 新闻更新
     * @param newsDo
     * @return
     * @throws ServiceException
     */
    void update(NewsDo newsDo)throws ServiceException;

    /**
     * 新闻删除
     * @param query
     * @throws ServiceException
     */
    void delete(NewsQuery query) throws ServiceException;

    /**
     * 发布新闻
     * @param newsId
     * @param userId
     * @throws ServiceException
     */
    void release(int newsId, int userId) throws ServiceException;

    /**
     * 按主键查询一条新闻
     * @param id
     * @return
     * @throws ServiceException
     */
    NewsDo getNews(int id) throws ServiceException;

    /**
     * 按查询条件查询新闻
     * @param query
     * @return
     * @throws ServiceException
     */
    List<NewsDo> getNewsByQuery(NewsQuery query) throws  ServiceException;
}
