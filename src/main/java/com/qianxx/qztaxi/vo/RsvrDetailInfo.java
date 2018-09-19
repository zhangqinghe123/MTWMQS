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
public class RsvrDetailInfo {
    private String STCD;
    private String name;
    private String staticTime;
    private double waterLever;
    private double inWaterFlow;
    private double outWaterFlow;
    private Integer rwptn;
    private Double alertWaterLevel;
    private Double capacity;

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

    public double getInWaterFlow() {
        return inWaterFlow;
    }

    public void setInWaterFlow(double inWaterFlow) {
        this.inWaterFlow = inWaterFlow;
    }

    public double getOutWaterFlow() {
        return outWaterFlow;
    }

    public void setOutWaterFlow(double outWaterFlow) {
        this.outWaterFlow = outWaterFlow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Double getAlertWaterLevel() {
        return alertWaterLevel;
    }

    public void setAlertWaterLevel(Double alertWaterLevel) {
        this.alertWaterLevel = alertWaterLevel;
    }

    public Integer getRwptn() {
        return rwptn;
    }

    public void setRwptn(Integer rwptn) {
        this.rwptn = rwptn;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }
}
