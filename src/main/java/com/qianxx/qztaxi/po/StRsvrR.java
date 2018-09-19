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
    private Double RZ;
    private Double INQ;
    private Double OTQ;
    private Double W;
    private Integer RWPTN;

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

    public Double getRZ() {
        return RZ;
    }

    public void setRZ(Double RZ) {
        this.RZ = RZ;
    }

    public Double getINQ() {
        return INQ;
    }

    public void setINQ(Double INQ) {
        this.INQ = INQ;
    }

    public Double getOTQ() {
        return OTQ;
    }

    public void setOTQ(Double OTQ) {
        this.OTQ = OTQ;
    }

    public Double getW() {
        return W;
    }

    public void setW(Double w) {
        W = w;
    }

    public Integer getRWPTN() {
        return RWPTN;
    }

    public void setRWPTN(Integer RWPTN) {
        this.RWPTN = RWPTN;
    }
}
