package com.qianxx.qztaxi.common.yingyan.model;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/11/5 09:19
 */
public class BaseResponse {
    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
