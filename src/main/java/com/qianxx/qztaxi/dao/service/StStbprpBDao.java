package com.qianxx.qztaxi.dao.service;

import com.qianxx.qztaxi.dao.IBaseDao;
import com.qianxx.qztaxi.po.StStbprpB;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;
import java.util.Map;

public interface StStbprpBDao extends IBaseDao<StStbprpB> {

    List<String> getAllSTCDByMap(Map<String, Object> searchParams);

    List<StStbprpB> getAllRainStation();

    List<StStbprpB> getAllRiverStation();

    List<StStbprpB> getAllRsvrStation();
}