package com.qianxx.qztaxi.vo;

import java.util.ArrayList;
import java.util.List;

public class RainFallLevel {

    private String levelName;
    private int stationNum = 0;

    private List<StationRainInfo> stationRainInfos = new ArrayList<>();

    public List<StationRainInfo> getStationRainInfos() {
        return stationRainInfos;
    }

    public void setStationRainInfos(List<StationRainInfo> stationRainInfos) {
        this.stationRainInfos = stationRainInfos;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public int getStationNum() {
        return stationNum;
    }

    public void setStationNum(int stationNum) {
        this.stationNum = stationNum;
    }
}

