package com.ljb.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.SysMenuDao;
import com.ljb.mapper.SysRoleMenuDao;
import com.ljb.entity.SysMenu;
import com.ljb.entity.SysRole;
import com.ljb.entity.SysRoleMenu;
import com.ljb.service.SysRoleMenuService;
import com.ljb.query.SysMenuQuery;
import com.ljb.query.SysRoleMenuQuery;
import com.ljb.query.SysRoleQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.Constant;
import com.ljb.utils.DateUtils;
import com.ljb.utils.MapPageUtil;
import com.ljb.utils.MapUtils;
import com.ljb.utils.TreeUtils;
import com.ljb.utils.ZTree;
import com.ljb.viewmodel.MenuModel;

import javassist.expr.NewArray;

/**
 * 角色与菜单Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-01 18:05:57
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuDao,SysRoleMenu> implements SysRoleMenuService {
   private static Logger logger=LoggerFactory.getLogger(SysRoleMenuServiceImpl.class);
	
	@Autowired
    private SysRoleMenuDao sysRoleMenuDao;
    
    @Autowired
    private SysMenuDao sysMenuDao;
    
    @Override
    public SysRoleMenu queryObject(Integer id) {
        return sysRoleMenuDao.selectById(id);
    }
    
    @Override
    public Collection<Object> menuList(Integer roleId,Integer adminId){
    	List<MenuModel> result = new ArrayList<>();
    	List<SysMenu> allMenu=new ArrayList<>();
    	if(adminId==Constant.SUPER_ADMIN) {
    		SysMenuQuery query=new SysMenuQuery();
    		allMenu=sysMenuDao.selectByQuery(query);
    	}else {
    		allMenu=sysMenuDao.allListByUserId(adminId);
    	}
    	List<SysMenu> hasMenu=sysMenuDao.allListByRoleId(roleId);
    	Map<Integer,Object> hasMap=hasMenu.stream().collect(Collectors.toMap(SysMenu::getId,a->a,(k1,k2)->k1));
    	List<ZTree> list=new ArrayList<>();
    	for (SysMenu menu : allMenu) {
			ZTree zTree=new ZTree();
			BeanUtils.copyProperties(menu, zTree);
			if(hasMap.containsKey(menu.getId()))
				zTree.setChecked(true);
			list.add(zTree);
		}
    	return TreeUtils.buildTree(list);
    }    

    @Override
   	public int save(Integer roleId,Integer[] menuIds,Integer adminId) {
       	SysRoleMenuQuery query=new SysRoleMenuQuery();
       	query.createCriteria().androleIdEqualTo(roleId);
       	sysRoleMenuDao.deleteByQuery(query);
       	List<SysRoleMenu> list=new ArrayList<>();
       	for (Integer menuId : menuIds) {
   			SysRoleMenu sysRoleMenu=new SysRoleMenu();
   			sysRoleMenu.setMenuId(menuId);
   			sysRoleMenu.setRoleId(roleId);
   			sysRoleMenu.setCreateId(adminId);
   			sysRoleMenu.setCreateTime(DateUtils.currentTime());
   			list.add(sysRoleMenu);
   			}
   		return insertBatch(list)?1:0;
   	}
    
    @Override
    public Page<SysRoleMenu> queryList(Map<String, Object> map) {
        MapPageUtil<SysRoleMenu> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysRoleMenu> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
     @Override
    public List<SysRoleMenu> queryAll(Map<String, Object> map){
    	MapPageUtil<SysRoleMenu> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysRoleMenu> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<SysRoleMenu> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysRoleMenu> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
	public int save(SysRoleMenu entity) {
    	SysRoleMenu sysRoleMenu=new SysRoleMenu();
    	BeanUtils.copyProperties(entity, sysRoleMenu);
		return sysRoleMenuDao.insert(sysRoleMenu);
	}

    @Override
    public int update(SysRoleMenu entity) {
    	SysRoleMenu sysRoleMenu=new SysRoleMenu();
    	BeanUtils.copyProperties(entity, sysRoleMenu);
        return sysRoleMenuDao.updateById(sysRoleMenu);
    }

    @Override
    public int delete(Integer id) {
    	return sysRoleMenuDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return sysRoleMenuDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	SysRoleMenuQuery query=new SysRoleMenuQuery();
        return sysRoleMenuDao.countByQuery(query);
    }

	@Override
    public List<SysRoleMenu> selectByQuery(){
    	SysRoleMenuQuery query=new SysRoleMenuQuery();
        return sysRoleMenuDao.selectByQuery(query);
    }
	
	@Override
    public SysRoleMenu selectOne(){
    	SysRoleMenuQuery query=new SysRoleMenuQuery();
        return sysRoleMenuDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	SysRoleMenuQuery query=new SysRoleMenuQuery();
        return sysRoleMenuDao.deleteByQuery(query);
    }
}
