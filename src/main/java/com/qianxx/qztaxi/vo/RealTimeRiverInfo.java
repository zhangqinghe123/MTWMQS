package com.qianxx.qztaxi.vo;

import java.util.List;

public class RealTimeRiverInfo {

    private Integer totalStationNum;
    private Integer alertNum;
    private List<RiverDetailInfo> riverDetailInfoList;

    public Integer getTotalStationNum() {
        return totalStationNum;
    }

    public void setTotalStationNum(Integer totalStationNum) {
        this.totalStationNum = totalStationNum;
    }

    public Integer getAlertNum() {
        return alertNum;
    }

    public void setAlertNum(Integer alertNum) {
        this.alertNum = alertNum;
    }

    public List<RiverDetailInfo> getRiverDetailInfoList() {
        return riverDetailInfoList;
    }

    public void setRiverDetailInfoList(List<RiverDetailInfo> riverDetailInfoList) {
        this.riverDetailInfoList = riverDetailInfoList;
    }
}
