package com.ljb.mapper;

import com.ljb.entity.ResultDetails;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.ResultDetailsQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 体质测试结果详情Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-08 17:18:14
 */
public interface ResultDetailsDao extends BaseMapper<ResultDetails>,BaseDao<ResultDetails> {

    int countByQuery(ResultDetailsQuery query);

	List<ResultDetails> selectByQuery(ResultDetailsQuery query);
	
	ResultDetails selectOne(ResultDetailsQuery query);
	
	int deleteByQuery(ResultDetailsQuery query);

}
