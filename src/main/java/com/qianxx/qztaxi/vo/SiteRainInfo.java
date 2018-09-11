package com.qianxx.qztaxi.vo;

import java.sql.Date;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/11 15:39
 */
public class SiteRainInfo {

    private String STCD;
    private String staticTime;
    private double DRP_AVG;
    private double INTV_AVG;
    private double PDR_AVG;
    private double DYP_AVG;

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

    public double getDRP_AVG() {
        return DRP_AVG;
    }

    public void setDRP_AVG(double DRP_AVG) {
        this.DRP_AVG = DRP_AVG;
    }

    public double getINTV_AVG() {
        return INTV_AVG;
    }

    public void setINTV_AVG(double INTV_AVG) {
        this.INTV_AVG = INTV_AVG;
    }

    public double getPDR_AVG() {
        return PDR_AVG;
    }

    public void setPDR_AVG(double PDR_AVG) {
        this.PDR_AVG = PDR_AVG;
    }

    public double getDYP_AVG() {
        return DYP_AVG;
    }

    public void setDYP_AVG(double DYP_AVG) {
        this.DYP_AVG = DYP_AVG;
    }
}
