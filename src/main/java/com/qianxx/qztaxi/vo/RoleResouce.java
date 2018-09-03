package com.qianxx.qztaxi.vo;

import java.sql.Timestamp;
import java.util.List;

/**
 * <p>
 * 字段IDValueObject.
 * </p>
 */
public class RoleResouce implements java.io.Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** ID **/
	private Integer id;
	/** ID **/
	private Integer pid;
	/** 名称 **/
	private String name;
	/** code **/
	private String code;
	/** 地址连接 **/
	private String actionLink;
	/** 禁用启用 **/
	private Short disabled;
	/** 创建时间 **/
	private Timestamp createTime;
	/** 更新时间 **/
	private Timestamp changeTime;

	private Integer orderBy;// 排序号
	private String iconClass;// 一级菜单图标class
	private String menuFlag;// 同步跳转标识
	private Integer tabFlag;// 1为选项卡标识

	private List<RoleResouce> sons;

	public List<RoleResouce> getSons() {
		return sons;
	}

	public void setSons(List<RoleResouce> sons) {
		this.sons = sons;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getActionLink() {
		return actionLink;
	}

	public void setActionLink(String actionLink) {
		this.actionLink = actionLink;
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

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}

	public String getIconClass() {
		return iconClass;
	}

	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}

	public String getMenuFlag() {
		return menuFlag;
	}

	public void setMenuFlag(String menuFlag) {
		this.menuFlag = menuFlag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getTabFlag() {
		return tabFlag;
	}

	public void setTabFlag(Integer tabFlag) {
		this.tabFlag = tabFlag;
	}

}