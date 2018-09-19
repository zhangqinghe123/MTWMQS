package com.qianxx.qztaxi.vo;

import java.util.List;

public class RealTimeRainInfo {

    private Long startTime;
    private String startTimeStr;
    private Long endTime;
    private String endTimeStr;
    private Integer totalStationNum;
    private Integer rainStationNum;
    private String maxRainStation;
    private Double maxRainfall;
    private List<RainFallLevel> rainFallLevel;

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public String getStartTimeStr() {
        return startTimeStr;
    }

    public void setStartTimeStr(String startTimeStr) {
        this.startTimeStr = startTimeStr;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
    }

    public Integer getTotalStationNum() {
        return totalStationNum;
    }

    public void setTotalStationNum(Integer totalStationNum) {
        this.totalStationNum = totalStationNum;
    }

    public Integer getRainStationNum() {
        return rainStationNum;
    }

    public void setRainStationNum(Integer rainStationNum) {
        this.rainStationNum = rainStationNum;
    }

    public String getMaxRainStation() {
        return maxRainStation;
    }

    public void setMaxRainStation(String maxRainStation) {
        this.maxRainStation = maxRainStation;
    }

    public Double getMaxRainfall() {
        return maxRainfall;
    }

    public void setMaxRainfall(Double maxRainfall) {
        this.maxRainfall = maxRainfall;
    }

    public List<RainFallLevel> getRainFallLevel() {
        return rainFallLevel;
    }

    public void setRainFallLevel(List<RainFallLevel> rainFallLevel) {
        this.rainFallLevel = rainFallLevel;
    }
}
