package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.ShopCartDao;
import com.ljb.mapper.ShopGoodsDao;
import com.ljb.entity.ShopCart;
import com.ljb.entity.ShopGoods;
import com.ljb.service.ShopCartService;
import com.ljb.query.ShopCartQuery;
import com.ljb.query.ShopGoodsQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.MapPageUtil;
import com.ljb.shiro.ShiroUtils;
import com.ljb.utils.DateUtils;

/**
 * 购物车Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:22
 */
@Service
public class ShopCartServiceImpl extends ServiceImpl<ShopCartDao,ShopCart> implements ShopCartService {
    @Autowired
    private ShopCartDao shopCartDao;
    
    @Autowired
    private ShopGoodsDao shopGoodsDao;
    
    @Override
    public ShopCart queryObject(Integer id) {
        return shopCartDao.selectById(id);
    }

    @Override
    public Page<ShopCart> queryList(Map<String, Object> map) {
        MapPageUtil<ShopCart> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopCart> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
    @Override
    public List<ShopCart> queryCart(Integer userId){
    	EntityWrapper<ShopCart> wrapper=new EntityWrapper<>();
    	wrapper.where("user_id = {0}", userId).orderBy("id", false);
    	return selectList(wrapper);
    }
    
    @Override
    public boolean addGoodsToCart(Integer goodsId,Integer userId) {
    	ShopGoodsQuery query=new ShopGoodsQuery();
    	query.createCriteria().andidEqualTo(goodsId);
    	ShopGoods shopGoods = shopGoodsDao.selectOne(query);
    	ShopCartQuery cartQuery=new ShopCartQuery();
    	cartQuery.createCriteria().anduserIdEqualTo(userId).andgoodsIdEqualTo(goodsId);
		ShopCart shopCart = shopCartDao.selectOne(cartQuery);
		if(shopCart!=null) {
			shopCart.setNumber(shopCart.getNumber()+1);
			shopCartDao.updateById(shopCart);
		}else {
		shopCart=new ShopCart();
		shopCart.setGoodsId(goodsId);
		shopCart.setGoodsName(shopGoods.getTitle());
		shopCart.setListPicUrl(shopGoods.getPrimaryPicUrl());
		shopCart.setMarketPrice(shopGoods.getMarketPrice());
		shopCart.setPrice(shopGoods.getPrice());
		shopCart.setUserId(userId);
		shopCart.setNumber(1);
		shopCartDao.insert(shopCart);
		}
		return true;
    }
    
     @Override
    public List<ShopCart> queryAll(Map<String, Object> map){
    	MapPageUtil<ShopCart> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopCart> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<ShopCart> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopCart> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
    public Map<String, Object> queryDetails(Integer id) {
        return shopCartDao.select(id);
    }
    
    @Override
	public int save(ShopCart entity) {
    	ShopCart shopCart=new ShopCart();
    	BeanUtils.copyProperties(entity, shopCart);
		return shopCartDao.insert(shopCart);
	}

    @Override
    public int update(ShopCart entity) {
    	ShopCart shopCart=new ShopCart();
    	BeanUtils.copyProperties(entity, shopCart);
        return shopCartDao.updateById(shopCart);
    }

    @Override
    public int delete(Integer id) {
    	return shopCartDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return shopCartDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	ShopCartQuery query=new ShopCartQuery();
        return shopCartDao.countByQuery(query);
    }

	@Override
    public List<ShopCart> selectByQuery(){
    	ShopCartQuery query=new ShopCartQuery();
        return shopCartDao.selectByQuery(query);
    }
	
	@Override
    public ShopCart selectOne(){
    	ShopCartQuery query=new ShopCartQuery();
        return shopCartDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	ShopCartQuery query=new ShopCartQuery();
        return shopCartDao.deleteByQuery(query);
    }
}
