package com.ljb.mapper;

import com.ljb.entity.HomeCursor;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.HomeCursorQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 首页轮播Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-05 13:08:46
 */
public interface HomeCursorDao extends BaseMapper<HomeCursor>,BaseDao<HomeCursor> {

    int countByQuery(HomeCursorQuery query);

	List<HomeCursor> selectByQuery(HomeCursorQuery query);
	
	HomeCursor selectOne(HomeCursorQuery query);
	
	int deleteByQuery(HomeCursorQuery query);

}
