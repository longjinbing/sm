package com.ljb.mapper;

import com.ljb.entity.ShopCollect;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.ShopCollectQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 用户收藏Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 09:59:38
 */
public interface ShopCollectDao extends BaseMapper<ShopCollect>,BaseDao<ShopCollect> {

    int countByQuery(ShopCollectQuery query);

	List<ShopCollect> selectByQuery(ShopCollectQuery query);
	
	ShopCollect selectOne(ShopCollectQuery query);
	
	int deleteByQuery(ShopCollectQuery query);

}
