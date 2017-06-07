package com.ygjt.gdn.ftisp.controller;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.Page;
import com.ygjt.gdn.ftisp.auth.tools.VelocitySecurityUtil;
import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.common.ResultFactory;
import com.ygjt.gdn.ftisp.enums.NewsEnum;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.NewsDo;
import com.ygjt.gdn.ftisp.model.Query.NewsQuery;
import com.ygjt.gdn.ftisp.model.UserDo;
import com.ygjt.gdn.ftisp.model.vo.po.ArticleListPO;
import com.ygjt.gdn.ftisp.ueditor.PathFormat;
import com.ygjt.gdn.ftisp.ueditor.define.FileType;
import com.ygjt.gdn.ftisp.utils.support.RegexUtils;
import com.ygjt.gdn.ftisp.model.vo.po.ArticleCreatePO;
import com.ygjt.gdn.ftisp.service.ArticleService;
import com.ygjt.gdn.ftisp.utils.DiyUploadUtils;
import com.ygjt.gdn.ftisp.utils.service.MessageProvider;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ZZY on 2016/8/24.
 */
@Controller
@RequestMapping("/api/v1/p/ftisp/manage/article")
public class ArticleController extends MessageProvider{
    private static final Logger logger = Logger.getLogger(ArticleController.class);
    @Value("#{configProperties['upload.path']}")
    private String uploadPath;
    private final String savePath = "/ueditor/images/{yyyy}{mm}{dd}";

    @Resource
    private ArticleService articleService;

    /**
     * 新增新闻
     * @return
     */
    @RequestMapping("/create")
    @ResponseBody
    public ResultData<?> addNews(ArticleCreatePO po) {
        //创建返回页面对象
        try {
            //获得当前用户
            UserDo userDo = VelocitySecurityUtil.getUserDo();
            char c1 = '~';
            char c2 = '"';
            po.setContent(po.getContent().replace(c1,c2));
            NewsDo newsDo = new NewsDo();
            BeanUtils.copyProperties(po,newsDo);
            if(po.getIsHead()== NewsEnum.NEWS_IS_HEAD.IS_HEAD.getValue()&&po.getTopPic().isEmpty()){
                return ResultFactory.createFailResultData("头条必须有版图");
            }
            //从新闻正文中获取第一张图片的路径
            if(po.getTopPic().isEmpty()){
                String firstImagePath = RegexUtils.getFirstImgPath(po.getContent());
                if(!StringUtils.isEmpty(firstImagePath)){
                    newsDo.setPicturePath(firstImagePath);
                }
            }else{
                //如何有版图则上传版图
                String originFileName = po.getTopPic().getOriginalFilename();
                String suffix = FileType.getSuffixByFilename(originFileName);
                String imagePath = PathFormat.parse(savePath);
                DiyUploadUtils.upload(po.getTopPic().getInputStream(),uploadPath+ File.separator+imagePath,originFileName);
                if(!StringUtils.isEmpty(imagePath)){
                    newsDo.setPicturePath(PathFormat.format(imagePath+"/"+originFileName));
                }
            }
            newsDo.setCreatedDt(new Date());
            newsDo.setCreatedBy(userDo.getId());
            newsDo.setCategory(po.getCategory());
            newsDo.setType(Integer.parseInt(po.getType()));
            //判断新闻是否需要发布
            if(StringUtils.isEmpty(newsDo.getStat())){
                newsDo.setStat(NewsEnum.NEWS_STAT.NOTRELEASED.getValue());
            }else{
                newsDo.setStat(NewsEnum.NEWS_STAT.RELEASED.getValue());
                newsDo.setReleaseTime(new Date());
                newsDo.setReleaseUser(userDo.getId());
            }
            articleService.save(newsDo);
            return ResultFactory.createSuccessResultData(null);
        } catch (ServiceException e) {
            logger.error("文章新建失败：",e);
            return ResultFactory.createFailResultData("文章新建失败");
        }  catch (Exception e) {
            logger.error("文章新建失败：",e);
            return ResultFactory.createFailResultData("文章新建失败");
        }
    }

    /**
     * 新闻列表
     * @return
     * @throws ServiceException
     */
    @RequestMapping("/list")
    @ResponseBody
    public ResultData<?> listNews(ArticleListPO po) throws ServiceException {
        logger.info("查询新闻列表开始！");
        //分页默认值
        if(po.getPage()==null){
            po.setPage(1);
        }
        if(po.getRows()==null){
            po.setRows(10);
        }
        //创建page对象
        Page<NewsDo> page = new Page<NewsDo>(po.getPage(), po.getRows());
        List<NewsDo> list = null;
        try {
            list = articleService.list(page, po);
            PageVO<NewsDo> pageVO = new PageVO<NewsDo>(page.getPageNum(), page.getPageSize(), page.getTotal(), list);
            return ResultFactory.createSuccessResultData(pageVO);
        } catch (ServiceException e) {
            logger.error("查询新闻list异常：" + e.getMessage());
            return ResultFactory.createFailResultData("查询新闻list异常");
        } catch (Exception e) {
            logger.error("查询新闻list异常：" + e.getMessage());
            return ResultFactory.createFailResultData("查询新闻list异常");
        }
    }

