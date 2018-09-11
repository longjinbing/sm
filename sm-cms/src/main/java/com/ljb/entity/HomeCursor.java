package com.ljb.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 首页轮播实体
 * 表名 home_cursor
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-05 13:08:46
 */
@TableName("home_cursor")
public class HomeCursor extends Model<HomeCursor> implements Serializable {
    private static final long serialVersionUID = 1L;

    //id
    @TableId(type=IdType.AUTO)
    private Integer id;
	//名称
	private String name;
	//链接
	private String url;
	//图片
	private String picurl;
	//排序
	private Integer orderNum;
	//创建时间
	private Date createTime;

    /**
     * 设置：id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：id
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：名称
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：链接
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取：链接
     */
    public String getUrl() {
        return url;
    }
    /**
     * 设置：图片
     */
    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    /**
     * 获取：图片
     */
    public String getPicurl() {
        return picurl;
    }
    /**
     * 设置：排序
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取：排序
     */
    public Integer getOrderNum() {
        return orderNum;
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
	@Override
	protected Serializable pkVal() {
	// TODO 自动生成的方法存根
	return this.id;
    }
}
