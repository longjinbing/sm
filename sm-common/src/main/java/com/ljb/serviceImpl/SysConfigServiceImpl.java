package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.SysConfigDao;
import com.ljb.entity.SysConfig;
import com.ljb.service.SysConfigService;
import com.ljb.query.SysConfigQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.MapPageUtil;

/**
 * 系统配置信息表Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-01 18:05:56
 */
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigDao,SysConfig> implements SysConfigService {
    @Autowired
    private SysConfigDao sysConfigDao;
    
    @Override
    public SysConfig queryObject(Integer id) {
        return sysConfigDao.selectById(id);
    }

    @Override
    public Page<SysConfig> queryList(Map<String, Object> map) {
        MapPageUtil<SysConfig> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysConfig> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
     @Override
    public List<SysConfig> queryAll(Map<String, Object> map){
    	MapPageUtil<SysConfig> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysConfig> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<SysConfig> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysConfig> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
	public int save(SysConfig entity) {
    	SysConfig sysConfig=new SysConfig();
    	BeanUtils.copyProperties(entity, sysConfig);
		return sysConfigDao.insert(sysConfig);
	}

    @Override
    public int update(SysConfig entity) {
    	SysConfig sysConfig=new SysConfig();
    	BeanUtils.copyProperties(entity, sysConfig);
        return sysConfigDao.updateById(sysConfig);
    }

    @Override
    public int delete(Integer id) {
    	return sysConfigDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return sysConfigDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	SysConfigQuery query=new SysConfigQuery();
        return sysConfigDao.countByQuery(query);
    }

	@Override
    public List<SysConfig> selectByQuery(){
    	SysConfigQuery query=new SysConfigQuery();
        return sysConfigDao.selectByQuery(query);
    }
	
	@Override
    public SysConfig selectOne(){
    	SysConfigQuery query=new SysConfigQuery();
        return sysConfigDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	SysConfigQuery query=new SysConfigQuery();
        return sysConfigDao.deleteByQuery(query);
    }
}
