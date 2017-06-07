package com.ygjt.gdn.ftisp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.SqlUtil;
import com.ygjt.gdn.ftisp.enums.NewsEnum;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.NewsDo;
import com.ygjt.gdn.ftisp.model.Query.NewsQuery;
import com.ygjt.gdn.ftisp.model.vo.po.ArticleListPO;
import com.ygjt.gdn.ftisp.persistence.NewsDao;
import com.ygjt.gdn.ftisp.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ZZY on 2016/8/25.
 */
@Service("newsService")
public class ArticleServiceImpl implements ArticleService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private NewsDao newsDao;

    @Override
    public Page<NewsDo> list(Page page, ArticleListPO po) throws ServiceException {
        NewsQuery newsQuery = createListQuery(po);
        //设置分页信息
        if (page == null) {
            page = PageHelper.startPage(po.getPage(), po.getRows());
        }
        SqlUtil.setLocalPage(page);
        //根据查询条件查询出库单list
        newsDao.selectByQuery(newsQuery);
        return page;
    }

    private NewsQuery createListQuery(ArticleListPO po){
        NewsQuery newsQuery = new NewsQuery();
        NewsQuery.Criteria criteria = newsQuery.createCriteria();
        if(po.getIsHead()!=null){
            criteria.andIsHeadEqualTo(po.getIsHead());
        }
        if(po.getCategory()!=null){
            criteria.andCategoryEqualTo(po.getCategory());
        }
        if(po.getType()!=null){
            criteria.andTypeEqualTo(po.getType());
        }
        if(po.getTitle()!=null){
            criteria.andTitleLike("%"+po.getTitle()+"%");
        }
        criteria.andStatNotEqualTo(NewsEnum.NEWS_STAT.DELETED.getValue());
        newsQuery.setOrderByClause("STAT desc,CREATED_DT desc");
        return newsQuery;
    }

    @Override
    public void save(NewsDo newsDo) throws ServiceException {
        logger.info("[进入新闻新建服务]");
        newsDao.insertSelective(newsDo);
    }

    @Override
    public void update(NewsDo newsDo) throws ServiceException {
        logger.info("[进入新闻更新服务]");
        newsDao.updateByPrimaryKeySelective(newsDo);
    }

    @Override
    public void delete(NewsQuery query) throws ServiceException {
        logger.info("[进入新闻删除服务]");
        NewsDo newsDo = new NewsDo();
        newsDo.setStat(NewsEnum.NEWS_STAT.DELETED.getValue());
        newsDao.updateByQuerySelective(newsDo,query);
        //newsDao.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void release(int newsId,int userId) throws ServiceException {
        logger.info("[进入新闻发布服务]");
        NewsDo newsDo = new NewsDo();
        newsDo.setId(newsId);
        newsDo.setReleaseUser(userId);
        newsDo.setReleaseTime(new Date());
        newsDo.setStat(NewsEnum.NEWS_STAT.RELEASED.getValue());
        newsDao.updateByPrimaryKeySelective(newsDo);
    }

    @Override
    public NewsDo getNews(int id) throws ServiceException {
        logger.info("[进入新闻按主键查询服务]");
        NewsDo newsDo = new NewsDo();
        newsDo = newsDao.selectByPrimaryKey(id);
        return newsDo;
    }

    @Override
    public List<NewsDo> getNewsByQuery(NewsQuery query) throws ServiceException {
        logger.info("[进入新闻按条件查询服务]");
        List<NewsDo> newsDos = new ArrayList<NewsDo>();
        newsDos = newsDao.selectByQuery(query);
        return newsDos;
    }

}
