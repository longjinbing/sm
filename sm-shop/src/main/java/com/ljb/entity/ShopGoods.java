package com.ljb.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;

/**
 * 商品管理实体
 * 表名 shop_goods
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:22
 */
@TableName("shop_goods")
public class ShopGoods extends Model<ShopGoods> implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    @TableId(type=IdType.AUTO)
    private Integer id;
	//分类ID
	private Integer categoryId;
	//商品编号
	private String goodsSn;
	//标题
	private String title;
	//商品描述
	private String goodsDesc;
	//商品主图
	private String primaryPicUrl;
	//商品列表图
	private String listPicUrl;
	//销售量
	private Integer sellNumber;
	//特点
	private String character;
	//价格
	private BigDecimal price;
	//市场价格
	private BigDecimal marketPrice;
	//创建人ID
	private Integer createId;
	//修改人ID
	private Integer updateId;
	//添加事件
	private Date createTime;
	//修改时间
	private Date updateTime;
	//邮费
	private BigDecimal shippingFee;

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
     * 设置：分类ID
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取：分类ID
     */
    public Integer getCategoryId() {
        return categoryId;
    }
    /**
     * 设置：商品编号
     */
    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    /**
     * 获取：商品编号
     */
    public String getGoodsSn() {
        return goodsSn;
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
     * 设置：商品描述
     */
    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    /**
     * 获取：商品描述
     */
    public String getGoodsDesc() {
        return goodsDesc;
    }
    /**
     * 设置：商品主图
     */
    public void setPrimaryPicUrl(String primaryPicUrl) {
        this.primaryPicUrl = primaryPicUrl;
    }

    /**
     * 获取：商品主图
     */
    public String getPrimaryPicUrl() {
        return primaryPicUrl;
    }
    /**
     * 设置：商品列表图
     */
    public void setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl;
    }

    /**
     * 获取：商品列表图
     */
    public String getListPicUrl() {
        return listPicUrl;
    }
    /**
     * 设置：销售量
     */
    public void setSellNumber(Integer sellNumber) {
        this.sellNumber = sellNumber;
    }

    /**
     * 获取：销售量
     */
    public Integer getSellNumber() {
        return sellNumber;
    }
    /**
     * 设置：特点
     */
    public void setCharacter(String character) {
        this.character = character;
    }

    /**
     * 获取：特点
     */
    public String getCharacter() {
        return character;
    }
    /**
     * 设置：价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取：价格
     */
    public BigDecimal getPrice() {
        return price;
    }
    /**
     * 设置：市场价格
     */
    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * 获取：市场价格
     */
    public BigDecimal getMarketPrice() {
        return marketPrice;
    }
    /**
     * 设置：创建人ID
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * 获取：创建人ID
     */
    public Integer getCreateId() {
        return createId;
    }
    /**
     * 设置：修改人ID
     */
    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    /**
     * 获取：修改人ID
     */
    public Integer getUpdateId() {
        return updateId;
    }
    /**
     * 设置：添加事件
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：添加事件
     */
    public Date getCreateTime() {
        return createTime;
    }
    /**
     * 设置：修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取：修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
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
	@Override
	protected Serializable pkVal() {
	// TODO 自动生成的方法存根
	return this.id;
    }
}
