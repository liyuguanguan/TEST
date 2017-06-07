package com.ygjt.gdn.ftisp.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 新闻
 * crm_news
 */
public class NewsDo implements Serializable {
    /**
     * ID
     * crm_news.ID
     */
    private Integer id;

    /**
     * 创建时间
     * crm_news.CREATED_DT
     */
    private Date createdDt;

    /**
     * 创建人
     * crm_news.CREATED_BY
     */
    private Integer createdBy;

    /**
     * 最后更新时间
     * crm_news.LASTUPDATE_DT
     */
    private Date lastupdateDt;

    /**
     * 最后更新人
     * crm_news.LASTUPDATE_BY
     */
    private Integer lastupdateBy;

    /**
     * 平台动态(1)行业动态(2)永康动态(3)通知公告(4)政策法规(5)系统公告(6)
     * crm_news.TYPE
     */
    private Integer type;

    /**
     * 标题
     * crm_news.TITLE
     */
    private String title;

    /**
     * 作者
     * crm_news.AUTHER
     */
    private String auther;

    /**
     * 概要
     * crm_news.SUMMARY
     */
    private String summary;

    /**
     * 图片路径
     * crm_news.PICTURE_PATH
     */
    private String picturePath;

    /**
     * 点击数
     * crm_news.POINT_COUNT
     */
    private Integer pointCount;

    /**
     * 跳转url
     * crm_news.URL
     */
    private String url;

    /**
     * 发布日期
     * crm_news.RELEASE_TIME
     */
    private Date releaseTime;

    /**
     * 发布人
     * crm_news.RELEASE_USER
     */
    private Integer releaseUser;

    /**
     * 状态(0:已经删除;1:已经发布;2:未发布)默认2
     * crm_news.STAT
     */
    private String stat;

    /**
     * 1:头条；2:普通
     * crm_news.IS_HEAD
     */
    private Integer isHead;

    /**
     * 种类(0:无类别;1:新闻;2:服务帮助;3:政策法规;4:系统公告)
     * crm_news.CATEGORY
     */
    private String category;

    /**
     * 内容
     * crm_news.CONTENT
     */
    private String content;

    /**
     * crm_news
     */
    private static final long serialVersionUID = 1L;

    /**
     * crm_news.ID
     * @return the value of crm_news.ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * crm_news.ID
     * @param id the value for crm_news.ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * crm_news.CREATED_DT
     * @return the value of crm_news.CREATED_DT
     */
    public Date getCreatedDt() {
        return createdDt;
    }

    /**
     * crm_news.CREATED_DT
     * @param createdDt the value for crm_news.CREATED_DT
     */
    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    /**
     * crm_news.CREATED_BY
     * @return the value of crm_news.CREATED_BY
     */
    public Integer getCreatedBy() {
        return createdBy;
    }

    /**
     * crm_news.CREATED_BY
     * @param createdBy the value for crm_news.CREATED_BY
     */
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * crm_news.LASTUPDATE_DT
     * @return the value of crm_news.LASTUPDATE_DT
     */
    public Date getLastupdateDt() {
        return lastupdateDt;
    }

    /**
     * crm_news.LASTUPDATE_DT
     * @param lastupdateDt the value for crm_news.LASTUPDATE_DT
     */
    public void setLastupdateDt(Date lastupdateDt) {
        this.lastupdateDt = lastupdateDt;
    }

    /**
     * crm_news.LASTUPDATE_BY
     * @return the value of crm_news.LASTUPDATE_BY
     */
    public Integer getLastupdateBy() {
        return lastupdateBy;
    }

    /**
     * crm_news.LASTUPDATE_BY
     * @param lastupdateBy the value for crm_news.LASTUPDATE_BY
     */
    public void setLastupdateBy(Integer lastupdateBy) {
        this.lastupdateBy = lastupdateBy;
    }

    /**
     * crm_news.TYPE
     * @return the value of crm_news.TYPE
     */
    public Integer getType() {
        return type;
    }

    /**
     * crm_news.TYPE
     * @param type the value for crm_news.TYPE
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * crm_news.TITLE
     * @return the value of crm_news.TITLE
     */
    public String getTitle() {
        return title;
    }

    /**
     * crm_news.TITLE
     * @param title the value for crm_news.TITLE
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * crm_news.AUTHER
     * @return the value of crm_news.AUTHER
     */
    public String getAuther() {
        return auther;
    }

    /**
     * crm_news.AUTHER
     * @param auther the value for crm_news.AUTHER
     */
    public void setAuther(String auther) {
        this.auther = auther == null ? null : auther.trim();
    }

    /**
     * crm_news.SUMMARY
     * @return the value of crm_news.SUMMARY
     */
    public String getSummary() {
        return summary;
    }

    /**
     * crm_news.SUMMARY
     * @param summary the value for crm_news.SUMMARY
     */
    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    /**
     * crm_news.PICTURE_PATH
     * @return the value of crm_news.PICTURE_PATH
     */
    public String getPicturePath() {
        return picturePath;
    }

