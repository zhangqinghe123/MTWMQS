package com.qianxx.qztaxi.service.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.qianxx.qztaxi.common.util.StringUtil;

public class PagerBean<T> {

	private Logger logger = Logger.getLogger(this.getClass());

	// 排序方式
	public enum OrderType {
		asc, desc
	}

	private List<T> rows = new ArrayList<T>();// 页面的数据
	private int curPage = 1;// 当前页
	private int pageSize = 10;// 页面的显示大小
	private int total = 0;// 总数
	private String sortName = "";// 排序字段
	private OrderType sortOrder = null;// 排序方式
	private String property;// 查找属性名称
	private String keyword;// 查找关键字，支持模糊查询

	private boolean isPage = true;

	private Map<String, Object> searchParams = new HashMap<String, Object>();

	public void initPage(List<T> data, int total, int pageSize, int curPage) {
		this.rows = data;
		this.total = total;
		this.pageSize = pageSize;
		this.curPage = curPage;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRowData(List<T> rows) {
		this.rows = rows;
	}

	public int getCurPage() {
		return curPage == 0 ? 1 : curPage;
	}

	/**
	 * 获取第几条数据
	 */
	public int nextNum() {
		return (this.getCurPage() - 1) * this.getPageSize();
	}

	/**
	 * 设置要显示的页面 当前页面
	 */
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public void setCurPageStr(String page) {
		if (StringUtil.isNotBlank(page))
			this.curPage = Integer.parseInt(page);
	}

	/**
	 * 取得上一页
	 */
	public int getPreviousPage() {
		return getCurPage() == 1 ? 1 : getCurPage() - 1;
	}

	/**
	 * 取得下一页
	 */
	public int getNextPage() {
		return getCurPage() > getTotalPage() ? (getTotalPage() == 0 ? 1 : getTotalPage()) : getCurPage() + 1;
	}

	/**
	 * 取得最后一页
	 */
	public int getLastPage() {
		return getTotalPage() == 0 ? 1 : getTotalPage();
	}

	/**
	 * 获取页面大小
	 */
	public int getPageSize() {
		return pageSize == 0 ? 10 : pageSize;
	}

	/**
	 * 设置页面显示的大小 例：共几页
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setPageSizeStr(String rows) {
		if (StringUtil.isNotBlank(rows))
			this.pageSize = Integer.parseInt(rows);
	}

	/**
	 * 获取总记录数
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * 设置总记录数
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * 获取总页数
	 */
	public int getTotalPage() {
		return this.total == 0 ? 0 : (this.total + this.getPageSize() - 1) / this.getPageSize();
	}

	public String getSortName() {
		return sortName;
	}

	public void setSort(String sortName) {
		this.sortName = sortName;
	}

	public OrderType getSortOrder() {
		return sortOrder;
	}

	public void setOrder(String sortOrder) {
		try {
			this.sortOrder = OrderType.valueOf(sortOrder.toLowerCase());
		} catch (Exception e) {
			logger.error("非法的排序");
		}
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Map<String, Object> getSearchParams() {
		return searchParams;
	}

	public void setSearchParams(Map<String, Object> searchParams) {
		this.searchParams = searchParams;
	}

	public boolean isPage() {
		return isPage;
	}

	public void setIsPage(String isPage) {
		if (isPage != null)
			this.isPage = Boolean.valueOf(isPage);
	}

	public void setPage(Integer page) {
		this.curPage = page;
	}

	public void setRows(Integer rows) {
		this.pageSize = rows;
	}

	public void setUn(String un) {
	}

}