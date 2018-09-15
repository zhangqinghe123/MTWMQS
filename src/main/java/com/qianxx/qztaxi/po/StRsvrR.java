package com.qianxx.qztaxi.po;

import java.sql.Timestamp;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/10 15:25
 */
public class StRsvrR {

    private String STCD;
    private Timestamp TM;
    private double RZ;
    private double INQ;
    private double OTQ;

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

    public String getSTCD() {
        return STCD;
    }

    public void setSTCD(String STCD) {
        this.STCD = STCD;
    }

    public Timestamp getTM() {
        return TM;
    }

    public void setTM(Timestamp TM) {
        this.TM = TM;
    }

    public double getRZ() {
        return RZ;
    }

    public void setRZ(double RZ) {
        this.RZ = RZ;
    }
}
