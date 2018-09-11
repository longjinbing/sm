package com.ljb.mapper;

import com.ljb.entity.ShopUserCoupon;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.ShopUserCouponQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 用户优惠券管理Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:21
 */
public interface ShopUserCouponDao extends BaseMapper<ShopUserCoupon>,BaseDao<ShopUserCoupon> {

    int countByQuery(ShopUserCouponQuery query);

	List<ShopUserCoupon> selectByQuery(ShopUserCouponQuery query);
	
	ShopUserCoupon selectOne(ShopUserCouponQuery query);
	
	int deleteByQuery(ShopUserCouponQuery query);

}
