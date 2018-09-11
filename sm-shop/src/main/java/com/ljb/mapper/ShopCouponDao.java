package com.ljb.mapper;

import com.ljb.entity.ShopCoupon;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.ShopCouponQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 优惠券管理Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:21
 */
public interface ShopCouponDao extends BaseMapper<ShopCoupon>,BaseDao<ShopCoupon> {

    int countByQuery(ShopCouponQuery query);

	List<ShopCoupon> selectByQuery(ShopCouponQuery query);
	
	ShopCoupon selectOne(ShopCouponQuery query);
	
	int deleteByQuery(ShopCouponQuery query);

}
