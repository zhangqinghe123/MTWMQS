package com.qianxx.qztaxi.service;

import com.qianxx.qztaxi.po.StRsvrR;
import com.qianxx.qztaxi.vo.RiverInfo;

import java.util.List;

public interface StRsvrRService extends IBaseService<StRsvrR> {

    List<RiverInfo> getNewestRsvrInfo(String stcds);

}