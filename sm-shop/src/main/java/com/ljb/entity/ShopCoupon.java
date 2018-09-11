package com.ljb.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;

/**
 * 优惠券管理实体
 * 表名 shop_coupon
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:21
 */
@TableName("shop_coupon")
public class ShopCoupon extends Model<ShopCoupon> implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    @TableId(type=IdType.AUTO)
    private Integer id;
	//优惠券名称
	private String name;
	//价值
	private BigDecimal money;
	//状态
	private Integer status;
	//启用价格
	private BigDecimal minAmount;
	//最高折扣
	private BigDecimal maxAmount;
	//开始使用时间
	private Date useStartDate;
	//过期时间
	private Date useEndDate;
	//描述
	private String desc;
	//创建时间
	private Date createTime;
	//创建人
	private Integer createId;
	//更新时间
	private Date updateTime;
	//更新人
	private Integer updateId;

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
     * 设置：优惠券名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：优惠券名称
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：价值
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * 获取：价值
     */
    public BigDecimal getMoney() {
        return money;
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
     * 设置：启用价格
     */
    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    /**
     * 获取：启用价格
     */
    public BigDecimal getMinAmount() {
        return minAmount;
    }
    /**
     * 设置：最高折扣
     */
    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    /**
     * 获取：最高折扣
     */
    public BigDecimal getMaxAmount() {
        return maxAmount;
    }
    /**
     * 设置：开始使用时间
     */
    public void setUseStartDate(Date useStartDate) {
        this.useStartDate = useStartDate;
    }

    /**
     * 获取：开始使用时间
     */
    public Date getUseStartDate() {
        return useStartDate;
    }
    /**
     * 设置：过期时间
     */
    public void setUseEndDate(Date useEndDate) {
        this.useEndDate = useEndDate;
    }

    /**
     * 获取：过期时间
     */
    public Date getUseEndDate() {
        return useEndDate;
    }
    /**
     * 设置：描述
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 获取：描述
     */
    public String getDesc() {
        return desc;
    }
    /**
     * 设置：创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }
    /**
     * 设置：创建人
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * 获取：创建人
     */
    public Integer getCreateId() {
        return createId;
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
     * 设置：更新人
     */
    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    /**
     * 获取：更新人
     */
    public Integer getUpdateId() {
        return updateId;
    }
	@Override
	protected Serializable pkVal() {
	// TODO 自动生成的方法存根
	return this.id;
    }
}
