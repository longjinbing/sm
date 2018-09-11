package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.ConstitutionDetailsDao;
import com.ljb.entity.ConstitutionDetails;
import com.ljb.service.ConstitutionDetailsService;
import com.ljb.query.ConstitutionDetailsQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.MapPageUtil;
import com.ljb.shiro.ShiroUtils;
import com.ljb.utils.DateUtils;

/**
 * 体质介绍Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-08 16:59:04
 */
@Service
public class ConstitutionDetailsServiceImpl extends ServiceImpl<ConstitutionDetailsDao,ConstitutionDetails> implements ConstitutionDetailsService {
    @Autowired
    private ConstitutionDetailsDao constitutionDetailsDao;
    
    @Override
    public ConstitutionDetails queryObject(Integer id) {
        return constitutionDetailsDao.selectById(id);
    }

    @Override
    public Page<ConstitutionDetails> queryList(Map<String, Object> map) {
        MapPageUtil<ConstitutionDetails> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ConstitutionDetails> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
     @Override
    public List<ConstitutionDetails> queryAll(Map<String, Object> map){
    	MapPageUtil<ConstitutionDetails> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ConstitutionDetails> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<ConstitutionDetails> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ConstitutionDetails> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
    public Map<String, Object> queryDetails(Integer id) {
        return constitutionDetailsDao.select(id);
    }
    
    @Override
	public int save(ConstitutionDetails entity) {
    	ConstitutionDetails constitutionDetails=new ConstitutionDetails();
    	BeanUtils.copyProperties(entity, constitutionDetails);
    	constitutionDetails.setCreateTime(DateUtils.currentTime());
		constitutionDetails.setCreateId(ShiroUtils.getSysUserId());
		return constitutionDetailsDao.insert(constitutionDetails);
	}

    @Override
    public int update(ConstitutionDetails entity) {
    	ConstitutionDetails constitutionDetails=new ConstitutionDetails();
    	BeanUtils.copyProperties(entity, constitutionDetails);
    	constitutionDetails.setUpdateTime(DateUtils.currentTime());
		constitutionDetails.setUpdateId(ShiroUtils.getSysUserId());
        return constitutionDetailsDao.updateById(constitutionDetails);
    }

    @Override
    public int delete(Integer id) {
    	return constitutionDetailsDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return constitutionDetailsDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	ConstitutionDetailsQuery query=new ConstitutionDetailsQuery();
        return constitutionDetailsDao.countByQuery(query);
    }

	@Override
    public List<ConstitutionDetails> selectByQuery(){
    	ConstitutionDetailsQuery query=new ConstitutionDetailsQuery();
        return constitutionDetailsDao.selectByQuery(query);
    }
	
	@Override
    public ConstitutionDetails selectOne(){
    	ConstitutionDetailsQuery query=new ConstitutionDetailsQuery();
        return constitutionDetailsDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	ConstitutionDetailsQuery query=new ConstitutionDetailsQuery();
        return constitutionDetailsDao.deleteByQuery(query);
    }
}
