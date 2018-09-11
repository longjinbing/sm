package com.ljb.mapper;

import com.ljb.entity.ConstitutionResult;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.ConstitutionResultQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 体质测试结果Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-07 18:22:42
 */
public interface ConstitutionResultDao extends BaseMapper<ConstitutionResult>,BaseDao<ConstitutionResult> {

    int countByQuery(ConstitutionResultQuery query);

	List<ConstitutionResult> selectByQuery(ConstitutionResultQuery query);
	
	ConstitutionResult selectOne(ConstitutionResultQuery query);
	
	int deleteByQuery(ConstitutionResultQuery query);

}
