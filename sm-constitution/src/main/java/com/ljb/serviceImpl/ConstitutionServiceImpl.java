package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.ConstitutionDao;
import com.ljb.entity.Constitution;
import com.ljb.service.ConstitutionService;
import com.ljb.query.ConstitutionQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.MapPageUtil;
import com.ljb.shiro.ShiroUtils;
import com.ljb.utils.DateUtils;

/**
 * 体质管理Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-07 18:22:42
 */
@Service
public class ConstitutionServiceImpl extends ServiceImpl<ConstitutionDao,Constitution> implements ConstitutionService {
    @Autowired
    private ConstitutionDao constitutionDao;
    
    @Override
    public Constitution queryObject(Integer id) {
        return constitutionDao.selectById(id);
    }
    
    @Override
    public  Constitution queryObject(String name) {
    	ConstitutionQuery query=new ConstitutionQuery();
		query.createCriteria().andnameEqualTo(name);
        return constitutionDao.selectOne(query);
    }
    
    

    @Override
    public Page<Constitution> queryList(Map<String, Object> map) {
        MapPageUtil<Constitution> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<Constitution> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
     @Override
    public List<Constitution> queryAll(Map<String, Object> map){
    	MapPageUtil<Constitution> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<Constitution> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<Constitution> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<Constitution> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
    public Map<String, Object> queryDetails(Integer id) {
        return constitutionDao.select(id);
    }
    
    @Override
	public int save(Constitution entity) {
    	Constitution constitution=new Constitution();
    	BeanUtils.copyProperties(entity, constitution);
    	constitution.setCreateTime(DateUtils.currentTime());
		constitution.setCreateId(ShiroUtils.getSysUserId());
		return constitutionDao.insert(constitution);
	}

    @Override
    public int update(Constitution entity) {
    	Constitution constitution=new Constitution();
    	BeanUtils.copyProperties(entity, constitution);
    	constitution.setUpdateTime(DateUtils.currentTime());
		constitution.setUpdateId(ShiroUtils.getSysUserId());
        return constitutionDao.updateById(constitution);
    }

    @Override
    public int delete(Integer id) {
    	return constitutionDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return constitutionDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	ConstitutionQuery query=new ConstitutionQuery();
        return constitutionDao.countByQuery(query);
    }

	@Override
    public List<Constitution> selectByQuery(){
    	ConstitutionQuery query=new ConstitutionQuery();
        return constitutionDao.selectByQuery(query);
    }
	
	@Override
    public Constitution selectOne(){
    	ConstitutionQuery query=new ConstitutionQuery();
        return constitutionDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	ConstitutionQuery query=new ConstitutionQuery();
        return constitutionDao.deleteByQuery(query);
    }
}
