package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.HomeCursorDao;
import com.ljb.entity.HomeCursor;
import com.ljb.service.HomeCursorService;
import com.ljb.query.HomeCursorQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.MapPageUtil;

/**
 * 首页轮播Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-05 13:08:46
 */
@Service
public class HomeCursorServiceImpl extends ServiceImpl<HomeCursorDao,HomeCursor> implements HomeCursorService {
    @Autowired
    private HomeCursorDao homeCursorDao;
    
    @Override
    public HomeCursor queryObject(Integer id) {
        return homeCursorDao.selectById(id);
    }

    @Override
    public Page<HomeCursor> queryList(Map<String, Object> map) {
        MapPageUtil<HomeCursor> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<HomeCursor> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
     @Override
    public List<HomeCursor> queryAll(Map<String, Object> map){
    	MapPageUtil<HomeCursor> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<HomeCursor> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<HomeCursor> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<HomeCursor> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
	public int save(HomeCursor entity) {
    	HomeCursor homeCursor=new HomeCursor();
    	BeanUtils.copyProperties(entity, homeCursor);
		return homeCursorDao.insert(homeCursor);
	}

    @Override
    public int update(HomeCursor entity) {
    	HomeCursor homeCursor=new HomeCursor();
    	BeanUtils.copyProperties(entity, homeCursor);
        return homeCursorDao.updateById(homeCursor);
    }

    @Override
    public int delete(Integer id) {
    	return homeCursorDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return homeCursorDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	HomeCursorQuery query=new HomeCursorQuery();
        return homeCursorDao.countByQuery(query);
    }

	@Override
    public List<HomeCursor> selectByQuery(){
    	HomeCursorQuery query=new HomeCursorQuery();
        return homeCursorDao.selectByQuery(query);
    }
	
	@Override
    public HomeCursor selectOne(){
    	HomeCursorQuery query=new HomeCursorQuery();
        return homeCursorDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	HomeCursorQuery query=new HomeCursorQuery();
        return homeCursorDao.deleteByQuery(query);
    }
}
