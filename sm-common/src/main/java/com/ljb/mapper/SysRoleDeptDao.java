package com.ljb.mapper;

import com.ljb.entity.SysRoleDept;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.SysRoleDeptQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 角色与部门对应关系Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-07-26 06:45:21
 */
public interface SysRoleDeptDao extends BaseMapper<SysRoleDept>,BaseDao<SysRoleDept> {

    int countByQuery(SysRoleDeptQuery query);

	List<SysRoleDept> selectByQuery(SysRoleDeptQuery query);
	
	SysRoleDept selectOne(SysRoleDeptQuery query);
	
	int deleteByQuery(SysRoleDeptQuery query);

}
