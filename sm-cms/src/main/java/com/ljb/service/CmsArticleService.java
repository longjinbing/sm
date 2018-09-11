package com.ljb.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.ljb.entity.CmsArticle;
import com.ljb.query.CmsArticleQuery;
import java.util.List;
import java.util.Map;

/**
 * 文章管理Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-05 14:38:45
 */
public interface CmsArticleService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    CmsArticle queryObject(Integer id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    Page<CmsArticle> queryList(Map<String, Object> map);
    
    Page<CmsArticle> apiList(Map<String, Object> map);
    
    Page<Map<String, Object>> apiListByCategory(Integer id);
    
    Page<Map<String, Object>> apiListByCategoryIds(Integer[] id);

	/**
     * 查询
     *
     * @param map 参数
     * @return list
     */
	List<CmsArticle> queryAll(Map<String, Object> map);
	
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
     * @param cmsArticle 实体
     * @return 保存条数
     */
    int save(CmsArticle entity);

    /**
     * 根据主键更新实体
     *
     * @param cmsArticle 实体
     * @return 更新条数
     */
    int update(CmsArticle entity);

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
    
    int issue(Integer[] ids);
    
    int pause(Integer[] ids);
    
    /**
     * 根据查询条件查询数量
     *
     * @param CmsArticleQuery
     * @return 满足条件数
     */
    int countByQuery();

	/**
     * 根据查询条件查询实体列表
     *
     * @param CmsArticleQuery
     * @return 满足条件数据
     */
	List<CmsArticle> selectByQuery();
	
	
	/**
     * 根据查询条件查询单个实体
     *
     * @param CmsArticleQuery
     * @return 满足条件数
     */
	CmsArticle selectOne();
	
	/**
     * 根据查询条件删除实体
     *
     * @param CmsArticleQuery
     * @return 满足条件数
     */
	int deleteByQuery();
}
