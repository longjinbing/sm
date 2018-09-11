package com.ljb.serviceImpl;

import org.apache.velocity.runtime.directive.Foreach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.alibaba.druid.sql.ast.expr.SQLCaseExpr.Item;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.ConstitutionDao;
import com.ljb.mapper.ConstitutionDetailsDao;
import com.ljb.mapper.ConstitutionResultDao;
import com.ljb.mapper.ConstiutionQuestionDao;
import com.ljb.mapper.ResultDetailsDao;
import com.ljb.entity.Constitution;
import com.ljb.entity.ConstitutionResult;
import com.ljb.entity.ConstiutionQuestion;
import com.ljb.entity.ResultDetails;
import com.ljb.service.ConstitutionResultService;
import com.ljb.query.ConstitutionResultQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.MapPageUtil;
import com.ljb.utils.R;


import com.ljb.shiro.ShiroUtils;
import com.ljb.utils.DateUtils;

/**
 * 体质测试结果Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-07 18:22:42
 */
@Service
public class ConstitutionResultServiceImpl extends ServiceImpl<ConstitutionResultDao,ConstitutionResult> implements ConstitutionResultService {
    private static Logger logger=LoggerFactory.getLogger(ConstitutionResultServiceImpl.class);
	@Autowired
    private ConstitutionResultDao constitutionResultDao;
    
    @Autowired
    private ConstitutionDetailsDao constitutionDetailsDao;
    
    @Autowired
    private ResultDetailsDao resultDetailsDao;
    
    @Autowired
    private ConstitutionDao constitutionDao;
    
    @Autowired
    private ConstiutionQuestionDao constiutionQuestionDao;
    
    @Override
    public ConstitutionResult queryObject(Integer id) {
        return constitutionResultDao.selectById(id);
    }
    
    @Override
    public ConstitutionResult queryObjectByUserId(Integer id) {
    	EntityWrapper<ConstitutionResult> wrapper=new EntityWrapper<>();
    	wrapper.where("user_id = {0}", id).orderBy("create_time", false);
    	return selectOne(wrapper);
    }
    
    @Override
    public Boolean saveResult(Map<String,Object> map) {
    	logger.info("已收到数据");
    	Set<Map.Entry<String,Object>> mapEntey=map.entrySet();
		Iterator iterator=mapEntey.iterator();
		Map<String, Integer> resultMap=new HashMap<String,Integer>();
		Map<Integer,Object> constitutionMap=new HashMap<>();
		List<Constitution> constitutionList=constitutionDao.selectList(null);
		for(Constitution item:constitutionList){
			constitutionMap.put(item.getId(), item);
		}
		while(iterator.hasNext()) {
			Map.Entry<String,Object> entry=(Map.Entry<String,Object>)iterator.next();
			Integer questionId=Integer.valueOf(entry.getKey());
			logger.info(entry.getValue().toString());
			ConstiutionQuestion constiutionQuestion=constiutionQuestionDao.selectById(questionId);
			logger.info(entry.getKey()+"结束1");
			Constitution constiution=(Constitution)constitutionMap.get(constiutionQuestion.getConstiutionId());
			if(constiution==null)
				continue;
			logger.info(entry.getKey()+"结束1");
			String constiutionName=constiution.getName();
			/*Integer value=resultMap.containsKey(constiutionName)?(Integer)resultMap.get(constiutionName)+(Integer)entry.getValue():(Integer)entry.getValue();*/
			Integer value=resultMap.containsKey(constiutionName)?resultMap.get(constiutionName)+Integer.valueOf(entry.getValue().toString()):Integer.valueOf(entry.getValue().toString());
			logger.info(entry.getKey()+"结束3"+value);
			resultMap.put(constiutionName,value);
			logger.info(entry.getKey()+"结束2");
		}
		String first="";
		Integer max=0;
		Set<Map.Entry<String, Integer>> resultMapEntry=resultMap.entrySet();
		Iterator resultIterator=resultMapEntry.iterator();
		while(resultIterator.hasNext()) {
			Map.Entry<String, Integer> item=(Map.Entry<String, Integer>)resultIterator.next();
			Integer current=item.getValue();
			if(max<current)
			{
			max=current;
			first=item.getKey();
			}
			
		}
		if(first=="") {
			return false;
		}else {
			final String s=first;
			Constitution currentresult=constitutionList.stream().filter((Constitution c)->c.getName().equals(s)).collect(Collectors.toList()).get(0);
			ConstitutionResult constitutionResult=new ConstitutionResult();
			constitutionResult.setUserId(ShiroUtils.getSysUserId());
			constitutionResult.setCreateTime(DateUtils.currentTime());
			constitutionResult.setCreateId(ShiroUtils.getSysUserId());
			constitutionResult.setConstitutionId(currentresult.getId());
			constitutionResultDao.insert(constitutionResult);
			resultIterator=resultMapEntry.iterator();
			while(resultIterator.hasNext()) {
				Map.Entry<String, Integer> item=(Map.Entry<String, Integer>)resultIterator.next();
				Integer current=item.getValue();
				currentresult=constitutionList.stream().filter((Constitution c)->c.getName().equals(item.getKey())).collect(Collectors.toList()).get(0);
				ResultDetails resultDetail=new ResultDetails();
				resultDetail.setResultId(constitutionResult.getId());
				resultDetail.setResult(item.getValue());
				resultDetail.setConstitutionId(currentresult.getId());
				resultDetailsDao.insert(resultDetail);
			}
		}
		return true;
    }
    
   

    @Override
    public Page<ConstitutionResult> queryList(Map<String, Object> map) {
        MapPageUtil<ConstitutionResult> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ConstitutionResult> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
    @Override
    public Page<ConstitutionResult> queryList(Integer userId){
    	Page<ConstitutionResult> page=new Page<>(1, 100);
    	EntityWrapper<ConstitutionResult> wrapper=new EntityWrapper<>();
    	wrapper.where("user_id", userId).orderBy("create_time", false);
    	return selectPage(page,wrapper);
    }
    
     @Override
    public List<ConstitutionResult> queryAll(Map<String, Object> map){
    	MapPageUtil<ConstitutionResult> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ConstitutionResult> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<ConstitutionResult> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ConstitutionResult> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
    public Map<String, Object> queryDetails(Integer id) {
        return constitutionResultDao.select(id);
    }
    
    @Override
	public int save(ConstitutionResult constitutionResult) {
    	constitutionResult.setCreateTime(DateUtils.currentTime());
		constitutionResult.setCreateId(ShiroUtils.getSysUserId());
		return constitutionResultDao.insert(constitutionResult);
	}

    @Override
    public int update(ConstitutionResult entity) {
    	ConstitutionResult constitutionResult=new ConstitutionResult();
    	BeanUtils.copyProperties(entity, constitutionResult);
        return constitutionResultDao.updateById(constitutionResult);
    }

    @Override
    public int delete(Integer id) {
    	return constitutionResultDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return constitutionResultDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	ConstitutionResultQuery query=new ConstitutionResultQuery();
        return constitutionResultDao.countByQuery(query);
    }

	@Override
    public List<ConstitutionResult> selectByQuery(){
    	ConstitutionResultQuery query=new ConstitutionResultQuery();
        return constitutionResultDao.selectByQuery(query);
    }
	
	@Override
    public ConstitutionResult selectOne(){
    	ConstitutionResultQuery query=new ConstitutionResultQuery();
        return constitutionResultDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	ConstitutionResultQuery query=new ConstitutionResultQuery();
        return constitutionResultDao.deleteByQuery(query);
    }
}
