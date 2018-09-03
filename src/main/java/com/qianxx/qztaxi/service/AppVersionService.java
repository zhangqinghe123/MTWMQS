package com.qianxx.qztaxi.service;

import com.qianxx.qztaxi.vo.AppVersion;

public interface AppVersionService extends IBaseService<AppVersion>  {

	/**
	 * 获取最新版信息
	 */
	AppVersion getNewVersion(Integer versionId, Integer terminal);

	/**
	 * 通过版本号查询
	 */
	AppVersion getByCode(String versionCode, Integer terminal);

	/**
	 * 检查版本号是否存在
	 */
	long getVersionByCode(Integer versionId, String versionCode, Integer terminal);

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

}