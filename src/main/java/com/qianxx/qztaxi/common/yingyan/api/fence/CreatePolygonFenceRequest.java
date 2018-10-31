package com.qianxx.qztaxi.common.yingyan.api.fence;

import com.qianxx.qztaxi.common.yingyan.model.BaseRequest;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/10/31 13:34
 */
public class CreatePolygonFenceRequest extends BaseRequest {
    private String fenceName;
    private String monitoredPerson;
    private String vertexes;
    private String coordType = "bd09ll";
    private int denoise = 100;

    public String getFenceName() {
        return fenceName;
    }

    public void setFenceName(String fenceName) {
        this.fenceName = fenceName;
    }

    public String getMonitoredPerson() {
        return monitoredPerson;
    }

    public void setMonitoredPerson(String monitoredPerson) {
        this.monitoredPerson = monitoredPerson;
    }

    public String getVertexes() {
        return vertexes;
    }

    public void setVertexes(String vertexes) {
        this.vertexes = vertexes;
    }

    public String getCoordType() {
        return coordType;
    }

    public int getDenoise() {
        return denoise;
    }

}
