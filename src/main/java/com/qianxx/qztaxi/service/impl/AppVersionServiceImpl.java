package com.qianxx.qztaxi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qianxx.qztaxi.dao.service.AppVersionDao;
import com.qianxx.qztaxi.service.AppVersionService;
import com.qianxx.qztaxi.vo.AppVersion;

/**
 * 数据访问接口
 */
@Service("appVersionService")
public class AppVersionServiceImpl extends BaseService<AppVersion, AppVersionDao> implements AppVersionService {

	@Autowired
	private AppVersionDao appVersionDao;

	public AppVersionDao getDao() {
		return appVersionDao;
	}

	/**
	 * 获取最新版信息
	 */
	public AppVersion getNewVersion(Integer versionId, Integer terminal) {
		return appVersionDao.getNewVersion(versionId, terminal);
	}

	/**
	 * 通过版本号查询
	 */
	public AppVersion getByCode(String versionCode, Integer terminal) {
		return appVersionDao.getByCode(versionCode, terminal);
	}

	/**
	 * 检查版本号是否存在
	 */
	public long getVersionByCode(Integer versionId, String versionCode, Integer terminal) {
		return appVersionDao.getVersionByCode(versionId, versionCode, terminal);
	}

	/**
	 * 启用、禁用
	 */
	public void doUpdateState(Integer versionId) {
		appVersionDao.doUpdateState(versionId);
	}

	/**
	 * 新增
	 */
	public void doInsert(AppVersion appVersion) {
		appVersionDao.doInsert(appVersion);
	}

	/**
	 * 编辑
	 */
	public void doUpdate(AppVersion appVersion) {
		appVersionDao.doUpdate(appVersion);
	}

	/**
	 * 删除
	 */
	public void doDelete(Integer versionId) {
		appVersionDao.doDelete(versionId);
	}

}