    @RequestMapping("/load")
    @ResponseBody
    public ResultData<?> load(String id){
        NewsDo newsDo = new NewsDo();
        try {
            //获得根据id的新闻初始化数据
            newsDo = articleService.getNews(Integer.parseInt(id));
            if(newsDo.getPicturePath()==null){
                newsDo.setPicturePath("");
            }
            return ResultFactory.createSuccessResultData(newsDo);
        } catch (ServiceException e) {
            logger.error("文章加载失败:",e);
            return ResultFactory.createFailResultData("文章加载失败");
        } catch (Exception e) {
            logger.error("文章加载失败:",e);
            return ResultFactory.createFailResultData("文章加载失败");
        }
    }

    /**
     * 更新新闻
     * @return
     * @throws ServiceException
     */
    @RequestMapping("/update")
    @ResponseBody
    public ResultData<?> updateNews(ArticleCreatePO po, HttpServletRequest request) throws ServiceException {
        try {
            //获得当前用户
            UserDo userDo = VelocitySecurityUtil.getUserDo();
            char c1 = '~';
            char c2 = '"';
            po.setContent(po.getContent().replace(c1,c2));
            NewsDo newsDo = new NewsDo();
            BeanUtils.copyProperties(po,newsDo);
            if(po.getIsHead()==NewsEnum.NEWS_IS_HEAD.IS_HEAD.getValue()&&(!"Y".equals(po.getHasPic()))){
                ResultFactory.createFailResultData("mms.article.updatenews.haspic");
            }
            //从新闻正文中获取第一张图片的路径
            if(!"Y".equals(po.getHasPic())){
                String firstImagePath = RegexUtils.getFirstImgPath(po.getContent());
                if(!StringUtils.isEmpty(firstImagePath)){
                    newsDo.setPicturePath(firstImagePath);
                }
            }else{
                if(!po.getTopPic().isEmpty()) {
                    //如果有版图则上传版图
                    String path = request.getSession().getServletContext().getRealPath("/");
                    String originFileName = po.getTopPic().getOriginalFilename();
                    String suffix = FileType.getSuffixByFilename(originFileName);
                    String imagePath = PathFormat.parse(savePath);
                    DiyUploadUtils.upload(po.getTopPic().getInputStream(),path + imagePath, originFileName);
                    if (!StringUtils.isEmpty(imagePath)) {
                        newsDo.setPicturePath(PathFormat.format("/ftisp"+imagePath + "/" + originFileName));
                    }
                }
            }
            newsDo.setId(Integer.parseInt(po.getId()));
            newsDo.setLastupdateDt(new Date());
            newsDo.setLastupdateBy(userDo.getId());
            newsDo.setType(Integer.parseInt(po.getType()));
            newsDo.setStat(NewsEnum.NEWS_STAT.NOTRELEASED.getValue());
            articleService.update(newsDo);
            return ResultFactory.createSuccessResultData(null);
        } catch (ServiceException e) {
            return ResultFactory.createFailResultData(this.getMessage("mms.article.updatenews.error"));
        } catch (Exception e) {
            return ResultFactory.createFailResultData(this.getMessage("mms.article.updatenews.error"));
        }
    }

    /**
     * 删除新闻
     * @param idStr
     * @return
     * @throws ServiceException
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResultData<?> deleteNews(String idStr) throws ServiceException {
        NewsQuery newsQuery = new NewsQuery();
        NewsQuery.Criteria criteria = newsQuery.createCriteria();
        List<Integer> list = new ArrayList<>();
        //将idStr中的id逐一放入list中
        for (String id : idStr.split(",")){
            list.add(Integer.parseInt(id));
        }
        criteria.andIdIn(list);
        try {
            articleService.delete(newsQuery);
            return ResultFactory.createSuccessResultData(null);
        } catch (ServiceException e) {
            return ResultFactory.createFailResultData("删除新闻异常");
        }
    }

    /**
     * 发布新闻
     * @param id
     * @return
     * @throws ServiceException
     */
    @RequestMapping("/release")
    @ResponseBody
    public ResultData<?> releaseNews(HttpSession session, String id) throws ServiceException {
        try {
            //获得当前用户
            UserDo userDo = VelocitySecurityUtil.getUserDo();
            articleService.release(Integer.parseInt(id),userDo.getId());
            return ResultFactory.createSuccessResultData(null);
        } catch (Exception e) {
            logger.error("发布文章异常：",e);
            return ResultFactory.createFailResultData("发布新闻异常");
        }
    }

}
