package com.qianxx.qztaxi.dao.service;

import com.qianxx.qztaxi.dao.IBaseDao;
import com.qianxx.qztaxi.po.StRiverR;
import com.qianxx.qztaxi.po.StRsvrR;
import org.apache.ibatis.annotations.Param;

import java.util.Date;


public interface StRsvrRDao extends IBaseDao<StRsvrR> {

    StRsvrR getRsvrInfoByTime(@Param("STCD") String STCD, @Param("staticTIme") Date staticTIme);

    StRsvrR getNewestRsvrInfo(@Param("STCD") String STCD);

}