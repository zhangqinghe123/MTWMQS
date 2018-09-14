package com.qianxx.qztaxi.dao.user;

import java.util.List;
import java.util.Map;

import com.qianxx.qztaxi.dao.IBaseDao;
import org.apache.ibatis.annotations.Param;

import com.qianxx.qztaxi.po.AppVersion;

public interface AppVersionDao extends IBaseDao<AppVersion> {

	/**
	 * 新增
	 */
	void doInsert(AppVersion appVersion);

	/**
	 * 删除
	 */
	void doDelete(Integer versionId);

	List<AppVersion> getPage(Map<String, Object> map);

	Integer countByMap(Map<String, Object> map);

    List<AppVersion> getNewestVersion(Map<String, Object> map);
}