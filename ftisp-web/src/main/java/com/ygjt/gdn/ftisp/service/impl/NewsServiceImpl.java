package com.ygjt.gdn.ftisp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.SqlUtil;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.enums.NewsEnum;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.NewsDo;
import com.ygjt.gdn.ftisp.model.vo.NewsListVO;
import com.ygjt.gdn.ftisp.model.vo.NewsLoadVO;
import com.ygjt.gdn.ftisp.model.vo.NewsPictureVO;
import com.ygjt.gdn.ftisp.model.vo.po.NewsListPO;
import com.ygjt.gdn.ftisp.model.vo.po.NewsPicturePO;
import com.ygjt.gdn.ftisp.persistence.NewsDao;
import com.ygjt.gdn.ftisp.service.NewsService;
import com.ygjt.gdn.ftisp.enums.SliderPicEnum;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhongb on 2017/4/17.
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao newsDao;
    @Override
    public Page<NewsListVO> list(Page page, NewsListPO po) throws ServiceException {
        HashMap<String, Object> param = new HashMap<String, Object>();
        if(NewsEnum.NEWS_IS_HEAD.NOT_HEAD.getValue() == Integer.parseInt(po.getIsHead())){
            if(StringUtils.isNotEmpty(po.getType())){
                param.put("type", Integer.parseInt(po.getType()));
            }
        }
        if(StringUtils.isNotBlank(po.getIsHead())){
            param.put("isHead",po.getIsHead());
        }
        param.put("orderByClause","STAT desc,RELEASE_TIME desc");
        //设置分页信息
        if (page == null) {
            page = PageHelper.startPage(po.getPage(), po.getRows());
        }
        SqlUtil.setLocalPage(page);
        //根据查询条件查询出库单list
        newsDao.selectListByQuery(param);
        return page;
    }

    @Override
    public NewsLoadVO getNews(Integer id) throws ServiceException {
        NewsLoadVO vo = new NewsLoadVO();
        NewsDo newsDo = new NewsDo();
        newsDo = newsDao.selectByPrimaryKey(id);
        BeanUtils.copyProperties(newsDo,vo);
        return vo;
    }

    @Override
    public List<NewsPictureVO> getSliderPicture(NewsPicturePO po) throws ServiceException {
        if(po.getNum()==null){
            po.setNum(3);
        }
        if(StringUtils.isEmpty(po.getType())){
            po.setType(SliderPicEnum.SLIDER_TYPE.NEWS_CENTER.getValue());
        }
        List<NewsPictureVO> vos = new ArrayList<>();
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("num", po.getNum());
        param.put("orderByClause","STAT desc,RELEASE_TIME desc");
        if(SliderPicEnum.SLIDER_TYPE.NEWS_CENTER.getValue().equals(po.getType())){
            vos = newsDao.selectSliderPicture(param);
        }else if(SliderPicEnum.SLIDER_TYPE.INDEX.getValue().equals(po.getType())){
        }
        return vos;
    }
}
