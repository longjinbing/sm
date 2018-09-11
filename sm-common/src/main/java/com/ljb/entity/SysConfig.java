package com.ljb.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 系统配置信息表实体
 * 表名 sys_config
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-01 17:22:57
 */
@TableName("sys_config")
public class SysConfig extends Model<SysConfig> implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    @TableId(type=IdType.AUTO)
    private Integer id;
	//key
	private String item;
	//value
	private String value;
	//状态   0：隐藏   1：显示
	private Integer status;
	//备注
	private String remark;
	//
	private Integer isDelete;
	//创建者ID
	private Integer createId;
	//创建时间
	private Date createTime;

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
     * 设置：key
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * 获取：key
     */
    public String getItem() {
        return item;
    }
    /**
     * 设置：value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取：value
     */
    public String getValue() {
        return value;
    }
    /**
     * 设置：状态   0：隐藏   1：显示
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：状态   0：隐藏   1：显示
     */
    public Integer getStatus() {
        return status;
    }
    /**
     * 设置：备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取：备注
     */
    public String getRemark() {
        return remark;
    }
    /**
     * 设置：
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取：
     */
    public Integer getIsDelete() {
        return isDelete;
    }
    /**
     * 设置：创建者ID
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * 获取：创建者ID
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
	@Override
	protected Serializable pkVal() {
	// TODO 自动生成的方法存根
	return this.id;
    }
}
