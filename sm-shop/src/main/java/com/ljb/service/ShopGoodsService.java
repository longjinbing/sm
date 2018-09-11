package com.ljb.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.ljb.entity.ShopGoods;
import com.ljb.query.ShopGoodsQuery;
import java.util.List;
import java.util.Map;

/**
 * 商品管理Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:22
 */
public interface ShopGoodsService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    ShopGoods queryObject(Integer id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    Page<ShopGoods> queryList(Map<String, Object> map);
    
    List<Map<String, Object>> queryListByConstitution(Map<String, Object> params);
    
    List<Map<String, Object>> queryListBy(Map<String, Object> params);
    
    Page<Map<String, Object>> queryListByCategory(Integer id);
    
    Page<Map<String, Object>> queryListByCategoryIds(Integer[] ids);

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
	List<ShopGoods> queryAll(Map<String, Object> map);
	
	/**
     * 查询
     *
     * @param id 参数
     * @return ShopGoods
     */
	Map<String, Object> queryDetails(Integer id);

    /**
     * 保存实体
     *
     * @param shopGoods 实体
     * @return 保存条数
     */
    int save(ShopGoods entity);

    /**
     * 根据主键更新实体
     *
     * @param shopGoods 实体
     * @return 更新条数
     */
    int update(ShopGoods entity);

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
     * @param ShopGoodsQuery
     * @return 满足条件数
     */
    int countByQuery();

	/**
     * 根据查询条件查询实体列表
     *
     * @param ShopGoodsQuery
     * @return 满足条件数据
     */
	List<ShopGoods> selectByQuery();
	
	
	/**
     * 根据查询条件查询单个实体
     *
     * @param ShopGoodsQuery
     * @return 满足条件数
     */
	ShopGoods selectOne();
	
	/**
     * 根据查询条件删除实体
     *
     * @param ShopGoodsQuery
     * @return 满足条件数
     */
	int deleteByQuery();
}
