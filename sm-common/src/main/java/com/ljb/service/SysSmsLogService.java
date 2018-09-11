package com.ljb.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.ljb.entity.SysSmsLog;
import com.ljb.query.SysSmsLogQuery;
import java.util.List;
import java.util.Map;

/**
 * Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-01 18:05:57
 */
public interface SysSmsLogService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    SysSmsLog queryObject(Long id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    Page<SysSmsLog> queryList(Map<String, Object> map);

	/**
     * 查询
     *
     * @param map 参数
     * @return list
     */
	List<SysSmsLog> queryAll(Map<String, Object> map);
	
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
     * @param sysSmsLog 实体
     * @return 保存条数
     */
    int save(SysSmsLog entity);

    /**
     * 根据主键更新实体
     *
     * @param sysSmsLog 实体
     * @return 更新条数
     */
    int update(SysSmsLog entity);

    /**
     * 根据主键删除
     *
     * @param id
     * @return 删除条数
     */
    int delete(Long id);

    /**
     * 根据主键批量删除
     *
     * @param ids
     * @return 删除条数
     */
    int deleteBatch(Long[] ids);
    
    /**
     * 根据查询条件查询数量
     *
     * @param SysSmsLogQuery
     * @return 满足条件数
     */
    int countByQuery();

	/**
     * 根据查询条件查询实体列表
     *
     * @param SysSmsLogQuery
     * @return 满足条件数据
     */
	List<SysSmsLog> selectByQuery();
	
	
	/**
     * 根据查询条件查询单个实体
     *
     * @param SysSmsLogQuery
     * @return 满足条件数
     */
	SysSmsLog selectOne();
	
	/**
     * 根据查询条件删除实体
     *
     * @param SysSmsLogQuery
     * @return 满足条件数
     */
	int deleteByQuery();
}
