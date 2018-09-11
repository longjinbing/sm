package com.ljb.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;

/**
 * 订单管理实体
 * 表名 shop_order
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:22
 */
@TableName("shop_order")
public class ShopOrder extends Model<ShopOrder> implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    @TableId(type=IdType.AUTO)
    private Integer id;
	//订单号
	private String orderSn;
	//用户id
	private Integer userId;
	//状态
	private Integer status;
	//支付状态
	private Integer payStatus;
	//国家
	private String country;
	//省份
	private String province;
	//城市
	private String city;
	//区
	private String district;
	//详细地址
	private String address;
	//手机号
	private String phone;
	//邮编
	private String postscript;
	//邮费
	private BigDecimal shippingFee;
	//实际需要支付的金额
	private BigDecimal actualPrice;
	//订单总价
	private BigDecimal orderPrice;
	//商品总价
	private BigDecimal goodsPrice;
	//下单时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//支付时间
	private Date payTime;
	//配送费用
	private Integer freightPrice;
	//总订单Id
	private Integer parentId;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：订单号
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    /**
     * 获取：订单号
     */
    public String getOrderSn() {
        return orderSn;
    }
    /**
     * 设置：用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取：用户id
     */
    public Integer getUserId() {
        return userId;
    }
    /**
     * 设置：状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：状态
     */
    public Integer getStatus() {
        return status;
    }
    /**
     * 设置：支付状态
     */
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * 获取：支付状态
     */
    public Integer getPayStatus() {
        return payStatus;
    }
    /**
     * 设置：国家
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 获取：国家
     */
    public String getCountry() {
        return country;
    }
    /**
     * 设置：省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取：省份
     */
    public String getProvince() {
        return province;
    }
    /**
     * 设置：城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取：城市
     */
    public String getCity() {
        return city;
    }
    /**
     * 设置：区
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * 获取：区
     */
    public String getDistrict() {
        return district;
    }
    /**
     * 设置：详细地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取：详细地址
     */
    public String getAddress() {
        return address;
    }
    /**
     * 设置：手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取：手机号
     */
    public String getPhone() {
        return phone;
    }
    /**
     * 设置：邮编
     */
    public void setPostscript(String postscript) {
        this.postscript = postscript;
    }

    /**
     * 获取：邮编
     */
    public String getPostscript() {
        return postscript;
    }
    /**
     * 设置：邮费
     */
    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    /**
     * 获取：邮费
     */
    public BigDecimal getShippingFee() {
        return shippingFee;
    }
    /**
     * 设置：实际需要支付的金额
     */
    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    /**
     * 获取：实际需要支付的金额
     */
    public BigDecimal getActualPrice() {
        return actualPrice;
    }
    /**
     * 设置：订单总价
     */
    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * 获取：订单总价
     */
    public BigDecimal getOrderPrice() {
        return orderPrice;
    }
    /**
     * 设置：商品总价
     */
    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    /**
     * 获取：商品总价
     */
    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }
    /**
     * 设置：下单时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：下单时间
     */
    public Date getCreateTime() {
        return createTime;
    }
    /**
     * 设置：更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取：更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }
    /**
     * 设置：支付时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取：支付时间
     */
    public Date getPayTime() {
        return payTime;
    }
    /**
     * 设置：配送费用
     */
    public void setFreightPrice(Integer freightPrice) {
        this.freightPrice = freightPrice;
    }

    /**
     * 获取：配送费用
     */
    public Integer getFreightPrice() {
        return freightPrice;
    }
    /**
     * 设置：总订单Id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取：总订单Id
     */
    public Integer getParentId() {
        return parentId;
    }
	@Override
	protected Serializable pkVal() {
	// TODO 自动生成的方法存根
	return this.id;
    }
}
