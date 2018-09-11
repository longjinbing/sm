package com.ljb.mapper;

import com.ljb.entity.CmsArticle;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.CmsArticleQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 文章管理Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-05 14:38:45
 */
public interface CmsArticleDao extends BaseMapper<CmsArticle>,BaseDao<CmsArticle> {

    int countByQuery(CmsArticleQuery query);

	List<CmsArticle> selectByQuery(CmsArticleQuery query);
	
	CmsArticle selectOne(CmsArticleQuery query);
	
	int deleteByQuery(CmsArticleQuery query);

}
