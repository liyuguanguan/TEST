package com.ygjt.gdn.ftisp.mail.service.impl;

import com.github.pagehelper.Page;
import com.ygjt.gdn.ftisp.model.NewsDo;
import com.ygjt.gdn.ftisp.model.vo.NewsListVO;
import com.ygjt.gdn.ftisp.model.vo.NewsLoadVO;
import com.ygjt.gdn.ftisp.model.vo.po.NewsListPO;
import com.ygjt.gdn.ftisp.service.impl.NewsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhongb on 2017/4/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/application-*.xml")
public class NewsServiceImplTest {
    @Autowired
    NewsServiceImpl newsServiceImpl;

    @Test
    public void testNews() throws Exception {
        NewsListPO newsListPO =new NewsListPO();
        //Page page= new Page();
        newsListPO.setTitle("今日头条");
        newsListPO.setAuther("Tom");
        newsListPO.setReleaseTime("2017-01-01");
        newsListPO.setType("1");
        newsListPO.setPage(1);
        newsListPO.setRows(10);
//        newsListPO.setSort("");
//        newsListPO.setOrder("");
        Page<NewsListVO> list = newsServiceImpl.list(null,newsListPO);
        System.out.println(list.isCount());
    }
    @Test
    public void testGetNews() throws Exception {
        NewsLoadVO newsLoadVO = new NewsLoadVO();
        NewsDo newsDo = new NewsDo();
      /*  newsListPO.setTitle("今日头条");
        newsListPO.setAuther("Tom");
        newsListPO.setReleaseTime("2017-01-01");
        newsListPO.setType("1");
        newsListPO.setPage(1);/
        newsListPO.setRows(10);
        newsListPO.setSort("");
        newsListPO.setOrder("");
        Page<NewsListVO> list = newsServiceImpl.list(page,newsListPO);
        System.out.println(list.isCount());*/
    }
}
