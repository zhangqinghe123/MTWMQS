package com.qianxx.qztaxi.dao.user;

import java.util.List;
import java.util.Map;

import com.qianxx.qztaxi.dao.IBaseDao;
import org.apache.ibatis.annotations.Param;

import com.qianxx.qztaxi.po.AppVersion;

public interface AppVersionDao extends IBaseDao<AppVersion> {

	/**
	 * 获取最新版信息
	 */
	AppVersion getNewVersion(@Param("versionId") Integer versionId, @Param("terminal") Integer terminal);

	/**
	 * 通过版本号查询
	 */
	AppVersion getByCode(@Param("versionCode") String versionCode, @Param("terminal") Integer terminal);

	/**
	 * 检查版本号是否存在
	 */
	long getVersionByCode(@Param("versionId") Integer versionId, @Param("versionCode") String versionCode, @Param("terminal") Integer terminal);

	/**
	 * 启用、禁用
	 */
	void doUpdateState(Integer versionId);

	/**
	 * 新增
	 */
	void doInsert(AppVersion appVersion);

	/**
	 * 编辑
	 */
	void doUpdate(AppVersion appVersion);

	/**
	 * 删除
	 */
	void doDelete(Integer versionId);

	List<AppVersion> getPage(Map<String, Object> map);

	Integer countByMap(Map<String, Object> map);

}