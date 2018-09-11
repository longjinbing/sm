package com.ljb.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.ljb.entity.ShopOrderDetails;
import com.ljb.query.ShopOrderDetailsQuery;
import java.util.List;
import java.util.Map;

/**
 * 订单详情Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 17:06:39
 */
public interface ShopOrderDetailsService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    ShopOrderDetails queryObject(Integer id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    Page<ShopOrderDetails> queryList(Map<String, Object> map);

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
	List<ShopOrderDetails> queryAll(Map<String, Object> map);
	
	/**
     * 查询
     *
     * @param id 参数
     * @return ShopOrderDetails
     */
	Map<String, Object> queryDetails(Integer id);

    /**
     * 保存实体
     *
     * @param shopOrderDetails 实体
     * @return 保存条数
     */
    int save(ShopOrderDetails entity);

    /**
     * 根据主键更新实体
     *
     * @param shopOrderDetails 实体
     * @return 更新条数
     */
    int update(ShopOrderDetails entity);

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
     * @param ShopOrderDetailsQuery
     * @return 满足条件数
     */
    int countByQuery();

	/**
     * 根据查询条件查询实体列表
     *
     * @param ShopOrderDetailsQuery
     * @return 满足条件数据
     */
	List<ShopOrderDetails> selectByQuery();
	
	
	/**
     * 根据查询条件查询单个实体
     *
     * @param ShopOrderDetailsQuery
     * @return 满足条件数
     */
	ShopOrderDetails selectOne();
	
	/**
     * 根据查询条件删除实体
     *
     * @param ShopOrderDetailsQuery
     * @return 满足条件数
     */
	int deleteByQuery();
}
