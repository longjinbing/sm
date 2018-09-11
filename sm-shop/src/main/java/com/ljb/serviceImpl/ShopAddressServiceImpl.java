package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.ShopAddressDao;
import com.ljb.entity.ShopAddress;
import com.ljb.service.ShopAddressService;
import com.ljb.query.ShopAddressQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.MapPageUtil;
import com.ljb.shiro.ShiroUtils;
import com.ljb.utils.DateUtils;

/**
 * 用户地址Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:22
 */
@Service
public class ShopAddressServiceImpl extends ServiceImpl<ShopAddressDao,ShopAddress> implements ShopAddressService {
    @Autowired
    private ShopAddressDao shopAddressDao;
    
    @Override
    public ShopAddress queryObject(Integer id) {
        return shopAddressDao.selectById(id);
    }

    @Override
    public Page<ShopAddress> queryList(Map<String, Object> map) {
        MapPageUtil<ShopAddress> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopAddress> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
     @Override
    public List<ShopAddress> queryAll(Map<String, Object> map){
    	MapPageUtil<ShopAddress> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopAddress> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<ShopAddress> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopAddress> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
    public Map<String, Object> queryDetails(Integer id) {
        return shopAddressDao.select(id);
    }
    
    @Override
	public int save(ShopAddress entity) {
    	ShopAddress shopAddress=new ShopAddress();
    	BeanUtils.copyProperties(entity, shopAddress);
		return shopAddressDao.insert(shopAddress);
	}

    @Override
    public int update(ShopAddress entity) {
    	ShopAddress shopAddress=new ShopAddress();
    	BeanUtils.copyProperties(entity, shopAddress);
        return shopAddressDao.updateById(shopAddress);
    }

    @Override
    public int delete(Integer id) {
    	return shopAddressDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return shopAddressDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	ShopAddressQuery query=new ShopAddressQuery();
        return shopAddressDao.countByQuery(query);
    }

	@Override
    public List<ShopAddress> selectByQuery(){
    	ShopAddressQuery query=new ShopAddressQuery();
        return shopAddressDao.selectByQuery(query);
    }
	
	@Override
    public ShopAddress selectOne(){
    	ShopAddressQuery query=new ShopAddressQuery();
        return shopAddressDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	ShopAddressQuery query=new ShopAddressQuery();
        return shopAddressDao.deleteByQuery(query);
    }
}
