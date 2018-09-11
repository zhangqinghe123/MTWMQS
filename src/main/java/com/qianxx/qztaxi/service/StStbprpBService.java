package com.qianxx.qztaxi.service;

import com.qianxx.qztaxi.po.StStbprpB;

import java.util.List;

public interface StStbprpBService extends IBaseService<StStbprpB>  {

    List<StStbprpB> getAllRainStations(Integer pageSize, Integer pageNum);
}