package com.qianxx.qztaxi.vo;

import java.io.Serializable;

/**
 * AppVersion表
 */
public class AppVersion implements Serializable {

	private static final long serialVersionUID = 1L;

	private java.lang.Integer versionId; // 版本编码
	private java.lang.String versionName; // 版本名称
	private java.lang.String versionCode; // 版本号
	private java.lang.Integer terminal; // 1用户端，2司机端
	private java.lang.Integer versionType; // 版本更新类型（0非强制1强制更新）
	private java.lang.Integer state; // 禁用状态（1已启用，2已禁用）
	private java.lang.Integer isDel; // 删除状态（1未删除，2已删除）
	private java.lang.String downLoadUrl; // 下载地址
	private java.lang.String introduce; // 版本介绍
	private java.lang.String md5; // MD5校验值
	private java.lang.String purpose; // 用途
	private java.util.Date ctime; // 创建时间

	public java.lang.Integer getVersionId() {
		return versionId;
	}

	public AppVersion setVersionId(java.lang.Integer versionId) {
		this.versionId = versionId;
		return this;
	}

	public java.lang.String getVersionName() {
		return versionName;
	}

	public AppVersion setVersionName(java.lang.String versionName) {
		this.versionName = versionName;
		return this;
	}

	public java.lang.String getVersionCode() {
		return versionCode;
	}

	public AppVersion setVersionCode(java.lang.String versionCode) {
		this.versionCode = versionCode;
		return this;
	}

	public java.lang.Integer getTerminal() {
		return terminal;
	}

	public void setTerminal(java.lang.Integer terminal) {
		this.terminal = terminal;
	}

	public java.lang.Integer getVersionType() {
		return versionType;
	}

	public AppVersion setVersionType(java.lang.Integer versionType) {
		this.versionType = versionType;
		return this;
	}

	public java.lang.Integer getState() {
		return state;
	}

	public AppVersion setState(java.lang.Integer state) {
		this.state = state;
		return this;
	}

	public java.lang.Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.String getDownLoadUrl() {
		return downLoadUrl;
	}

	public AppVersion setDownLoadUrl(java.lang.String downLoadUrl) {
		this.downLoadUrl = downLoadUrl;
		return this;
	}

	public java.lang.String getIntroduce() {
		return introduce;
	}

	public AppVersion setIntroduce(java.lang.String introduce) {
		this.introduce = introduce;
		return this;
	}

	public java.lang.String getMd5() {
		return md5;
	}

	public void setMd5(java.lang.String md5) {
		this.md5 = md5;
	}

	public java.lang.String getPurpose() {
		return purpose;
	}

	public void setPurpose(java.lang.String purpose) {
		this.purpose = purpose;
	}

	public java.util.Date getCtime() {
		return ctime;
	}

	public AppVersion setCtime(java.util.Date ctime) {
		this.ctime = ctime;
		return this;
	}

}