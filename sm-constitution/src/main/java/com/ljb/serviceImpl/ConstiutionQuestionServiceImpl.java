package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.ConstiutionQuestionDao;
import com.ljb.entity.ConstiutionQuestion;
import com.ljb.service.ConstiutionQuestionService;
import com.ljb.query.ConstiutionQuestionQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.MapPageUtil;
import com.ljb.shiro.ShiroUtils;
import com.ljb.utils.DateUtils;

/**
 * 体质测试问题Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-07 18:22:42
 */
@Service
public class ConstiutionQuestionServiceImpl extends ServiceImpl<ConstiutionQuestionDao,ConstiutionQuestion> implements ConstiutionQuestionService {
    @Autowired
    private ConstiutionQuestionDao constiutionQuestionDao;
    
    @Override
    public ConstiutionQuestion queryObject(Integer id) {
        return constiutionQuestionDao.selectById(id);
    }

    @Override
    public Page<ConstiutionQuestion> queryList(Map<String, Object> map) {
        MapPageUtil<ConstiutionQuestion> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ConstiutionQuestion> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
     @Override
    public List<ConstiutionQuestion> queryAll(Map<String, Object> map){
    	MapPageUtil<ConstiutionQuestion> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ConstiutionQuestion> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<ConstiutionQuestion> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ConstiutionQuestion> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
    public Map<String, Object> queryDetails(Integer id) {
        return constiutionQuestionDao.select(id);
    }
    
    @Override
	public int save(ConstiutionQuestion entity) {
    	ConstiutionQuestion constiutionQuestion=new ConstiutionQuestion();
    	BeanUtils.copyProperties(entity, constiutionQuestion);
    	constiutionQuestion.setCreateTime(DateUtils.currentTime());
		constiutionQuestion.setCreateId(ShiroUtils.getSysUserId());
		return constiutionQuestionDao.insert(constiutionQuestion);
	}

    @Override
    public int update(ConstiutionQuestion entity) {
    	ConstiutionQuestion constiutionQuestion=new ConstiutionQuestion();
    	BeanUtils.copyProperties(entity, constiutionQuestion);
    	constiutionQuestion.setUpdateTime(DateUtils.currentTime());
		constiutionQuestion.setUpdateId(ShiroUtils.getSysUserId());
        return constiutionQuestionDao.updateById(constiutionQuestion);
    }

    @Override
    public int delete(Integer id) {
    	return constiutionQuestionDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return constiutionQuestionDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	ConstiutionQuestionQuery query=new ConstiutionQuestionQuery();
        return constiutionQuestionDao.countByQuery(query);
    }

	@Override
    public List<ConstiutionQuestion> selectByQuery(){
    	ConstiutionQuestionQuery query=new ConstiutionQuestionQuery();
        return constiutionQuestionDao.selectByQuery(query);
    }
	
	@Override
    public ConstiutionQuestion selectOne(){
    	ConstiutionQuestionQuery query=new ConstiutionQuestionQuery();
        return constiutionQuestionDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	ConstiutionQuestionQuery query=new ConstiutionQuestionQuery();
        return constiutionQuestionDao.deleteByQuery(query);
    }
}
