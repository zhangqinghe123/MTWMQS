package com.qianxx.qztaxi.vo;

import io.swagger.models.auth.In;

import java.sql.Timestamp;

/**
 * <p>
 * 字段IDValueObject.
 * </p>
 */
public class Adminuser implements java.io.Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Adminuser(Integer id, String account, String password, String userName) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.userName = userName;
    }

    /**
     * 登录名
     **/
    private Integer id;
    /**
     * 登录名
     **/
    private String account;
    /**
     * 密码
     **/
    private String password;
    /**
     * 用户名
     **/
    private String userName;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}