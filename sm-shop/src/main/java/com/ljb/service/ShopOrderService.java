package com.ljb.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.ljb.entity.ShopOrder;
import com.ljb.query.ShopOrderQuery;
import java.util.List;
import java.util.Map;

/**
 * 订单管理Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:22
 */
public interface ShopOrderService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    ShopOrder queryObject(Integer id);
    
    Boolean submitOrder(Map<String, Object> map,Integer userId);
    
    Boolean submitOrder(Map<String, Object> map,Integer goodsId,Integer userId);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    Page<ShopOrder> queryList(Map<String, Object> map);
    
    List<Map<String, Object>> orderList(Integer userId);
    
    Map<String, Object> orderDetails(Integer id);

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
	List<ShopOrder> queryAll(Map<String, Object> map);
	
	/**
     * 查询
     *
     * @param id 参数
     * @return ShopOrder
     */
	Map<String, Object> queryDetails(Integer id);

    /**
     * 保存实体
     *
     * @param shopOrder 实体
     * @return 保存条数
     */
    int save(ShopOrder entity);

    /**
     * 根据主键更新实体
     *
     * @param shopOrder 实体
     * @return 更新条数
     */
    int update(ShopOrder entity);

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
     * @param ShopOrderQuery
     * @return 满足条件数
     */
    int countByQuery();

	/**
     * 根据查询条件查询实体列表
     *
     * @param ShopOrderQuery
     * @return 满足条件数据
     */
	List<ShopOrder> selectByQuery();
	
	
	/**
     * 根据查询条件查询单个实体
     *
     * @param ShopOrderQuery
     * @return 满足条件数
     */
	ShopOrder selectOne();
	
	/**
     * 根据查询条件删除实体
     *
     * @param ShopOrderQuery
     * @return 满足条件数
     */
	int deleteByQuery();
}
