package com.qianxx.qztaxi.dao.service;

import com.qianxx.qztaxi.dao.IBaseDao;
import com.qianxx.qztaxi.po.StRiverR;
import com.qianxx.qztaxi.po.StRsvrR;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.Map;


public interface StRsvrRDao extends IBaseDao<StRsvrR> {

    StRsvrR getRsvrInfoByTime(@Param("STCD") String STCD, @Param("staticTIme") Date staticTIme);

    StRsvrR getNewestRsvrInfo(@Param("STCD") String STCD);

    Map<String,Object> getInfoBetweenTime(@Param("startTime") Date startFullTime, @Param("endTime") Date endFullTime, @Param("STCD") String stcd);
}