package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.SysLogDao;
import com.ljb.entity.SysLog;
import com.ljb.service.SysLogService;
import com.ljb.query.SysLogQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.MapPageUtil;

/**
 * 系统日志Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-01 18:05:56
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogDao,SysLog> implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;
    
    @Override
    public SysLog queryObject(Long id) {
        return sysLogDao.selectById(id);
    }

    @Override
    public Page<SysLog> queryList(Map<String, Object> map) {
        MapPageUtil<SysLog> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysLog> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
     @Override
    public List<SysLog> queryAll(Map<String, Object> map){
    	MapPageUtil<SysLog> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysLog> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<SysLog> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysLog> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
	public int save(SysLog entity) {
    	SysLog sysLog=new SysLog();
    	BeanUtils.copyProperties(entity, sysLog);
		return sysLogDao.insert(sysLog);
	}

    @Override
    public int update(SysLog entity) {
    	SysLog sysLog=new SysLog();
    	BeanUtils.copyProperties(entity, sysLog);
        return sysLogDao.updateById(sysLog);
    }

    @Override
    public int delete(Long id) {
    	return sysLogDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Long[] ids) {
        return sysLogDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	SysLogQuery query=new SysLogQuery();
        return sysLogDao.countByQuery(query);
    }

	@Override
    public List<SysLog> selectByQuery(){
    	SysLogQuery query=new SysLogQuery();
        return sysLogDao.selectByQuery(query);
    }
	
	@Override
    public SysLog selectOne(){
    	SysLogQuery query=new SysLogQuery();
        return sysLogDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	SysLogQuery query=new SysLogQuery();
        return sysLogDao.deleteByQuery(query);
    }
}
