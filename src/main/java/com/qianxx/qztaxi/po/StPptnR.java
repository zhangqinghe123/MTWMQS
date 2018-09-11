package com.qianxx.qztaxi.po;

import java.sql.Date;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/10 15:25
 */
public class StPptnR {

    private String STCD;
    private Date TM;
    private double DRP;
    private double INTV;
    private double PDR;
    private double DYP;
    private String WTH;

    public String getSTCD() {
        return STCD;
    }

    public void setSTCD(String STCD) {
        this.STCD = STCD;
    }

    public Date getTM() {
        return TM;
    }

    public void setTM(Date TM) {
        this.TM = TM;
    }

    public double getDRP() {
        return DRP;
    }

    public void setDRP(double DRP) {
        this.DRP = DRP;
    }

    public double getINTV() {
        return INTV;
    }

    public void setINTV(double INTV) {
        this.INTV = INTV;
    }

    public double getPDR() {
        return PDR;
    }

    public void setPDR(double PDR) {
        this.PDR = PDR;
    }

    public double getDYP() {
        return DYP;
    }

    public void setDYP(double DYP) {
        this.DYP = DYP;
    }

    public String getWTH() {
        return WTH;
    }

    public void setWTH(String WTH) {
        this.WTH = WTH;
    }
}
