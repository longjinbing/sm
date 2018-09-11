package com.ljb.mapper;

import com.ljb.entity.ShopCart;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.ShopCartQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 购物车Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:22
 */
public interface ShopCartDao extends BaseMapper<ShopCart>,BaseDao<ShopCart> {

    int countByQuery(ShopCartQuery query);

	List<ShopCart> selectByQuery(ShopCartQuery query);
	
	ShopCart selectOne(ShopCartQuery query);
	
	int deleteByQuery(ShopCartQuery query);

}
