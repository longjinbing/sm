package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.SysRoleDeptDao;
import com.ljb.entity.SysRoleDept;
import com.ljb.service.SysRoleDeptService;
import com.ljb.query.SysRoleDeptQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.MapPageUtil;

/**
 * 角色与部门对应关系Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-01 18:05:57
 */
@Service
public class SysRoleDeptServiceImpl extends ServiceImpl<SysRoleDeptDao,SysRoleDept> implements SysRoleDeptService {
    @Autowired
    private SysRoleDeptDao sysRoleDeptDao;
    
    @Override
    public SysRoleDept queryObject(Integer id) {
        return sysRoleDeptDao.selectById(id);
    }

    @Override
    public Page<SysRoleDept> queryList(Map<String, Object> map) {
        MapPageUtil<SysRoleDept> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysRoleDept> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
     @Override
    public List<SysRoleDept> queryAll(Map<String, Object> map){
    	MapPageUtil<SysRoleDept> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysRoleDept> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<SysRoleDept> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysRoleDept> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
	public int save(SysRoleDept entity) {
    	SysRoleDept sysRoleDept=new SysRoleDept();
    	BeanUtils.copyProperties(entity, sysRoleDept);
		return sysRoleDeptDao.insert(sysRoleDept);
	}

    @Override
    public int update(SysRoleDept entity) {
    	SysRoleDept sysRoleDept=new SysRoleDept();
    	BeanUtils.copyProperties(entity, sysRoleDept);
        return sysRoleDeptDao.updateById(sysRoleDept);
    }

    @Override
    public int delete(Integer id) {
    	return sysRoleDeptDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return sysRoleDeptDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	SysRoleDeptQuery query=new SysRoleDeptQuery();
        return sysRoleDeptDao.countByQuery(query);
    }

	@Override
    public List<SysRoleDept> selectByQuery(){
    	SysRoleDeptQuery query=new SysRoleDeptQuery();
        return sysRoleDeptDao.selectByQuery(query);
    }
	
	@Override
    public SysRoleDept selectOne(){
    	SysRoleDeptQuery query=new SysRoleDeptQuery();
        return sysRoleDeptDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	SysRoleDeptQuery query=new SysRoleDeptQuery();
        return sysRoleDeptDao.deleteByQuery(query);
    }
}
