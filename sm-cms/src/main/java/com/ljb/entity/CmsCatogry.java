package com.ljb.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 目录实体
 * 表名 cms_catogry
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-05 13:28:31
 */
@TableName("cms_catogry")
public class CmsCatogry extends Model<CmsCatogry> implements Serializable {
    private static final long serialVersionUID = 1L;

    //目录ID
    @TableId(type=IdType.AUTO)
    private Integer id;
	//父Id
	private Integer parentId;
	//名称
	private String name;
	//
	private String desc;
	//排序
	private Integer orderNum;
	//状态
	private Integer status;
	//创建者
	private Integer createId;
	//创建时间
	private Date createTime;
	//
	private Date updateTime;

    /**
     * 设置：目录ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：目录ID
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：父Id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取：父Id
     */
    public Integer getParentId() {
        return parentId;
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
     * 设置：
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 获取：
     */
    public String getDesc() {
        return desc;
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
     * 设置：创建者
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * 获取：创建者
     */
    public Integer getCreateId() {
        return createId;
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
     * 设置：
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取：
     */
    public Date getUpdateTime() {
        return updateTime;
    }
	@Override
	protected Serializable pkVal() {
	// TODO 自动生成的方法存根
	return this.id;
    }
}
