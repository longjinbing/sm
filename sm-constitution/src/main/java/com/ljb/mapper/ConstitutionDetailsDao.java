package com.ljb.mapper;

import com.ljb.entity.ConstitutionDetails;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.ConstitutionDetailsQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 体质介绍Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-08 16:59:04
 */
public interface ConstitutionDetailsDao extends BaseMapper<ConstitutionDetails>,BaseDao<ConstitutionDetails> {

    int countByQuery(ConstitutionDetailsQuery query);

	List<ConstitutionDetails> selectByQuery(ConstitutionDetailsQuery query);
	
	ConstitutionDetails selectOne(ConstitutionDetailsQuery query);
	
	int deleteByQuery(ConstitutionDetailsQuery query);

}
