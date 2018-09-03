package com.qianxx.qztaxi.webService.response.datatable;



import java.util.HashMap;
import java.util.Map;

public class DatatableRequest {

	private String searchValue;
	private String orderKey;
	private String orderDir;
	
	private int start;
	private int length;
	private int draw;
	
	private Map<String,Object> searchMap = new HashMap<String, Object>();
	private Map<String,Object> searchMap_S = new HashMap<String, Object>();
	private Map<String,Object> beanMap = new HashMap<String, Object>();
	

	public Map<String,Object> getSearchMap() {
		return searchMap;
	}
	public void setSearchMap(Map<String,Object> searchMap) {
		this.searchMap = searchMap;
	}
	public int getDraw() {return draw;}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	public String getOrderKey() {
		return orderKey;
	}
	public void setOrderKey(String orderKey) {
		this.orderKey = orderKey;
	}
	public String getOrderDir() {
		return orderDir;
	}
	public void setOrderDir(String orderDir) {
		this.orderDir = orderDir;
	}
	public Map<String,Object> getSearchMap_S() {
		return searchMap_S;
	}
	public void setSearchMap_S(Map<String,Object> searchMap_S) {
		this.searchMap_S = searchMap_S;
	}
	public Map<String,Object> getBeanMap() {
		return beanMap;
	}
	public void setBeanMap(Map<String,Object> beanMap) {
		this.beanMap = beanMap;
	}
	
}
