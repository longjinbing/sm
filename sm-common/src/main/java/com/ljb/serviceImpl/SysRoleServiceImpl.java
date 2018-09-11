package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.SysRoleDao;
import com.ljb.entity.SysRole;
import com.ljb.service.SysRoleService;
import com.ljb.query.SysRoleQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.Constant;
import com.ljb.utils.DateUtils;
import com.ljb.utils.MapPageUtil;

/**
 * 角色管理Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-01 18:05:57
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao,SysRole> implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;
    
    @Override
    public SysRole queryObject(Integer id) {
        return sysRoleDao.selectById(id);
    }
    
    @Override
    public List<String> roleNames(Integer userId){
    	List<SysRole> roles;
    	List<String> roleNames=new ArrayList<String>();
    	//判断是否是超级管理员
    	if(userId==Constant.SUPER_ADMIN) {
    		roleNames.add("超级管理员");
    	}else {
    		roles=sysRoleDao.roleByUserId(userId);
    		for (SysRole role : roles) {
				roleNames.add(role.getName());
			}
    	}
    	return roleNames;
    }
    
    @Override
    public List<Map<String, Object>> roleListByuserIdAndAdminId(Integer userId,Integer adminId){
    	//登录账户所拥有的角色
    	List<SysRole> allRoles;
    	//判断是否是超级管理员
    	if(adminId==Constant.SUPER_ADMIN) {
    		SysRoleQuery query=new SysRoleQuery();
    		allRoles=sysRoleDao.selectByQuery(query);
    	}else {
    		allRoles=sysRoleDao.roleByUserId(adminId);
    	}
    	//将赋予角色用户拥有的角色
    	List<SysRole> hasRoles;
    	if(userId==Constant.SUPER_ADMIN) {
    		SysRoleQuery query=new SysRoleQuery();
    		hasRoles=sysRoleDao.selectByQuery(query);
    	}else {
    		hasRoles=sysRoleDao.roleByUserId(userId);
    	}
    	Map<Integer, Object> ids=new HashMap<>();
    	for (SysRole role : hasRoles) {
			ids.put(role.getId(), "");
		}
    	List<Map<String, Object>> result=new ArrayList<>();
    	for (SysRole role : allRoles) {
    		Map<String, Object> map=new HashMap<>();
    		map.put("id", role.getId());
    		map.put("name", role.getName());
    		if(ids.containsKey(role.getId())) {
    			map.put("checked", true);
    		}else {
    			map.put("checked", false);
    		}
    		result.add(map);
		}
    	return result;
    }


    @Override
    public Page<SysRole> queryList(Map<String, Object> map) {
        MapPageUtil<SysRole> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysRole> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
     @Override
    public List<SysRole> queryAll(Map<String, Object> map){
    	MapPageUtil<SysRole> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysRole> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<SysRole> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysRole> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
	public int save(SysRole entity) {
    	SysRole sysRole=new SysRole();
    	BeanUtils.copyProperties(entity, sysRole);
    	sysRole.setCreateTime(DateUtils.currentTime());
		return sysRoleDao.insert(sysRole);
	}

    @Override
    public int update(SysRole entity) {
    	SysRole sysRole=new SysRole();
    	BeanUtils.copyProperties(entity, sysRole);
        return sysRoleDao.updateById(sysRole);
    }

    @Override
    public int delete(Integer id) {
    	return sysRoleDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return sysRoleDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	SysRoleQuery query=new SysRoleQuery();
        return sysRoleDao.countByQuery(query);
    }

	@Override
    public List<SysRole> selectByQuery(){
    	SysRoleQuery query=new SysRoleQuery();
        return sysRoleDao.selectByQuery(query);
    }
	
	@Override
    public SysRole selectOne(){
    	SysRoleQuery query=new SysRoleQuery();
        return sysRoleDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	SysRoleQuery query=new SysRoleQuery();
        return sysRoleDao.deleteByQuery(query);
    }
}
