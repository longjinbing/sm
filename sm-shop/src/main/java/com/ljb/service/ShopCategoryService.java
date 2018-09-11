package com.ljb.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.ljb.entity.ShopCategory;
import com.ljb.query.ShopCategoryQuery;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 商品分类Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:21
 */
public interface ShopCategoryService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    ShopCategory queryObject(Integer id);
    
    Collection<?> zTressList();

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    Page<ShopCategory> queryList(Map<String, Object> map);

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
	List<ShopCategory> queryAll(Map<String, Object> map);
	
	/**
     * 查询
     *
     * @param id 参数
     * @return ShopCategory
     */
	Map<String, Object> queryDetails(Integer id);

    /**
     * 保存实体
     *
     * @param shopCategory 实体
     * @return 保存条数
     */
    int save(ShopCategory entity);

    /**
     * 根据主键更新实体
     *
     * @param shopCategory 实体
     * @return 更新条数
     */
    int update(ShopCategory entity);

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
     * @param ShopCategoryQuery
     * @return 满足条件数
     */
    int countByQuery();

	/**
     * 根据查询条件查询实体列表
     *
     * @param ShopCategoryQuery
     * @return 满足条件数据
     */
	List<ShopCategory> selectByQuery();
	
	
	/**
     * 根据查询条件查询单个实体
     *
     * @param ShopCategoryQuery
     * @return 满足条件数
     */
	ShopCategory selectOne();
	
	/**
     * 根据查询条件删除实体
     *
     * @param ShopCategoryQuery
     * @return 满足条件数
     */
	int deleteByQuery();
}
