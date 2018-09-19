package com.qianxx.qztaxi.vo;

import java.util.ArrayList;
import java.util.List;

public class RainFallLevel {

    private String levelName;
    private int stationNum = 0;

    private List<StationInfo> stationInfos = new ArrayList<>();

    public List<StationInfo> getStationInfos() {
        return stationInfos;
    }

    public void setStationInfos(List<StationInfo> stationInfos) {
        this.stationInfos = stationInfos;
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

