package com.ygjt.gdn.ftisp.controller.manage;

import com.github.pagehelper.Page;
import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.common.ResultFactory;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.vo.NewsListVO;
import com.ygjt.gdn.ftisp.model.vo.NewsLoadVO;
import com.ygjt.gdn.ftisp.model.vo.po.NewsListPO;
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
public class NewsManageController {
    private static final Logger logger = Logger.getLogger(NewsManageController.class);
    @Autowired
    NewsService newsService;

  
}
