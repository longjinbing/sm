package com.ljb.mapper;

import com.ljb.entity.ShopGoods;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.ShopGoodsQuery;
import com.ljb.utils.BaseDao;
import java.util.List;
import java.util.Map;

/**
 * 商品管理Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:22
 */
public interface ShopGoodsDao extends BaseMapper<ShopGoods>,BaseDao<ShopGoods> {

    int countByQuery(ShopGoodsQuery query);

	List<ShopGoods> selectByQuery(ShopGoodsQuery query);
	
	List<Map<String, Object>> queryListByConstitution(Map<String, Object> params);
	
	ShopGoods selectOne(ShopGoodsQuery query);
	
	int deleteByQuery(ShopGoodsQuery query);

}
