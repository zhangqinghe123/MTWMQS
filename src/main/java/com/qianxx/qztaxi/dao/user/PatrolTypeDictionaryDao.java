package com.qianxx.qztaxi.dao.user;

import com.qianxx.qztaxi.dao.IBaseDao;
import com.qianxx.qztaxi.po.PatrolTypeDictionary;

import java.util.List;
import java.util.Map;

public interface PatrolTypeDictionaryDao extends IBaseDao<PatrolTypeDictionary> {
    List<PatrolTypeDictionary> getPage(Map<String, Object> map);

    Integer countByMap(Map<String, Object> map);
}