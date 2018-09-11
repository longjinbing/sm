package com.ljb.utils;

import java.util.Map;

import org.apache.poi.ss.formula.functions.T;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ljb.xss.SQLFilter;

public  class MapPageUtil<T> {
	
	private Map<String, Object> params;

	public MapPageUtil(Map<String, Object> params) {
		this.params=params;
	}
	
	public Page<T> page() {
		Integer offset=params.containsKey("offset")?Integer.valueOf(params.get("offset").toString()):0;
		Integer limit=params.containsKey("limit")?Integer.valueOf(params.get("limit").toString()):10;
		Integer pageNum=offset/limit+1;
		String sort=params.containsKey("sort")?params.get("sort").toString():"id";
		Boolean isAsc=params.containsKey("order")?params.get("order").toString()=="asc"?true:false:false;
		Page<T> page=new Page<>(pageNum, limit,sort,isAsc);
		return page;
	}
	public EntityWrapper<T> condition() {
		EntityWrapper<T> wrapper=new EntityWrapper<>();
		if(params.containsKey("searchText")&&!params.get("searchField").toString().isEmpty()&&!params.get("searchText").toString().isEmpty()) {
			String field=SQLFilter.sqlInject(params.get("searchField").toString());
			String text=SQLFilter.sqlInject(params.get("searchText").toString());
			wrapper.like(field, text);
		}
		if(params.containsKey("startTime")&&!params.get("startTime").toString().isEmpty()&&!params.get("endTime").toString().isEmpty()) {
			String startTime =SQLFilter.sqlInject(params.get("startTime").toString());
	        String endTime =SQLFilter.sqlInject(params.get("endTime").toString());
			wrapper.between("create_time", SQLFilter.sqlInject(startTime), SQLFilter.sqlInject(endTime));
		}
		return wrapper;
	}
}
