package com.ljb.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.ljb.entity.ConstitutionDetails;
import com.ljb.query.ConstitutionDetailsQuery;
import java.util.List;
import java.util.Map;

/**
 * 体质介绍Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-08 16:59:04
 */
public interface ConstitutionDetailsService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    ConstitutionDetails queryObject(Integer id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    Page<ConstitutionDetails> queryList(Map<String, Object> map);

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
	List<ConstitutionDetails> queryAll(Map<String, Object> map);
	
	/**
     * 查询
     *
     * @param id 参数
     * @return ConstitutionDetails
     */
	Map<String, Object> queryDetails(Integer id);

    /**
     * 保存实体
     *
     * @param constitutionDetails 实体
     * @return 保存条数
     */
    int save(ConstitutionDetails entity);

    /**
     * 根据主键更新实体
     *
     * @param constitutionDetails 实体
     * @return 更新条数
     */
    int update(ConstitutionDetails entity);

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
     * @param ConstitutionDetailsQuery
     * @return 满足条件数
     */
    int countByQuery();

	/**
     * 根据查询条件查询实体列表
     *
     * @param ConstitutionDetailsQuery
     * @return 满足条件数据
     */
	List<ConstitutionDetails> selectByQuery();
	
	
	/**
     * 根据查询条件查询单个实体
     *
     * @param ConstitutionDetailsQuery
     * @return 满足条件数
     */
	ConstitutionDetails selectOne();
	
	/**
     * 根据查询条件删除实体
     *
     * @param ConstitutionDetailsQuery
     * @return 满足条件数
     */
	int deleteByQuery();
}
