package com.ljb.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.ljb.entity.ShopCoupon;
import com.ljb.query.ShopCouponQuery;
import java.util.List;
import java.util.Map;

/**
 * 优惠券管理Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:21
 */
public interface ShopCouponService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    ShopCoupon queryObject(Integer id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    Page<ShopCoupon> queryList(Map<String, Object> map);

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
	List<ShopCoupon> queryAll(Map<String, Object> map);
	
	List<Map<String, Object>> queryAll(Integer userId);
	
	/**
     * 查询
     *
     * @param id 参数
     * @return ShopCoupon
     */
	Map<String, Object> queryDetails(Integer id);

    /**
     * 保存实体
     *
     * @param shopCoupon 实体
     * @return 保存条数
     */
    int save(ShopCoupon entity);

    /**
     * 根据主键更新实体
     *
     * @param shopCoupon 实体
     * @return 更新条数
     */
    int update(ShopCoupon entity);

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
     * @param ShopCouponQuery
     * @return 满足条件数
     */
    int countByQuery();

	/**
     * 根据查询条件查询实体列表
     *
     * @param ShopCouponQuery
     * @return 满足条件数据
     */
	List<ShopCoupon> selectByQuery();
	
	
	/**
     * 根据查询条件查询单个实体
     *
     * @param ShopCouponQuery
     * @return 满足条件数
     */
	ShopCoupon selectOne();
	
	/**
     * 根据查询条件删除实体
     *
     * @param ShopCouponQuery
     * @return 满足条件数
     */
	int deleteByQuery();
}
