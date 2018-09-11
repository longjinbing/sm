package com.ljb.serviceImpl;

import org.apache.commons.validator.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.ShopCartDao;
import com.ljb.mapper.ShopGoodsDao;
import com.ljb.mapper.ShopOrderDao;
import com.ljb.mapper.ShopOrderDetailsDao;
import com.ljb.entity.ShopCart;
import com.ljb.entity.ShopGoods;
import com.ljb.entity.ShopOrder;
import com.ljb.entity.ShopOrderDetails;
import com.ljb.service.ShopOrderService;
import com.ljb.query.ShopOrderQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.MapPageUtil;

import javassist.expr.NewArray;

import com.ljb.shiro.ShiroUtils;
import com.ljb.utils.DateUtils;
import com.ljb.utils.IdUtil;

/**
 * 订单管理Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:22
 */
@Service
public class ShopOrderServiceImpl extends ServiceImpl<ShopOrderDao,ShopOrder> implements ShopOrderService {
    @Autowired
    private ShopOrderDao shopOrderDao;
    
    @Autowired
    private ShopCartDao shopCartDao;
    
    @Autowired
    private ShopGoodsDao shopGoodsDao;
    
    @Autowired
    private ShopOrderDetailsDao shopOrderDetailsDao;
    
    @Override
    public ShopOrder queryObject(Integer id) {
        return shopOrderDao.selectById(id);
    }

    @Override
    public Page<ShopOrder> queryList(Map<String, Object> map) {
        MapPageUtil<ShopOrder> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopOrder> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
     @Override
    public List<ShopOrder> queryAll(Map<String, Object> map){
    	MapPageUtil<ShopOrder> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopOrder> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }
     
     @Override
     public List<Map<String, Object>> orderList(Integer userId){
    	 EntityWrapper<ShopOrder> wrapper=new EntityWrapper<>();
    	 wrapper.where("user_id = {0}", userId).orderBy("id", false);
    	 List<ShopOrder> list=shopOrderDao.selectList(wrapper);
    	 List<Map<String, Object>> listMap=new ArrayList<>();
    	 for (ShopOrder shopOrder : list) {
    		 Map<String, Object> map=new HashMap<>();
    		 map= BeanUtils.bean2Map(shopOrder, true);
    		 EntityWrapper<ShopOrderDetails> wrapper2=new EntityWrapper<>();
    		 wrapper2.where("order_id = {0}",shopOrder.getId());
    		 List<ShopOrderDetails> list2=shopOrderDetailsDao.selectList(wrapper2);
    		 map.put("list",list2.get(0));
    		 listMap.add(map);
    	 }
    	 return listMap;
     }
     
     @Override
     public Map<String, Object> orderDetails(Integer id){
    	 ShopOrder shopOrder=shopOrderDao.selectById(id);
    	Map<String, Object> map=new HashMap<>();
    	map= BeanUtils.bean2Map(shopOrder, true);
    		 EntityWrapper<ShopOrderDetails> wrapper2=new EntityWrapper<>();
    		 wrapper2.where("order_id = {0}",shopOrder.getId());
    		 List<ShopOrderDetails> list2=shopOrderDetailsDao.selectList(wrapper2);
    		 map.put("list",list2);
    	 return map;
     }
     
     @Override
     public  Boolean submitOrder(Map<String, Object> map,Integer userId) {
    	 EntityWrapper<ShopCart> wrapper=new EntityWrapper<>();
     	wrapper.where("user_id = {0}", userId).orderBy("id", false);
     	List<ShopCart> shopCarts=shopCartDao.selectList(wrapper);
     	int sumPrice=0,marketSumPrice=0;
     	for (ShopCart shopCart : shopCarts) {
     		sumPrice+=shopCart.getPrice().intValue();
     		marketSumPrice+=shopCart.getMarketPrice().intValue();
		}
     	ShopOrder shopOrder=new ShopOrder();
     	BeanUtils.map2Bean(map, shopOrder);
     	shopOrder.setGoodsPrice( new BigDecimal(marketSumPrice));
     	shopOrder.setOrderPrice(new BigDecimal(sumPrice));
     	shopOrder.setShippingFee(new BigDecimal(0));
     	shopOrder.setOrderSn(IdUtil.createIdByDate());
     	shopOrder.setUserId(userId);
     	shopOrder.setStatus(1);
     	save(shopOrder);
     	for (ShopCart shopCart : shopCarts) {
     		ShopOrderDetails shopOrderDetails=new ShopOrderDetails();
     		shopOrderDetails.setGoodsId(shopCart.getGoodsId());
     		shopOrderDetails.setNumber(shopCart.getNumber());
     		shopOrderDetails.setPrice(shopCart.getPrice());
     		shopOrderDetails.setOrderId(shopOrder.getId());
     		shopOrderDetails.setPicUrl(shopCart.getListPicUrl());
     		shopOrderDetails.setTitle(shopCart.getGoodsName());
     		shopOrderDetailsDao.insert(shopOrderDetails);
		}
     	return true;
     }
     
     @Override
     public  Boolean submitOrder(Map<String, Object> map,Integer goodsId,Integer userId) {
    	ShopGoods shopGoods=shopGoodsDao.selectById(goodsId);
      	ShopOrder shopOrder=new ShopOrder();
      	BeanUtils.map2Bean(map, shopOrder);
      	shopOrder.setGoodsPrice(shopGoods.getMarketPrice());
      	shopOrder.setOrderPrice(shopGoods.getPrice());
      	shopOrder.setShippingFee(new BigDecimal(0));
      	shopOrder.setOrderSn(IdUtil.createIdByDate());
      	shopOrder.setStatus(1);
      	save(shopOrder);
      	ShopOrderDetails shopOrderDetails=new ShopOrderDetails();
 		shopOrderDetails.setGoodsId(shopGoods.getId());
 		int number=Integer.valueOf(map.get("number").toString());
 		shopOrderDetails.setNumber(number);
 		shopOrderDetails.setPrice(shopGoods.getPrice());
 		shopOrderDetails.setOrderId(shopOrder.getId());
 		shopOrderDetails.setPicUrl(shopGoods.getPrimaryPicUrl());
 		shopOrderDetails.setTitle(shopGoods.getTitle());
 		shopOrder.setUserId(userId);
 		shopOrderDetailsDao.insert(shopOrderDetails);
 		return true;
     }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<ShopOrder> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopOrder> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
    public Map<String, Object> queryDetails(Integer id) {
        return shopOrderDao.select(id);
    }
    
    @Override
	public int save(ShopOrder shopOrder) {
    	shopOrder.setCreateTime(DateUtils.currentTime());
		return shopOrderDao.insert(shopOrder);
	}

    @Override
    public int update(ShopOrder shopOrder) {
    	shopOrder.setUpdateTime(DateUtils.currentTime());
        return shopOrderDao.updateById(shopOrder);
    }

    @Override
    public int delete(Integer id) {
    	return shopOrderDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return shopOrderDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	ShopOrderQuery query=new ShopOrderQuery();
        return shopOrderDao.countByQuery(query);
    }

	@Override
    public List<ShopOrder> selectByQuery(){
    	ShopOrderQuery query=new ShopOrderQuery();
        return shopOrderDao.selectByQuery(query);
    }
	
	@Override
    public ShopOrder selectOne(){
    	ShopOrderQuery query=new ShopOrderQuery();
        return shopOrderDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	ShopOrderQuery query=new ShopOrderQuery();
        return shopOrderDao.deleteByQuery(query);
    }
}
