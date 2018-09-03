package com.qianxx.qztaxi.vo;

import java.sql.Timestamp;

/**
 * <p>
 * 字段IDValueObject.
 * </p>
 */
public class RoleGroup implements java.io.Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** ID **/
	private Integer id;
	/** 名称 **/
	private String name;
	/** 禁用启用 **/
	private Short disabled;
	/** 创建时间 **/
	private Timestamp createTime;
	/** 更新时间 **/
	private Timestamp changeTime;

	private boolean myRole;// 是否是我的角色

	public boolean isMyRole() {
		return myRole;
	}

	public void setMyRole(boolean myRole) {
		this.myRole = myRole;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getDisabled() {
		return disabled;
	}

	public void setDisabled(Short disabled) {
		this.disabled = disabled;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(Timestamp changeTime) {
		this.changeTime = changeTime;
	}

}