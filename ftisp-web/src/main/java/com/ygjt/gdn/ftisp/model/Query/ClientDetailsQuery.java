package com.ygjt.gdn.ftisp.model.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientDetailsQuery {
    /**
     * auth_client_details
     */
    protected String orderByClause;

    /**
     * auth_client_details
     */
    protected boolean distinct;

    /**
     * auth_client_details
     */
    protected List<Criteria> oredCriteria;

    /**
     * auth_client_details
     */
    public ClientDetailsQuery() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * auth_client_details
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * auth_client_details
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * auth_client_details
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * auth_client_details
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * auth_client_details
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * auth_client_details
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * auth_client_details
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * auth_client_details
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * auth_client_details
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * auth_client_details
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class corresponds to the database table auth_client_details
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNull() {
            addCriterion("client_id is null");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNotNull() {
            addCriterion("client_id is not null");
            return (Criteria) this;
        }

        public Criteria andClientIdEqualTo(String value) {
            addCriterion("client_id =", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotEqualTo(String value) {
            addCriterion("client_id <>", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThan(String value) {
            addCriterion("client_id >", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThanOrEqualTo(String value) {
            addCriterion("client_id >=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThan(String value) {
            addCriterion("client_id <", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThanOrEqualTo(String value) {
            addCriterion("client_id <=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLike(String value) {
            addCriterion("client_id like", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotLike(String value) {
            addCriterion("client_id not like", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdIn(List<String> values) {
            addCriterion("client_id in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotIn(List<String> values) {
            addCriterion("client_id not in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdBetween(String value1, String value2) {
            addCriterion("client_id between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotBetween(String value1, String value2) {
            addCriterion("client_id not between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andResourceIdsIsNull() {
            addCriterion("resource_ids is null");
            return (Criteria) this;
        }

        public Criteria andResourceIdsIsNotNull() {
            addCriterion("resource_ids is not null");
            return (Criteria) this;
        }

        public Criteria andResourceIdsEqualTo(String value) {
            addCriterion("resource_ids =", value, "resourceIds");
            return (Criteria) this;
        }

        public Criteria andResourceIdsNotEqualTo(String value) {
            addCriterion("resource_ids <>", value, "resourceIds");
            return (Criteria) this;
        }

        public Criteria andResourceIdsGreaterThan(String value) {
            addCriterion("resource_ids >", value, "resourceIds");
            return (Criteria) this;
        }

        public Criteria andResourceIdsGreaterThanOrEqualTo(String value) {
            addCriterion("resource_ids >=", value, "resourceIds");
            return (Criteria) this;
        }

        public Criteria andResourceIdsLessThan(String value) {
            addCriterion("resource_ids <", value, "resourceIds");
            return (Criteria) this;
        }

        public Criteria andResourceIdsLessThanOrEqualTo(String value) {
            addCriterion("resource_ids <=", value, "resourceIds");
            return (Criteria) this;
        }

        public Criteria andResourceIdsLike(String value) {
            addCriterion("resource_ids like", value, "resourceIds");
            return (Criteria) this;
        }

        public Criteria andResourceIdsNotLike(String value) {
            addCriterion("resource_ids not like", value, "resourceIds");
            return (Criteria) this;
        }

        public Criteria andResourceIdsIn(List<String> values) {
            addCriterion("resource_ids in", values, "resourceIds");
            return (Criteria) this;
        }

        public Criteria andResourceIdsNotIn(List<String> values) {
            addCriterion("resource_ids not in", values, "resourceIds");
            return (Criteria) this;
        }

        public Criteria andResourceIdsBetween(String value1, String value2) {
            addCriterion("resource_ids between", value1, value2, "resourceIds");
            return (Criteria) this;
        }

        public Criteria andResourceIdsNotBetween(String value1, String value2) {
            addCriterion("resource_ids not between", value1, value2, "resourceIds");
            return (Criteria) this;
        }

        public Criteria andClientSecretIsNull() {
            addCriterion("client_secret is null");
            return (Criteria) this;
        }

        public Criteria andClientSecretIsNotNull() {
            addCriterion("client_secret is not null");
            return (Criteria) this;
        }

        public Criteria andClientSecretEqualTo(String value) {
            addCriterion("client_secret =", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretNotEqualTo(String value) {
            addCriterion("client_secret <>", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretGreaterThan(String value) {
            addCriterion("client_secret >", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretGreaterThanOrEqualTo(String value) {
            addCriterion("client_secret >=", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretLessThan(String value) {
            addCriterion("client_secret <", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretLessThanOrEqualTo(String value) {
            addCriterion("client_secret <=", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretLike(String value) {
            addCriterion("client_secret like", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretNotLike(String value) {
            addCriterion("client_secret not like", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretIn(List<String> values) {
            addCriterion("client_secret in", values, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretNotIn(List<String> values) {
            addCriterion("client_secret not in", values, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretBetween(String value1, String value2) {
            addCriterion("client_secret between", value1, value2, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretNotBetween(String value1, String value2) {
            addCriterion("client_secret not between", value1, value2, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andScopeIsNull() {
            addCriterion("scope is null");
            return (Criteria) this;
        }

        public Criteria andScopeIsNotNull() {
            addCriterion("scope is not null");
            return (Criteria) this;
        }

        public Criteria andScopeEqualTo(String value) {
            addCriterion("scope =", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotEqualTo(String value) {
            addCriterion("scope <>", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeGreaterThan(String value) {
            addCriterion("scope >", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeGreaterThanOrEqualTo(String value) {
            addCriterion("scope >=", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeLessThan(String value) {
            addCriterion("scope <", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeLessThanOrEqualTo(String value) {
            addCriterion("scope <=", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeLike(String value) {
            addCriterion("scope like", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotLike(String value) {
            addCriterion("scope not like", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeIn(List<String> values) {
            addCriterion("scope in", values, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotIn(List<String> values) {
            addCriterion("scope not in", values, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeBetween(String value1, String value2) {
            addCriterion("scope between", value1, value2, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotBetween(String value1, String value2) {
            addCriterion("scope not between", value1, value2, "scope");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesIsNull() {
            addCriterion("authorized_grant_types is null");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesIsNotNull() {
            addCriterion("authorized_grant_types is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesEqualTo(String value) {
            addCriterion("authorized_grant_types =", value, "authorizedGrantTypes");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesNotEqualTo(String value) {
            addCriterion("authorized_grant_types <>", value, "authorizedGrantTypes");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesGreaterThan(String value) {
            addCriterion("authorized_grant_types >", value, "authorizedGrantTypes");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesGreaterThanOrEqualTo(String value) {
            addCriterion("authorized_grant_types >=", value, "authorizedGrantTypes");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesLessThan(String value) {
            addCriterion("authorized_grant_types <", value, "authorizedGrantTypes");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesLessThanOrEqualTo(String value) {
            addCriterion("authorized_grant_types <=", value, "authorizedGrantTypes");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesLike(String value) {
            addCriterion("authorized_grant_types like", value, "authorizedGrantTypes");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesNotLike(String value) {
            addCriterion("authorized_grant_types not like", value, "authorizedGrantTypes");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesIn(List<String> values) {
            addCriterion("authorized_grant_types in", values, "authorizedGrantTypes");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesNotIn(List<String> values) {
            addCriterion("authorized_grant_types not in", values, "authorizedGrantTypes");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesBetween(String value1, String value2) {
            addCriterion("authorized_grant_types between", value1, value2, "authorizedGrantTypes");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesNotBetween(String value1, String value2) {
            addCriterion("authorized_grant_types not between", value1, value2, "authorizedGrantTypes");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriIsNull() {
            addCriterion("web_server_redirect_uri is null");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriIsNotNull() {
            addCriterion("web_server_redirect_uri is not null");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriEqualTo(String value) {
            addCriterion("web_server_redirect_uri =", value, "webServerRedirectUri");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriNotEqualTo(String value) {
            addCriterion("web_server_redirect_uri <>", value, "webServerRedirectUri");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriGreaterThan(String value) {
            addCriterion("web_server_redirect_uri >", value, "webServerRedirectUri");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriGreaterThanOrEqualTo(String value) {
            addCriterion("web_server_redirect_uri >=", value, "webServerRedirectUri");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriLessThan(String value) {
            addCriterion("web_server_redirect_uri <", value, "webServerRedirectUri");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriLessThanOrEqualTo(String value) {
            addCriterion("web_server_redirect_uri <=", value, "webServerRedirectUri");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriLike(String value) {
            addCriterion("web_server_redirect_uri like", value, "webServerRedirectUri");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriNotLike(String value) {
            addCriterion("web_server_redirect_uri not like", value, "webServerRedirectUri");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriIn(List<String> values) {
            addCriterion("web_server_redirect_uri in", values, "webServerRedirectUri");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriNotIn(List<String> values) {
            addCriterion("web_server_redirect_uri not in", values, "webServerRedirectUri");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriBetween(String value1, String value2) {
            addCriterion("web_server_redirect_uri between", value1, value2, "webServerRedirectUri");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriNotBetween(String value1, String value2) {
            addCriterion("web_server_redirect_uri not between", value1, value2, "webServerRedirectUri");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesIsNull() {
            addCriterion("authorities is null");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesIsNotNull() {
            addCriterion("authorities is not null");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesEqualTo(String value) {
            addCriterion("authorities =", value, "authorities");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesNotEqualTo(String value) {
            addCriterion("authorities <>", value, "authorities");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesGreaterThan(String value) {
            addCriterion("authorities >", value, "authorities");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesGreaterThanOrEqualTo(String value) {
            addCriterion("authorities >=", value, "authorities");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesLessThan(String value) {
            addCriterion("authorities <", value, "authorities");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesLessThanOrEqualTo(String value) {
            addCriterion("authorities <=", value, "authorities");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesLike(String value) {
            addCriterion("authorities like", value, "authorities");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesNotLike(String value) {
            addCriterion("authorities not like", value, "authorities");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesIn(List<String> values) {
            addCriterion("authorities in", values, "authorities");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesNotIn(List<String> values) {
            addCriterion("authorities not in", values, "authorities");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesBetween(String value1, String value2) {
            addCriterion("authorities between", value1, value2, "authorities");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesNotBetween(String value1, String value2) {
            addCriterion("authorities not between", value1, value2, "authorities");
            return (Criteria) this;
        }

        public Criteria andAccessTokenValidityIsNull() {
            addCriterion("access_token_validity is null");
            return (Criteria) this;
        }

        public Criteria andAccessTokenValidityIsNotNull() {
            addCriterion("access_token_validity is not null");
            return (Criteria) this;
        }

        public Criteria andAccessTokenValidityEqualTo(Integer value) {
            addCriterion("access_token_validity =", value, "accessTokenValidity");
            return (Criteria) this;
        }

        public Criteria andAccessTokenValidityNotEqualTo(Integer value) {
            addCriterion("access_token_validity <>", value, "accessTokenValidity");
            return (Criteria) this;
        }

        public Criteria andAccessTokenValidityGreaterThan(Integer value) {
            addCriterion("access_token_validity >", value, "accessTokenValidity");
            return (Criteria) this;
        }

        public Criteria andAccessTokenValidityGreaterThanOrEqualTo(Integer value) {
            addCriterion("access_token_validity >=", value, "accessTokenValidity");
            return (Criteria) this;
        }

        public Criteria andAccessTokenValidityLessThan(Integer value) {
            addCriterion("access_token_validity <", value, "accessTokenValidity");
            return (Criteria) this;
        }

        public Criteria andAccessTokenValidityLessThanOrEqualTo(Integer value) {
            addCriterion("access_token_validity <=", value, "accessTokenValidity");
            return (Criteria) this;
        }

        public Criteria andAccessTokenValidityIn(List<Integer> values) {
            addCriterion("access_token_validity in", values, "accessTokenValidity");
            return (Criteria) this;
        }

        public Criteria andAccessTokenValidityNotIn(List<Integer> values) {
            addCriterion("access_token_validity not in", values, "accessTokenValidity");
            return (Criteria) this;
        }

        public Criteria andAccessTokenValidityBetween(Integer value1, Integer value2) {
            addCriterion("access_token_validity between", value1, value2, "accessTokenValidity");
            return (Criteria) this;
        }

        public Criteria andAccessTokenValidityNotBetween(Integer value1, Integer value2) {
            addCriterion("access_token_validity not between", value1, value2, "accessTokenValidity");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenValidityIsNull() {
            addCriterion("refresh_token_validity is null");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenValidityIsNotNull() {
            addCriterion("refresh_token_validity is not null");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenValidityEqualTo(Integer value) {
            addCriterion("refresh_token_validity =", value, "refreshTokenValidity");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenValidityNotEqualTo(Integer value) {
            addCriterion("refresh_token_validity <>", value, "refreshTokenValidity");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenValidityGreaterThan(Integer value) {
            addCriterion("refresh_token_validity >", value, "refreshTokenValidity");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenValidityGreaterThanOrEqualTo(Integer value) {
            addCriterion("refresh_token_validity >=", value, "refreshTokenValidity");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenValidityLessThan(Integer value) {
            addCriterion("refresh_token_validity <", value, "refreshTokenValidity");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenValidityLessThanOrEqualTo(Integer value) {
            addCriterion("refresh_token_validity <=", value, "refreshTokenValidity");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenValidityIn(List<Integer> values) {
            addCriterion("refresh_token_validity in", values, "refreshTokenValidity");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenValidityNotIn(List<Integer> values) {
            addCriterion("refresh_token_validity not in", values, "refreshTokenValidity");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenValidityBetween(Integer value1, Integer value2) {
            addCriterion("refresh_token_validity between", value1, value2, "refreshTokenValidity");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenValidityNotBetween(Integer value1, Integer value2) {
            addCriterion("refresh_token_validity not between", value1, value2, "refreshTokenValidity");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationIsNull() {
            addCriterion("additional_information is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationIsNotNull() {
            addCriterion("additional_information is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationEqualTo(String value) {
            addCriterion("additional_information =", value, "additionalInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationNotEqualTo(String value) {
            addCriterion("additional_information <>", value, "additionalInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationGreaterThan(String value) {
            addCriterion("additional_information >", value, "additionalInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationGreaterThanOrEqualTo(String value) {
            addCriterion("additional_information >=", value, "additionalInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationLessThan(String value) {
            addCriterion("additional_information <", value, "additionalInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationLessThanOrEqualTo(String value) {
            addCriterion("additional_information <=", value, "additionalInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationLike(String value) {
            addCriterion("additional_information like", value, "additionalInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationNotLike(String value) {
            addCriterion("additional_information not like", value, "additionalInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationIn(List<String> values) {
            addCriterion("additional_information in", values, "additionalInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationNotIn(List<String> values) {
            addCriterion("additional_information not in", values, "additionalInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationBetween(String value1, String value2) {
            addCriterion("additional_information between", value1, value2, "additionalInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationNotBetween(String value1, String value2) {
            addCriterion("additional_information not between", value1, value2, "additionalInformation");
            return (Criteria) this;
        }

        public Criteria andArchivedIsNull() {
            addCriterion("archived is null");
            return (Criteria) this;
        }

        public Criteria andArchivedIsNotNull() {
            addCriterion("archived is not null");
            return (Criteria) this;
        }

        public Criteria andArchivedEqualTo(Byte value) {
            addCriterion("archived =", value, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedNotEqualTo(Byte value) {
            addCriterion("archived <>", value, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedGreaterThan(Byte value) {
            addCriterion("archived >", value, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedGreaterThanOrEqualTo(Byte value) {
            addCriterion("archived >=", value, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedLessThan(Byte value) {
            addCriterion("archived <", value, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedLessThanOrEqualTo(Byte value) {
            addCriterion("archived <=", value, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedIn(List<Byte> values) {
            addCriterion("archived in", values, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedNotIn(List<Byte> values) {
            addCriterion("archived not in", values, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedBetween(Byte value1, Byte value2) {
            addCriterion("archived between", value1, value2, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedNotBetween(Byte value1, Byte value2) {
            addCriterion("archived not between", value1, value2, "archived");
            return (Criteria) this;
        }

        public Criteria andTrustedIsNull() {
            addCriterion("trusted is null");
            return (Criteria) this;
        }

        public Criteria andTrustedIsNotNull() {
            addCriterion("trusted is not null");
            return (Criteria) this;
        }

        public Criteria andTrustedEqualTo(Byte value) {
            addCriterion("trusted =", value, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedNotEqualTo(Byte value) {
            addCriterion("trusted <>", value, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedGreaterThan(Byte value) {
            addCriterion("trusted >", value, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedGreaterThanOrEqualTo(Byte value) {
            addCriterion("trusted >=", value, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedLessThan(Byte value) {
            addCriterion("trusted <", value, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedLessThanOrEqualTo(Byte value) {
            addCriterion("trusted <=", value, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedIn(List<Byte> values) {
            addCriterion("trusted in", values, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedNotIn(List<Byte> values) {
            addCriterion("trusted not in", values, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedBetween(Byte value1, Byte value2) {
            addCriterion("trusted between", value1, value2, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedNotBetween(Byte value1, Byte value2) {
            addCriterion("trusted not between", value1, value2, "trusted");
            return (Criteria) this;
        }

        public Criteria andAutoapproveIsNull() {
            addCriterion("autoapprove is null");
            return (Criteria) this;
        }

        public Criteria andAutoapproveIsNotNull() {
            addCriterion("autoapprove is not null");
            return (Criteria) this;
        }

        public Criteria andAutoapproveEqualTo(String value) {
            addCriterion("autoapprove =", value, "autoapprove");
            return (Criteria) this;
        }

        public Criteria andAutoapproveNotEqualTo(String value) {
            addCriterion("autoapprove <>", value, "autoapprove");
            return (Criteria) this;
        }

        public Criteria andAutoapproveGreaterThan(String value) {
            addCriterion("autoapprove >", value, "autoapprove");
            return (Criteria) this;
        }

        public Criteria andAutoapproveGreaterThanOrEqualTo(String value) {
            addCriterion("autoapprove >=", value, "autoapprove");
            return (Criteria) this;
        }

        public Criteria andAutoapproveLessThan(String value) {
            addCriterion("autoapprove <", value, "autoapprove");
            return (Criteria) this;
        }

        public Criteria andAutoapproveLessThanOrEqualTo(String value) {
            addCriterion("autoapprove <=", value, "autoapprove");
            return (Criteria) this;
        }

        public Criteria andAutoapproveLike(String value) {
            addCriterion("autoapprove like", value, "autoapprove");
            return (Criteria) this;
        }

        public Criteria andAutoapproveNotLike(String value) {
            addCriterion("autoapprove not like", value, "autoapprove");
            return (Criteria) this;
        }

        public Criteria andAutoapproveIn(List<String> values) {
            addCriterion("autoapprove in", values, "autoapprove");
            return (Criteria) this;
        }

        public Criteria andAutoapproveNotIn(List<String> values) {
            addCriterion("autoapprove not in", values, "autoapprove");
            return (Criteria) this;
        }

        public Criteria andAutoapproveBetween(String value1, String value2) {
            addCriterion("autoapprove between", value1, value2, "autoapprove");
            return (Criteria) this;
        }

        public Criteria andAutoapproveNotBetween(String value1, String value2) {
            addCriterion("autoapprove not between", value1, value2, "autoapprove");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNull() {
            addCriterion("created_by is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("created_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(Integer value) {
            addCriterion("created_by =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(Integer value) {
            addCriterion("created_by <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(Integer value) {
            addCriterion("created_by >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(Integer value) {
            addCriterion("created_by >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(Integer value) {
            addCriterion("created_by <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(Integer value) {
            addCriterion("created_by <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<Integer> values) {
            addCriterion("created_by in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<Integer> values) {
            addCriterion("created_by not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(Integer value1, Integer value2) {
            addCriterion("created_by between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(Integer value1, Integer value2) {
            addCriterion("created_by not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedDtIsNull() {
            addCriterion("created_dt is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDtIsNotNull() {
            addCriterion("created_dt is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDtEqualTo(Date value) {
            addCriterion("created_dt =", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtNotEqualTo(Date value) {
            addCriterion("created_dt <>", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtGreaterThan(Date value) {
            addCriterion("created_dt >", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_dt >=", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtLessThan(Date value) {
            addCriterion("created_dt <", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtLessThanOrEqualTo(Date value) {
            addCriterion("created_dt <=", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtIn(List<Date> values) {
            addCriterion("created_dt in", values, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtNotIn(List<Date> values) {
            addCriterion("created_dt not in", values, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtBetween(Date value1, Date value2) {
            addCriterion("created_dt between", value1, value2, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtNotBetween(Date value1, Date value2) {
            addCriterion("created_dt not between", value1, value2, "createdDt");
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

        public Criteria andClientIdLikeInsensitive(String value) {
            addCriterion("upper(client_id) like", value.toUpperCase(), "clientId");
            return (Criteria) this;
        }

        public Criteria andResourceIdsLikeInsensitive(String value) {
            addCriterion("upper(resource_ids) like", value.toUpperCase(), "resourceIds");
            return (Criteria) this;
        }

        public Criteria andClientSecretLikeInsensitive(String value) {
            addCriterion("upper(client_secret) like", value.toUpperCase(), "clientSecret");
            return (Criteria) this;
        }

        public Criteria andScopeLikeInsensitive(String value) {
            addCriterion("upper(scope) like", value.toUpperCase(), "scope");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesLikeInsensitive(String value) {
            addCriterion("upper(authorized_grant_types) like", value.toUpperCase(), "authorizedGrantTypes");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriLikeInsensitive(String value) {
            addCriterion("upper(web_server_redirect_uri) like", value.toUpperCase(), "webServerRedirectUri");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesLikeInsensitive(String value) {
            addCriterion("upper(authorities) like", value.toUpperCase(), "authorities");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationLikeInsensitive(String value) {
            addCriterion("upper(additional_information) like", value.toUpperCase(), "additionalInformation");
            return (Criteria) this;
        }

        public Criteria andAutoapproveLikeInsensitive(String value) {
            addCriterion("upper(autoapprove) like", value.toUpperCase(), "autoapprove");
            return (Criteria) this;
        }

        public Criteria andStsLikeInsensitive(String value) {
            addCriterion("upper(sts) like", value.toUpperCase(), "sts");
            return (Criteria) this;
        }
    }

    /**
     * auth_client_details
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class corresponds to the database table auth_client_details
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