package com.ljb.mapper;

import com.ljb.entity.SysRoleMenu;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.SysRoleMenuQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 角色与菜单Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-07-26 06:45:21
 */
public interface SysRoleMenuDao extends BaseMapper<SysRoleMenu>,BaseDao<SysRoleMenu> {

    int countByQuery(SysRoleMenuQuery query);

	List<SysRoleMenu> selectByQuery(SysRoleMenuQuery query);
	
	SysRoleMenu selectOne(SysRoleMenuQuery query);
	
	int deleteByQuery(SysRoleMenuQuery query);

}
