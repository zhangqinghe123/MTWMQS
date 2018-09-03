package com.qianxx.qztaxi.service;

import java.util.List;
import java.util.Map;

import com.qianxx.qztaxi.service.bean.PagerBean;

public abstract interface IBaseService<T> {

	/**
	 * 根据ID查询对象
	 */
	T getById(Integer id);

	/**
	 * 根据page条件查询对象列表
	 */
	void getAll(PagerBean<T> page);

	/**
	 * 根据map条件查询对象列表
	 */
	List<T> getAll(Map<String, Object> searchParams);

	/**
	 * 查询所有
	 */
	List<T> getAll();

	/**
	 * 根据IDS删除对象
	 */
	void deleteByIds(String ids);

	/**
	 * 根据IDS启用对象
	 */
	void enableByIds(String ids);

	/**
	 * 根据IDS禁用对象
	 */
	void disableByIds(String ids);

	/**
	 * 删除所有
	 */
	void deleteAll();

	/**
	 * 保存对象
	 */
	void save(T t);

	/**
	 * 根据ID更新对象，注意ID要有值
	 */
	void update(T t);

	/**
	 * 根据map条件查询是否存在对象
	 */
	boolean exist(Map<String, Object> map);

	/**
	 * 根据条件计算个数
	 */
	Integer countByMap(Map<String, Object> map);
}