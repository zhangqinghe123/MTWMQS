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
