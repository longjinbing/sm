package com.ljb.utils;


import java.io.Serializable;
import java.util.List;

/**
 * 分页工具类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2016年11月4日 下午12:59:00
 */
public class PageUtil implements Serializable {
    private static final long serialVersionUID = 1L;
    //总记录数
    private int total;
    //每页记录数
    private int size;
    //总页数
    private int pages;
    //当前页数
    private int current;
    //列表数据
    private List<?> records;
    
    /**
     * 分页
     *
     * @param rows       列表数据
     * @param total 总记录数
     * @param pageSize   每页记录数
     * @param curPage   当前页数
     */
    public PageUtil(List<?> rows, int total, int pageSize, int curPage) {
        this.setRecords(rows);
        this.setTotal(total);
        this.setSize(pageSize);
        this.setCurrent(curPage);
        this.setPages((int) Math.ceil((double) total / pageSize));
    }

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public List<?> getRecords() {
		return records;
	}

	public void setRecords(List<?> records) {
		this.records = records;
	}
}
