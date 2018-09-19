package com.qianxx.qztaxi.service;

import com.qianxx.qztaxi.po.StRiverR;
import com.qianxx.qztaxi.vo.RealTimeRiverInfo;
import com.qianxx.qztaxi.vo.RiverDetailInfo;
import com.qianxx.qztaxi.vo.RiverInfo;

import java.util.List;

public interface StRiverRService extends IBaseService<StRiverR> {

    List<RiverInfo> getNewestRiverInfo(String stcds);

    List<RiverDetailInfo> getRiverInfoByTime(String startTime, String endTime, String stcd);

    RealTimeRiverInfo getRiverInfoList();
}