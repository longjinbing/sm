package com.ljb.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.ljb.entity.SysRoleMenu;
import com.ljb.query.SysRoleMenuQuery;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 角色与菜单Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-01 18:05:57
 */
public interface SysRoleMenuService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    SysRoleMenu queryObject(Integer id);
    
    Collection<Object> menuList(Integer roleId,Integer adminId);
    
    int save(Integer roleId,Integer[] menuIds,Integer adminId);
    

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    Page<SysRoleMenu> queryList(Map<String, Object> map);

	/**
     * 查询
     *
     * @param map 参数
     * @return list
     */
	List<SysRoleMenu> queryAll(Map<String, Object> map);
	
    /**
     * 分页统计总数
     *
     * @param map 参数
     * @return 总数
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存实体
     *
     * @param sysRoleMenu 实体
     * @return 保存条数
     */
    int save(SysRoleMenu entity);

    /**
     * 根据主键更新实体
     *
     * @param sysRoleMenu 实体
     * @return 更新条数
     */
    int update(SysRoleMenu entity);

    /**
     * 根据主键删除
     *
     * @param id
     * @return 删除条数
     */
    int delete(Integer id);

    /**
     * 根据主键批量删除
     *
     * @param ids
     * @return 删除条数
     */
    int deleteBatch(Integer[] ids);
    
    /**
     * 根据查询条件查询数量
     *
     * @param SysRoleMenuQuery
     * @return 满足条件数
     */
    int countByQuery();

	/**
     * 根据查询条件查询实体列表
     *
     * @param SysRoleMenuQuery
     * @return 满足条件数据
     */
	List<SysRoleMenu> selectByQuery();
	
	
	/**
     * 根据查询条件查询单个实体
     *
     * @param SysRoleMenuQuery
     * @return 满足条件数
     */
	SysRoleMenu selectOne();
	
	/**
     * 根据查询条件删除实体
     *
     * @param SysRoleMenuQuery
     * @return 满足条件数
     */
	int deleteByQuery();
}
