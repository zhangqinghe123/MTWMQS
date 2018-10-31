package com.qianxx.qztaxi.po;

import java.util.Date;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/4 10:24
 */
public class PatrolRecord {
    private Integer id;
    private Date createTime;
    private String filePath;
    private Integer userId;
    private String explain;
    private Double longitude;
    private Double latitude;
    private String userName;
    private String userMobile;
    private Integer patrolTypeId;
    private String patrolTypeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public Integer getPatrolTypeId() {
        return patrolTypeId;
    }

    public void setPatrolTypeId(Integer patrolTypeId) {
        this.patrolTypeId = patrolTypeId;
    }

    public String getPatrolTypeName() {
        return patrolTypeName;
    }

    public void setPatrolTypeName(String patrolTypeName) {
        this.patrolTypeName = patrolTypeName;
    }
}
