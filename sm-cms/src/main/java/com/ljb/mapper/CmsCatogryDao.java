package com.ljb.mapper;

import com.ljb.entity.CmsCatogry;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.CmsCatogryQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 目录Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-05 13:08:46
 */
public interface CmsCatogryDao extends BaseMapper<CmsCatogry>,BaseDao<CmsCatogry> {

    int countByQuery(CmsCatogryQuery query);

	List<CmsCatogry> selectByQuery(CmsCatogryQuery query);
	
	CmsCatogry selectOne(CmsCatogryQuery query);
	
	int deleteByQuery(CmsCatogryQuery query);

}
