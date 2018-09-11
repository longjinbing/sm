package com.ljb.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.ljb.entity.Constitution;
import com.ljb.query.ConstitutionQuery;
import java.util.List;
import java.util.Map;

/**
 * 体质管理Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-07 18:22:42
 */
public interface ConstitutionService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    Constitution queryObject(Integer id);
    
    Constitution queryObject(String name);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    Page<Constitution> queryList(Map<String, Object> map);

	/**
     * 分页统计总数
     *
     * @param map 参数
     * @return 总数
     */
	int queryTotal(Map<String, Object> map);
	
	/**
     * 查询
     *
     * @param map 参数
     * @return list
     */
	List<Constitution> queryAll(Map<String, Object> map);
	
	/**
     * 查询
     *
     * @param id 参数
     * @return Constitution
     */
	Map<String, Object> queryDetails(Integer id);

    /**
     * 保存实体
     *
     * @param constitution 实体
     * @return 保存条数
     */
    int save(Constitution entity);

    /**
     * 根据主键更新实体
     *
     * @param constitution 实体
     * @return 更新条数
     */
    int update(Constitution entity);

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
     * @param ConstitutionQuery
     * @return 满足条件数
     */
    int countByQuery();

	/**
     * 根据查询条件查询实体列表
     *
     * @param ConstitutionQuery
     * @return 满足条件数据
     */
	List<Constitution> selectByQuery();
	
	
	/**
     * 根据查询条件查询单个实体
     *
     * @param ConstitutionQuery
     * @return 满足条件数
     */
	Constitution selectOne();
	
	/**
     * 根据查询条件删除实体
     *
     * @param ConstitutionQuery
     * @return 满足条件数
     */
	int deleteByQuery();
}
