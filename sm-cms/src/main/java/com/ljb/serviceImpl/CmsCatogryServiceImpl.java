package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.CmsCatogryDao;
import com.ljb.mapper.SysMenuDao;
import com.ljb.entity.CmsCatogry;
import com.ljb.service.CmsCatogryService;
import com.ljb.query.CmsCatogryQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.DateUtils;
import com.ljb.utils.MapPageUtil;
import com.ljb.utils.TreeUtils;

/**
 * 目录Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-05 13:08:46
 */
@Service
public class CmsCatogryServiceImpl extends ServiceImpl<CmsCatogryDao,CmsCatogry> implements CmsCatogryService {
    @Autowired
    private CmsCatogryDao cmsCatogryDao;
    
    @Override
    public CmsCatogry queryObject(Integer id) {
        return cmsCatogryDao.selectById(id);
    }

    @Override
    public Page<CmsCatogry> queryList(Map<String, Object> map) {
        MapPageUtil<CmsCatogry> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<CmsCatogry> wrapper=mapPage.condition();
    	wrapper.where("parent_id = {0}", map.get("id"));
        return selectPage(mapPage.page(), wrapper);
    }
    
    @Override
    public Collection<?> zTressList(){
    	CmsCatogryQuery query=new CmsCatogryQuery();
    	query.createCriteria().andstatusEqualTo(1);
    	List<CmsCatogry> catogries=cmsCatogryDao.selectByQuery(query);
    	CmsCatogry cmsCatogry=new CmsCatogry();
    	cmsCatogry.setId(0);
    	cmsCatogry.setParentId(-1);
    	cmsCatogry.setName("主目录");
    	catogries.add(cmsCatogry);
    	return TreeUtils.buildTree(catogries);
    }
    
     @Override
    public List<CmsCatogry> queryAll(Map<String, Object> map){
    	MapPageUtil<CmsCatogry> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<CmsCatogry> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<CmsCatogry> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<CmsCatogry> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
	public int save(CmsCatogry entity) {
    	CmsCatogry cmsCatogry=new CmsCatogry();
    	BeanUtils.copyProperties(entity, cmsCatogry);
    	cmsCatogry.setCreateTime(DateUtils.currentTime());
		return cmsCatogryDao.insert(cmsCatogry);
	}

    @Override
    public int update(CmsCatogry entity) {
    	CmsCatogry cmsCatogry=new CmsCatogry();
    	BeanUtils.copyProperties(entity, cmsCatogry);
        return cmsCatogryDao.updateById(cmsCatogry);
    }

    @Override
    public int delete(Integer id) {
    	return cmsCatogryDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return cmsCatogryDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	CmsCatogryQuery query=new CmsCatogryQuery();
        return cmsCatogryDao.countByQuery(query);
    }

	@Override
    public List<CmsCatogry> selectByQuery(){
    	CmsCatogryQuery query=new CmsCatogryQuery();
        return cmsCatogryDao.selectByQuery(query);
    }
	
	@Override
    public CmsCatogry selectOne(){
    	CmsCatogryQuery query=new CmsCatogryQuery();
        return cmsCatogryDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	CmsCatogryQuery query=new CmsCatogryQuery();
        return cmsCatogryDao.deleteByQuery(query);
    }
}
