package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.CmsArticleCommentDao;
import com.ljb.entity.CmsArticleComment;
import com.ljb.service.CmsArticleCommentService;
import com.ljb.query.CmsArticleCommentQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.MapPageUtil;

/**
 * 文章评论Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-05 13:08:46
 */
@Service
public class CmsArticleCommentServiceImpl extends ServiceImpl<CmsArticleCommentDao,CmsArticleComment> implements CmsArticleCommentService {
    @Autowired
    private CmsArticleCommentDao cmsArticleCommentDao;
    
    @Override
    public CmsArticleComment queryObject(Integer id) {
        return cmsArticleCommentDao.selectById(id);
    }

    @Override
    public Page<CmsArticleComment> queryList(Map<String, Object> map) {
        MapPageUtil<CmsArticleComment> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<CmsArticleComment> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
     @Override
    public List<CmsArticleComment> queryAll(Map<String, Object> map){
    	MapPageUtil<CmsArticleComment> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<CmsArticleComment> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<CmsArticleComment> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<CmsArticleComment> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
	public int save(CmsArticleComment entity) {
    	CmsArticleComment cmsArticleComment=new CmsArticleComment();
    	BeanUtils.copyProperties(entity, cmsArticleComment);
		return cmsArticleCommentDao.insert(cmsArticleComment);
	}

    @Override
    public int update(CmsArticleComment entity) {
    	CmsArticleComment cmsArticleComment=new CmsArticleComment();
    	BeanUtils.copyProperties(entity, cmsArticleComment);
        return cmsArticleCommentDao.updateById(cmsArticleComment);
    }

    @Override
    public int delete(Integer id) {
    	return cmsArticleCommentDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return cmsArticleCommentDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	CmsArticleCommentQuery query=new CmsArticleCommentQuery();
        return cmsArticleCommentDao.countByQuery(query);
    }

	@Override
    public List<CmsArticleComment> selectByQuery(){
    	CmsArticleCommentQuery query=new CmsArticleCommentQuery();
        return cmsArticleCommentDao.selectByQuery(query);
    }
	
	@Override
    public CmsArticleComment selectOne(){
    	CmsArticleCommentQuery query=new CmsArticleCommentQuery();
        return cmsArticleCommentDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	CmsArticleCommentQuery query=new CmsArticleCommentQuery();
        return cmsArticleCommentDao.deleteByQuery(query);
    }
}
