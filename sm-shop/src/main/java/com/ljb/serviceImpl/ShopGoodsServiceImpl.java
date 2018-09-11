package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.ShopGoodsDao;
import com.ljb.entity.ShopGoods;
import com.ljb.service.ShopGoodsService;
import com.ljb.query.ShopGoodsQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.MapPageUtil;
import com.ljb.utils.Query;
import com.ljb.shiro.ShiroUtils;
import com.ljb.utils.DateUtils;
import com.ljb.utils.FormatUtils;
import com.ljb.utils.IdUtil;

/**
 * 商品管理Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:22
 */
@Service
public class ShopGoodsServiceImpl extends ServiceImpl<ShopGoodsDao,ShopGoods> implements ShopGoodsService {
    @Autowired
    private ShopGoodsDao shopGoodsDao;
    
    @Override
    public ShopGoods queryObject(Integer id) {
        return shopGoodsDao.selectById(id);
    }

    @Override
    public Page<ShopGoods> queryList(Map<String, Object> map) {
        MapPageUtil<ShopGoods> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopGoods> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
    @Override
    public List<Map<String, Object>> queryListByConstitution(Map<String, Object> params){
    	Query query=new Query(params);
    	return shopGoodsDao.queryListByConstitution(query);
    }
    
    @Override
    public Page<Map<String, Object>> queryListByCategory(Integer id){
    	EntityWrapper<ShopGoods> wrapper=new EntityWrapper<>();
    	wrapper.where("category_id = {0}", id).orderBy("create_time", false);
    	Page<ShopGoods> page=new Page<>(1, 4);
    	return selectMapsPage(page, wrapper);
    }
    
    @Override
    public Page<Map<String, Object>> queryListByCategoryIds(Integer[] ids){
    	EntityWrapper<ShopGoods> wrapper=new EntityWrapper<>();
    	wrapper.in("category_id", ids).orderBy("create_time", false);
    	Page<ShopGoods> page=new Page<>(1, 50);
    	return selectMapsPage(page, wrapper);
    }
    
    @Override
    public List<Map<String, Object>> queryListBy(Map<String, Object> params){
    	Query query=new Query(params);
    	return shopGoodsDao.selectByPage(query);
    }
    
     @Override
    public List<ShopGoods> queryAll(Map<String, Object> map){
    	MapPageUtil<ShopGoods> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopGoods> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<ShopGoods> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ShopGoods> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
    public Map<String, Object> queryDetails(Integer id) {
        return shopGoodsDao.select(id);
    }
    
    @Override
	public int save(ShopGoods entity) {
    	ShopGoods shopGoods=new ShopGoods();
    	BeanUtils.copyProperties(entity, shopGoods);
		shopGoods.setCreateId(ShiroUtils.getSysUserId());
    	shopGoods.setCreateTime(DateUtils.currentTime());
    	shopGoods.setGoodsSn(IdUtil.createIdByDate());
		return shopGoodsDao.insert(shopGoods);
	}

    @Override
    public int update(ShopGoods entity) {
    	ShopGoods shopGoods=new ShopGoods();
    	BeanUtils.copyProperties(entity, shopGoods);
		shopGoods.setUpdateId(ShiroUtils.getSysUserId());
    	shopGoods.setUpdateTime(DateUtils.currentTime());
        return shopGoodsDao.updateById(shopGoods);
    }

    @Override
    public int delete(Integer id) {
    	return shopGoodsDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return shopGoodsDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	ShopGoodsQuery query=new ShopGoodsQuery();
        return shopGoodsDao.countByQuery(query);
    }

	@Override
    public List<ShopGoods> selectByQuery(){
    	ShopGoodsQuery query=new ShopGoodsQuery();
        return shopGoodsDao.selectByQuery(query);
    }
	
	@Override
    public ShopGoods selectOne(){
    	ShopGoodsQuery query=new ShopGoodsQuery();
        return shopGoodsDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	ShopGoodsQuery query=new ShopGoodsQuery();
        return shopGoodsDao.deleteByQuery(query);
    }
}
