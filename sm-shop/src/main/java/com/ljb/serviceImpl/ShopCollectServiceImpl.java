package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.ShopCollectDao;
import com.ljb.entity.ShopCollect;
import com.ljb.service.ShopCollectService;
import com.ljb.query.ShopCollectQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.MapPageUtil;
import com.ljb.shiro.ShiroUtils;
import com.ljb.utils.DateUtils;

/**
 * 用户收藏Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 09:59:38
 */
@Service
public class ShopCollectServiceImpl extends ServiceImpl<ShopCollectDao,ShopCollect> implements ShopCollectService {
    @Autowired
    private ShopCollectDao shopCollectDao;
    
    @Override
    public ShopCollect queryObject(Integer id) {
        return shopCollectDao.selectById(id);
    }

    @Override
    public Page<ShopCollect> queryList(Map<String, Object> map) {
        MapPageUtil<ShopCollect> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopCollect> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
    @Override
    public List<ShopCollect> queryListByUserId(Integer userId){
    	EntityWrapper<ShopCollect> wrapper=new EntityWrapper<>();
    	wrapper.where("user_id = {0}", userId).orderBy("id", false);
    	return selectList(wrapper);
    }
    
     @Override
    public List<ShopCollect> queryAll(Map<String, Object> map){
    	MapPageUtil<ShopCollect> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopCollect> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<ShopCollect> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopCollect> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
    public Map<String, Object> queryDetails(Integer id) {
        return shopCollectDao.select(id);
    }
    
    @Override
	public int save(ShopCollect entity) {
    	ShopCollect shopCollect=new ShopCollect();
    	BeanUtils.copyProperties(entity, shopCollect);
		return shopCollectDao.insert(shopCollect);
	}

    @Override
    public int update(ShopCollect entity) {
    	ShopCollect shopCollect=new ShopCollect();
    	BeanUtils.copyProperties(entity, shopCollect);
        return shopCollectDao.updateById(shopCollect);
    }

    @Override
    public int delete(Integer id) {
    	return shopCollectDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return shopCollectDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	ShopCollectQuery query=new ShopCollectQuery();
        return shopCollectDao.countByQuery(query);
    }

	@Override
    public List<ShopCollect> selectByQuery(){
    	ShopCollectQuery query=new ShopCollectQuery();
        return shopCollectDao.selectByQuery(query);
    }
	
	@Override
    public ShopCollect selectOne(){
    	ShopCollectQuery query=new ShopCollectQuery();
        return shopCollectDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	ShopCollectQuery query=new ShopCollectQuery();
        return shopCollectDao.deleteByQuery(query);
    }
}
