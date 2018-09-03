package com.qianxx.qztaxi.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qianxx.qztaxi.dao.IBaseDao;
import org.apache.log4j.Logger;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianxx.qztaxi.common.ErrCodeConstants;
import com.qianxx.qztaxi.service.IBaseService;
import com.qianxx.qztaxi.service.bean.PagerBean;
import com.qianxx.qztaxi.webService.response.WsResponse;

/**
 * 泛型biz实现类
 */
@SuppressWarnings("all")
public abstract class BaseService<T, Dao extends IBaseDao<T>> implements IBaseService<T> {

	protected Logger logger = Logger.getLogger(this.getClass());

	public abstract Dao getDao();

	public static final String API_STATUS_SUCCESS = "1";

	protected WsResponse wsResponse = new WsResponse(API_STATUS_SUCCESS, ErrCodeConstants.ERR_0_SUCCESS, "");

	public T getById(Integer id) {
		return getDao().getById(id);
	}

	public void getAll(PagerBean<T> pager) {
		if (pager.isPage()) {
			Page<T> page = PageHelper.startPage(pager.getCurPage(), pager.getPageSize());

			getDao().getAllByMap(pager.getSearchParams());
			pager.setRowData(page.getResult());
			pager.setTotal((int) page.getTotal());
		} else {
			pager.setRowData(getDao().getAllByMap(pager.getSearchParams()));
		}
	}

	public List<T> getAll(Map<String, Object> searchParams) {
		return getDao().getAllByMap(searchParams);
	}

	public List<T> getAll() {
		return getDao().getAllByMap(new HashMap<String, Object>());
	}

	public void deleteByIds(String ids) {
		getDao().deleteByIds(ids.split(","));
	}

	public void enableByIds(String ids) {
		getDao().enableByIds(ids.split(","));
	}

	public void disableByIds(String ids) {
		getDao().disableByIds(ids.split(","));
	}

	public void deleteAll() {
		getDao().deleteAll();
	}

	public void save(T t) {
		getDao().save(t);
	}

	public void update(T t) {
		getDao().update(t);
	}

	public boolean exist(Map<String, Object> map) {
		return getDao().countByMap(map) > 0;
	}

	public Integer countByMap(Map<String, Object> map) {
		return getDao().countByMap(map);
	}

	public WsResponse toResponseJson() {
		wsResponse.setStatus(API_STATUS_SUCCESS);
		wsResponse.setErrCode(ErrCodeConstants.ERR_0_SUCCESS);
		wsResponse.setMessage("");
		return wsResponse;
	}

	public WsResponse toResponseJson(String message, Object data) {
		wsResponse.setMessage(message);
		wsResponse.setData(data);
		return toResponseJson();
	}

	public WsResponse toResponseJson(Integer errCode, String message) {
		wsResponse.setStatus(API_STATUS_SUCCESS);
		wsResponse.setErrCode(errCode);
		wsResponse.setMessage(message);
		return wsResponse;
	}

	public WsResponse toResponseJson(String status, Integer errCode, String message) {
		wsResponse.setStatus(status);
		wsResponse.setErrCode(errCode);
		wsResponse.setMessage(message);
		return wsResponse;
	}

}