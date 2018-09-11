package com.ljb.mapper;

import com.ljb.entity.SysLog;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.SysLogQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 系统日志Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-07-26 06:45:21
 */
public interface SysLogDao extends BaseMapper<SysLog>,BaseDao<SysLog> {

    int countByQuery(SysLogQuery query);

	List<SysLog> selectByQuery(SysLogQuery query);
	
	SysLog selectOne(SysLogQuery query);
	
	int deleteByQuery(SysLogQuery query);

}
