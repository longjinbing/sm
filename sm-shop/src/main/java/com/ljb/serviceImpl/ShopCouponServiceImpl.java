package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.ShopCouponDao;
import com.ljb.mapper.ShopUserCouponDao;
import com.ljb.entity.ShopCoupon;
import com.ljb.entity.ShopUserCoupon;
import com.ljb.service.ShopCouponService;
import com.ljb.query.ShopCouponQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.MapPageUtil;
import com.ljb.shiro.ShiroUtils;
import com.ljb.utils.DateUtils;

/**
 * 优惠券管理Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:21
 */
@Service
public class ShopCouponServiceImpl extends ServiceImpl<ShopCouponDao,ShopCoupon> implements ShopCouponService {
    @Autowired
    private ShopCouponDao shopCouponDao;
    
    @Autowired
    private ShopUserCouponDao shopUserCouponDao;
    
    @Override
    public ShopCoupon queryObject(Integer id) {
        return shopCouponDao.selectById(id);
    }

    @Override
    public Page<ShopCoupon> queryList(Map<String, Object> map) {
        MapPageUtil<ShopCoupon> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopCoupon> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
     @Override
    public List<ShopCoupon> queryAll(Map<String, Object> map){
    	MapPageUtil<ShopCoupon> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopCoupon> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }
     
     @Override
     public List<Map<String, Object>> queryAll(Integer userId){
    	 List<ShopCoupon> shopCoupons=selectList(null);
    	 EntityWrapper<ShopUserCoupon> wrapper=new EntityWrapper<>();
    	 wrapper.where("user_id={0}", userId);
    	 List<ShopUserCoupon> shopUserCoupons=shopUserCouponDao.selectList(wrapper);
    	 Map<Integer, Object> mapList=new HashMap<>();
    	 for (ShopUserCoupon shopUserCoupon : shopUserCoupons) {
			mapList.put(shopUserCoupon.getCouponId(), shopUserCoupon);
    	 }
    	 List<Map<String,Object>> resultMap=new ArrayList<>();
    	 for (ShopCoupon shopCoupon : shopCoupons) {
			Map<String, Object> map=BeanUtils.bean2Map(shopCoupon, true);
			if(mapList.containsKey(shopCoupon.getId())){
				map.put("isHas",true );
			}
			resultMap.add(map);
		}
    	 return resultMap;
     }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<ShopCoupon> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopCoupon> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
    public Map<String, Object> queryDetails(Integer id) {
        return shopCouponDao.select(id);
    }
    
    @Override
	public int save(ShopCoupon entity) {
    	ShopCoupon shopCoupon=new ShopCoupon();
    	BeanUtils.copyProperties(entity, shopCoupon);
    	shopCoupon.setCreateTime(DateUtils.currentTime());
		shopCoupon.setCreateId(ShiroUtils.getSysUserId());
		return shopCouponDao.insert(shopCoupon);
	}

    @Override
    public int update(ShopCoupon entity) {
    	ShopCoupon shopCoupon=new ShopCoupon();
    	BeanUtils.copyProperties(entity, shopCoupon);
    	shopCoupon.setUpdateTime(DateUtils.currentTime());
		shopCoupon.setUpdateId(ShiroUtils.getSysUserId());
        return shopCouponDao.updateById(shopCoupon);
    }

    @Override
    public int delete(Integer id) {
    	return shopCouponDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return shopCouponDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	ShopCouponQuery query=new ShopCouponQuery();
        return shopCouponDao.countByQuery(query);
    }

	@Override
    public List<ShopCoupon> selectByQuery(){
    	ShopCouponQuery query=new ShopCouponQuery();
        return shopCouponDao.selectByQuery(query);
    }
	
	@Override
    public ShopCoupon selectOne(){
    	ShopCouponQuery query=new ShopCouponQuery();
        return shopCouponDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	ShopCouponQuery query=new ShopCouponQuery();
        return shopCouponDao.deleteByQuery(query);
    }
}
