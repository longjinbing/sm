package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.SysSmsLogDao;
import com.ljb.entity.SysSmsLog;
import com.ljb.service.SysSmsLogService;
import com.ljb.query.SysSmsLogQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.MapPageUtil;

/**
 * Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-01 18:05:57
 */
@Service
public class SysSmsLogServiceImpl extends ServiceImpl<SysSmsLogDao,SysSmsLog> implements SysSmsLogService {
    @Autowired
    private SysSmsLogDao sysSmsLogDao;
    
    @Override
    public SysSmsLog queryObject(Long id) {
        return sysSmsLogDao.selectById(id);
    }

    @Override
    public Page<SysSmsLog> queryList(Map<String, Object> map) {
        MapPageUtil<SysSmsLog> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysSmsLog> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
     @Override
    public List<SysSmsLog> queryAll(Map<String, Object> map){
    	MapPageUtil<SysSmsLog> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysSmsLog> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<SysSmsLog> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<SysSmsLog> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
	public int save(SysSmsLog entity) {
    	SysSmsLog sysSmsLog=new SysSmsLog();
    	BeanUtils.copyProperties(entity, sysSmsLog);
		return sysSmsLogDao.insert(sysSmsLog);
	}

    @Override
    public int update(SysSmsLog entity) {
    	SysSmsLog sysSmsLog=new SysSmsLog();
    	BeanUtils.copyProperties(entity, sysSmsLog);
        return sysSmsLogDao.updateById(sysSmsLog);
    }

    @Override
    public int delete(Long id) {
    	return sysSmsLogDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Long[] ids) {
        return sysSmsLogDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	SysSmsLogQuery query=new SysSmsLogQuery();
        return sysSmsLogDao.countByQuery(query);
    }

	@Override
    public List<SysSmsLog> selectByQuery(){
    	SysSmsLogQuery query=new SysSmsLogQuery();
        return sysSmsLogDao.selectByQuery(query);
    }
	
	@Override
    public SysSmsLog selectOne(){
    	SysSmsLogQuery query=new SysSmsLogQuery();
        return sysSmsLogDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	SysSmsLogQuery query=new SysSmsLogQuery();
        return sysSmsLogDao.deleteByQuery(query);
    }
}
