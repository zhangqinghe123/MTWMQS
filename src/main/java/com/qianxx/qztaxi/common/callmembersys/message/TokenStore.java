package com.qianxx.qztaxi.common.callmembersys.message;

public class TokenStore {
    private String accessToken = new String();
    private Long expireDate = new Long(0);

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Long expireDate) {
        this.expireDate = expireDate;
    }
}
