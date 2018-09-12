package com.qianxx.qztaxi.service;

import com.qianxx.qztaxi.po.StStbprpB;

import java.util.List;

public interface StStbprpBService extends IBaseService<StStbprpB> {

    /**
     * 查询所有雨量站信息
     *
     * @return 雨量站
     */
    List<StStbprpB> getAllRainStations();

    /**
     * 查询所有水库站信息
     *
     * @return 水库站
     */
    List<StStbprpB> getAllReservoirStations();

    /**
     * 查询所有河流站信息
     *
     * @return 河流站
     */
    List<StStbprpB> getAllRiverStations();

    /**
     * 查询所有山洪站信息
     *
     * @return 山洪站
     */
    List<StStbprpB> getAllMountainTorrentStations();

    /**
     * 查询所有水文站信息
     *
     * @return 水文站
     */
    List<StStbprpB> getAllHydrologyStations();
}