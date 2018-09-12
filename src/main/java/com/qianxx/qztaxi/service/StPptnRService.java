package com.qianxx.qztaxi.service;

import com.qianxx.qztaxi.po.StPptnR;
import com.qianxx.qztaxi.po.StStbprpB;

import java.util.List;

public interface StPptnRService extends IBaseService<StPptnR> {

    List<StStbprpB> getAllRainStations(String startTime, String endTime);
}