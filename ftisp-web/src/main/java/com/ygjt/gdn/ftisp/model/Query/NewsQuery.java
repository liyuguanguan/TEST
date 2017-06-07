package com.ygjt.gdn.ftisp.model.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsQuery {
    /**
     * crm_news
     */
    protected String orderByClause;

    /**
     * crm_news
     */
    protected boolean distinct;

    /**
     * crm_news
     */
    protected List<Criteria> oredCriteria;

    /**
     * crm_news
     */
    public NewsQuery() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * crm_news
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * crm_news
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * crm_news
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * crm_news
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * crm_news
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * crm_news
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * crm_news
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * crm_news
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * crm_news
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * crm_news
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class corresponds to the database table crm_news
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreatedDtIsNull() {
            addCriterion("CREATED_DT is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDtIsNotNull() {
            addCriterion("CREATED_DT is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDtEqualTo(Date value) {
            addCriterion("CREATED_DT =", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtNotEqualTo(Date value) {
            addCriterion("CREATED_DT <>", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtGreaterThan(Date value) {
            addCriterion("CREATED_DT >", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATED_DT >=", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtLessThan(Date value) {
            addCriterion("CREATED_DT <", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtLessThanOrEqualTo(Date value) {
            addCriterion("CREATED_DT <=", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtIn(List<Date> values) {
            addCriterion("CREATED_DT in", values, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtNotIn(List<Date> values) {
            addCriterion("CREATED_DT not in", values, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtBetween(Date value1, Date value2) {
            addCriterion("CREATED_DT between", value1, value2, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtNotBetween(Date value1, Date value2) {
            addCriterion("CREATED_DT not between", value1, value2, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNull() {
            addCriterion("CREATED_BY is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("CREATED_BY is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(Integer value) {
            addCriterion("CREATED_BY =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(Integer value) {
            addCriterion("CREATED_BY <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(Integer value) {
            addCriterion("CREATED_BY >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(Integer value) {
            addCriterion("CREATED_BY >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(Integer value) {
            addCriterion("CREATED_BY <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(Integer value) {
            addCriterion("CREATED_BY <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<Integer> values) {
            addCriterion("CREATED_BY in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<Integer> values) {
            addCriterion("CREATED_BY not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(Integer value1, Integer value2) {
            addCriterion("CREATED_BY between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(Integer value1, Integer value2) {
            addCriterion("CREATED_BY not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andLastupdateDtIsNull() {
            addCriterion("LASTUPDATE_DT is null");
            return (Criteria) this;
        }

        public Criteria andLastupdateDtIsNotNull() {
            addCriterion("LASTUPDATE_DT is not null");
            return (Criteria) this;
        }

        public Criteria andLastupdateDtEqualTo(Date value) {
            addCriterion("LASTUPDATE_DT =", value, "lastupdateDt");
            return (Criteria) this;
        }

        public Criteria andLastupdateDtNotEqualTo(Date value) {
            addCriterion("LASTUPDATE_DT <>", value, "lastupdateDt");
            return (Criteria) this;
        }

        public Criteria andLastupdateDtGreaterThan(Date value) {
            addCriterion("LASTUPDATE_DT >", value, "lastupdateDt");
            return (Criteria) this;
        }

        public Criteria andLastupdateDtGreaterThanOrEqualTo(Date value) {
            addCriterion("LASTUPDATE_DT >=", value, "lastupdateDt");
            return (Criteria) this;
        }

        public Criteria andLastupdateDtLessThan(Date value) {
            addCriterion("LASTUPDATE_DT <", value, "lastupdateDt");
            return (Criteria) this;
        }

        public Criteria andLastupdateDtLessThanOrEqualTo(Date value) {
            addCriterion("LASTUPDATE_DT <=", value, "lastupdateDt");
            return (Criteria) this;
        }

        public Criteria andLastupdateDtIn(List<Date> values) {
            addCriterion("LASTUPDATE_DT in", values, "lastupdateDt");
            return (Criteria) this;
        }

        public Criteria andLastupdateDtNotIn(List<Date> values) {
            addCriterion("LASTUPDATE_DT not in", values, "lastupdateDt");
            return (Criteria) this;
        }

        public Criteria andLastupdateDtBetween(Date value1, Date value2) {
            addCriterion("LASTUPDATE_DT between", value1, value2, "lastupdateDt");
            return (Criteria) this;
        }

        public Criteria andLastupdateDtNotBetween(Date value1, Date value2) {
            addCriterion("LASTUPDATE_DT not between", value1, value2, "lastupdateDt");
            return (Criteria) this;
        }

        public Criteria andLastupdateByIsNull() {
            addCriterion("LASTUPDATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andLastupdateByIsNotNull() {
            addCriterion("LASTUPDATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andLastupdateByEqualTo(Integer value) {
            addCriterion("LASTUPDATE_BY =", value, "lastupdateBy");
            return (Criteria) this;
        }

        public Criteria andLastupdateByNotEqualTo(Integer value) {
            addCriterion("LASTUPDATE_BY <>", value, "lastupdateBy");
            return (Criteria) this;
        }

        public Criteria andLastupdateByGreaterThan(Integer value) {
            addCriterion("LASTUPDATE_BY >", value, "lastupdateBy");
            return (Criteria) this;
        }

        public Criteria andLastupdateByGreaterThanOrEqualTo(Integer value) {
            addCriterion("LASTUPDATE_BY >=", value, "lastupdateBy");
            return (Criteria) this;
        }

        public Criteria andLastupdateByLessThan(Integer value) {
            addCriterion("LASTUPDATE_BY <", value, "lastupdateBy");
            return (Criteria) this;
        }

        public Criteria andLastupdateByLessThanOrEqualTo(Integer value) {
            addCriterion("LASTUPDATE_BY <=", value, "lastupdateBy");
            return (Criteria) this;
        }

        public Criteria andLastupdateByIn(List<Integer> values) {
            addCriterion("LASTUPDATE_BY in", values, "lastupdateBy");
            return (Criteria) this;
        }

        public Criteria andLastupdateByNotIn(List<Integer> values) {
            addCriterion("LASTUPDATE_BY not in", values, "lastupdateBy");
            return (Criteria) this;
        }

        public Criteria andLastupdateByBetween(Integer value1, Integer value2) {
            addCriterion("LASTUPDATE_BY between", value1, value2, "lastupdateBy");
            return (Criteria) this;
        }

        public Criteria andLastupdateByNotBetween(Integer value1, Integer value2) {
            addCriterion("LASTUPDATE_BY not between", value1, value2, "lastupdateBy");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andAutherIsNull() {
            addCriterion("AUTHER is null");
            return (Criteria) this;
        }

        public Criteria andAutherIsNotNull() {
            addCriterion("AUTHER is not null");
            return (Criteria) this;
        }

        public Criteria andAutherEqualTo(String value) {
            addCriterion("AUTHER =", value, "auther");
            return (Criteria) this;
        }

        public Criteria andAutherNotEqualTo(String value) {
            addCriterion("AUTHER <>", value, "auther");
            return (Criteria) this;
        }

        public Criteria andAutherGreaterThan(String value) {
            addCriterion("AUTHER >", value, "auther");
            return (Criteria) this;
        }

        public Criteria andAutherGreaterThanOrEqualTo(String value) {
            addCriterion("AUTHER >=", value, "auther");
            return (Criteria) this;
        }

        public Criteria andAutherLessThan(String value) {
            addCriterion("AUTHER <", value, "auther");
            return (Criteria) this;
        }

        public Criteria andAutherLessThanOrEqualTo(String value) {
            addCriterion("AUTHER <=", value, "auther");
            return (Criteria) this;
        }

        public Criteria andAutherLike(String value) {
            addCriterion("AUTHER like", value, "auther");
            return (Criteria) this;
        }

        public Criteria andAutherNotLike(String value) {
            addCriterion("AUTHER not like", value, "auther");
            return (Criteria) this;
        }

        public Criteria andAutherIn(List<String> values) {
            addCriterion("AUTHER in", values, "auther");
            return (Criteria) this;
        }

        public Criteria andAutherNotIn(List<String> values) {
            addCriterion("AUTHER not in", values, "auther");
            return (Criteria) this;
        }

        public Criteria andAutherBetween(String value1, String value2) {
            addCriterion("AUTHER between", value1, value2, "auther");
            return (Criteria) this;
        }

        public Criteria andAutherNotBetween(String value1, String value2) {
            addCriterion("AUTHER not between", value1, value2, "auther");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("SUMMARY is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("SUMMARY is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("SUMMARY =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("SUMMARY <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("SUMMARY >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("SUMMARY >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("SUMMARY <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("SUMMARY <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("SUMMARY like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("SUMMARY not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("SUMMARY in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("SUMMARY not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("SUMMARY between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("SUMMARY not between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andPicturePathIsNull() {
            addCriterion("PICTURE_PATH is null");
            return (Criteria) this;
        }

        public Criteria andPicturePathIsNotNull() {
            addCriterion("PICTURE_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andPicturePathEqualTo(String value) {
            addCriterion("PICTURE_PATH =", value, "picturePath");
            return (Criteria) this;
        }

        public Criteria andPicturePathNotEqualTo(String value) {
            addCriterion("PICTURE_PATH <>", value, "picturePath");
            return (Criteria) this;
        }

        public Criteria andPicturePathGreaterThan(String value) {
            addCriterion("PICTURE_PATH >", value, "picturePath");
            return (Criteria) this;
        }

        public Criteria andPicturePathGreaterThanOrEqualTo(String value) {
            addCriterion("PICTURE_PATH >=", value, "picturePath");
            return (Criteria) this;
        }

        public Criteria andPicturePathLessThan(String value) {
            addCriterion("PICTURE_PATH <", value, "picturePath");
            return (Criteria) this;
        }

        public Criteria andPicturePathLessThanOrEqualTo(String value) {
            addCriterion("PICTURE_PATH <=", value, "picturePath");
            return (Criteria) this;
        }

        public Criteria andPicturePathLike(String value) {
            addCriterion("PICTURE_PATH like", value, "picturePath");
            return (Criteria) this;
        }

        public Criteria andPicturePathNotLike(String value) {
            addCriterion("PICTURE_PATH not like", value, "picturePath");
            return (Criteria) this;
        }

        public Criteria andPicturePathIn(List<String> values) {
            addCriterion("PICTURE_PATH in", values, "picturePath");
            return (Criteria) this;
        }

        public Criteria andPicturePathNotIn(List<String> values) {
            addCriterion("PICTURE_PATH not in", values, "picturePath");
            return (Criteria) this;
        }

        public Criteria andPicturePathBetween(String value1, String value2) {
            addCriterion("PICTURE_PATH between", value1, value2, "picturePath");
            return (Criteria) this;
        }

        public Criteria andPicturePathNotBetween(String value1, String value2) {
            addCriterion("PICTURE_PATH not between", value1, value2, "picturePath");
            return (Criteria) this;
        }

        public Criteria andPointCountIsNull() {
            addCriterion("POINT_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andPointCountIsNotNull() {
            addCriterion("POINT_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPointCountEqualTo(Integer value) {
            addCriterion("POINT_COUNT =", value, "pointCount");
            return (Criteria) this;
        }

        public Criteria andPointCountNotEqualTo(Integer value) {
            addCriterion("POINT_COUNT <>", value, "pointCount");
            return (Criteria) this;
        }

        public Criteria andPointCountGreaterThan(Integer value) {
            addCriterion("POINT_COUNT >", value, "pointCount");
            return (Criteria) this;
        }

        public Criteria andPointCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("POINT_COUNT >=", value, "pointCount");
            return (Criteria) this;
        }

        public Criteria andPointCountLessThan(Integer value) {
            addCriterion("POINT_COUNT <", value, "pointCount");
            return (Criteria) this;
        }

        public Criteria andPointCountLessThanOrEqualTo(Integer value) {
            addCriterion("POINT_COUNT <=", value, "pointCount");
            return (Criteria) this;
        }

        public Criteria andPointCountIn(List<Integer> values) {
            addCriterion("POINT_COUNT in", values, "pointCount");
            return (Criteria) this;
        }

        public Criteria andPointCountNotIn(List<Integer> values) {
            addCriterion("POINT_COUNT not in", values, "pointCount");
            return (Criteria) this;
        }

        public Criteria andPointCountBetween(Integer value1, Integer value2) {
            addCriterion("POINT_COUNT between", value1, value2, "pointCount");
            return (Criteria) this;
        }

        public Criteria andPointCountNotBetween(Integer value1, Integer value2) {
            addCriterion("POINT_COUNT not between", value1, value2, "pointCount");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("URL is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("URL is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("URL =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("URL <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("URL >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("URL >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("URL <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("URL <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("URL like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("URL not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("URL in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("URL not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("URL between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("URL not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNull() {
            addCriterion("RELEASE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNotNull() {
            addCriterion("RELEASE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeEqualTo(Date value) {
            addCriterion("RELEASE_TIME =", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotEqualTo(Date value) {
            addCriterion("RELEASE_TIME <>", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThan(Date value) {
            addCriterion("RELEASE_TIME >", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RELEASE_TIME >=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThan(Date value) {
            addCriterion("RELEASE_TIME <", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThanOrEqualTo(Date value) {
            addCriterion("RELEASE_TIME <=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIn(List<Date> values) {
            addCriterion("RELEASE_TIME in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotIn(List<Date> values) {
            addCriterion("RELEASE_TIME not in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeBetween(Date value1, Date value2) {
            addCriterion("RELEASE_TIME between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotBetween(Date value1, Date value2) {
            addCriterion("RELEASE_TIME not between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseUserIsNull() {
            addCriterion("RELEASE_USER is null");
            return (Criteria) this;
        }

        public Criteria andReleaseUserIsNotNull() {
            addCriterion("RELEASE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseUserEqualTo(Integer value) {
            addCriterion("RELEASE_USER =", value, "releaseUser");
            return (Criteria) this;
        }

        public Criteria andReleaseUserNotEqualTo(Integer value) {
            addCriterion("RELEASE_USER <>", value, "releaseUser");
            return (Criteria) this;
        }

        public Criteria andReleaseUserGreaterThan(Integer value) {
            addCriterion("RELEASE_USER >", value, "releaseUser");
            return (Criteria) this;
        }

        public Criteria andReleaseUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("RELEASE_USER >=", value, "releaseUser");
            return (Criteria) this;
        }

        public Criteria andReleaseUserLessThan(Integer value) {
            addCriterion("RELEASE_USER <", value, "releaseUser");
            return (Criteria) this;
        }

        public Criteria andReleaseUserLessThanOrEqualTo(Integer value) {
            addCriterion("RELEASE_USER <=", value, "releaseUser");
            return (Criteria) this;
        }

        public Criteria andReleaseUserIn(List<Integer> values) {
            addCriterion("RELEASE_USER in", values, "releaseUser");
            return (Criteria) this;
        }

        public Criteria andReleaseUserNotIn(List<Integer> values) {
            addCriterion("RELEASE_USER not in", values, "releaseUser");
            return (Criteria) this;
        }

        public Criteria andReleaseUserBetween(Integer value1, Integer value2) {
            addCriterion("RELEASE_USER between", value1, value2, "releaseUser");
            return (Criteria) this;
        }

        public Criteria andReleaseUserNotBetween(Integer value1, Integer value2) {
            addCriterion("RELEASE_USER not between", value1, value2, "releaseUser");
            return (Criteria) this;
        }

        public Criteria andStatIsNull() {
            addCriterion("STAT is null");
            return (Criteria) this;
        }

        public Criteria andStatIsNotNull() {
            addCriterion("STAT is not null");
            return (Criteria) this;
        }

        public Criteria andStatEqualTo(String value) {
            addCriterion("STAT =", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotEqualTo(String value) {
            addCriterion("STAT <>", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThan(String value) {
            addCriterion("STAT >", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThanOrEqualTo(String value) {
            addCriterion("STAT >=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThan(String value) {
            addCriterion("STAT <", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThanOrEqualTo(String value) {
            addCriterion("STAT <=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLike(String value) {
            addCriterion("STAT like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotLike(String value) {
            addCriterion("STAT not like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatIn(List<String> values) {
            addCriterion("STAT in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotIn(List<String> values) {
            addCriterion("STAT not in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatBetween(String value1, String value2) {
            addCriterion("STAT between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotBetween(String value1, String value2) {
            addCriterion("STAT not between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andIsHeadIsNull() {
            addCriterion("IS_HEAD is null");
            return (Criteria) this;
        }

        public Criteria andIsHeadIsNotNull() {
            addCriterion("IS_HEAD is not null");
            return (Criteria) this;
        }

        public Criteria andIsHeadEqualTo(Integer value) {
            addCriterion("IS_HEAD =", value, "isHead");
            return (Criteria) this;
        }

        public Criteria andIsHeadNotEqualTo(Integer value) {
            addCriterion("IS_HEAD <>", value, "isHead");
            return (Criteria) this;
        }

        public Criteria andIsHeadGreaterThan(Integer value) {
            addCriterion("IS_HEAD >", value, "isHead");
            return (Criteria) this;
        }

        public Criteria andIsHeadGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_HEAD >=", value, "isHead");
            return (Criteria) this;
        }

        public Criteria andIsHeadLessThan(Integer value) {
            addCriterion("IS_HEAD <", value, "isHead");
            return (Criteria) this;
        }

        public Criteria andIsHeadLessThanOrEqualTo(Integer value) {
            addCriterion("IS_HEAD <=", value, "isHead");
            return (Criteria) this;
        }

        public Criteria andIsHeadIn(List<Integer> values) {
            addCriterion("IS_HEAD in", values, "isHead");
            return (Criteria) this;
        }

        public Criteria andIsHeadNotIn(List<Integer> values) {
            addCriterion("IS_HEAD not in", values, "isHead");
            return (Criteria) this;
        }

        public Criteria andIsHeadBetween(Integer value1, Integer value2) {
            addCriterion("IS_HEAD between", value1, value2, "isHead");
            return (Criteria) this;
        }

        public Criteria andIsHeadNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_HEAD not between", value1, value2, "isHead");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("CATEGORY is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("CATEGORY is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("CATEGORY =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("CATEGORY <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("CATEGORY >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("CATEGORY >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("CATEGORY <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("CATEGORY <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("CATEGORY like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("CATEGORY not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("CATEGORY in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("CATEGORY not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("CATEGORY between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("CATEGORY not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andTitleLikeInsensitive(String value) {
            addCriterion("upper(TITLE) like", value.toUpperCase(), "title");
            return (Criteria) this;
        }

        public Criteria andAutherLikeInsensitive(String value) {
            addCriterion("upper(AUTHER) like", value.toUpperCase(), "auther");
            return (Criteria) this;
        }

        public Criteria andSummaryLikeInsensitive(String value) {
            addCriterion("upper(SUMMARY) like", value.toUpperCase(), "summary");
            return (Criteria) this;
        }

        public Criteria andPicturePathLikeInsensitive(String value) {
            addCriterion("upper(PICTURE_PATH) like", value.toUpperCase(), "picturePath");
            return (Criteria) this;
        }

        public Criteria andUrlLikeInsensitive(String value) {
            addCriterion("upper(URL) like", value.toUpperCase(), "url");
            return (Criteria) this;
        }

        public Criteria andStatLikeInsensitive(String value) {
            addCriterion("upper(STAT) like", value.toUpperCase(), "stat");
            return (Criteria) this;
        }

        public Criteria andCategoryLikeInsensitive(String value) {
            addCriterion("upper(CATEGORY) like", value.toUpperCase(), "category");
            return (Criteria) this;
        }
    }

    /**
     * crm_news
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class corresponds to the database table crm_news
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}