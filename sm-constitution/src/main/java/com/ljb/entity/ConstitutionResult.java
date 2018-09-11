package com.ljb.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;

/**
 * 体质测试结果实体
 * 表名 constitution_result
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-07 18:22:42
 */
@TableName("constitution_result")
public class ConstitutionResult extends Model<ConstitutionResult> implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    @TableId(type=IdType.AUTO)
    private Integer id;
	//用户id
	private Integer userId;
	//体质id
	private Integer constitutionId;
	//测试时间
	private Date createTime;
	//创建者
	private Integer createId;

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
     * 设置：体质id
     */
    public void setConstitutionId(Integer constitutionId) {
        this.constitutionId = constitutionId;
    }

    /**
     * 获取：体质id
     */
    public Integer getConstitutionId() {
        return constitutionId;
    }
    /**
     * 设置：测试时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：测试时间
     */
    public Date getCreateTime() {
        return createTime;
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
	@Override
	protected Serializable pkVal() {
	// TODO 自动生成的方法存根
	return this.id;
    }
}
