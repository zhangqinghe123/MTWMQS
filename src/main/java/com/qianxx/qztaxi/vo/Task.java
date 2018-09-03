package com.qianxx.qztaxi.vo;

import java.sql.Timestamp;

/**
 * 描述： <br>
 * Created on 2016/6/20. <br>
 *
 * @author zhangjie
 */
public class Task {


    /** id **/
    private Integer id;
    /** 类型id **/
    private Integer typeId;
    /** 推送类型 **/
    private Integer type;
    /**推送状态 **/
    private String status;
    /** 创建时间 **/
    private Timestamp createdOn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
