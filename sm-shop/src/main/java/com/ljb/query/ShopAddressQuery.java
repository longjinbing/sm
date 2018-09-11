package com.ljb.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 用户地址Query
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:22
 */
public class ShopAddressQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopAddressQuery() {
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
        public Criteria andphoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andphoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andphoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andphoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andphoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andphoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andphoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andphoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andphoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andphoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andphoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andphoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }
        public Criteria andpostalCodeIsNull() {
            addCriterion("postal_code is null");
            return (Criteria) this;
        }

        public Criteria andpostalCodeIsNotNull() {
            addCriterion("postal_code is not null");
            return (Criteria) this;
        }

        public Criteria andpostalCodeEqualTo(String value) {
            addCriterion("postal_code =", value, "postal_code");
            return (Criteria) this;
        }

        public Criteria andpostalCodeNotEqualTo(String value) {
            addCriterion("postal_code <>", value, "postal_code");
            return (Criteria) this;
        }

        public Criteria andpostalCodeGreaterThan(String value) {
            addCriterion("postal_code >", value, "postal_code");
            return (Criteria) this;
        }

        public Criteria andpostalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("postal_code >=", value, "postal_code");
            return (Criteria) this;
        }

        public Criteria andpostalCodeLessThan(String value) {
            addCriterion("postal_code <", value, "postal_code");
            return (Criteria) this;
        }

        public Criteria andpostalCodeLessThanOrEqualTo(String value) {
            addCriterion("postal_code <=", value, "postal_code");
            return (Criteria) this;
        }

        public Criteria andpostalCodeIn(List<String> values) {
            addCriterion("postal_code in", values, "postal_code");
            return (Criteria) this;
        }

        public Criteria andpostalCodeNotIn(List<String> values) {
            addCriterion("postal_code not in", values, "postal_code");
            return (Criteria) this;
        }

        public Criteria andpostalCodeBetween(String value1, String value2) {
            addCriterion("postal_code between", value1, value2, "postal_code");
            return (Criteria) this;
        }

        public Criteria andpostalCodeNotBetween(String value1, String value2) {
            addCriterion("postal_code not between", value1, value2, "postal_code");
            return (Criteria) this;
        }
        public Criteria andnationalCodeIsNull() {
            addCriterion("national_code is null");
            return (Criteria) this;
        }

        public Criteria andnationalCodeIsNotNull() {
            addCriterion("national_code is not null");
            return (Criteria) this;
        }

        public Criteria andnationalCodeEqualTo(String value) {
            addCriterion("national_code =", value, "national_code");
            return (Criteria) this;
        }

        public Criteria andnationalCodeNotEqualTo(String value) {
            addCriterion("national_code <>", value, "national_code");
            return (Criteria) this;
        }

        public Criteria andnationalCodeGreaterThan(String value) {
            addCriterion("national_code >", value, "national_code");
            return (Criteria) this;
        }

        public Criteria andnationalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("national_code >=", value, "national_code");
            return (Criteria) this;
        }

        public Criteria andnationalCodeLessThan(String value) {
            addCriterion("national_code <", value, "national_code");
            return (Criteria) this;
        }

        public Criteria andnationalCodeLessThanOrEqualTo(String value) {
            addCriterion("national_code <=", value, "national_code");
            return (Criteria) this;
        }

        public Criteria andnationalCodeIn(List<String> values) {
            addCriterion("national_code in", values, "national_code");
            return (Criteria) this;
        }

        public Criteria andnationalCodeNotIn(List<String> values) {
            addCriterion("national_code not in", values, "national_code");
            return (Criteria) this;
        }

        public Criteria andnationalCodeBetween(String value1, String value2) {
            addCriterion("national_code between", value1, value2, "national_code");
            return (Criteria) this;
        }

        public Criteria andnationalCodeNotBetween(String value1, String value2) {
            addCriterion("national_code not between", value1, value2, "national_code");
            return (Criteria) this;
        }
        public Criteria andprovinceNameIsNull() {
            addCriterion("province_Name is null");
            return (Criteria) this;
        }

        public Criteria andprovinceNameIsNotNull() {
            addCriterion("province_Name is not null");
            return (Criteria) this;
        }

        public Criteria andprovinceNameEqualTo(String value) {
            addCriterion("province_Name =", value, "province_Name");
            return (Criteria) this;
        }

        public Criteria andprovinceNameNotEqualTo(String value) {
            addCriterion("province_Name <>", value, "province_Name");
            return (Criteria) this;
        }

        public Criteria andprovinceNameGreaterThan(String value) {
            addCriterion("province_Name >", value, "province_Name");
            return (Criteria) this;
        }

        public Criteria andprovinceNameGreaterThanOrEqualTo(String value) {
            addCriterion("province_Name >=", value, "province_Name");
            return (Criteria) this;
        }

        public Criteria andprovinceNameLessThan(String value) {
            addCriterion("province_Name <", value, "province_Name");
            return (Criteria) this;
        }

        public Criteria andprovinceNameLessThanOrEqualTo(String value) {
            addCriterion("province_Name <=", value, "province_Name");
            return (Criteria) this;
        }

        public Criteria andprovinceNameIn(List<String> values) {
            addCriterion("province_Name in", values, "province_Name");
            return (Criteria) this;
        }

        public Criteria andprovinceNameNotIn(List<String> values) {
            addCriterion("province_Name not in", values, "province_Name");
            return (Criteria) this;
        }

        public Criteria andprovinceNameBetween(String value1, String value2) {
            addCriterion("province_Name between", value1, value2, "province_Name");
            return (Criteria) this;
        }

        public Criteria andprovinceNameNotBetween(String value1, String value2) {
            addCriterion("province_Name not between", value1, value2, "province_Name");
            return (Criteria) this;
        }
        public Criteria andcityNameIsNull() {
            addCriterion("city_Name is null");
            return (Criteria) this;
        }

        public Criteria andcityNameIsNotNull() {
            addCriterion("city_Name is not null");
            return (Criteria) this;
        }

        public Criteria andcityNameEqualTo(String value) {
            addCriterion("city_Name =", value, "city_Name");
            return (Criteria) this;
        }

        public Criteria andcityNameNotEqualTo(String value) {
            addCriterion("city_Name <>", value, "city_Name");
            return (Criteria) this;
        }

        public Criteria andcityNameGreaterThan(String value) {
            addCriterion("city_Name >", value, "city_Name");
            return (Criteria) this;
        }

        public Criteria andcityNameGreaterThanOrEqualTo(String value) {
            addCriterion("city_Name >=", value, "city_Name");
            return (Criteria) this;
        }

        public Criteria andcityNameLessThan(String value) {
            addCriterion("city_Name <", value, "city_Name");
            return (Criteria) this;
        }

        public Criteria andcityNameLessThanOrEqualTo(String value) {
            addCriterion("city_Name <=", value, "city_Name");
            return (Criteria) this;
        }

        public Criteria andcityNameIn(List<String> values) {
            addCriterion("city_Name in", values, "city_Name");
            return (Criteria) this;
        }

        public Criteria andcityNameNotIn(List<String> values) {
            addCriterion("city_Name not in", values, "city_Name");
            return (Criteria) this;
        }

        public Criteria andcityNameBetween(String value1, String value2) {
            addCriterion("city_Name between", value1, value2, "city_Name");
            return (Criteria) this;
        }

        public Criteria andcityNameNotBetween(String value1, String value2) {
            addCriterion("city_Name not between", value1, value2, "city_Name");
            return (Criteria) this;
        }
        public Criteria andcountyNameIsNull() {
            addCriterion("county_Name is null");
            return (Criteria) this;
        }

        public Criteria andcountyNameIsNotNull() {
            addCriterion("county_Name is not null");
            return (Criteria) this;
        }

        public Criteria andcountyNameEqualTo(String value) {
            addCriterion("county_Name =", value, "county_Name");
            return (Criteria) this;
        }

        public Criteria andcountyNameNotEqualTo(String value) {
            addCriterion("county_Name <>", value, "county_Name");
            return (Criteria) this;
        }

        public Criteria andcountyNameGreaterThan(String value) {
            addCriterion("county_Name >", value, "county_Name");
            return (Criteria) this;
        }

        public Criteria andcountyNameGreaterThanOrEqualTo(String value) {
            addCriterion("county_Name >=", value, "county_Name");
            return (Criteria) this;
        }

        public Criteria andcountyNameLessThan(String value) {
            addCriterion("county_Name <", value, "county_Name");
            return (Criteria) this;
        }

        public Criteria andcountyNameLessThanOrEqualTo(String value) {
            addCriterion("county_Name <=", value, "county_Name");
            return (Criteria) this;
        }

        public Criteria andcountyNameIn(List<String> values) {
            addCriterion("county_Name in", values, "county_Name");
            return (Criteria) this;
        }

        public Criteria andcountyNameNotIn(List<String> values) {
            addCriterion("county_Name not in", values, "county_Name");
            return (Criteria) this;
        }

        public Criteria andcountyNameBetween(String value1, String value2) {
            addCriterion("county_Name between", value1, value2, "county_Name");
            return (Criteria) this;
        }

        public Criteria andcountyNameNotBetween(String value1, String value2) {
            addCriterion("county_Name not between", value1, value2, "county_Name");
            return (Criteria) this;
        }
        public Criteria anddetailInfoIsNull() {
            addCriterion("detail_Info is null");
            return (Criteria) this;
        }

        public Criteria anddetailInfoIsNotNull() {
            addCriterion("detail_Info is not null");
            return (Criteria) this;
        }

        public Criteria anddetailInfoEqualTo(String value) {
            addCriterion("detail_Info =", value, "detail_Info");
            return (Criteria) this;
        }

        public Criteria anddetailInfoNotEqualTo(String value) {
            addCriterion("detail_Info <>", value, "detail_Info");
            return (Criteria) this;
        }

        public Criteria anddetailInfoGreaterThan(String value) {
            addCriterion("detail_Info >", value, "detail_Info");
            return (Criteria) this;
        }

        public Criteria anddetailInfoGreaterThanOrEqualTo(String value) {
            addCriterion("detail_Info >=", value, "detail_Info");
            return (Criteria) this;
        }

        public Criteria anddetailInfoLessThan(String value) {
            addCriterion("detail_Info <", value, "detail_Info");
            return (Criteria) this;
        }

        public Criteria anddetailInfoLessThanOrEqualTo(String value) {
            addCriterion("detail_Info <=", value, "detail_Info");
            return (Criteria) this;
        }

        public Criteria anddetailInfoIn(List<String> values) {
            addCriterion("detail_Info in", values, "detail_Info");
            return (Criteria) this;
        }

        public Criteria anddetailInfoNotIn(List<String> values) {
            addCriterion("detail_Info not in", values, "detail_Info");
            return (Criteria) this;
        }

        public Criteria anddetailInfoBetween(String value1, String value2) {
            addCriterion("detail_Info between", value1, value2, "detail_Info");
            return (Criteria) this;
        }

        public Criteria anddetailInfoNotBetween(String value1, String value2) {
            addCriterion("detail_Info not between", value1, value2, "detail_Info");
            return (Criteria) this;
        }
        public Criteria andisDefaultIsNull() {
            addCriterion("is_default is null");
            return (Criteria) this;
        }

        public Criteria andisDefaultIsNotNull() {
            addCriterion("is_default is not null");
            return (Criteria) this;
        }

        public Criteria andisDefaultEqualTo(Integer value) {
            addCriterion("is_default =", value, "is_default");
            return (Criteria) this;
        }

        public Criteria andisDefaultNotEqualTo(Integer value) {
            addCriterion("is_default <>", value, "is_default");
            return (Criteria) this;
        }

        public Criteria andisDefaultGreaterThan(Integer value) {
            addCriterion("is_default >", value, "is_default");
            return (Criteria) this;
        }

        public Criteria andisDefaultGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_default >=", value, "is_default");
            return (Criteria) this;
        }

        public Criteria andisDefaultLessThan(Integer value) {
            addCriterion("is_default <", value, "is_default");
            return (Criteria) this;
        }

        public Criteria andisDefaultLessThanOrEqualTo(Integer value) {
            addCriterion("is_default <=", value, "is_default");
            return (Criteria) this;
        }

        public Criteria andisDefaultIn(List<Integer> values) {
            addCriterion("is_default in", values, "is_default");
            return (Criteria) this;
        }

        public Criteria andisDefaultNotIn(List<Integer> values) {
            addCriterion("is_default not in", values, "is_default");
            return (Criteria) this;
        }

        public Criteria andisDefaultBetween(Integer value1, Integer value2) {
            addCriterion("is_default between", value1, value2, "is_default");
            return (Criteria) this;
        }

        public Criteria andisDefaultNotBetween(Integer value1, Integer value2) {
            addCriterion("is_default not between", value1, value2, "is_default");
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
