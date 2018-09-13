package com.qianxx.qztaxi.dao.user;

import com.qianxx.qztaxi.dao.IBaseDao;
import com.qianxx.qztaxi.po.Resource;
import com.qianxx.qztaxi.po.UserInfo;

import java.util.List;

public interface ResourceDao extends IBaseDao<Resource> {

    List<Resource> getAllFather();
}