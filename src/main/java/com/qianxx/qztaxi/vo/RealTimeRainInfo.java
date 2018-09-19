package com.qianxx.qztaxi.vo;

import java.util.List;

public class RealTimeRainInfo {

    private Integer totalStationNum;
    private Integer rainStationNum;
    private String maxRainStationSTCD;
    private String maxRainStationName;
    private Double maxRainfall;
    private List<RainFallLevel> rainFallLevel;

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

    public String getMaxRainStationSTCD() {
        return maxRainStationSTCD;
    }

    public void setMaxRainStationSTCD(String maxRainStationSTCD) {
        this.maxRainStationSTCD = maxRainStationSTCD;
    }

    public String getMaxRainStationName() {
        return maxRainStationName;
    }

    public void setMaxRainStationName(String maxRainStationName) {
        this.maxRainStationName = maxRainStationName;
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
