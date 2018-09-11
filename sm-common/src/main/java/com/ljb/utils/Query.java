package com.ljb.utils;

import java.util.LinkedHashMap;
import java.util.Map;

import com.ljb.xss.SQLFilter;
import com.mysql.jdbc.Field;

/**
 * 查询参数
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-03-14 23:15
 */
public class Query extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    //当前页码
    private int offset;
    //每页条数
    private int limit = 10;
    
    private int pageNum;

    public Query(Map<String, Object> params) {
        this.putAll(params);

        //分页参数
        this.offset =params.containsKey("offset")? Integer.parseInt(params.get("offset").toString()):0;
        this.limit = params.containsKey("limit")?Integer.parseInt(params.get("limit").toString()):10;
        this.pageNum =offset/limit+1;
        this.put("page", (offset/limit)+1);
        this.put("offset", offset);
        this.put("limit", limit);
        String field=params.containsKey("field")?params.get("field").toString():"";
		String text=params.containsKey("text")?params.get("text").toString():"";
		String sort=params.containsKey("sort")?params.get("sort").toString():"";
		String order=params.containsKey("order")?params.get("order").toString():"";
		String stime =params.containsKey("stime")?params.get("stime").toString():"";
        String etime =params.containsKey("etime")?params.get("etime").toString():"";
        if(!field.isEmpty()) {
        	this.put("field", field);
        	this.put("text", text);
        }
        if(!sort.isEmpty()) {
        	this.put("sort", sort);
        	this.put("order", order);
        }
        if(!stime.isEmpty()) {
        	this.put("stime",stime );
        	this.put("etime",etime );
        }
    }


    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }


	public int getPage() {
		return pageNum;
	}

	public void setPage(int page) {
		this.pageNum = page;
	}
}
