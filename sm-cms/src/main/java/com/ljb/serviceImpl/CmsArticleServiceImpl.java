package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.CmsArticleDao;
import com.ljb.entity.CmsArticle;
import com.ljb.service.CmsArticleService;
import com.ljb.shiro.BaseService;
import com.ljb.shiro.ShiroUtils;
import com.ljb.query.CmsArticleQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.DateUtils;
import com.ljb.utils.MapPageUtil;
import com.ljb.utils.PageUtil;
import com.ljb.utils.Query;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

/**
 * 文章管理Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-05 14:38:45
 */
@Service
public class CmsArticleServiceImpl extends ServiceImpl<CmsArticleDao,CmsArticle> implements CmsArticleService {
    @Autowired
    private CmsArticleDao cmsArticleDao;
    
    @Override
    public CmsArticle queryObject(Integer id) {
        return cmsArticleDao.selectById(id);
    }

    @Override
    public Page<CmsArticle> queryList(Map<String, Object> map) {
        MapPageUtil<CmsArticle> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<CmsArticle> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
    @Override
    public Page<CmsArticle> apiList(Map<String, Object> map) {
        MapPageUtil<CmsArticle> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<CmsArticle> wrapper=mapPage.condition();
    	wrapper.where("status={0}", 1);
        return selectPage(mapPage.page(), wrapper);
    }
    
    @Override
    public Page<Map<String, Object>> apiListByCategory(Integer id){
    	EntityWrapper<CmsArticle> wrapper=new EntityWrapper<>();
    	wrapper.where("catogry_id = {0}", id).orderBy("create_time", false);
    	Page<CmsArticle> page=new Page<>(1, 5);
    	return selectMapsPage(page, wrapper);
    }
    
    @Override
    public Page<Map<String, Object>> apiListByCategoryIds(Integer[] ids){
    	EntityWrapper<CmsArticle> wrapper=new EntityWrapper<>();
    	wrapper.in("catogry_id", ids).orderBy("create_time", false);
    	Page<CmsArticle> page=new Page<>(1, 50);
    	return selectMapsPage(page, wrapper);
    }
    
     @Override
    public List<CmsArticle> queryAll(Map<String, Object> map){
    	MapPageUtil<CmsArticle> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<CmsArticle> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<CmsArticle> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<CmsArticle> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
	public int save(CmsArticle entity) {
    	CmsArticle cmsArticle=new CmsArticle();
    	BeanUtils.copyProperties(entity, cmsArticle);
    	cmsArticle.setCreateTime(DateUtils.currentTime());
    	cmsArticle.setOrderNum(1);
    	cmsArticle.setCreateId(ShiroUtils.getSysUserId());
		return cmsArticleDao.insert(cmsArticle);
	}

    @Override
    public int update(CmsArticle entity) {
    	CmsArticle cmsArticle=new CmsArticle();
    	BeanUtils.copyProperties(entity, cmsArticle);
    	cmsArticle.setUpdateTime(DateUtils.currentTime());
    	cmsArticle.setCreateId(ShiroUtils.getSysUserId());
        return cmsArticleDao.updateById(cmsArticle);
    }

    @Override
    public int delete(Integer id) {
    	return cmsArticleDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return cmsArticleDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int issue(Integer[] ids) {
    	List<CmsArticle> cmsArticles=new ArrayList<>();
    	for (Integer id : ids) {
    		CmsArticle cmsArticle=selectById(id);
    		cmsArticle.setStatus(1);
    		cmsArticles.add(cmsArticle);
		}
    	return updateBatchById(cmsArticles)?1:0;
    }
    
    @Override
    public int pause(Integer[] ids) {
    	List<CmsArticle> cmsArticles=new ArrayList<>();
    	for (Integer id : ids) {
    		CmsArticle cmsArticle=selectById(id);
    		cmsArticle.setStatus(2);
    		cmsArticles.add(cmsArticle);
		}
    	return updateBatchById(cmsArticles)?1:0;
    }
    
    @Override
    public int countByQuery(){
    	CmsArticleQuery query=new CmsArticleQuery();
        return cmsArticleDao.countByQuery(query);
    }

	@Override
    public List<CmsArticle> selectByQuery(){
    	CmsArticleQuery query=new CmsArticleQuery();
        return cmsArticleDao.selectByQuery(query);
    }
	
	@Override
    public CmsArticle selectOne(){
    	CmsArticleQuery query=new CmsArticleQuery();
        return cmsArticleDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	CmsArticleQuery query=new CmsArticleQuery();
        return cmsArticleDao.deleteByQuery(query);
    }
}
