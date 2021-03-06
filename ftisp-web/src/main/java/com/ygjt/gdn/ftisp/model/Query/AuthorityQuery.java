package com.ygjt.gdn.ftisp.model.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuthorityQuery {
    /**
     * auth_authority
     */
    protected String orderByClause;

    /**
     * auth_authority
     */
    protected boolean distinct;

    /**
     * auth_authority
     */
    protected List<Criteria> oredCriteria;

    /**
     * auth_authority
     */
    public AuthorityQuery() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * auth_authority
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * auth_authority
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * auth_authority
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * auth_authority
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * auth_authority
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * auth_authority
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * auth_authority
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * auth_authority
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * auth_authority
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * auth_authority
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class corresponds to the database table auth_authority
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

        public Criteria andAuthorityMarkIsNull() {
            addCriterion("AUTHORITY_MARK is null");
            return (Criteria) this;
        }

        public Criteria andAuthorityMarkIsNotNull() {
            addCriterion("AUTHORITY_MARK is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorityMarkEqualTo(String value) {
            addCriterion("AUTHORITY_MARK =", value, "authorityMark");
            return (Criteria) this;
        }

        public Criteria andAuthorityMarkNotEqualTo(String value) {
            addCriterion("AUTHORITY_MARK <>", value, "authorityMark");
            return (Criteria) this;
        }

        public Criteria andAuthorityMarkGreaterThan(String value) {
            addCriterion("AUTHORITY_MARK >", value, "authorityMark");
            return (Criteria) this;
        }

        public Criteria andAuthorityMarkGreaterThanOrEqualTo(String value) {
            addCriterion("AUTHORITY_MARK >=", value, "authorityMark");
            return (Criteria) this;
        }

        public Criteria andAuthorityMarkLessThan(String value) {
            addCriterion("AUTHORITY_MARK <", value, "authorityMark");
            return (Criteria) this;
        }

        public Criteria andAuthorityMarkLessThanOrEqualTo(String value) {
            addCriterion("AUTHORITY_MARK <=", value, "authorityMark");
            return (Criteria) this;
        }

        public Criteria andAuthorityMarkLike(String value) {
            addCriterion("AUTHORITY_MARK like", value, "authorityMark");
            return (Criteria) this;
        }

        public Criteria andAuthorityMarkNotLike(String value) {
            addCriterion("AUTHORITY_MARK not like", value, "authorityMark");
            return (Criteria) this;
        }

        public Criteria andAuthorityMarkIn(List<String> values) {
            addCriterion("AUTHORITY_MARK in", values, "authorityMark");
            return (Criteria) this;
        }

        public Criteria andAuthorityMarkNotIn(List<String> values) {
            addCriterion("AUTHORITY_MARK not in", values, "authorityMark");
            return (Criteria) this;
        }

        public Criteria andAuthorityMarkBetween(String value1, String value2) {
            addCriterion("AUTHORITY_MARK between", value1, value2, "authorityMark");
            return (Criteria) this;
        }

        public Criteria andAuthorityMarkNotBetween(String value1, String value2) {
            addCriterion("AUTHORITY_MARK not between", value1, value2, "authorityMark");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameIsNull() {
            addCriterion("AUTHORITY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameIsNotNull() {
            addCriterion("AUTHORITY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameEqualTo(String value) {
            addCriterion("AUTHORITY_NAME =", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameNotEqualTo(String value) {
            addCriterion("AUTHORITY_NAME <>", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameGreaterThan(String value) {
            addCriterion("AUTHORITY_NAME >", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameGreaterThanOrEqualTo(String value) {
            addCriterion("AUTHORITY_NAME >=", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameLessThan(String value) {
            addCriterion("AUTHORITY_NAME <", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameLessThanOrEqualTo(String value) {
            addCriterion("AUTHORITY_NAME <=", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameLike(String value) {
            addCriterion("AUTHORITY_NAME like", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameNotLike(String value) {
            addCriterion("AUTHORITY_NAME not like", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameIn(List<String> values) {
            addCriterion("AUTHORITY_NAME in", values, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameNotIn(List<String> values) {
            addCriterion("AUTHORITY_NAME not in", values, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameBetween(String value1, String value2) {
            addCriterion("AUTHORITY_NAME between", value1, value2, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameNotBetween(String value1, String value2) {
            addCriterion("AUTHORITY_NAME not between", value1, value2, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityDescIsNull() {
            addCriterion("AUTHORITY_DESC is null");
            return (Criteria) this;
        }

        public Criteria andAuthorityDescIsNotNull() {
            addCriterion("AUTHORITY_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorityDescEqualTo(String value) {
            addCriterion("AUTHORITY_DESC =", value, "authorityDesc");
            return (Criteria) this;
        }

        public Criteria andAuthorityDescNotEqualTo(String value) {
            addCriterion("AUTHORITY_DESC <>", value, "authorityDesc");
            return (Criteria) this;
        }

        public Criteria andAuthorityDescGreaterThan(String value) {
            addCriterion("AUTHORITY_DESC >", value, "authorityDesc");
            return (Criteria) this;
        }

        public Criteria andAuthorityDescGreaterThanOrEqualTo(String value) {
            addCriterion("AUTHORITY_DESC >=", value, "authorityDesc");
            return (Criteria) this;
        }

        public Criteria andAuthorityDescLessThan(String value) {
            addCriterion("AUTHORITY_DESC <", value, "authorityDesc");
            return (Criteria) this;
        }

        public Criteria andAuthorityDescLessThanOrEqualTo(String value) {
            addCriterion("AUTHORITY_DESC <=", value, "authorityDesc");
            return (Criteria) this;
        }

        public Criteria andAuthorityDescLike(String value) {
            addCriterion("AUTHORITY_DESC like", value, "authorityDesc");
            return (Criteria) this;
        }

        public Criteria andAuthorityDescNotLike(String value) {
            addCriterion("AUTHORITY_DESC not like", value, "authorityDesc");
            return (Criteria) this;
        }

        public Criteria andAuthorityDescIn(List<String> values) {
            addCriterion("AUTHORITY_DESC in", values, "authorityDesc");
            return (Criteria) this;
        }

        public Criteria andAuthorityDescNotIn(List<String> values) {
            addCriterion("AUTHORITY_DESC not in", values, "authorityDesc");
            return (Criteria) this;
        }

        public Criteria andAuthorityDescBetween(String value1, String value2) {
            addCriterion("AUTHORITY_DESC between", value1, value2, "authorityDesc");
            return (Criteria) this;
        }

        public Criteria andAuthorityDescNotBetween(String value1, String value2) {
            addCriterion("AUTHORITY_DESC not between", value1, value2, "authorityDesc");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("MESSAGE is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("MESSAGE is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("MESSAGE =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("MESSAGE <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("MESSAGE >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("MESSAGE >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("MESSAGE <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("MESSAGE <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("MESSAGE like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("MESSAGE not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("MESSAGE in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("MESSAGE not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("MESSAGE between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("MESSAGE not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andEnableIsNull() {
            addCriterion("ENABLE is null");
            return (Criteria) this;
        }

        public Criteria andEnableIsNotNull() {
            addCriterion("ENABLE is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEqualTo(String value) {
            addCriterion("ENABLE =", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualTo(String value) {
            addCriterion("ENABLE <>", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThan(String value) {
            addCriterion("ENABLE >", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualTo(String value) {
            addCriterion("ENABLE >=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThan(String value) {
            addCriterion("ENABLE <", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualTo(String value) {
            addCriterion("ENABLE <=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLike(String value) {
            addCriterion("ENABLE like", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotLike(String value) {
            addCriterion("ENABLE not like", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableIn(List<String> values) {
            addCriterion("ENABLE in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotIn(List<String> values) {
            addCriterion("ENABLE not in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableBetween(String value1, String value2) {
            addCriterion("ENABLE between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotBetween(String value1, String value2) {
            addCriterion("ENABLE not between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andIssysIsNull() {
            addCriterion("ISSYS is null");
            return (Criteria) this;
        }

        public Criteria andIssysIsNotNull() {
            addCriterion("ISSYS is not null");
            return (Criteria) this;
        }

        public Criteria andIssysEqualTo(String value) {
            addCriterion("ISSYS =", value, "issys");
            return (Criteria) this;
        }

        public Criteria andIssysNotEqualTo(String value) {
            addCriterion("ISSYS <>", value, "issys");
            return (Criteria) this;
        }

        public Criteria andIssysGreaterThan(String value) {
            addCriterion("ISSYS >", value, "issys");
            return (Criteria) this;
        }

        public Criteria andIssysGreaterThanOrEqualTo(String value) {
            addCriterion("ISSYS >=", value, "issys");
            return (Criteria) this;
        }

        public Criteria andIssysLessThan(String value) {
            addCriterion("ISSYS <", value, "issys");
            return (Criteria) this;
        }

        public Criteria andIssysLessThanOrEqualTo(String value) {
            addCriterion("ISSYS <=", value, "issys");
            return (Criteria) this;
        }

        public Criteria andIssysLike(String value) {
            addCriterion("ISSYS like", value, "issys");
            return (Criteria) this;
        }

        public Criteria andIssysNotLike(String value) {
            addCriterion("ISSYS not like", value, "issys");
            return (Criteria) this;
        }

        public Criteria andIssysIn(List<String> values) {
            addCriterion("ISSYS in", values, "issys");
            return (Criteria) this;
        }

        public Criteria andIssysNotIn(List<String> values) {
            addCriterion("ISSYS not in", values, "issys");
            return (Criteria) this;
        }

        public Criteria andIssysBetween(String value1, String value2) {
            addCriterion("ISSYS between", value1, value2, "issys");
            return (Criteria) this;
        }

        public Criteria andIssysNotBetween(String value1, String value2) {
            addCriterion("ISSYS not between", value1, value2, "issys");
            return (Criteria) this;
        }

        public Criteria andModuleIdIsNull() {
            addCriterion("MODULE_ID is null");
            return (Criteria) this;
        }

        public Criteria andModuleIdIsNotNull() {
            addCriterion("MODULE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andModuleIdEqualTo(Integer value) {
            addCriterion("MODULE_ID =", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotEqualTo(Integer value) {
            addCriterion("MODULE_ID <>", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdGreaterThan(Integer value) {
            addCriterion("MODULE_ID >", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("MODULE_ID >=", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdLessThan(Integer value) {
            addCriterion("MODULE_ID <", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdLessThanOrEqualTo(Integer value) {
            addCriterion("MODULE_ID <=", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdIn(List<Integer> values) {
            addCriterion("MODULE_ID in", values, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotIn(List<Integer> values) {
            addCriterion("MODULE_ID not in", values, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdBetween(Integer value1, Integer value2) {
            addCriterion("MODULE_ID between", value1, value2, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("MODULE_ID not between", value1, value2, "moduleId");
            return (Criteria) this;
        }

        public Criteria andCreateDtIsNull() {
            addCriterion("create_dt is null");
            return (Criteria) this;
        }

        public Criteria andCreateDtIsNotNull() {
            addCriterion("create_dt is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDtEqualTo(Date value) {
            addCriterion("create_dt =", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtNotEqualTo(Date value) {
            addCriterion("create_dt <>", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtGreaterThan(Date value) {
            addCriterion("create_dt >", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtGreaterThanOrEqualTo(Date value) {
            addCriterion("create_dt >=", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtLessThan(Date value) {
            addCriterion("create_dt <", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtLessThanOrEqualTo(Date value) {
            addCriterion("create_dt <=", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtIn(List<Date> values) {
            addCriterion("create_dt in", values, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtNotIn(List<Date> values) {
            addCriterion("create_dt not in", values, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtBetween(Date value1, Date value2) {
            addCriterion("create_dt between", value1, value2, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtNotBetween(Date value1, Date value2) {
            addCriterion("create_dt not between", value1, value2, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(Integer value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Integer value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Integer value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Integer value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Integer value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Integer> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Integer> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Integer value1, Integer value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Integer value1, Integer value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDtIsNull() {
            addCriterion("last_update_dt is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDtIsNotNull() {
            addCriterion("last_update_dt is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDtEqualTo(Date value) {
            addCriterion("last_update_dt =", value, "lastUpdateDt");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDtNotEqualTo(Date value) {
            addCriterion("last_update_dt <>", value, "lastUpdateDt");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDtGreaterThan(Date value) {
            addCriterion("last_update_dt >", value, "lastUpdateDt");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDtGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update_dt >=", value, "lastUpdateDt");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDtLessThan(Date value) {
            addCriterion("last_update_dt <", value, "lastUpdateDt");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDtLessThanOrEqualTo(Date value) {
            addCriterion("last_update_dt <=", value, "lastUpdateDt");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDtIn(List<Date> values) {
            addCriterion("last_update_dt in", values, "lastUpdateDt");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDtNotIn(List<Date> values) {
            addCriterion("last_update_dt not in", values, "lastUpdateDt");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDtBetween(Date value1, Date value2) {
            addCriterion("last_update_dt between", value1, value2, "lastUpdateDt");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDtNotBetween(Date value1, Date value2) {
            addCriterion("last_update_dt not between", value1, value2, "lastUpdateDt");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByIsNull() {
            addCriterion("last_update_by is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByIsNotNull() {
            addCriterion("last_update_by is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByEqualTo(Integer value) {
            addCriterion("last_update_by =", value, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByNotEqualTo(Integer value) {
            addCriterion("last_update_by <>", value, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByGreaterThan(Integer value) {
            addCriterion("last_update_by >", value, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_update_by >=", value, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByLessThan(Integer value) {
            addCriterion("last_update_by <", value, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByLessThanOrEqualTo(Integer value) {
            addCriterion("last_update_by <=", value, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByIn(List<Integer> values) {
            addCriterion("last_update_by in", values, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByNotIn(List<Integer> values) {
            addCriterion("last_update_by not in", values, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByBetween(Integer value1, Integer value2) {
            addCriterion("last_update_by between", value1, value2, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByNotBetween(Integer value1, Integer value2) {
            addCriterion("last_update_by not between", value1, value2, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andStsIsNull() {
            addCriterion("sts is null");
            return (Criteria) this;
        }

        public Criteria andStsIsNotNull() {
            addCriterion("sts is not null");
            return (Criteria) this;
        }

        public Criteria andStsEqualTo(String value) {
            addCriterion("sts =", value, "sts");
            return (Criteria) this;
        }

        public Criteria andStsNotEqualTo(String value) {
            addCriterion("sts <>", value, "sts");
            return (Criteria) this;
        }

        public Criteria andStsGreaterThan(String value) {
            addCriterion("sts >", value, "sts");
            return (Criteria) this;
        }

        public Criteria andStsGreaterThanOrEqualTo(String value) {
            addCriterion("sts >=", value, "sts");
            return (Criteria) this;
        }

        public Criteria andStsLessThan(String value) {
            addCriterion("sts <", value, "sts");
            return (Criteria) this;
        }

        public Criteria andStsLessThanOrEqualTo(String value) {
            addCriterion("sts <=", value, "sts");
            return (Criteria) this;
        }

        public Criteria andStsLike(String value) {
            addCriterion("sts like", value, "sts");
            return (Criteria) this;
        }

        public Criteria andStsNotLike(String value) {
            addCriterion("sts not like", value, "sts");
            return (Criteria) this;
        }

        public Criteria andStsIn(List<String> values) {
            addCriterion("sts in", values, "sts");
            return (Criteria) this;
        }

        public Criteria andStsNotIn(List<String> values) {
            addCriterion("sts not in", values, "sts");
            return (Criteria) this;
        }

        public Criteria andStsBetween(String value1, String value2) {
            addCriterion("sts between", value1, value2, "sts");
            return (Criteria) this;
        }

        public Criteria andStsNotBetween(String value1, String value2) {
            addCriterion("sts not between", value1, value2, "sts");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNull() {
            addCriterion("SYSTEM_ID is null");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNotNull() {
            addCriterion("SYSTEM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSystemIdEqualTo(Integer value) {
            addCriterion("SYSTEM_ID =", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotEqualTo(Integer value) {
            addCriterion("SYSTEM_ID <>", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThan(Integer value) {
            addCriterion("SYSTEM_ID >", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SYSTEM_ID >=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThan(Integer value) {
            addCriterion("SYSTEM_ID <", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThanOrEqualTo(Integer value) {
            addCriterion("SYSTEM_ID <=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdIn(List<Integer> values) {
            addCriterion("SYSTEM_ID in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotIn(List<Integer> values) {
            addCriterion("SYSTEM_ID not in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdBetween(Integer value1, Integer value2) {
            addCriterion("SYSTEM_ID between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SYSTEM_ID not between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andAuthorityMarkLikeInsensitive(String value) {
            addCriterion("upper(AUTHORITY_MARK) like", value.toUpperCase(), "authorityMark");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameLikeInsensitive(String value) {
            addCriterion("upper(AUTHORITY_NAME) like", value.toUpperCase(), "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityDescLikeInsensitive(String value) {
            addCriterion("upper(AUTHORITY_DESC) like", value.toUpperCase(), "authorityDesc");
            return (Criteria) this;
        }

        public Criteria andMessageLikeInsensitive(String value) {
            addCriterion("upper(MESSAGE) like", value.toUpperCase(), "message");
            return (Criteria) this;
        }

        public Criteria andEnableLikeInsensitive(String value) {
            addCriterion("upper(ENABLE) like", value.toUpperCase(), "enable");
            return (Criteria) this;
        }

        public Criteria andIssysLikeInsensitive(String value) {
            addCriterion("upper(ISSYS) like", value.toUpperCase(), "issys");
            return (Criteria) this;
        }

        public Criteria andStsLikeInsensitive(String value) {
            addCriterion("upper(sts) like", value.toUpperCase(), "sts");
            return (Criteria) this;
        }
    }

    /**
     * auth_authority
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class corresponds to the database table auth_authority
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