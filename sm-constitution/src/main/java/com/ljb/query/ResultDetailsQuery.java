package com.ljb.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 体质测试结果详情Query
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-08 17:18:14
 */
public class ResultDetailsQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResultDetailsQuery() {
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
        public Criteria andresultIdIsNull() {
            addCriterion("result_id is null");
            return (Criteria) this;
        }

        public Criteria andresultIdIsNotNull() {
            addCriterion("result_id is not null");
            return (Criteria) this;
        }

        public Criteria andresultIdEqualTo(Integer value) {
            addCriterion("result_id =", value, "result_id");
            return (Criteria) this;
        }

        public Criteria andresultIdNotEqualTo(Integer value) {
            addCriterion("result_id <>", value, "result_id");
            return (Criteria) this;
        }

        public Criteria andresultIdGreaterThan(Integer value) {
            addCriterion("result_id >", value, "result_id");
            return (Criteria) this;
        }

        public Criteria andresultIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("result_id >=", value, "result_id");
            return (Criteria) this;
        }

        public Criteria andresultIdLessThan(Integer value) {
            addCriterion("result_id <", value, "result_id");
            return (Criteria) this;
        }

        public Criteria andresultIdLessThanOrEqualTo(Integer value) {
            addCriterion("result_id <=", value, "result_id");
            return (Criteria) this;
        }

        public Criteria andresultIdIn(List<Integer> values) {
            addCriterion("result_id in", values, "result_id");
            return (Criteria) this;
        }

        public Criteria andresultIdNotIn(List<Integer> values) {
            addCriterion("result_id not in", values, "result_id");
            return (Criteria) this;
        }

        public Criteria andresultIdBetween(Integer value1, Integer value2) {
            addCriterion("result_id between", value1, value2, "result_id");
            return (Criteria) this;
        }

        public Criteria andresultIdNotBetween(Integer value1, Integer value2) {
            addCriterion("result_id not between", value1, value2, "result_id");
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
        public Criteria andresultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andresultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andresultEqualTo(Integer value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andresultNotEqualTo(Integer value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andresultGreaterThan(Integer value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andresultGreaterThanOrEqualTo(Integer value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andresultLessThan(Integer value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andresultLessThanOrEqualTo(Integer value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andresultIn(List<Integer> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andresultNotIn(List<Integer> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andresultBetween(Integer value1, Integer value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andresultNotBetween(Integer value1, Integer value2) {
            addCriterion("result not between", value1, value2, "result");
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
