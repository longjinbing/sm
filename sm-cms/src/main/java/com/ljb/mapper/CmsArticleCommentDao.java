package com.ljb.mapper;

import com.ljb.entity.CmsArticleComment;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.CmsArticleCommentQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 文章评论Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-05 13:08:46
 */
public interface CmsArticleCommentDao extends BaseMapper<CmsArticleComment>,BaseDao<CmsArticleComment> {

    int countByQuery(CmsArticleCommentQuery query);

	List<CmsArticleComment> selectByQuery(CmsArticleCommentQuery query);
	
	CmsArticleComment selectOne(CmsArticleCommentQuery query);
	
	int deleteByQuery(CmsArticleCommentQuery query);

}
