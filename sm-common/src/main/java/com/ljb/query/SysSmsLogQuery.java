package com.ljb.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Query
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-01 18:05:57
 */
public class SysSmsLogQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysSmsLogQuery() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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
        public Criteria andidIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andidIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andidEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andidNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andidGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andidGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andidLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andidLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andidIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andidNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andidBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andidNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }
        public Criteria anduserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria anduserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria anduserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria anduserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria anduserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria anduserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria anduserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria anduserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria anduserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria anduserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria anduserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria anduserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "user_id");
            return (Criteria) this;
        }
        public Criteria andcontentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andcontentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andcontentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andcontentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andcontentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andcontentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andcontentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andcontentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andcontentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andcontentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andcontentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andcontentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }
        public Criteria andmobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andmobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andmobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andmobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andmobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andmobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andmobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andmobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andmobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andmobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andmobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andmobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }
        public Criteria andcreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andcreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andcreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andcreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andcreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andcreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andcreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andcreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andcreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andcreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andcreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andcreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }
        public Criteria andsignIsNull() {
            addCriterion("sign is null");
            return (Criteria) this;
        }

        public Criteria andsignIsNotNull() {
            addCriterion("sign is not null");
            return (Criteria) this;
        }

        public Criteria andsignEqualTo(String value) {
            addCriterion("sign =", value, "sign");
            return (Criteria) this;
        }

        public Criteria andsignNotEqualTo(String value) {
            addCriterion("sign <>", value, "sign");
            return (Criteria) this;
        }

        public Criteria andsignGreaterThan(String value) {
            addCriterion("sign >", value, "sign");
            return (Criteria) this;
        }

        public Criteria andsignGreaterThanOrEqualTo(String value) {
            addCriterion("sign >=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andsignLessThan(String value) {
            addCriterion("sign <", value, "sign");
            return (Criteria) this;
        }

        public Criteria andsignLessThanOrEqualTo(String value) {
            addCriterion("sign <=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andsignIn(List<String> values) {
            addCriterion("sign in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andsignNotIn(List<String> values) {
            addCriterion("sign not in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andsignBetween(String value1, String value2) {
            addCriterion("sign between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andsignNotBetween(String value1, String value2) {
            addCriterion("sign not between", value1, value2, "sign");
            return (Criteria) this;
        }
        public Criteria andtypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andtypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andtypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andtypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andtypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andtypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andtypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andtypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andtypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andtypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andtypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andtypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }
        public Criteria andextnoIsNull() {
            addCriterion("extno is null");
            return (Criteria) this;
        }

        public Criteria andextnoIsNotNull() {
            addCriterion("extno is not null");
            return (Criteria) this;
        }

        public Criteria andextnoEqualTo(String value) {
            addCriterion("extno =", value, "extno");
            return (Criteria) this;
        }

        public Criteria andextnoNotEqualTo(String value) {
            addCriterion("extno <>", value, "extno");
            return (Criteria) this;
        }

        public Criteria andextnoGreaterThan(String value) {
            addCriterion("extno >", value, "extno");
            return (Criteria) this;
        }

        public Criteria andextnoGreaterThanOrEqualTo(String value) {
            addCriterion("extno >=", value, "extno");
            return (Criteria) this;
        }

        public Criteria andextnoLessThan(String value) {
            addCriterion("extno <", value, "extno");
            return (Criteria) this;
        }

        public Criteria andextnoLessThanOrEqualTo(String value) {
            addCriterion("extno <=", value, "extno");
            return (Criteria) this;
        }

        public Criteria andextnoIn(List<String> values) {
            addCriterion("extno in", values, "extno");
            return (Criteria) this;
        }

        public Criteria andextnoNotIn(List<String> values) {
            addCriterion("extno not in", values, "extno");
            return (Criteria) this;
        }

        public Criteria andextnoBetween(String value1, String value2) {
            addCriterion("extno between", value1, value2, "extno");
            return (Criteria) this;
        }

        public Criteria andextnoNotBetween(String value1, String value2) {
            addCriterion("extno not between", value1, value2, "extno");
            return (Criteria) this;
        }
        public Criteria andsendStatusIsNull() {
            addCriterion("send_status is null");
            return (Criteria) this;
        }

        public Criteria andsendStatusIsNotNull() {
            addCriterion("send_status is not null");
            return (Criteria) this;
        }

        public Criteria andsendStatusEqualTo(Integer value) {
            addCriterion("send_status =", value, "send_status");
            return (Criteria) this;
        }

        public Criteria andsendStatusNotEqualTo(Integer value) {
            addCriterion("send_status <>", value, "send_status");
            return (Criteria) this;
        }

        public Criteria andsendStatusGreaterThan(Integer value) {
            addCriterion("send_status >", value, "send_status");
            return (Criteria) this;
        }

        public Criteria andsendStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_status >=", value, "send_status");
            return (Criteria) this;
        }

        public Criteria andsendStatusLessThan(Integer value) {
            addCriterion("send_status <", value, "send_status");
            return (Criteria) this;
        }

        public Criteria andsendStatusLessThanOrEqualTo(Integer value) {
            addCriterion("send_status <=", value, "send_status");
            return (Criteria) this;
        }

        public Criteria andsendStatusIn(List<Integer> values) {
            addCriterion("send_status in", values, "send_status");
            return (Criteria) this;
        }

        public Criteria andsendStatusNotIn(List<Integer> values) {
            addCriterion("send_status not in", values, "send_status");
            return (Criteria) this;
        }

        public Criteria andsendStatusBetween(Integer value1, Integer value2) {
            addCriterion("send_status between", value1, value2, "send_status");
            return (Criteria) this;
        }

        public Criteria andsendStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("send_status not between", value1, value2, "send_status");
            return (Criteria) this;
        }
        public Criteria andsendIdIsNull() {
            addCriterion("send_id is null");
            return (Criteria) this;
        }

        public Criteria andsendIdIsNotNull() {
            addCriterion("send_id is not null");
            return (Criteria) this;
        }

        public Criteria andsendIdEqualTo(String value) {
            addCriterion("send_id =", value, "send_id");
            return (Criteria) this;
        }

        public Criteria andsendIdNotEqualTo(String value) {
            addCriterion("send_id <>", value, "send_id");
            return (Criteria) this;
        }

        public Criteria andsendIdGreaterThan(String value) {
            addCriterion("send_id >", value, "send_id");
            return (Criteria) this;
        }

        public Criteria andsendIdGreaterThanOrEqualTo(String value) {
            addCriterion("send_id >=", value, "send_id");
            return (Criteria) this;
        }

        public Criteria andsendIdLessThan(String value) {
            addCriterion("send_id <", value, "send_id");
            return (Criteria) this;
        }

        public Criteria andsendIdLessThanOrEqualTo(String value) {
            addCriterion("send_id <=", value, "send_id");
            return (Criteria) this;
        }

        public Criteria andsendIdIn(List<String> values) {
            addCriterion("send_id in", values, "send_id");
            return (Criteria) this;
        }

        public Criteria andsendIdNotIn(List<String> values) {
            addCriterion("send_id not in", values, "send_id");
            return (Criteria) this;
        }

        public Criteria andsendIdBetween(String value1, String value2) {
            addCriterion("send_id between", value1, value2, "send_id");
            return (Criteria) this;
        }

        public Criteria andsendIdNotBetween(String value1, String value2) {
            addCriterion("send_id not between", value1, value2, "send_id");
            return (Criteria) this;
        }
        public Criteria andinvalidNumIsNull() {
            addCriterion("invalid_num is null");
            return (Criteria) this;
        }

        public Criteria andinvalidNumIsNotNull() {
            addCriterion("invalid_num is not null");
            return (Criteria) this;
        }

        public Criteria andinvalidNumEqualTo(Integer value) {
            addCriterion("invalid_num =", value, "invalid_num");
            return (Criteria) this;
        }

        public Criteria andinvalidNumNotEqualTo(Integer value) {
            addCriterion("invalid_num <>", value, "invalid_num");
            return (Criteria) this;
        }

        public Criteria andinvalidNumGreaterThan(Integer value) {
            addCriterion("invalid_num >", value, "invalid_num");
            return (Criteria) this;
        }

        public Criteria andinvalidNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("invalid_num >=", value, "invalid_num");
            return (Criteria) this;
        }

        public Criteria andinvalidNumLessThan(Integer value) {
            addCriterion("invalid_num <", value, "invalid_num");
            return (Criteria) this;
        }

        public Criteria andinvalidNumLessThanOrEqualTo(Integer value) {
            addCriterion("invalid_num <=", value, "invalid_num");
            return (Criteria) this;
        }

        public Criteria andinvalidNumIn(List<Integer> values) {
            addCriterion("invalid_num in", values, "invalid_num");
            return (Criteria) this;
        }

        public Criteria andinvalidNumNotIn(List<Integer> values) {
            addCriterion("invalid_num not in", values, "invalid_num");
            return (Criteria) this;
        }

        public Criteria andinvalidNumBetween(Integer value1, Integer value2) {
            addCriterion("invalid_num between", value1, value2, "invalid_num");
            return (Criteria) this;
        }

        public Criteria andinvalidNumNotBetween(Integer value1, Integer value2) {
            addCriterion("invalid_num not between", value1, value2, "invalid_num");
            return (Criteria) this;
        }
        public Criteria andsuccessNumIsNull() {
            addCriterion("success_num is null");
            return (Criteria) this;
        }

        public Criteria andsuccessNumIsNotNull() {
            addCriterion("success_num is not null");
            return (Criteria) this;
        }

        public Criteria andsuccessNumEqualTo(Integer value) {
            addCriterion("success_num =", value, "success_num");
            return (Criteria) this;
        }

        public Criteria andsuccessNumNotEqualTo(Integer value) {
            addCriterion("success_num <>", value, "success_num");
            return (Criteria) this;
        }

        public Criteria andsuccessNumGreaterThan(Integer value) {
            addCriterion("success_num >", value, "success_num");
            return (Criteria) this;
        }

        public Criteria andsuccessNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("success_num >=", value, "success_num");
            return (Criteria) this;
        }

        public Criteria andsuccessNumLessThan(Integer value) {
            addCriterion("success_num <", value, "success_num");
            return (Criteria) this;
        }

        public Criteria andsuccessNumLessThanOrEqualTo(Integer value) {
            addCriterion("success_num <=", value, "success_num");
            return (Criteria) this;
        }

        public Criteria andsuccessNumIn(List<Integer> values) {
            addCriterion("success_num in", values, "success_num");
            return (Criteria) this;
        }

        public Criteria andsuccessNumNotIn(List<Integer> values) {
            addCriterion("success_num not in", values, "success_num");
            return (Criteria) this;
        }

        public Criteria andsuccessNumBetween(Integer value1, Integer value2) {
            addCriterion("success_num between", value1, value2, "success_num");
            return (Criteria) this;
        }

        public Criteria andsuccessNumNotBetween(Integer value1, Integer value2) {
            addCriterion("success_num not between", value1, value2, "success_num");
            return (Criteria) this;
        }
        public Criteria andblackNumIsNull() {
            addCriterion("black_num is null");
            return (Criteria) this;
        }

        public Criteria andblackNumIsNotNull() {
            addCriterion("black_num is not null");
            return (Criteria) this;
        }

        public Criteria andblackNumEqualTo(Integer value) {
            addCriterion("black_num =", value, "black_num");
            return (Criteria) this;
        }

        public Criteria andblackNumNotEqualTo(Integer value) {
            addCriterion("black_num <>", value, "black_num");
            return (Criteria) this;
        }

        public Criteria andblackNumGreaterThan(Integer value) {
            addCriterion("black_num >", value, "black_num");
            return (Criteria) this;
        }

        public Criteria andblackNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("black_num >=", value, "black_num");
            return (Criteria) this;
        }

        public Criteria andblackNumLessThan(Integer value) {
            addCriterion("black_num <", value, "black_num");
            return (Criteria) this;
        }

        public Criteria andblackNumLessThanOrEqualTo(Integer value) {
            addCriterion("black_num <=", value, "black_num");
            return (Criteria) this;
        }

        public Criteria andblackNumIn(List<Integer> values) {
            addCriterion("black_num in", values, "black_num");
            return (Criteria) this;
        }

        public Criteria andblackNumNotIn(List<Integer> values) {
            addCriterion("black_num not in", values, "black_num");
            return (Criteria) this;
        }

        public Criteria andblackNumBetween(Integer value1, Integer value2) {
            addCriterion("black_num between", value1, value2, "black_num");
            return (Criteria) this;
        }

        public Criteria andblackNumNotBetween(Integer value1, Integer value2) {
            addCriterion("black_num not between", value1, value2, "black_num");
            return (Criteria) this;
        }
        public Criteria andreturnMsgIsNull() {
            addCriterion("return_msg is null");
            return (Criteria) this;
        }

        public Criteria andreturnMsgIsNotNull() {
            addCriterion("return_msg is not null");
            return (Criteria) this;
        }

        public Criteria andreturnMsgEqualTo(String value) {
            addCriterion("return_msg =", value, "return_msg");
            return (Criteria) this;
        }

        public Criteria andreturnMsgNotEqualTo(String value) {
            addCriterion("return_msg <>", value, "return_msg");
            return (Criteria) this;
        }

        public Criteria andreturnMsgGreaterThan(String value) {
            addCriterion("return_msg >", value, "return_msg");
            return (Criteria) this;
        }

        public Criteria andreturnMsgGreaterThanOrEqualTo(String value) {
            addCriterion("return_msg >=", value, "return_msg");
            return (Criteria) this;
        }

        public Criteria andreturnMsgLessThan(String value) {
            addCriterion("return_msg <", value, "return_msg");
            return (Criteria) this;
        }

        public Criteria andreturnMsgLessThanOrEqualTo(String value) {
            addCriterion("return_msg <=", value, "return_msg");
            return (Criteria) this;
        }

        public Criteria andreturnMsgIn(List<String> values) {
            addCriterion("return_msg in", values, "return_msg");
            return (Criteria) this;
        }

        public Criteria andreturnMsgNotIn(List<String> values) {
            addCriterion("return_msg not in", values, "return_msg");
            return (Criteria) this;
        }

        public Criteria andreturnMsgBetween(String value1, String value2) {
            addCriterion("return_msg between", value1, value2, "return_msg");
            return (Criteria) this;
        }

        public Criteria andreturnMsgNotBetween(String value1, String value2) {
            addCriterion("return_msg not between", value1, value2, "return_msg");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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
