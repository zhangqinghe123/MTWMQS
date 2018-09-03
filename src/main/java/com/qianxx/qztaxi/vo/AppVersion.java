package com.qianxx.qztaxi.vo;

import java.io.Serializable;

/**
 * AppVersion表
 */
public class AppVersion implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer versionId; // 版本编码
	private String versionName; // 版本名称
	private String versionCode; // 版本号
	private Integer terminal; // 1用户端，2司机端
	private Integer versionType; // 版本更新类型（0非强制1强制更新）
	private Integer state; // 禁用状态（1已启用，2已禁用）
	private Integer isDel; // 删除状态（1未删除，2已删除）
	private String downLoadUrl; // 下载地址
	private String introduce; // 版本介绍
	private String md5; // MD5校验值
	private String purpose; // 用途
	private java.util.Date ctime; // 创建时间

	public Integer getVersionId() {
		return versionId;
	}

	public AppVersion setVersionId(Integer versionId) {
		this.versionId = versionId;
		return this;
	}

	public String getVersionName() {
		return versionName;
	}

	public AppVersion setVersionName(String versionName) {
		this.versionName = versionName;
		return this;
	}

	public String getVersionCode() {
		return versionCode;
	}

	public AppVersion setVersionCode(String versionCode) {
		this.versionCode = versionCode;
		return this;
	}

	public Integer getTerminal() {
		return terminal;
	}

	public void setTerminal(Integer terminal) {
		this.terminal = terminal;
	}

	public Integer getVersionType() {
		return versionType;
	}

	public AppVersion setVersionType(Integer versionType) {
		this.versionType = versionType;
		return this;
	}

	public Integer getState() {
		return state;
	}

	public AppVersion setState(Integer state) {
		this.state = state;
		return this;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public String getDownLoadUrl() {
		return downLoadUrl;
	}

	public AppVersion setDownLoadUrl(String downLoadUrl) {
		this.downLoadUrl = downLoadUrl;
		return this;
	}

	public String getIntroduce() {
		return introduce;
	}

	public AppVersion setIntroduce(String introduce) {
		this.introduce = introduce;
		return this;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
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