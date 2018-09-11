package com.ljb.mapper;

import com.ljb.entity.ShopOrder;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.ShopOrderQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 订单管理Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:22
 */
public interface ShopOrderDao extends BaseMapper<ShopOrder>,BaseDao<ShopOrder> {

    int countByQuery(ShopOrderQuery query);

	List<ShopOrder> selectByQuery(ShopOrderQuery query);
	
	ShopOrder selectOne(ShopOrderQuery query);
	
	int deleteByQuery(ShopOrderQuery query);

}
