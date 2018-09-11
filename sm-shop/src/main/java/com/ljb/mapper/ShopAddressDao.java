package com.ljb.mapper;

import com.ljb.entity.ShopAddress;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.ShopAddressQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 用户地址Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:22
 */
public interface ShopAddressDao extends BaseMapper<ShopAddress>,BaseDao<ShopAddress> {

    int countByQuery(ShopAddressQuery query);

	List<ShopAddress> selectByQuery(ShopAddressQuery query);
	
	ShopAddress selectOne(ShopAddressQuery query);
	
	int deleteByQuery(ShopAddressQuery query);

}
