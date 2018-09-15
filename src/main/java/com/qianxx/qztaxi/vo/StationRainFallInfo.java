package com.qianxx.qztaxi.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/15 13:21
 */
public class StationRainFallInfo {

    private String STCD;

    private double totalRainFall = 0;

    private List<RainFallInfo> rainFallInfos = new ArrayList<>();

    public String getSTCD() {
        return STCD;
    }

    public void setSTCD(String STCD) {
        this.STCD = STCD;
    }

    public List<RainFallInfo> getRainFallInfos() {
        return rainFallInfos;
    }

    public void setRainFallInfos(List<RainFallInfo> rainFallInfos) {
        this.rainFallInfos = rainFallInfos;
    }

    public double getTotalRainFall() {
        return totalRainFall;
    }

    public void setTotalRainFall(double totalRainFall) {
        this.totalRainFall = totalRainFall;
    }

    public void addTotalRainFall(double rainFall) {
        totalRainFall += rainFall;
    }
}
