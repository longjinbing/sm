package com.ljb.mapper;

import com.ljb.entity.SysDept;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.SysDeptQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 部门管理Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-07-26 06:45:21
 */
public interface SysDeptDao extends BaseMapper<SysDept>,BaseDao<SysDept> {

    int countByQuery(SysDeptQuery query);

	List<SysDept> selectByQuery(SysDeptQuery query);
	
	List<SysDept> deptListByUserId(Integer userId);
	
	SysDept selectOne(SysDeptQuery query);
	
	int deleteByQuery(SysDeptQuery query);

}
