package com.qianxx.qztaxi.service;

import com.qianxx.qztaxi.po.StRiverR;
import com.qianxx.qztaxi.vo.RiverInfo;

import java.util.List;

public interface StRiverRService extends IBaseService<StRiverR> {

    List<RiverInfo> getNewestRiverInfo(String stcds);

}