    /**
     * crm_news.PICTURE_PATH
     * @param picturePath the value for crm_news.PICTURE_PATH
     */
    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath == null ? null : picturePath.trim();
    }

    /**
     * crm_news.POINT_COUNT
     * @return the value of crm_news.POINT_COUNT
     */
    public Integer getPointCount() {
        return pointCount;
    }

    /**
     * crm_news.POINT_COUNT
     * @param pointCount the value for crm_news.POINT_COUNT
     */
    public void setPointCount(Integer pointCount) {
        this.pointCount = pointCount;
    }

    /**
     * crm_news.URL
     * @return the value of crm_news.URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * crm_news.URL
     * @param url the value for crm_news.URL
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * crm_news.RELEASE_TIME
     * @return the value of crm_news.RELEASE_TIME
     */
    public Date getReleaseTime() {
        return releaseTime;
    }

    /**
     * crm_news.RELEASE_TIME
     * @param releaseTime the value for crm_news.RELEASE_TIME
     */
    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    /**
     * crm_news.RELEASE_USER
     * @return the value of crm_news.RELEASE_USER
     */
    public Integer getReleaseUser() {
        return releaseUser;
    }

    /**
     * crm_news.RELEASE_USER
     * @param releaseUser the value for crm_news.RELEASE_USER
     */
    public void setReleaseUser(Integer releaseUser) {
        this.releaseUser = releaseUser;
    }

    /**
     * crm_news.STAT
     * @return the value of crm_news.STAT
     */
    public String getStat() {
        return stat;
    }

    /**
     * crm_news.STAT
     * @param stat the value for crm_news.STAT
     */
    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
    }

    /**
     * crm_news.IS_HEAD
     * @return the value of crm_news.IS_HEAD
     */
    public Integer getIsHead() {
        return isHead;
    }

    /**
     * crm_news.IS_HEAD
     * @param isHead the value for crm_news.IS_HEAD
     */
    public void setIsHead(Integer isHead) {
        this.isHead = isHead;
    }

    /**
     * crm_news.CATEGORY
     * @return the value of crm_news.CATEGORY
     */
    public String getCategory() {
        return category;
    }

    /**
     * crm_news.CATEGORY
     * @param category the value for crm_news.CATEGORY
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * crm_news.CONTENT
     * @return the value of crm_news.CONTENT
     */
    public String getContent() {
        return content;
    }

    /**
     * crm_news.CONTENT
     * @param content the value for crm_news.CONTENT
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * crm_news
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        NewsDo other = (NewsDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreatedDt() == null ? other.getCreatedDt() == null : this.getCreatedDt().equals(other.getCreatedDt()))
            && (this.getCreatedBy() == null ? other.getCreatedBy() == null : this.getCreatedBy().equals(other.getCreatedBy()))
            && (this.getLastupdateDt() == null ? other.getLastupdateDt() == null : this.getLastupdateDt().equals(other.getLastupdateDt()))
            && (this.getLastupdateBy() == null ? other.getLastupdateBy() == null : this.getLastupdateBy().equals(other.getLastupdateBy()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getAuther() == null ? other.getAuther() == null : this.getAuther().equals(other.getAuther()))
            && (this.getSummary() == null ? other.getSummary() == null : this.getSummary().equals(other.getSummary()))
            && (this.getPicturePath() == null ? other.getPicturePath() == null : this.getPicturePath().equals(other.getPicturePath()))
            && (this.getPointCount() == null ? other.getPointCount() == null : this.getPointCount().equals(other.getPointCount()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getReleaseTime() == null ? other.getReleaseTime() == null : this.getReleaseTime().equals(other.getReleaseTime()))
            && (this.getReleaseUser() == null ? other.getReleaseUser() == null : this.getReleaseUser().equals(other.getReleaseUser()))
            && (this.getStat() == null ? other.getStat() == null : this.getStat().equals(other.getStat()))
            && (this.getIsHead() == null ? other.getIsHead() == null : this.getIsHead().equals(other.getIsHead()))
            && (this.getCategory() == null ? other.getCategory() == null : this.getCategory().equals(other.getCategory()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    /**
     * crm_news
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreatedDt() == null) ? 0 : getCreatedDt().hashCode());
        result = prime * result + ((getCreatedBy() == null) ? 0 : getCreatedBy().hashCode());
        result = prime * result + ((getLastupdateDt() == null) ? 0 : getLastupdateDt().hashCode());
        result = prime * result + ((getLastupdateBy() == null) ? 0 : getLastupdateBy().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getAuther() == null) ? 0 : getAuther().hashCode());
        result = prime * result + ((getSummary() == null) ? 0 : getSummary().hashCode());
        result = prime * result + ((getPicturePath() == null) ? 0 : getPicturePath().hashCode());
        result = prime * result + ((getPointCount() == null) ? 0 : getPointCount().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getReleaseTime() == null) ? 0 : getReleaseTime().hashCode());
        result = prime * result + ((getReleaseUser() == null) ? 0 : getReleaseUser().hashCode());
        result = prime * result + ((getStat() == null) ? 0 : getStat().hashCode());
        result = prime * result + ((getIsHead() == null) ? 0 : getIsHead().hashCode());
        result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }
}