package com.qianxx.qztaxi.dao.service;

import com.qianxx.qztaxi.dao.IBaseDao;
import com.qianxx.qztaxi.po.StPptnR;
import com.qianxx.qztaxi.po.StRiverR;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface StRiverRDao extends IBaseDao<StRiverR> {

    StRiverR getRiverInfoByTime(@Param("STCD") String STCD, @Param("staticTime") Date staticTime);

    List<StRiverR> getNewestRiverInfo(@Param("STCD") String STCD);

    Map<String, Object> getInfoBetweenTime(@Param("startTime") Date startFullTime, @Param("endTime") Date endFullTime, @Param("STCD") String stcd);
}