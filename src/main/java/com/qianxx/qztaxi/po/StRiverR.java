package com.qianxx.qztaxi.po;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/10 15:25
 */
public class StRiverR {

    private String STCD;
    private Timestamp TM;
    private double Z;
    private double Q;

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

    public double getZ() {
        return Z;
    }

    public void setZ(double z) {
        Z = z;
    }

    public double getQ() {
        return Q;
    }

    public void setQ(double q) {
        Q = q;
    }
}
