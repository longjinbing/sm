package com.ljb.mapper;

import com.ljb.entity.ShopOrderDetails;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.ShopOrderDetailsQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 订单详情Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 17:06:39
 */
public interface ShopOrderDetailsDao extends BaseMapper<ShopOrderDetails>,BaseDao<ShopOrderDetails> {

    int countByQuery(ShopOrderDetailsQuery query);

	List<ShopOrderDetails> selectByQuery(ShopOrderDetailsQuery query);
	
	ShopOrderDetails selectOne(ShopOrderDetailsQuery query);
	
	int deleteByQuery(ShopOrderDetailsQuery query);

}
