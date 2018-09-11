package com.ljb.mapper;

import com.ljb.entity.SysRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.SysRoleQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 角色管理Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-07-26 06:45:21
 */
public interface SysRoleDao extends BaseMapper<SysRole>,BaseDao<SysRole> {

    int countByQuery(SysRoleQuery query);
    
    List<SysRole> roleByUserId(Integer userId);

	List<SysRole> selectByQuery(SysRoleQuery query);
	
	SysRole selectOne(SysRoleQuery query);
	
	int deleteByQuery(SysRoleQuery query);

}
