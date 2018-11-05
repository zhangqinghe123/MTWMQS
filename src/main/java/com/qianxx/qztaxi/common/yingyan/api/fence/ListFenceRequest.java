package com.qianxx.qztaxi.common.yingyan.api.fence;

import com.qianxx.qztaxi.common.yingyan.model.BaseRequest;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/11/5 09:13
 */
public class ListFenceRequest extends BaseRequest {

    private String monitored_person;

    public String getMonitored_person() {
        return monitored_person;
    }

    public void setMonitored_person(String monitored_person) {
        this.monitored_person = monitored_person;
    }
}
