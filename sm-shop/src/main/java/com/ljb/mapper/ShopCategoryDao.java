package com.ljb.mapper;

import com.ljb.entity.ShopCategory;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.ShopCategoryQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 商品分类Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-10 05:47:21
 */
public interface ShopCategoryDao extends BaseMapper<ShopCategory>,BaseDao<ShopCategory> {

    int countByQuery(ShopCategoryQuery query);

	List<ShopCategory> selectByQuery(ShopCategoryQuery query);
	
	ShopCategory selectOne(ShopCategoryQuery query);
	
	int deleteByQuery(ShopCategoryQuery query);

}
