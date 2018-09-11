package com.ljb.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;

/**
 * 用户地址实体
 * 表名 shop_address
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:22
 */
@TableName("shop_address")
public class ShopAddress extends Model<ShopAddress> implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    @TableId(type=IdType.AUTO)
    private Integer id;
	//会员ID
	private Integer userId;
	//手机
	private String phone;
	//邮编
	private String postalCode;
	//收货地址国家码
	private String nationalCode;
	//省
	private String provinceName;
	//市
	private String cityName;
	//区
	private String countyName;
	//详细收货地址信息
	private String detailInfo;
	//是否是默认地址
	private Integer isDefault;

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
     * 设置：会员ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取：会员ID
     */
    public Integer getUserId() {
        return userId;
    }
    /**
     * 设置：手机
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取：手机
     */
    public String getPhone() {
        return phone;
    }
    /**
     * 设置：邮编
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * 获取：邮编
     */
    public String getPostalCode() {
        return postalCode;
    }
    /**
     * 设置：收货地址国家码
     */
    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    /**
     * 获取：收货地址国家码
     */
    public String getNationalCode() {
        return nationalCode;
    }
    /**
     * 设置：省
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /**
     * 获取：省
     */
    public String getProvinceName() {
        return provinceName;
    }
    /**
     * 设置：市
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * 获取：市
     */
    public String getCityName() {
        return cityName;
    }
    /**
     * 设置：区
     */
    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    /**
     * 获取：区
     */
    public String getCountyName() {
        return countyName;
    }
    /**
     * 设置：详细收货地址信息
     */
    public void setDetailInfo(String detailInfo) {
        this.detailInfo = detailInfo;
    }

    /**
     * 获取：详细收货地址信息
     */
    public String getDetailInfo() {
        return detailInfo;
    }
    /**
     * 设置：是否是默认地址
     */
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * 获取：是否是默认地址
     */
    public Integer getIsDefault() {
        return isDefault;
    }
	@Override
	protected Serializable pkVal() {
	// TODO 自动生成的方法存根
	return this.id;
    }
}
