package com.ljb.mapper;

import com.ljb.entity.Constitution;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.ConstitutionQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 体质管理Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-07 18:22:42
 */
public interface ConstitutionDao extends BaseMapper<Constitution>,BaseDao<Constitution> {

    int countByQuery(ConstitutionQuery query);

	List<Constitution> selectByQuery(ConstitutionQuery query);
	
	Constitution selectOne(ConstitutionQuery query);
	
	int deleteByQuery(ConstitutionQuery query);

}
