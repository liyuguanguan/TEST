package com.ygjt.gdn.ftisp.controller;

import com.github.pagehelper.Page;
import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.common.ResultFactory;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.vo.NewsListVO;
import com.ygjt.gdn.ftisp.model.vo.NewsLoadVO;
import com.ygjt.gdn.ftisp.model.vo.NewsPictureVO;
import com.ygjt.gdn.ftisp.model.vo.po.NewsListPO;
import com.ygjt.gdn.ftisp.model.vo.po.NewsPicturePO;
import com.ygjt.gdn.ftisp.service.NewsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhongb on 2017/4/17.
 */
@Controller
@RequestMapping("/api/v1/p")
public class NewsController {
    private static final Logger logger = Logger.getLogger(NewsController.class);
    @Autowired
    NewsService newsService;

    /**
     * 新闻列表
     * @return
     * @throws ServiceException
     */
    @RequestMapping("/ftisp/unlogin/article/list")
    @ResponseBody
    public ResultData<?> listNews(NewsListPO po) throws ServiceException {
        //分页默认值
        if(po.getPage()==null){
            po.setPage(1);
        }
        if(po.getRows()==null){
            po.setRows(6);
        }
        //创建page对象
        Page<NewsListVO> page = new Page<NewsListVO>(po.getPage(), po.getRows());
        List<NewsListVO> list = null;
        try {
            list = newsService.list(page, po);
            PageVO<NewsListVO> pageVO = new PageVO<NewsListVO>(page.getPageNum(), page.getPageSize(), page.getTotal(), list);
            return ResultFactory.createSuccessResultData(pageVO);
        } catch (ServiceException e) {
            logger.error("查询新闻list异常：" ,e);
            return ResultFactory.createFailResultData("查询新闻list异常:"+e.getMessage(), null);
        } catch (NumberFormatException e) {
            logger.error("查询新闻list异常：" ,e);
            return ResultFactory.createFailResultData("查询新闻list异常：", null);
        }
    }

    @RequestMapping("/ftisp/unlogin/article/load")
    @ResponseBody
    public ResultData<?> getDetail(Integer id) throws ServiceException{
        try {
            NewsLoadVO vo = newsService.getNews(id);
            return ResultFactory.createSuccessResultData(vo);
        } catch (Exception e) {
            logger.error("加载新闻异常：" ,e);
            return ResultFactory.createFailResultData("加载新闻异常：", null);
        }
    }

    @RequestMapping("/ftisp/unlogin/slider/picture")
    @ResponseBody
    public ResultData<?> getPicture(NewsPicturePO po) throws ServiceException{
        try {
            List<NewsPictureVO> vo = newsService.getSliderPicture(po);
            return ResultFactory.createSuccessResultData(vo);
        } catch (Exception e) {
            logger.error("加载轮播图图片异常：" ,e);
            return ResultFactory.createFailResultData("加载轮播图图片异常：", null);
        }
    }
}
