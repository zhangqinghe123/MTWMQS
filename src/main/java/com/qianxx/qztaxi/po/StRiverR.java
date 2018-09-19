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
    private Double Z;
    private Double Q;
    private Integer WPTN;

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

    public Double getZ() {
        return Z;
    }

    public void setZ(Double z) {
        Z = z;
    }

    public Double getQ() {
        return Q;
    }

    public void setQ(Double q) {
        Q = q;
    }

    public Integer getWPTN() {
        return WPTN;
    }

    public void setWPTN(Integer WPTN) {
        this.WPTN = WPTN;
    }
}
