package com.ljb.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.ljb.entity.CmsArticleComment;
import com.ljb.query.CmsArticleCommentQuery;
import java.util.List;
import java.util.Map;

/**
 * 文章评论Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-05 13:08:46
 */
public interface CmsArticleCommentService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    CmsArticleComment queryObject(Integer id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    Page<CmsArticleComment> queryList(Map<String, Object> map);

	/**
     * 查询
     *
     * @param map 参数
     * @return list
     */
	List<CmsArticleComment> queryAll(Map<String, Object> map);
	
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
     * @param cmsArticleComment 实体
     * @return 保存条数
     */
    int save(CmsArticleComment entity);

    /**
     * 根据主键更新实体
     *
     * @param cmsArticleComment 实体
     * @return 更新条数
     */
    int update(CmsArticleComment entity);

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
     * @param CmsArticleCommentQuery
     * @return 满足条件数
     */
    int countByQuery();

	/**
     * 根据查询条件查询实体列表
     *
     * @param CmsArticleCommentQuery
     * @return 满足条件数据
     */
	List<CmsArticleComment> selectByQuery();
	
	
	/**
     * 根据查询条件查询单个实体
     *
     * @param CmsArticleCommentQuery
     * @return 满足条件数
     */
	CmsArticleComment selectOne();
	
	/**
     * 根据查询条件删除实体
     *
     * @param CmsArticleCommentQuery
     * @return 满足条件数
     */
	int deleteByQuery();
}
