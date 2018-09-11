package com.ljb.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.ljb.entity.ConstiutionQuestion;
import com.ljb.query.ConstiutionQuestionQuery;
import java.util.List;
import java.util.Map;

/**
 * 体质测试问题Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-07 18:22:42
 */
public interface ConstiutionQuestionService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    ConstiutionQuestion queryObject(Integer id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    Page<ConstiutionQuestion> queryList(Map<String, Object> map);

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
	List<ConstiutionQuestion> queryAll(Map<String, Object> map);
	
	/**
     * 查询
     *
     * @param id 参数
     * @return ConstiutionQuestion
     */
	Map<String, Object> queryDetails(Integer id);

    /**
     * 保存实体
     *
     * @param constiutionQuestion 实体
     * @return 保存条数
     */
    int save(ConstiutionQuestion entity);

    /**
     * 根据主键更新实体
     *
     * @param constiutionQuestion 实体
     * @return 更新条数
     */
    int update(ConstiutionQuestion entity);

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
     * @param ConstiutionQuestionQuery
     * @return 满足条件数
     */
    int countByQuery();

	/**
     * 根据查询条件查询实体列表
     *
     * @param ConstiutionQuestionQuery
     * @return 满足条件数据
     */
	List<ConstiutionQuestion> selectByQuery();
	
	
	/**
     * 根据查询条件查询单个实体
     *
     * @param ConstiutionQuestionQuery
     * @return 满足条件数
     */
	ConstiutionQuestion selectOne();
	
	/**
     * 根据查询条件删除实体
     *
     * @param ConstiutionQuestionQuery
     * @return 满足条件数
     */
	int deleteByQuery();
}
