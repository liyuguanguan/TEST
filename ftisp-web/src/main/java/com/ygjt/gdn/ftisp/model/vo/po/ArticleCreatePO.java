package com.ygjt.gdn.ftisp.model.vo.po;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by zzy on 2016/8/30.
 */
public class ArticleCreatePO {
    /**
     * ID
     * tb_news.ID
     */
    private String id;
    /**
     * 标题
     * tb_news.TITLE
     */
    private String title;
    /**
     * 版图
     */
    private MultipartFile topPic;
    /**
     * 文章来源
     */
    private String url;
    /**
     * 作者
     * tb_news.AUTHER
     */
    private String auther;
    /**
     * 概要
     * tb_news.SUMMARY
     */
    private String summary;
    /**
     * 内容
     * tb_news.CONTENT
     */
    private String content;
    /**
     * 平台动态(1)行业动态(2)永康动态(3)通知公告(4)政策法规(5)系统公告(6)
     * tb_news.TYPE
     */
    private String type;

    private String category;
    /**
     * 状态(0:已经删除;1:已经发布;2:未发布)默认2
     * tb_news.STAT
     */
    private String stat;
    /**
     * 1:头条；2:普通
     */
    private int isHead;

    private String hasPic;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getHasPic() {
        return hasPic;
    }

    public void setHasPic(String hasPic) {
        this.hasPic = hasPic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MultipartFile getTopPic() {
        return topPic;
    }

    public void setTopPic(MultipartFile topPic) {
        this.topPic = topPic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public int getIsHead() {
        return isHead;
    }

    public void setIsHead(int isHead) {
        this.isHead = isHead;
    }
}
