package com.qianxx.qztaxi.vo;

import com.qianxx.qztaxi.common.util.DateUtil;
import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;


/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/15 15:55
 */
public class RsvrInfo {
    private String STCD;
    private boolean yesterdayEightClock = false;
    // 8时水位
    private double eightClockWaterLevel;
    // 当前水位
    private double currentWaterLevel;
    // 当前时间
    private long currentTime;
    // 当前时间
    private String currentTimeStr;

    private double INQ;

    private double OTQ;

    public double getEightClockWaterLevel() {
        return eightClockWaterLevel;
    }

    public void setEightClockWaterLevel(double eightClockWaterLevel) {
        this.eightClockWaterLevel = eightClockWaterLevel;
    }

    public double getCurrentWaterLevel() {
        return currentWaterLevel;
    }

    public void setCurrentWaterLevel(double currentWaterLevel) {
        this.currentWaterLevel = currentWaterLevel;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public String getSTCD() {
        return STCD;
    }

    public void setSTCD(String STCD) {
        this.STCD = STCD;
    }

    public boolean isYesterdayEightClock() {
        return yesterdayEightClock;
    }

    public void setYesterdayEightClock(boolean yesterdayEightClock) {
        this.yesterdayEightClock = yesterdayEightClock;
    }

    public String getCurrentTimeStr() {
        return DateFormatUtils.format(new Date(currentTime), DateUtil.DEFAULT_WHOLE_FORMAT);
    }

    public void setCurrentTimeStr(String currentTimeStr) {
        this.currentTimeStr = currentTimeStr;
    }

    public double getINQ() {
        return INQ;
    }

    public void setINQ(double INQ) {
        this.INQ = INQ;
    }

    public double getOTQ() {
        return OTQ;
    }

    public void setOTQ(double OTQ) {
        this.OTQ = OTQ;
    }
}
