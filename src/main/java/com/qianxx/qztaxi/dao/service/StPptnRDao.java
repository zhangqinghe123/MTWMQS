package com.qianxx.qztaxi.dao.service;

import com.qianxx.qztaxi.dao.IBaseDao;
import com.qianxx.qztaxi.po.StPptnR;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.Map;


public interface StPptnRDao extends IBaseDao<StPptnR> {
    Map<String, Object> getRainInfoByTime(@Param("STCD") String STCD, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    Map<String, Object> getAvgRainfallInfo(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    Integer getRainfallGt50Num(@Param("startTime") Date startTime, @Param("endTime") Date endTime);
}