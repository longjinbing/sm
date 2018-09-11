package com.ljb.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 角色与菜单实体
 * 表名 sys_role_menu
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-01 17:22:58
 */
@TableName("sys_role_menu")
public class SysRoleMenu extends Model<SysRoleMenu> implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    @TableId(type=IdType.AUTO)
    private Integer id;
	//角色
	private Integer roleId;
	//菜单
	private Integer menuId;
	//创建者
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
     * 设置：角色
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取：角色
     */
    public Integer getRoleId() {
        return roleId;
    }
    /**
     * 设置：菜单
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    /**
     * 获取：菜单
     */
    public Integer getMenuId() {
        return menuId;
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
	@Override
	protected Serializable pkVal() {
	// TODO 自动生成的方法存根
	return this.id;
    }
}
