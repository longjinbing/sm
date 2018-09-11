package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.SysUserDao;
import com.ljb.entity.SysUser;
import com.ljb.service.SysUserService;
import com.ljb.query.SysUserQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.MapPageUtil;

/**
 * 系统用户Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-01 18:05:56
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao,SysUser> implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;
    
    @Override
    public SysUser queryObject(Integer id) {
        return sysUserDao.selectById(id);
    }
    
    @Override
    public SysUser queryByName(String username) {
    	SysUserQuery query=new SysUserQuery();
    	query.createCriteria().andusernameEqualTo(username);
    	return sysUserDao.selectOne(query);
    };
    
    @Override
    public SysUser queryByNamePass(String username,String password) {
    	SysUserQuery query=new SysUserQuery();
    	query.createCriteria().andusernameEqualTo(username).andpasswordEqualTo(password);
    	return sysUserDao.selectOne(query);
    };


    @Override
    public Page<SysUser> queryList(Map<String, Object> map) {
        MapPageUtil<SysUser> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysUser> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
     @Override
    public List<SysUser> queryAll(Map<String, Object> map){
    	MapPageUtil<SysUser> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysUser> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<SysUser> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysUser> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
	public int save(SysUser entity) {
    	SysUser sysUser=new SysUser();
    	BeanUtils.copyProperties(entity, sysUser);
		return sysUserDao.insert(sysUser);
	}

    @Override
    public int update(SysUser entity) {
    	SysUser sysUser=new SysUser();
    	BeanUtils.copyProperties(entity, sysUser);
        return sysUserDao.updateById(sysUser);
    }

    @Override
    public int delete(Integer id) {
    	return sysUserDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return sysUserDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	SysUserQuery query=new SysUserQuery();
        return sysUserDao.countByQuery(query);
    }

	@Override
    public List<SysUser> selectByQuery(){
    	SysUserQuery query=new SysUserQuery();
        return sysUserDao.selectByQuery(query);
    }
	
	@Override
    public SysUser selectOne(){
    	SysUserQuery query=new SysUserQuery();
        return sysUserDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	SysUserQuery query=new SysUserQuery();
        return sysUserDao.deleteByQuery(query);
    }
}
