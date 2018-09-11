package com.ljb.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;

/**
 * 订单详情实体
 * 表名 shop_order_details
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 17:06:39
 */
@TableName("shop_order_details")
public class ShopOrderDetails extends Model<ShopOrderDetails> implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    @TableId(type=IdType.AUTO)
    private Integer id;
	//订单id
	private Integer orderId;
	//商品id
	private Integer goodsId;
	//下单价格
	private BigDecimal price;
	//图片
	private String picUrl;
	//标题
	private String title;
	//数量
	private Integer number;

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
     * 设置：订单id
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取：订单id
     */
    public Integer getOrderId() {
        return orderId;
    }
    /**
     * 设置：商品id
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取：商品id
     */
    public Integer getGoodsId() {
        return goodsId;
    }
    /**
     * 设置：下单价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取：下单价格
     */
    public BigDecimal getPrice() {
        return price;
    }
    /**
     * 设置：图片
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    /**
     * 获取：图片
     */
    public String getPicUrl() {
        return picUrl;
    }
    /**
     * 设置：标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取：标题
     */
    public String getTitle() {
        return title;
    }
    /**
     * 设置：数量
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 获取：数量
     */
    public Integer getNumber() {
        return number;
    }
	@Override
	protected Serializable pkVal() {
	// TODO 自动生成的方法存根
	return this.id;
    }
}
