package com.qianxx.qztaxi.vo;

import java.sql.Timestamp;

/**
 * <p>
 * 字段IDValueObject.
 * </p>
 */
public class Usertoken implements java.io.Serializable {
	/**
     *
     */
	private static final long serialVersionUID = 1L;

	/** TOKEN **/
	private String token;
	/** 用户ID **/
	private Integer userId;
	/** APP ID **/
	private String appid;
	/** 客户端类型**/
	private int clientType;
	/** 创建时间 **/
	private Timestamp createdOn;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public int getClientType() {
		return clientType;
	}

	public void setClientType(int clientType) {
		this.clientType = clientType;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

}