package com.ljb.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.ljb.entity.ShopCart;
import com.ljb.query.ShopCartQuery;
import java.util.List;
import java.util.Map;

/**
 * 购物车Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:22
 */
public interface ShopCartService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    ShopCart queryObject(Integer id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    Page<ShopCart> queryList(Map<String, Object> map);

    List<ShopCart> queryCart(Integer userId);
    
    boolean addGoodsToCart(Integer goodsId,Integer userId);

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
	List<ShopCart> queryAll(Map<String, Object> map);
	
	/**
     * 查询
     *
     * @param id 参数
     * @return ShopCart
     */
	Map<String, Object> queryDetails(Integer id);

    /**
     * 保存实体
     *
     * @param shopCart 实体
     * @return 保存条数
     */
    int save(ShopCart entity);

    /**
     * 根据主键更新实体
     *
     * @param shopCart 实体
     * @return 更新条数
     */
    int update(ShopCart entity);

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
     * @param ShopCartQuery
     * @return 满足条件数
     */
    int countByQuery();

	/**
     * 根据查询条件查询实体列表
     *
     * @param ShopCartQuery
     * @return 满足条件数据
     */
	List<ShopCart> selectByQuery();
	
	
	/**
     * 根据查询条件查询单个实体
     *
     * @param ShopCartQuery
     * @return 满足条件数
     */
	ShopCart selectOne();
	
	/**
     * 根据查询条件删除实体
     *
     * @param ShopCartQuery
     * @return 满足条件数
     */
	int deleteByQuery();
}
