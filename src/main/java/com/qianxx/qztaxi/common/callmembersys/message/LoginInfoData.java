package com.qianxx.qztaxi.common.callmembersys.message;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/11/13 17:13
 */
public class LoginInfoData {
    private String accessToken;
    private Long expireTime;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }
}
