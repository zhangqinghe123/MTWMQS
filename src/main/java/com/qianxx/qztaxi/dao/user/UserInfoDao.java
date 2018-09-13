package com.qianxx.qztaxi.dao.user;

import com.qianxx.qztaxi.dao.IBaseDao;
import com.qianxx.qztaxi.po.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoDao extends IBaseDao<UserInfo> {

    List<UserInfo> getPage(Map<String, Object> map);

    Integer countByMap(Map<String, Object> map);
}