package com.ljb.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;

/**
 * 体质测试结果详情实体
 * 表名 result_details
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-08 17:18:14
 */
@TableName("result_details")
public class ResultDetails extends Model<ResultDetails> implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    @TableId(type=IdType.AUTO)
    private Integer id;
	//结果id
	private Integer resultId;
	//体质id
	private Integer constitutionId;
	//分值
	private Integer result;

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
     * 设置：结果id
     */
    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    /**
     * 获取：结果id
     */
    public Integer getResultId() {
        return resultId;
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
     * 设置：分值
     */
    public void setResult(Integer result) {
        this.result = result;
    }

    /**
     * 获取：分值
     */
    public Integer getResult() {
        return result;
    }
	@Override
	protected Serializable pkVal() {
	// TODO 自动生成的方法存根
	return this.id;
    }
}
