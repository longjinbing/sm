package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.naming.spi.DirStateFactory.Result;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.ConstitutionDao;
import com.ljb.mapper.ResultDetailsDao;
import com.ljb.entity.Constitution;
import com.ljb.entity.ResultDetails;
import com.ljb.service.ResultDetailsService;
import com.ljb.query.ResultDetailsQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.MapPageUtil;
import com.ljb.shiro.ShiroUtils;
import com.ljb.utils.DateUtils;

/**
 * 体质测试结果详情Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-08 17:18:14
 */
@Service
public class ResultDetailsServiceImpl extends ServiceImpl<ResultDetailsDao,ResultDetails> implements ResultDetailsService {
    @Autowired
    private ResultDetailsDao resultDetailsDao;
    
    @Autowired
    private ConstitutionDao constitutionDao;
    
    @Override
    public ResultDetails queryObject(Integer id) {
        return resultDetailsDao.selectById(id);
    }

    @Override
    public Page<ResultDetails> queryList(Map<String, Object> map) {
        MapPageUtil<ResultDetails> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ResultDetails> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
    @Override
    public Map<String, Object> resultDetails(Integer id){
    	List<Constitution> constitutionList=constitutionDao.selectList(null);
    	EntityWrapper<ResultDetails> wrapper=new EntityWrapper<>();
    	wrapper.where("result_id = {0}", id).orderBy("id", false);
    	List<ResultDetails> list=resultDetailsDao.selectList(wrapper);
    	List<String> names=new ArrayList<>();
    	List<Integer> results=new ArrayList<>();
    	Map<String, Integer> resultMap=new TreeMap<String, Integer>();
    	for (ResultDetails resultDetails : list) {
    		Constitution current=constitutionList.stream().filter((Constitution c)->c.getId().equals(resultDetails.getConstitutionId())).collect(Collectors.toList()).get(0);
			resultMap.put(current.getName(), resultDetails.getResult());
		}
    	List<Map.Entry<String,Integer>> sortList = new ArrayList<Map.Entry<String, Integer>>(resultMap.entrySet());
    	 Collections.sort(sortList,new Comparator<Map.Entry<String,Integer>>() {
             //升序排序
             public int compare(Map.Entry<String, Integer> o1,
            		 Map.Entry<String, Integer> o2) {
            	 if(o1.getValue()>o2.getValue()) {
            		 return -1;
            	 }else if(o1.getValue()<o2.getValue()) {
            		 return 1;
            	 }
                 return 0;
             }
         });
    	for (Map.Entry<String, Integer> entry : sortList) {
    		names.add(entry.getKey());
			results.add(entry.getValue());
		}
    	Map<String, Object> map=new HashMap<>();
    	map.put("names",names.toArray());
    	map.put("results",results.toArray());
    	return map;
    }
    
     @Override
    public List<ResultDetails> queryAll(Map<String, Object> map){
    	MapPageUtil<ResultDetails> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ResultDetails> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<ResultDetails> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<ResultDetails> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
    public Map<String, Object> queryDetails(Integer id) {
        return resultDetailsDao.select(id);
    }
    
    @Override
	public int save(ResultDetails entity) {
    	ResultDetails resultDetails=new ResultDetails();
    	BeanUtils.copyProperties(entity, resultDetails);
		return resultDetailsDao.insert(resultDetails);
	}

    @Override
    public int update(ResultDetails entity) {
    	ResultDetails resultDetails=new ResultDetails();
    	BeanUtils.copyProperties(entity, resultDetails);
        return resultDetailsDao.updateById(resultDetails);
    }

    @Override
    public int delete(Integer id) {
    	return resultDetailsDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return resultDetailsDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	ResultDetailsQuery query=new ResultDetailsQuery();
        return resultDetailsDao.countByQuery(query);
    }

	@Override
    public List<ResultDetails> selectByQuery(){
    	ResultDetailsQuery query=new ResultDetailsQuery();
        return resultDetailsDao.selectByQuery(query);
    }
	
	@Override
    public ResultDetails selectOne(){
    	ResultDetailsQuery query=new ResultDetailsQuery();
        return resultDetailsDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	ResultDetailsQuery query=new ResultDetailsQuery();
        return resultDetailsDao.deleteByQuery(query);
    }
}
