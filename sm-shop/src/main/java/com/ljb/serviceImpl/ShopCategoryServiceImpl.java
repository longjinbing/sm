package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.ShopCategoryDao;
import com.ljb.entity.ShopCategory;
import com.ljb.service.ShopCategoryService;
import com.ljb.query.ShopCategoryQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.MapPageUtil;
import com.ljb.utils.TreeUtils;
import com.ljb.shiro.ShiroUtils;
import com.ljb.utils.DateUtils;

/**
 * 商品分类Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:21
 */
@Service
public class ShopCategoryServiceImpl extends ServiceImpl<ShopCategoryDao,ShopCategory> implements ShopCategoryService {
    @Autowired
    private ShopCategoryDao shopCategoryDao;
    
    @Override
    public ShopCategory queryObject(Integer id) {
        return shopCategoryDao.selectById(id);
    }

    @Override
    public Page<ShopCategory> queryList(Map<String, Object> map) {
        MapPageUtil<ShopCategory> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopCategory> wrapper=mapPage.condition();
    	wrapper.where("parent_id = {0}", map.get("id"));
        return selectPage(mapPage.page(), wrapper);
    }
    
    @Override
    public Collection<?> zTressList(){
    	ShopCategoryQuery query=new ShopCategoryQuery();
    	query.createCriteria().andstatusEqualTo(1);
    	List<ShopCategory> catogries=shopCategoryDao.selectByQuery(query);
    	ShopCategory shopCategory=new ShopCategory();
    	shopCategory.setId(0);
    	shopCategory.setParentId(-1);
    	shopCategory.setName("类别");
    	catogries.add(shopCategory);
    	return TreeUtils.buildTree(catogries);
    }
    
     @Override
    public List<ShopCategory> queryAll(Map<String, Object> map){
    	MapPageUtil<ShopCategory> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopCategory> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<ShopCategory> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopCategory> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
    public Map<String, Object> queryDetails(Integer id) {
        return shopCategoryDao.select(id);
    }
    
    @Override
	public int save(ShopCategory entity) {
    	ShopCategory shopCategory=new ShopCategory();
    	BeanUtils.copyProperties(entity, shopCategory);
    	shopCategory.setStatus(1);
		return shopCategoryDao.insert(shopCategory);
	}

    @Override
    public int update(ShopCategory entity) {
    	ShopCategory shopCategory=new ShopCategory();
    	BeanUtils.copyProperties(entity, shopCategory);
        return shopCategoryDao.updateById(shopCategory);
    }

    @Override
    public int delete(Integer id) {
    	return shopCategoryDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return shopCategoryDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	ShopCategoryQuery query=new ShopCategoryQuery();
        return shopCategoryDao.countByQuery(query);
    }

	@Override
    public List<ShopCategory> selectByQuery(){
    	ShopCategoryQuery query=new ShopCategoryQuery();
        return shopCategoryDao.selectByQuery(query);
    }
	
	@Override
    public ShopCategory selectOne(){
    	ShopCategoryQuery query=new ShopCategoryQuery();
        return shopCategoryDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	ShopCategoryQuery query=new ShopCategoryQuery();
        return shopCategoryDao.deleteByQuery(query);
    }
}
