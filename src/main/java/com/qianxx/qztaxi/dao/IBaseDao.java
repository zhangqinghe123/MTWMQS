package com.qianxx.qztaxi.dao;

import java.util.List;
import java.util.Map;

/**
 * 
 * 泛型基础dao接口
 * <p>
 */
public abstract interface IBaseDao<T> {
	/**
	 * 根据ID查询对象
	 * 
	 * @author lenovo
	 * @since 2016年1月10日 下午9:13:37
	 * @param id
	 * @return
	 */
	T getById(Integer id);

	/**
	 * 根据map条件查询对象列表
	 * 
	 * @author lenovo
	 * @since 2016年1月10日 下午9:14:00
	 * @param searchParams
	 * @return
	 */
	List<T> getAllByMap(Map<String, Object> searchParams);

	/**
	 * 根据IDS删除对象
	 * 
	 * @author lenovo
	 * @since 2016年1月10日 下午9:14:25
	 * @param ids
	 */
	void deleteByIds(String[] ids);

	/**
	 * 根据IDS启用对象
	 * 
	 * @author lenovo
	 * @since 2016年1月10日 下午9:14:25
	 * @param ids
	 */
	void enableByIds(String[] ids);

	/**
	 * 根据IDS禁用对象
	 * 
	 * @author lenovo
	 * @since 2016年1月10日 下午9:14:25
	 * @param ids
	 */
	void disableByIds(String[] ids);

	/**
	 * 删除所有
	 * 
	 * @author lenovo
	 * @since 2016年1月10日 下午9:14:25
	 * @param ids
	 */
	void deleteAll();

	/**
	 * 保存对象
	 * 
	 * @author lenovo
	 * @since 2016年1月10日 下午9:15:49
	 * @param t
	 */
	void save(T t);

	/**
	 * 根据ID更新对象，注意ID要有值
	 * 
	 * @author lenovo
	 * @since 2016年1月10日 下午9:16:07
	 * @param t
	 */
	void update(T t);

	/**
	 * 根据条件计算个数
	 * 
	 * @author lenovo
	 * @since 2016年1月10日 下午9:16:59
	 * @param searchParams
	 * @return
	 */
	Integer countByMap(Map<String, Object> searchParams);
}
