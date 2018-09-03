package com.qianxx.qztaxi.vo;

import java.sql.Timestamp;

/**
 * <p>
 * 字段IDValueObject.
 * </p>
 */
public class Version implements java.io.Serializable {
	public Version() {
	}

	/**
	 * @param id ID
	 * @param versionNo 版本号
	 * @param versionName 版本名
	 * @param status 状态
	 * @param packagePath 安装包路径
	 * @param packageName 安装包名
	 * @param platform 平台
	 * @param identify 客户端类型
	 * @param iosUpdUrl IOS下载链接
	 * @param updContent 更新内容描述
	 * @param fileSize 文件大小
	 * @param createdOn 创建时间
	 * @param updatedOn 更新时间
	 * @param updatedBy 更新者
	 */
	public Version(Integer id, Integer versionNo,String identify, String versionName, String status,String isCheck, String packagePath, String packageName, String platform, String iosUpdUrl, String updContent, Double fileSize, Timestamp createdOn, Timestamp updatedOn, Integer updatedBy) {
		this.id = id;
		this.versionNo = versionNo;
		this.versionName = versionName;
		this.identify = identify;
		this.status = status;
		this.isCheck = isCheck;
		this.packagePath = packagePath;
		this.packageName = packageName;
		this.platform = platform;
		this.iosUpdUrl = iosUpdUrl;
		this.updContent = updContent;
		this.fileSize = fileSize;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.updatedBy = updatedBy;
	}

	/**
     *
     */
	private static final long serialVersionUID = 1L;

	/** ID **/
	private Integer id;
	/** 版本号 **/
	private Integer versionNo;
	/** 版本名 **/
	private String versionName;
	/** 状态 **/
	private String status;
	/** 审核版本 **/
	private String isCheck;

	/** 安装包路径 **/
	private String packagePath;
	/** 安装包名 **/
	private String packageName;
	/** 平台 **/
	private String platform;
	/** 客户端类型 **/
	private String identify;
	/** IOS下载链接 **/
	private String iosUpdUrl;
	/** 更新内容描述 **/
	private String updContent;
	/** 文件大小 **/
	private Double fileSize;
	/** 创建时间 **/
	private Timestamp createdOn;
	/** 更新时间 **/
	private Timestamp updatedOn;
	/** 更新者 **/
	private Integer updatedBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPackagePath() {
		return packagePath;
	}

	public void setPackagePath(String packagePath) {
		this.packagePath = packagePath;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getIosUpdUrl() {
		return iosUpdUrl;
	}

	public void setIosUpdUrl(String iosUpdUrl) {
		this.iosUpdUrl = iosUpdUrl;
	}

	public String getUpdContent() {
		return updContent;
	}

	public void setUpdContent(String updContent) {
		this.updContent = updContent;
	}

	public Double getFileSize() {
		return fileSize;
	}

	public void setFileSize(Double fileSize) {
		this.fileSize = fileSize;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getIdentify() {
		return identify;
	}

	public void setIdentify(String identify) {
		this.identify = identify;
	}

	public String getIsCheck() {
		return isCheck;
	}


	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}
}