package com.ljb.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 商品管理Query
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:22
 */
public class ShopGoodsQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopGoodsQuery() {
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
        public Criteria andcategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andcategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andcategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "category_id");
            return (Criteria) this;
        }

        public Criteria andcategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "category_id");
            return (Criteria) this;
        }

        public Criteria andcategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "category_id");
            return (Criteria) this;
        }

        public Criteria andcategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "category_id");
            return (Criteria) this;
        }

        public Criteria andcategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "category_id");
            return (Criteria) this;
        }

        public Criteria andcategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "category_id");
            return (Criteria) this;
        }

        public Criteria andcategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "category_id");
            return (Criteria) this;
        }

        public Criteria andcategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "category_id");
            return (Criteria) this;
        }

        public Criteria andcategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "category_id");
            return (Criteria) this;
        }

        public Criteria andcategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "category_id");
            return (Criteria) this;
        }
        public Criteria andgoodsSnIsNull() {
            addCriterion("goods_sn is null");
            return (Criteria) this;
        }

        public Criteria andgoodsSnIsNotNull() {
            addCriterion("goods_sn is not null");
            return (Criteria) this;
        }

        public Criteria andgoodsSnEqualTo(String value) {
            addCriterion("goods_sn =", value, "goods_sn");
            return (Criteria) this;
        }

        public Criteria andgoodsSnNotEqualTo(String value) {
            addCriterion("goods_sn <>", value, "goods_sn");
            return (Criteria) this;
        }

        public Criteria andgoodsSnGreaterThan(String value) {
            addCriterion("goods_sn >", value, "goods_sn");
            return (Criteria) this;
        }

        public Criteria andgoodsSnGreaterThanOrEqualTo(String value) {
            addCriterion("goods_sn >=", value, "goods_sn");
            return (Criteria) this;
        }

        public Criteria andgoodsSnLessThan(String value) {
            addCriterion("goods_sn <", value, "goods_sn");
            return (Criteria) this;
        }

        public Criteria andgoodsSnLessThanOrEqualTo(String value) {
            addCriterion("goods_sn <=", value, "goods_sn");
            return (Criteria) this;
        }

        public Criteria andgoodsSnIn(List<String> values) {
            addCriterion("goods_sn in", values, "goods_sn");
            return (Criteria) this;
        }

        public Criteria andgoodsSnNotIn(List<String> values) {
            addCriterion("goods_sn not in", values, "goods_sn");
            return (Criteria) this;
        }

        public Criteria andgoodsSnBetween(String value1, String value2) {
            addCriterion("goods_sn between", value1, value2, "goods_sn");
            return (Criteria) this;
        }

        public Criteria andgoodsSnNotBetween(String value1, String value2) {
            addCriterion("goods_sn not between", value1, value2, "goods_sn");
            return (Criteria) this;
        }
        public Criteria andtitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andtitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andtitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andtitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andtitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andtitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andtitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andtitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andtitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andtitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andtitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andtitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }
        public Criteria andgoodsDescIsNull() {
            addCriterion("goods_desc is null");
            return (Criteria) this;
        }

        public Criteria andgoodsDescIsNotNull() {
            addCriterion("goods_desc is not null");
            return (Criteria) this;
        }

        public Criteria andgoodsDescEqualTo(String value) {
            addCriterion("goods_desc =", value, "goods_desc");
            return (Criteria) this;
        }

        public Criteria andgoodsDescNotEqualTo(String value) {
            addCriterion("goods_desc <>", value, "goods_desc");
            return (Criteria) this;
        }

        public Criteria andgoodsDescGreaterThan(String value) {
            addCriterion("goods_desc >", value, "goods_desc");
            return (Criteria) this;
        }

        public Criteria andgoodsDescGreaterThanOrEqualTo(String value) {
            addCriterion("goods_desc >=", value, "goods_desc");
            return (Criteria) this;
        }

        public Criteria andgoodsDescLessThan(String value) {
            addCriterion("goods_desc <", value, "goods_desc");
            return (Criteria) this;
        }

        public Criteria andgoodsDescLessThanOrEqualTo(String value) {
            addCriterion("goods_desc <=", value, "goods_desc");
            return (Criteria) this;
        }

        public Criteria andgoodsDescIn(List<String> values) {
            addCriterion("goods_desc in", values, "goods_desc");
            return (Criteria) this;
        }

        public Criteria andgoodsDescNotIn(List<String> values) {
            addCriterion("goods_desc not in", values, "goods_desc");
            return (Criteria) this;
        }

        public Criteria andgoodsDescBetween(String value1, String value2) {
            addCriterion("goods_desc between", value1, value2, "goods_desc");
            return (Criteria) this;
        }

        public Criteria andgoodsDescNotBetween(String value1, String value2) {
            addCriterion("goods_desc not between", value1, value2, "goods_desc");
            return (Criteria) this;
        }
        public Criteria andprimaryPicUrlIsNull() {
            addCriterion("primary_pic_url is null");
            return (Criteria) this;
        }

        public Criteria andprimaryPicUrlIsNotNull() {
            addCriterion("primary_pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andprimaryPicUrlEqualTo(String value) {
            addCriterion("primary_pic_url =", value, "primary_pic_url");
            return (Criteria) this;
        }

        public Criteria andprimaryPicUrlNotEqualTo(String value) {
            addCriterion("primary_pic_url <>", value, "primary_pic_url");
            return (Criteria) this;
        }

        public Criteria andprimaryPicUrlGreaterThan(String value) {
            addCriterion("primary_pic_url >", value, "primary_pic_url");
            return (Criteria) this;
        }

        public Criteria andprimaryPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("primary_pic_url >=", value, "primary_pic_url");
            return (Criteria) this;
        }

        public Criteria andprimaryPicUrlLessThan(String value) {
            addCriterion("primary_pic_url <", value, "primary_pic_url");
            return (Criteria) this;
        }

        public Criteria andprimaryPicUrlLessThanOrEqualTo(String value) {
            addCriterion("primary_pic_url <=", value, "primary_pic_url");
            return (Criteria) this;
        }

        public Criteria andprimaryPicUrlIn(List<String> values) {
            addCriterion("primary_pic_url in", values, "primary_pic_url");
            return (Criteria) this;
        }

        public Criteria andprimaryPicUrlNotIn(List<String> values) {
            addCriterion("primary_pic_url not in", values, "primary_pic_url");
            return (Criteria) this;
        }

        public Criteria andprimaryPicUrlBetween(String value1, String value2) {
            addCriterion("primary_pic_url between", value1, value2, "primary_pic_url");
            return (Criteria) this;
        }

        public Criteria andprimaryPicUrlNotBetween(String value1, String value2) {
            addCriterion("primary_pic_url not between", value1, value2, "primary_pic_url");
            return (Criteria) this;
        }
        public Criteria andlistPicUrlIsNull() {
            addCriterion("list_pic_url is null");
            return (Criteria) this;
        }

        public Criteria andlistPicUrlIsNotNull() {
            addCriterion("list_pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andlistPicUrlEqualTo(String value) {
            addCriterion("list_pic_url =", value, "list_pic_url");
            return (Criteria) this;
        }

        public Criteria andlistPicUrlNotEqualTo(String value) {
            addCriterion("list_pic_url <>", value, "list_pic_url");
            return (Criteria) this;
        }

        public Criteria andlistPicUrlGreaterThan(String value) {
            addCriterion("list_pic_url >", value, "list_pic_url");
            return (Criteria) this;
        }

        public Criteria andlistPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("list_pic_url >=", value, "list_pic_url");
            return (Criteria) this;
        }

        public Criteria andlistPicUrlLessThan(String value) {
            addCriterion("list_pic_url <", value, "list_pic_url");
            return (Criteria) this;
        }

        public Criteria andlistPicUrlLessThanOrEqualTo(String value) {
            addCriterion("list_pic_url <=", value, "list_pic_url");
            return (Criteria) this;
        }

        public Criteria andlistPicUrlIn(List<String> values) {
            addCriterion("list_pic_url in", values, "list_pic_url");
            return (Criteria) this;
        }

        public Criteria andlistPicUrlNotIn(List<String> values) {
            addCriterion("list_pic_url not in", values, "list_pic_url");
            return (Criteria) this;
        }

        public Criteria andlistPicUrlBetween(String value1, String value2) {
            addCriterion("list_pic_url between", value1, value2, "list_pic_url");
            return (Criteria) this;
        }

        public Criteria andlistPicUrlNotBetween(String value1, String value2) {
            addCriterion("list_pic_url not between", value1, value2, "list_pic_url");
            return (Criteria) this;
        }
        public Criteria andsellNumberIsNull() {
            addCriterion("sell_number is null");
            return (Criteria) this;
        }

        public Criteria andsellNumberIsNotNull() {
            addCriterion("sell_number is not null");
            return (Criteria) this;
        }

        public Criteria andsellNumberEqualTo(Integer value) {
            addCriterion("sell_number =", value, "sell_number");
            return (Criteria) this;
        }

        public Criteria andsellNumberNotEqualTo(Integer value) {
            addCriterion("sell_number <>", value, "sell_number");
            return (Criteria) this;
        }

        public Criteria andsellNumberGreaterThan(Integer value) {
            addCriterion("sell_number >", value, "sell_number");
            return (Criteria) this;
        }

        public Criteria andsellNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("sell_number >=", value, "sell_number");
            return (Criteria) this;
        }

        public Criteria andsellNumberLessThan(Integer value) {
            addCriterion("sell_number <", value, "sell_number");
            return (Criteria) this;
        }

        public Criteria andsellNumberLessThanOrEqualTo(Integer value) {
            addCriterion("sell_number <=", value, "sell_number");
            return (Criteria) this;
        }

        public Criteria andsellNumberIn(List<Integer> values) {
            addCriterion("sell_number in", values, "sell_number");
            return (Criteria) this;
        }

        public Criteria andsellNumberNotIn(List<Integer> values) {
            addCriterion("sell_number not in", values, "sell_number");
            return (Criteria) this;
        }

        public Criteria andsellNumberBetween(Integer value1, Integer value2) {
            addCriterion("sell_number between", value1, value2, "sell_number");
            return (Criteria) this;
        }

        public Criteria andsellNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("sell_number not between", value1, value2, "sell_number");
            return (Criteria) this;
        }
        public Criteria andcharacterIsNull() {
            addCriterion("character is null");
            return (Criteria) this;
        }

        public Criteria andcharacterIsNotNull() {
            addCriterion("character is not null");
            return (Criteria) this;
        }

        public Criteria andcharacterEqualTo(String value) {
            addCriterion("character =", value, "character");
            return (Criteria) this;
        }

        public Criteria andcharacterNotEqualTo(String value) {
            addCriterion("character <>", value, "character");
            return (Criteria) this;
        }

        public Criteria andcharacterGreaterThan(String value) {
            addCriterion("character >", value, "character");
            return (Criteria) this;
        }

        public Criteria andcharacterGreaterThanOrEqualTo(String value) {
            addCriterion("character >=", value, "character");
            return (Criteria) this;
        }

        public Criteria andcharacterLessThan(String value) {
            addCriterion("character <", value, "character");
            return (Criteria) this;
        }

        public Criteria andcharacterLessThanOrEqualTo(String value) {
            addCriterion("character <=", value, "character");
            return (Criteria) this;
        }

        public Criteria andcharacterIn(List<String> values) {
            addCriterion("character in", values, "character");
            return (Criteria) this;
        }

        public Criteria andcharacterNotIn(List<String> values) {
            addCriterion("character not in", values, "character");
            return (Criteria) this;
        }

        public Criteria andcharacterBetween(String value1, String value2) {
            addCriterion("character between", value1, value2, "character");
            return (Criteria) this;
        }

        public Criteria andcharacterNotBetween(String value1, String value2) {
            addCriterion("character not between", value1, value2, "character");
            return (Criteria) this;
        }
        public Criteria andpriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andpriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andpriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andpriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andpriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andpriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andpriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andpriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }
        public Criteria andmarketPriceIsNull() {
            addCriterion("market_price is null");
            return (Criteria) this;
        }

        public Criteria andmarketPriceIsNotNull() {
            addCriterion("market_price is not null");
            return (Criteria) this;
        }

        public Criteria andmarketPriceEqualTo(BigDecimal value) {
            addCriterion("market_price =", value, "market_price");
            return (Criteria) this;
        }

        public Criteria andmarketPriceNotEqualTo(BigDecimal value) {
            addCriterion("market_price <>", value, "market_price");
            return (Criteria) this;
        }

        public Criteria andmarketPriceGreaterThan(BigDecimal value) {
            addCriterion("market_price >", value, "market_price");
            return (Criteria) this;
        }

        public Criteria andmarketPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("market_price >=", value, "market_price");
            return (Criteria) this;
        }

        public Criteria andmarketPriceLessThan(BigDecimal value) {
            addCriterion("market_price <", value, "market_price");
            return (Criteria) this;
        }

        public Criteria andmarketPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("market_price <=", value, "market_price");
            return (Criteria) this;
        }

        public Criteria andmarketPriceIn(List<BigDecimal> values) {
            addCriterion("market_price in", values, "market_price");
            return (Criteria) this;
        }

        public Criteria andmarketPriceNotIn(List<BigDecimal> values) {
            addCriterion("market_price not in", values, "market_price");
            return (Criteria) this;
        }

        public Criteria andmarketPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("market_price between", value1, value2, "market_price");
            return (Criteria) this;
        }

        public Criteria andmarketPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("market_price not between", value1, value2, "market_price");
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
        public Criteria andupdateIdIsNull() {
            addCriterion("update_id is null");
            return (Criteria) this;
        }

        public Criteria andupdateIdIsNotNull() {
            addCriterion("update_id is not null");
            return (Criteria) this;
        }

        public Criteria andupdateIdEqualTo(Integer value) {
            addCriterion("update_id =", value, "update_id");
            return (Criteria) this;
        }

        public Criteria andupdateIdNotEqualTo(Integer value) {
            addCriterion("update_id <>", value, "update_id");
            return (Criteria) this;
        }

        public Criteria andupdateIdGreaterThan(Integer value) {
            addCriterion("update_id >", value, "update_id");
            return (Criteria) this;
        }

        public Criteria andupdateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_id >=", value, "update_id");
            return (Criteria) this;
        }

        public Criteria andupdateIdLessThan(Integer value) {
            addCriterion("update_id <", value, "update_id");
            return (Criteria) this;
        }

        public Criteria andupdateIdLessThanOrEqualTo(Integer value) {
            addCriterion("update_id <=", value, "update_id");
            return (Criteria) this;
        }

        public Criteria andupdateIdIn(List<Integer> values) {
            addCriterion("update_id in", values, "update_id");
            return (Criteria) this;
        }

        public Criteria andupdateIdNotIn(List<Integer> values) {
            addCriterion("update_id not in", values, "update_id");
            return (Criteria) this;
        }

        public Criteria andupdateIdBetween(Integer value1, Integer value2) {
            addCriterion("update_id between", value1, value2, "update_id");
            return (Criteria) this;
        }

        public Criteria andupdateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("update_id not between", value1, value2, "update_id");
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
        public Criteria andupdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andupdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andupdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andupdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andupdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andupdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andupdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andupdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andupdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andupdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andupdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andupdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "update_time");
            return (Criteria) this;
        }
        public Criteria andshippingFeeIsNull() {
            addCriterion("shipping_fee is null");
            return (Criteria) this;
        }

        public Criteria andshippingFeeIsNotNull() {
            addCriterion("shipping_fee is not null");
            return (Criteria) this;
        }

        public Criteria andshippingFeeEqualTo(BigDecimal value) {
            addCriterion("shipping_fee =", value, "shipping_fee");
            return (Criteria) this;
        }

        public Criteria andshippingFeeNotEqualTo(BigDecimal value) {
            addCriterion("shipping_fee <>", value, "shipping_fee");
            return (Criteria) this;
        }

        public Criteria andshippingFeeGreaterThan(BigDecimal value) {
            addCriterion("shipping_fee >", value, "shipping_fee");
            return (Criteria) this;
        }

        public Criteria andshippingFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_fee >=", value, "shipping_fee");
            return (Criteria) this;
        }

        public Criteria andshippingFeeLessThan(BigDecimal value) {
            addCriterion("shipping_fee <", value, "shipping_fee");
            return (Criteria) this;
        }

        public Criteria andshippingFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_fee <=", value, "shipping_fee");
            return (Criteria) this;
        }

        public Criteria andshippingFeeIn(List<BigDecimal> values) {
            addCriterion("shipping_fee in", values, "shipping_fee");
            return (Criteria) this;
        }

        public Criteria andshippingFeeNotIn(List<BigDecimal> values) {
            addCriterion("shipping_fee not in", values, "shipping_fee");
            return (Criteria) this;
        }

        public Criteria andshippingFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_fee between", value1, value2, "shipping_fee");
            return (Criteria) this;
        }

        public Criteria andshippingFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_fee not between", value1, value2, "shipping_fee");
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
