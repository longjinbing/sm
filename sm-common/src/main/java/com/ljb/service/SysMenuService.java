package com.ljb.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.ljb.entity.SysMenu;
import com.ljb.query.SysMenuQuery;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.swing.text.StyledEditorKit.BoldAction;

/**
 * 菜单管理Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-01 18:05:57
 */
public interface SysMenuService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    SysMenu queryObject(Integer id);
    
    List<String> permissions(Integer userId);
    
    Collection<Object> menuList(Integer userId);
    
    Collection<Object> menuSelectList(Integer userId);
    
    Collection<Object> zTreeList(Integer userId);

    Boolean refershMenu(); 

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    Page<SysMenu> queryList(Map<String, Object> map);

	/**
     * 查询
     *
     * @param map 参数
     * @return list
     */
	List<SysMenu> queryAll(Map<String, Object> map);
	
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
     * @param sysMenu 实体
     * @return 保存条数
     */
    int save(SysMenu entity);

    /**
     * 根据主键更新实体
     *
     * @param sysMenu 实体
     * @return 更新条数
     */
    int update(SysMenu entity);

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
     * @param SysMenuQuery
     * @return 满足条件数
     */
    int countByQuery();

	/**
     * 根据查询条件查询实体列表
     *
     * @param SysMenuQuery
     * @return 满足条件数据
     */
	List<SysMenu> selectByQuery();
	
	
	/**
     * 根据查询条件查询单个实体
     *
     * @param SysMenuQuery
     * @return 满足条件数
     */
	SysMenu selectOne();
	
	/**
     * 根据查询条件删除实体
     *
     * @param SysMenuQuery
     * @return 满足条件数
     */
	int deleteByQuery();
}
