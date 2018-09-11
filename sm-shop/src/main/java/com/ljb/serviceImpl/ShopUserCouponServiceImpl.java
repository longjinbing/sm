package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.ShopUserCouponDao;
import com.ljb.entity.ShopUserCoupon;
import com.ljb.service.ShopUserCouponService;
import com.ljb.query.ShopUserCouponQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.MapPageUtil;
import com.ljb.shiro.ShiroUtils;
import com.ljb.utils.DateUtils;

/**
 * 用户优惠券管理Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:21
 */
@Service
public class ShopUserCouponServiceImpl extends ServiceImpl<ShopUserCouponDao,ShopUserCoupon> implements ShopUserCouponService {
    @Autowired
    private ShopUserCouponDao shopUserCouponDao;
    
    @Override
    public ShopUserCoupon queryObject(Integer id) {
        return shopUserCouponDao.selectById(id);
    }

    @Override
    public Page<ShopUserCoupon> queryList(Map<String, Object> map) {
        MapPageUtil<ShopUserCoupon> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopUserCoupon> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
     @Override
    public List<ShopUserCoupon> queryAll(Map<String, Object> map){
    	MapPageUtil<ShopUserCoupon> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopUserCoupon> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<ShopUserCoupon> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopUserCoupon> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
    public Map<String, Object> queryDetails(Integer id) {
        return shopUserCouponDao.select(id);
    }
    
    @Override
	public int save(ShopUserCoupon entity) {
    	ShopUserCoupon shopUserCoupon=new ShopUserCoupon();
    	BeanUtils.copyProperties(entity, shopUserCoupon);
		return shopUserCouponDao.insert(shopUserCoupon);
	}

    @Override
    public int update(ShopUserCoupon entity) {
    	ShopUserCoupon shopUserCoupon=new ShopUserCoupon();
    	BeanUtils.copyProperties(entity, shopUserCoupon);
        return shopUserCouponDao.updateById(shopUserCoupon);
    }

    @Override
    public int delete(Integer id) {
    	return shopUserCouponDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return shopUserCouponDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	ShopUserCouponQuery query=new ShopUserCouponQuery();
        return shopUserCouponDao.countByQuery(query);
    }

	@Override
    public List<ShopUserCoupon> selectByQuery(){
    	ShopUserCouponQuery query=new ShopUserCouponQuery();
        return shopUserCouponDao.selectByQuery(query);
    }
	
	@Override
    public ShopUserCoupon selectOne(){
    	ShopUserCouponQuery query=new ShopUserCouponQuery();
        return shopUserCouponDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	ShopUserCouponQuery query=new ShopUserCouponQuery();
        return shopUserCouponDao.deleteByQuery(query);
    }
}
