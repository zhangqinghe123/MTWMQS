package com.qianxx.qztaxi.service;

import com.qianxx.qztaxi.po.StPptnR;
import com.qianxx.qztaxi.po.StStbprpB;
import com.qianxx.qztaxi.vo.RainFallInfo;
import com.qianxx.qztaxi.vo.StationRainFallInfo;

import java.util.List;

public interface StPptnRService extends IBaseService<StPptnR> {

    List<StationRainFallInfo> getRainfallInfoByTime(Long startTime, Long endTime, Integer interval, String stcds);

    double getNewAvgRainfallInfo();

    Integer getRainfallGt50Num();
}