package com.qianxx.qztaxi.service;

import com.qianxx.qztaxi.vo.StStbprpB;

import java.util.List;

public interface StStbprpBService extends IBaseService<StStbprpB>  {

    List<StStbprpB> getAllRainStations();
}