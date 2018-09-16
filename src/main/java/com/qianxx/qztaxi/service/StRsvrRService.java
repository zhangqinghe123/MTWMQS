package com.qianxx.qztaxi.service;

import com.qianxx.qztaxi.po.StRsvrR;
import com.qianxx.qztaxi.vo.RiverInfo;
import com.qianxx.qztaxi.vo.RsvrDetailInfo;
import com.qianxx.qztaxi.vo.RsvrInfo;

import java.util.List;

public interface StRsvrRService extends IBaseService<StRsvrR> {

    List<RsvrInfo> getNewestRsvrInfo(String stcds);

    List<RsvrDetailInfo> getRsvrInfoByTime(String startTime, String endTime, String stcd);
}