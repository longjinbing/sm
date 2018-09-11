package com.ljb.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;

/**
 * 体质管理实体
 * 表名 constitution
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-07 18:22:42
 */
@TableName("constitution")
public class Constitution extends Model<Constitution> implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    @TableId(type=IdType.AUTO)
    private Integer id;
	//体质名称
	private String name;
	//体质描述
	private String desc;
	//体质特征
	private String character;
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
     * 设置：体质名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：体质名称
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：体质描述
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 获取：体质描述
     */
    public String getDesc() {
        return desc;
    }
    /**
     * 设置：体质特征
     */
    public void setCharacter(String character) {
        this.character = character;
    }

    /**
     * 获取：体质特征
     */
    public String getCharacter() {
        return character;
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
