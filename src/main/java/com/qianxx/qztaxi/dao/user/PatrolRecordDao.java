package com.qianxx.qztaxi.dao.user;

import com.qianxx.qztaxi.dao.IBaseDao;
import com.qianxx.qztaxi.po.PatrolRecord;

import java.util.List;
import java.util.Map;

public interface PatrolRecordDao extends IBaseDao<PatrolRecord> {

    List<PatrolRecord> getPage(Map<String, Object> map);

    Integer countByMap(Map<String, Object> map);

}