package com.ljb.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 体质测试结果Query
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-07 18:22:42
 */
public class ConstitutionResultQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConstitutionResultQuery() {
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

        public Criteria andidEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andidNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andidGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andidGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andidLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andidLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andidIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andidNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andidBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andidNotBetween(Integer value1, Integer value2) {
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
        public Criteria andconstitutionIdIsNull() {
            addCriterion("constitution_id is null");
            return (Criteria) this;
        }

        public Criteria andconstitutionIdIsNotNull() {
            addCriterion("constitution_id is not null");
            return (Criteria) this;
        }

        public Criteria andconstitutionIdEqualTo(Integer value) {
            addCriterion("constitution_id =", value, "constitution_id");
            return (Criteria) this;
        }

        public Criteria andconstitutionIdNotEqualTo(Integer value) {
            addCriterion("constitution_id <>", value, "constitution_id");
            return (Criteria) this;
        }

        public Criteria andconstitutionIdGreaterThan(Integer value) {
            addCriterion("constitution_id >", value, "constitution_id");
            return (Criteria) this;
        }

        public Criteria andconstitutionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("constitution_id >=", value, "constitution_id");
            return (Criteria) this;
        }

        public Criteria andconstitutionIdLessThan(Integer value) {
            addCriterion("constitution_id <", value, "constitution_id");
            return (Criteria) this;
        }

        public Criteria andconstitutionIdLessThanOrEqualTo(Integer value) {
            addCriterion("constitution_id <=", value, "constitution_id");
            return (Criteria) this;
        }

        public Criteria andconstitutionIdIn(List<Integer> values) {
            addCriterion("constitution_id in", values, "constitution_id");
            return (Criteria) this;
        }

        public Criteria andconstitutionIdNotIn(List<Integer> values) {
            addCriterion("constitution_id not in", values, "constitution_id");
            return (Criteria) this;
        }

        public Criteria andconstitutionIdBetween(Integer value1, Integer value2) {
            addCriterion("constitution_id between", value1, value2, "constitution_id");
            return (Criteria) this;
        }

        public Criteria andconstitutionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("constitution_id not between", value1, value2, "constitution_id");
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
        public Criteria andcreateIdIsNull() {
            addCriterion("create_id is null");
            return (Criteria) this;
        }

        public Criteria andcreateIdIsNotNull() {
            addCriterion("create_id is not null");
            return (Criteria) this;
        }

        public Criteria andcreateIdEqualTo(Integer value) {
            addCriterion("create_id =", value, "create_id");
            return (Criteria) this;
        }

        public Criteria andcreateIdNotEqualTo(Integer value) {
            addCriterion("create_id <>", value, "create_id");
            return (Criteria) this;
        }

        public Criteria andcreateIdGreaterThan(Integer value) {
            addCriterion("create_id >", value, "create_id");
            return (Criteria) this;
        }

        public Criteria andcreateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_id >=", value, "create_id");
            return (Criteria) this;
        }

        public Criteria andcreateIdLessThan(Integer value) {
            addCriterion("create_id <", value, "create_id");
            return (Criteria) this;
        }

        public Criteria andcreateIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_id <=", value, "create_id");
            return (Criteria) this;
        }

        public Criteria andcreateIdIn(List<Integer> values) {
            addCriterion("create_id in", values, "create_id");
            return (Criteria) this;
        }

        public Criteria andcreateIdNotIn(List<Integer> values) {
            addCriterion("create_id not in", values, "create_id");
            return (Criteria) this;
        }

        public Criteria andcreateIdBetween(Integer value1, Integer value2) {
            addCriterion("create_id between", value1, value2, "create_id");
            return (Criteria) this;
        }

        public Criteria andcreateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_id not between", value1, value2, "create_id");
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