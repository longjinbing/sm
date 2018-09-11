package com.ljb.viewmodel;

import java.util.List;


public class MenuTree {
	
	public MenuTree(Integer id,String title,String url,String icon,Integer parent_id) {
		this.id=id;
		this.title=title;
		this.url=url;
		this.icon=icon;
		this.setParent_id(parent_id);
	}

	private Integer id;
	
	private String title;
	
	private String url;
	
	private String icon;
	
	private Integer parent_id;
	
	private List<MenuTree> children;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<MenuTree> getChildren() {
		return children;
	}

	public void setChildren(List<MenuTree> children) {
		this.children = children;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	
	public void addChild(MenuTree menuTree) {  
		  this.children.add(menuTree);  
		 }
	
}
