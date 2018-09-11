package com.ljb.mapper;

import com.ljb.entity.SysMenu;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.SysMenuQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 菜单管理Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-07-26 06:45:21
 */
public interface SysMenuDao extends BaseMapper<SysMenu>,BaseDao<SysMenu> {

    int countByQuery(SysMenuQuery query);
    
    List<SysMenu> menuByUserId(Integer userId);

    List<SysMenu> menuListByUserId(Integer userId);
    
    List<SysMenu> allListByUserId(Integer userId);
    
    List<SysMenu> allListByRoleId(Integer roleId);

	List<SysMenu> selectByQuery(SysMenuQuery query);
	
	SysMenu selectOne(SysMenuQuery query);
	
	int deleteByQuery(SysMenuQuery query);

}
