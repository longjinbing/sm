package com.ljb.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.ljb.entity.Token;
import com.ljb.query.TokenQuery;
import java.util.List;
import java.util.Map;

/**
 * 用户TokenService接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-01 18:05:56
 */
public interface TokenService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    Token queryObject(Integer userId);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    Page<Token> queryList(Map<String, Object> map);

	/**
     * 查询
     *
     * @param map 参数
     * @return list
     */
	List<Token> queryAll(Map<String, Object> map);
	
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
     * @param token 实体
     * @return 保存条数
     */
    int save(Token entity);

    /**
     * 根据主键更新实体
     *
     * @param token 实体
     * @return 更新条数
     */
    int update(Token entity);

    /**
     * 根据主键删除
     *
     * @param userId
     * @return 删除条数
     */
    int delete(Integer userId);

    /**
     * 根据主键批量删除
     *
     * @param userIds
     * @return 删除条数
     */
    int deleteBatch(Integer[] userIds);
    
    /**
     * 根据查询条件查询数量
     *
     * @param TokenQuery
     * @return 满足条件数
     */
    int countByQuery();

	/**
     * 根据查询条件查询实体列表
     *
     * @param TokenQuery
     * @return 满足条件数据
     */
	List<Token> selectByQuery();
	
	
	/**
     * 根据查询条件查询单个实体
     *
     * @param TokenQuery
     * @return 满足条件数
     */
	Token selectOne();
	
	/**
     * 根据查询条件删除实体
     *
     * @param TokenQuery
     * @return 满足条件数
     */
	int deleteByQuery();
}
