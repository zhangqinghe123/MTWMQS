package com.qianxx.qztaxi.service;

import com.qianxx.qztaxi.po.AppVersion;

import java.util.List;

public interface AppVersionService extends IBaseService<AppVersion> {
    /**
     * 通过版本号查询
     */
    List<AppVersion> getByCodeInt(Integer codeInt);
    /**
     * 新增
     */
    void doInsert(AppVersion appVersion);
    /**
     * 删除
     */
    void doDelete(Integer versionId);

    List<AppVersion> getNewestVersion(int versionCode);
}