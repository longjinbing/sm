package com.ljb.mapper;

import com.ljb.entity.SysUserRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.SysUserRoleQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 用户与角色Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-07-26 06:45:21
 */
public interface SysUserRoleDao extends BaseMapper<SysUserRole>,BaseDao<SysUserRole> {

    int countByQuery(SysUserRoleQuery query);

	List<SysUserRole> selectByQuery(SysUserRoleQuery query);
	
	SysUserRole selectOne(SysUserRoleQuery query);
	
	int deleteByQuery(SysUserRoleQuery query);

}
