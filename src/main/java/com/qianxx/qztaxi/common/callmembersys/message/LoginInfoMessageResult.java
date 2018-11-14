package com.qianxx.qztaxi.common.callmembersys.message;

public class LoginInfoMessageResult {
    private String code;
    private String msg;
    private LoginInfoBody data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public LoginInfoBody getData() {
        return data;
    }

    public void setData(LoginInfoBody data) {
        this.data = data;
    }
}
