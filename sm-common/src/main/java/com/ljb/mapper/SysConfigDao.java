package com.ljb.mapper;

import com.ljb.entity.SysConfig;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.SysConfigQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 系统配置信息表Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-07-26 06:45:21
 */
public interface SysConfigDao extends BaseMapper<SysConfig>,BaseDao<SysConfig> {

    int countByQuery(SysConfigQuery query);

	List<SysConfig> selectByQuery(SysConfigQuery query);
	
	SysConfig selectOne(SysConfigQuery query);
	
	int deleteByQuery(SysConfigQuery query);

}
