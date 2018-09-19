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
public class RiverDetailInfo {
    private String STCD;
    private String name;
    private String staticTime;
    private double waterLever;
    private double waterFlow;
    private Integer upper;
    private Double alertWaterLevel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUpper() {
        return upper;
    }

    public void setUpper(Integer upper) {
        this.upper = upper;
    }

    public Double getAlertWaterLevel() {
        return alertWaterLevel;
    }

    public void setAlertWaterLevel(Double alertWaterLevel) {
        this.alertWaterLevel = alertWaterLevel;
    }

    public String getSTCD() {
        return STCD;
    }

    public void setSTCD(String STCD) {
        this.STCD = STCD;
    }

    public String getStaticTime() {
        return staticTime;
    }

    public void setStaticTime(String staticTime) {
        this.staticTime = staticTime;
    }

    public double getWaterLever() {
        return waterLever;
    }

    public void setWaterLever(double waterLever) {
        this.waterLever = waterLever;
    }

    public double getWaterFlow() {
        return waterFlow;
    }

    public void setWaterFlow(double waterFlow) {
        this.waterFlow = waterFlow;
    }
}
