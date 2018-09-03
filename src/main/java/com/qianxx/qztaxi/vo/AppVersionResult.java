package com.qianxx.qztaxi.vo;

import java.io.Serializable;

public class AppVersionResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private java.lang.Integer isNew;

	private java.lang.String versionCode;

	private java.lang.Integer versionType;

	private java.lang.String md5;

	private java.lang.String downLoadUrl;

	private java.lang.String introduce;

	public java.lang.Integer getIsNew() {
		return isNew;
	}

	public void setIsNew(java.lang.Integer isNew) {
		this.isNew = isNew;
	}

	public java.lang.String getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(java.lang.String versionCode) {
		this.versionCode = versionCode;
	}

	public java.lang.Integer getVersionType() {
		return versionType;
	}

	public void setVersionType(java.lang.Integer versionType) {
		this.versionType = versionType;
	}

	public java.lang.String getMd5() {
		return md5;
	}

	public void setMd5(java.lang.String md5) {
		this.md5 = md5;
	}

	public java.lang.String getDownLoadUrl() {
		return downLoadUrl;
	}

	public void setDownLoadUrl(java.lang.String downLoadUrl) {
		this.downLoadUrl = downLoadUrl;
	}

	public java.lang.String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(java.lang.String introduce) {
		this.introduce = introduce;
	}

}