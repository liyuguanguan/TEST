package com.ygjt.gdn.ftisp.service;

import com.github.pagehelper.Page;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.NewsDo;
import com.ygjt.gdn.ftisp.model.vo.NewsListVO;
import com.ygjt.gdn.ftisp.model.vo.NewsLoadVO;
import com.ygjt.gdn.ftisp.model.vo.NewsPictureVO;
import com.ygjt.gdn.ftisp.model.vo.po.NewsListPO;
import com.ygjt.gdn.ftisp.model.vo.po.NewsPicturePO;

import java.util.List;

/**
 * Created by zhongb on 2017/4/17.
 */
public interface NewsService {
    /**
     * 新闻分页
     * @return
     * @throws ServiceException
     */
    Page<NewsListVO> list(Page page, NewsListPO po) throws ServiceException;

    /**
     * 按主键查询一条新闻
     * @param id
     * @return
     * @throws ServiceException
     */
    NewsLoadVO getNews(Integer id) throws ServiceException;

    /**
     * 查询轮播图
     * @param po
     * @return
     * @throws ServiceException
     */
    List<NewsPictureVO> getSliderPicture(NewsPicturePO po) throws ServiceException;

}
