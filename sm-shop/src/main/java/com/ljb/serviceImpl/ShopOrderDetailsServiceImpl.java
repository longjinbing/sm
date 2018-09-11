package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.ShopOrderDetailsDao;
import com.ljb.entity.ShopOrderDetails;
import com.ljb.service.ShopOrderDetailsService;
import com.ljb.query.ShopOrderDetailsQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.MapPageUtil;
import com.ljb.shiro.ShiroUtils;
import com.ljb.utils.DateUtils;

/**
 * 订单详情Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 17:06:39
 */
@Service
public class ShopOrderDetailsServiceImpl extends ServiceImpl<ShopOrderDetailsDao,ShopOrderDetails> implements ShopOrderDetailsService {
    @Autowired
    private ShopOrderDetailsDao shopOrderDetailsDao;
    
    @Override
    public ShopOrderDetails queryObject(Integer id) {
        return shopOrderDetailsDao.selectById(id);
    }

    @Override
    public Page<ShopOrderDetails> queryList(Map<String, Object> map) {
        MapPageUtil<ShopOrderDetails> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopOrderDetails> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
     @Override
    public List<ShopOrderDetails> queryAll(Map<String, Object> map){
    	MapPageUtil<ShopOrderDetails> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopOrderDetails> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<ShopOrderDetails> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopOrderDetails> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
    public Map<String, Object> queryDetails(Integer id) {
        return shopOrderDetailsDao.select(id);
    }
    
    @Override
	public int save(ShopOrderDetails entity) {
    	ShopOrderDetails shopOrderDetails=new ShopOrderDetails();
    	BeanUtils.copyProperties(entity, shopOrderDetails);
		return shopOrderDetailsDao.insert(shopOrderDetails);
	}

    @Override
    public int update(ShopOrderDetails entity) {
    	ShopOrderDetails shopOrderDetails=new ShopOrderDetails();
    	BeanUtils.copyProperties(entity, shopOrderDetails);
        return shopOrderDetailsDao.updateById(shopOrderDetails);
    }

    @Override
    public int delete(Integer id) {
    	return shopOrderDetailsDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return shopOrderDetailsDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	ShopOrderDetailsQuery query=new ShopOrderDetailsQuery();
        return shopOrderDetailsDao.countByQuery(query);
    }

	@Override
    public List<ShopOrderDetails> selectByQuery(){
    	ShopOrderDetailsQuery query=new ShopOrderDetailsQuery();
        return shopOrderDetailsDao.selectByQuery(query);
    }
	
	@Override
    public ShopOrderDetails selectOne(){
    	ShopOrderDetailsQuery query=new ShopOrderDetailsQuery();
        return shopOrderDetailsDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	ShopOrderDetailsQuery query=new ShopOrderDetailsQuery();
        return shopOrderDetailsDao.deleteByQuery(query);
    }
}
