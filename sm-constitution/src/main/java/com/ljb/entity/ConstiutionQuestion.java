package com.ljb.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;

/**
 * 体质测试问题实体
 * 表名 constiution_question
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-08 16:58:16
 */
@TableName("constiution_question")
public class ConstiutionQuestion extends Model<ConstiutionQuestion> implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    @TableId(type=IdType.AUTO)
    private Integer id;
	//问题
	private String question;
	//创建时间
	private Date createTime;
	//创建人
	private Integer createId;
	//体质Id
	private Integer constiutionId;
	//
	private Date updateTime;
	//
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
     * 设置：问题
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * 获取：问题
     */
    public String getQuestion() {
        return question;
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
     * 设置：体质Id
     */
    public void setConstiutionId(Integer constiutionId) {
        this.constiutionId = constiutionId;
    }

    /**
     * 获取：体质Id
     */
    public Integer getConstiutionId() {
        return constiutionId;
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
    /**
     * 设置：
     */
    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    /**
     * 获取：
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
