package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
import com.ljb.mapper.SysDeptDao;
import com.ljb.entity.SysDept;
import com.ljb.service.SysDeptService;
import com.ljb.query.SysDeptQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.Constant;
import com.ljb.utils.DateUtils;
import com.ljb.utils.MapPageUtil;
import com.ljb.utils.TreeUtils;
import com.ljb.utils.ZTree;

/**
 * 部门管理Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-01 18:05:56
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptDao,SysDept> implements SysDeptService {
    @Autowired
    private SysDeptDao sysDeptDao;
    
    @Override
    public SysDept queryObject(Integer id) {
        return sysDeptDao.selectById(id);
    }
    
    @Override
    public Collection<Object> zTreeList(Integer userId){
    	List<SysDept> depts;
    	if(userId==Constant.SUPER_ADMIN) {
    		SysDeptQuery query=new SysDeptQuery();
    		depts=sysDeptDao.selectByQuery(query);
    	}else {
    		depts=sysDeptDao.deptListByUserId(userId);
    	}
    	SysDept sysDept=new SysDept();
    	sysDept.setId(0);
    	sysDept.setParentId(-1);
    	sysDept.setName("总公司");
    	depts.add(sysDept);
    	return TreeUtils.buildTree(depts);
    }


    @Override
    public Page<SysDept> queryList(Map<String, Object> map) {
        MapPageUtil<SysDept> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysDept> wrapper=mapPage.condition();
    	wrapper.where("parent_id= {0}", map.get("id"));
        return selectPage(mapPage.page(), wrapper);
    }
    
     @Override
    public List<SysDept> queryAll(Map<String, Object> map){
    	MapPageUtil<SysDept> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysDept> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<SysDept> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysDept> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
	public int save(SysDept entity) {
    	SysDept sysDept=new SysDept();
    	BeanUtils.copyProperties(entity, sysDept);
    	sysDept.setCreateTime(DateUtils.currentTime());
		return sysDeptDao.insert(sysDept);
	}

    @Override
    public int update(SysDept entity) {
    	SysDept sysDept=new SysDept();
    	BeanUtils.copyProperties(entity, sysDept);
        return sysDeptDao.updateById(sysDept);
    }

    @Override
    public int delete(Integer id) {
    	return sysDeptDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return sysDeptDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	SysDeptQuery query=new SysDeptQuery();
        return sysDeptDao.countByQuery(query);
    }

	@Override
    public List<SysDept> selectByQuery(){
    	SysDeptQuery query=new SysDeptQuery();
        return sysDeptDao.selectByQuery(query);
    }
	
	@Override
    public SysDept selectOne(){
    	SysDeptQuery query=new SysDeptQuery();
        return sysDeptDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	SysDeptQuery query=new SysDeptQuery();
        return sysDeptDao.deleteByQuery(query);
    }
}
