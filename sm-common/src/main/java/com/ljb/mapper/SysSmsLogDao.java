package com.ljb.mapper;

import com.ljb.entity.SysSmsLog;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.SysSmsLogQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-07-26 06:45:21
 */
public interface SysSmsLogDao extends BaseMapper<SysSmsLog>,BaseDao<SysSmsLog> {

    int countByQuery(SysSmsLogQuery query);

	List<SysSmsLog> selectByQuery(SysSmsLogQuery query);
	
	SysSmsLog selectOne(SysSmsLogQuery query);
	
	int deleteByQuery(SysSmsLogQuery query);

}
