package com.ljb.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.ljb.entity.SysUser;
import com.ljb.query.SysUserQuery;
import java.util.List;
import java.util.Map;

/**
 * 系统用户Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-01 18:05:56
 */
public interface SysUserService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    SysUser queryObject(Integer id);
    
    SysUser queryByName(String username);
    
    SysUser queryByNamePass(String username,String password);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    Page<SysUser> queryList(Map<String, Object> map);

	/**
     * 查询
     *
     * @param map 参数
     * @return list
     */
	List<SysUser> queryAll(Map<String, Object> map);
	
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
     * @param sysUser 实体
     * @return 保存条数
     */
    int save(SysUser entity);

    /**
     * 根据主键更新实体
     *
     * @param sysUser 实体
     * @return 更新条数
     */
    int update(SysUser entity);

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
     * @param SysUserQuery
     * @return 满足条件数
     */
    int countByQuery();

	/**
     * 根据查询条件查询实体列表
     *
     * @param SysUserQuery
     * @return 满足条件数据
     */
	List<SysUser> selectByQuery();
	
	
	/**
     * 根据查询条件查询单个实体
     *
     * @param SysUserQuery
     * @return 满足条件数
     */
	SysUser selectOne();
	
	/**
     * 根据查询条件删除实体
     *
     * @param SysUserQuery
     * @return 满足条件数
     */
	int deleteByQuery();
}