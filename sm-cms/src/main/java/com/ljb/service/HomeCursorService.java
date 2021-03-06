package com.ljb.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.ljb.entity.HomeCursor;
import com.ljb.query.HomeCursorQuery;
import java.util.List;
import java.util.Map;

/**
 * 首页轮播Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-05 13:08:46
 */
public interface HomeCursorService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    HomeCursor queryObject(Integer id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    Page<HomeCursor> queryList(Map<String, Object> map);

	/**
     * 查询
     *
     * @param map 参数
     * @return list
     */
	List<HomeCursor> queryAll(Map<String, Object> map);
	
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
     * @param homeCursor 实体
     * @return 保存条数
     */
    int save(HomeCursor entity);

    /**
     * 根据主键更新实体
     *
     * @param homeCursor 实体
     * @return 更新条数
     */
    int update(HomeCursor entity);

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
     * @param HomeCursorQuery
     * @return 满足条件数
     */
    int countByQuery();

	/**
     * 根据查询条件查询实体列表
     *
     * @param HomeCursorQuery
     * @return 满足条件数据
     */
	List<HomeCursor> selectByQuery();
	
	
	/**
     * 根据查询条件查询单个实体
     *
     * @param HomeCursorQuery
     * @return 满足条件数
     */
	HomeCursor selectOne();
	
	/**
     * 根据查询条件删除实体
     *
     * @param HomeCursorQuery
     * @return 满足条件数
     */
	int deleteByQuery();
}
