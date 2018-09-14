package com.qianxx.qztaxi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qianxx.qztaxi.dao.user.AppVersionDao;
import com.qianxx.qztaxi.service.AppVersionService;
import com.qianxx.qztaxi.po.AppVersion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<AppVersion> getByCodeInt(Integer codeInt) {
        Map<String, Object> params = new HashMap<>();
        params.put("codeInt", codeInt);
        return appVersionDao.getAllByMap(params);
    }

    /**
     * 新增
     */
    public void doInsert(AppVersion appVersion) {
        appVersionDao.doInsert(appVersion);
    }

    /**
     * 删除
     */
    public void doDelete(Integer versionId) {
        appVersionDao.doDelete(versionId);
    }

    @Override
    public List<AppVersion> getNewestVersion(int versionCode) {
        Map<String,Object> param = new HashMap<>();
        param.put("codeInt",versionCode);
        return appVersionDao.getNewestVersion(param);
    }

}