package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.SysMenuDao;
import com.ljb.annotation.DescBean;
import com.ljb.entity.SysMenu;
import com.ljb.service.SysMenuService;
import com.ljb.query.SysMenuQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.Constant;
import com.ljb.utils.MapPageUtil;
import com.ljb.utils.TreeUtils;
import com.ljb.utils.ZTree;

/**
 * 菜单管理Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-01 18:05:57
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao,SysMenu> implements SysMenuService {
    @Autowired
    private SysMenuDao sysMenuDao;
    
    @Autowired
    private DescBean descBean;
    
    @Override
    public SysMenu queryObject(Integer id) {
        return sysMenuDao.selectById(id);
    }
    
    @Override
    public List<String> permissions(Integer userId){
    	List<String> permission=new ArrayList<String>();
    	List<SysMenu> menus;
    	if(userId.equals(Constant.SUPER_ADMIN)) {
    		SysMenuQuery query=new SysMenuQuery();
    		Integer[] types= {1,2};
    		query.createCriteria().andtypeIn(Arrays.asList(types));
    		menus=sysMenuDao.selectByQuery(query);
    	}else {
    	menus=sysMenuDao.menuByUserId(userId);
    	}
    	for (SysMenu sysMenu : menus) {
    		if(sysMenu.getType()==2) {
			permission.add(sysMenu.getPerms());
    		}else if(sysMenu.getType()==1) {
    			permission.add(sysMenu.getUrl());
    		}
		}
    	return permission;
    }
    
    
    
    @Override
    public Collection<Object> menuList(Integer userId){
    	List<SysMenu> menus;
    	if(userId==Constant.SUPER_ADMIN) {
    		SysMenuQuery query=new SysMenuQuery();
    		Integer[] types= {0,1} ;
    		query.createCriteria().andtypeIn(Arrays.asList(types)).andstatusEqualTo(1);
    		menus=sysMenuDao.selectByQuery(query);
    	}else {
    	menus=sysMenuDao.menuListByUserId(userId);
    	}
    	return TreeUtils.buildTree(menus);
    }
    
    @Override
    public Collection<Object> zTreeList(Integer userId){
    	List<SysMenu> menus;
    	if(userId==Constant.SUPER_ADMIN) {
    		SysMenuQuery query=new SysMenuQuery();
    		Integer[] types= {0,1} ;
    		query.createCriteria().andtypeIn(Arrays.asList(types));
    		menus=sysMenuDao.selectByQuery(query);
    	}else {
    	menus=sysMenuDao.menuListByUserId(userId);
    	}
    	SysMenu sysMenu=new SysMenu();
    	sysMenu.setId(0);
    	sysMenu.setName("主菜单");
    	sysMenu.setParentId(-1);
    	sysMenu.setType(-1);
    	menus.add(sysMenu);
    	return TreeUtils.buildTree(menus);
    }
    
    @Override
    public Collection<Object> menuSelectList(Integer userId){
    	List<SysMenu> menus;
    	if(userId==Constant.SUPER_ADMIN) {
    		SysMenuQuery query=new SysMenuQuery();
    		Integer[] types= {0,1} ;
    		query.createCriteria().andtypeIn(Arrays.asList(types));
    		menus=sysMenuDao.selectByQuery(query);
    	}else {
    	menus=sysMenuDao.menuListByUserId(userId);
    	}
    	return TreeUtils.buildTree(menus);
    }
    
    @Override
    public Boolean refershMenu() {
    	SysMenuQuery sysMenuQuery=new SysMenuQuery();
    	sysMenuDao.deleteByQuery(sysMenuQuery);
    	List<ZTree> ztreeList=descBean.getZtree();
    	for (ZTree root : ztreeList) {
    		int rootNum=1;
    		List<ZTree>	menuList=root.getChildren();
    		SysMenu r=new SysMenu();
    		r.setName(root.getName());
    		r.setIcon(root.getIcon());
    		r.setOrderNum(rootNum);
    		r.setType(0);
    		r.setParentId(0);
    		r.setStatus(1);
    		sysMenuDao.insert(r);
    		rootNum++;
    		int menuNum=1;
			if(menuList!=null) {
				for (ZTree menu : menuList) {
					SysMenu m=new SysMenu();
		    		m.setName(menu.getName());
		    		m.setIcon(menu.getIcon());
		    		m.setOrderNum(menuNum);
		    		m.setType(1);
		    		m.setParentId(r.getId());
		    		m.setUrl(menu.getUrl());
		    		m.setStatus(1);
		    		sysMenuDao.insert(m);
		    		menuNum++;
					List<ZTree>	buttonList=menu.getChildren();
					int buttonNum=1;
					if(buttonList!=null) {
						for (ZTree button : buttonList) {
							SysMenu b=new SysMenu();
				    		b.setName(button.getName());
				    		b.setIcon(button.getIcon());
				    		b.setOrderNum(buttonNum);
				    		b.setType(2);
				    		b.setParentId(m.getId());
				    		b.setPerms(button.getUrl());
				    		b.setStatus(1);
				    		sysMenuDao.insert(b);
				    		buttonNum++;
						}
					}
				}
			}
		}
    	return true;
    }
    

    @Override
    public Page<SysMenu> queryList(Map<String, Object> map) {
        MapPageUtil<SysMenu> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysMenu> wrapper=mapPage.condition();
    	wrapper.where("parent_id= {0}", map.get("id"));
        return selectPage(mapPage.page(), wrapper);
    }
    
     @Override
    public List<SysMenu> queryAll(Map<String, Object> map){
    	MapPageUtil<SysMenu> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysMenu> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<SysMenu> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysMenu> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
	public int save(SysMenu entity) {
    	if(entity.getParentId()==0) {
    		entity.setType(0);
    	}else {
    		entity.setType(selectById(entity.getParentId()).getType()+1);
    	}
		return sysMenuDao.insert(entity);
	}

    @Override
    public int update(SysMenu entity) {
    	SysMenu sysMenu=new SysMenu();
    	BeanUtils.copyProperties(entity, sysMenu);
        return sysMenuDao.updateById(sysMenu);
    }

    @Override
    public int delete(Integer id) {
    	return sysMenuDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return sysMenuDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	SysMenuQuery query=new SysMenuQuery();
        return sysMenuDao.countByQuery(query);
    }

	@Override
    public List<SysMenu> selectByQuery(){
    	SysMenuQuery query=new SysMenuQuery();
        return sysMenuDao.selectByQuery(query);
    }
	
	@Override
    public SysMenu selectOne(){
    	SysMenuQuery query=new SysMenuQuery();
        return sysMenuDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	SysMenuQuery query=new SysMenuQuery();
        return sysMenuDao.deleteByQuery(query);
    }
	
}
