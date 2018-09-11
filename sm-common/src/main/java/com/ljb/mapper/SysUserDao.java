package com.ljb.mapper;

import com.ljb.entity.SysUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.SysUserQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 系统用户Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-07-26 06:45:21
 */
public interface SysUserDao extends BaseMapper<SysUser>,BaseDao<SysUser> {

    int countByQuery(SysUserQuery query);

	List<SysUser> selectByQuery(SysUserQuery query);
	
	SysUser selectOne(SysUserQuery query);
	
	int deleteByQuery(SysUserQuery query);

}
