package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.SysUserRoleDao;
import com.ljb.entity.SysUserRole;
import com.ljb.service.SysUserRoleService;
import com.ljb.query.SysUserRoleQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.DateUtils;
import com.ljb.utils.MapPageUtil;

/**
 * 用户与角色Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-01 18:05:56
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao,SysUserRole> implements SysUserRoleService {
    @Autowired
    private SysUserRoleDao sysUserRoleDao;
    
    @Override
    public SysUserRole queryObject(Integer id) {
        return sysUserRoleDao.selectById(id);
    }

    @Override
    public Page<SysUserRole> queryList(Map<String, Object> map) {
        MapPageUtil<SysUserRole> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysUserRole> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
    @Override
	public int save(Integer id,Integer[] roleIds,Integer userId) {
    	SysUserRoleQuery query=new SysUserRoleQuery();
    	query.createCriteria().anduserIdEqualTo(id);
    	sysUserRoleDao.deleteByQuery(query);
    	List<SysUserRole> list=new ArrayList<>();
    	for (Integer roleId : roleIds) {
			SysUserRole sysUserRole=new SysUserRole();
			sysUserRole.setUserId(id);
			sysUserRole.setRoleId(roleId);
			sysUserRole.setCreateId(userId);
			sysUserRole.setCreateTime(DateUtils.currentTime());
			list.add(sysUserRole);
			}
		return insertBatch(list)==true?1:0;
	}
    
     @Override
    public List<SysUserRole> queryAll(Map<String, Object> map){
    	MapPageUtil<SysUserRole> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysUserRole> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<SysUserRole> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysUserRole> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
	public int save(SysUserRole entity) {
    	SysUserRole sysUserRole=new SysUserRole();
    	BeanUtils.copyProperties(entity, sysUserRole);
		return sysUserRoleDao.insert(sysUserRole);
	}

    @Override
    public int update(SysUserRole entity) {
    	SysUserRole sysUserRole=new SysUserRole();
    	BeanUtils.copyProperties(entity, sysUserRole);
        return sysUserRoleDao.updateById(sysUserRole);
    }

    @Override
    public int delete(Integer id) {
    	return sysUserRoleDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return sysUserRoleDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	SysUserRoleQuery query=new SysUserRoleQuery();
        return sysUserRoleDao.countByQuery(query);
    }

	@Override
    public List<SysUserRole> selectByQuery(){
    	SysUserRoleQuery query=new SysUserRoleQuery();
        return sysUserRoleDao.selectByQuery(query);
    }
	
	@Override
    public SysUserRole selectOne(){
    	SysUserRoleQuery query=new SysUserRoleQuery();
        return sysUserRoleDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	SysUserRoleQuery query=new SysUserRoleQuery();
        return sysUserRoleDao.deleteByQuery(query);
    }
}
