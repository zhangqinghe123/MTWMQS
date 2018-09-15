package com.qianxx.qztaxi.vo;

import com.qianxx.qztaxi.common.util.DateUtil;
import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/11 15:39
 */
public class RainFallInfo {
    // 起始时间
    private Long startTime;
    private String startTimeStr;
    // 终止时间
    private Long endTime;
    private String endTimeStr;
    // 总降水量（mm）
    private double DRP_SUM;
    // 总降水时长（mm）
    private double INTV_SUM;
    // 日降水量
    private double DYP;
    // 天气情况
    private double WTH;

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public double getDRP_SUM() {
        return DRP_SUM;
    }

    public void setDRP_SUM(double DRP_SUM) {
        this.DRP_SUM = DRP_SUM;
    }

    public double getINTV_SUM() {
        return INTV_SUM;
    }

    public void setINTV_SUM(double INTV_SUM) {
        this.INTV_SUM = INTV_SUM;
    }

    public double getDYP() {
        return DYP;
    }

    public void setDYP(double DYP) {
        this.DYP = DYP;
    }

    public double getWTH() {
        return WTH;
    }

    public void setWTH(double WTH) {
        this.WTH = WTH;
    }

    public String getStartTimeStr() {
        return DateFormatUtils.format(new Date(startTime), DateUtil.DEFAULT_WHOLE_FORMAT);
    }

    public void setStartTimeStr(String startTimeStr) {
        this.startTimeStr = startTimeStr;
    }

    public String getEndTimeStr() {
        return DateFormatUtils.format(new Date(endTime), DateUtil.DEFAULT_WHOLE_FORMAT);
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
    }
}
