package com.qianxx.qztaxi.vo;


/**
 * <p>
 * 字段IDValueObject.
 * </p>
 */
public class RoleAdmin implements java.io.Serializable {
	/**
     *
     */
	private static final long serialVersionUID = 1L;

	/** ID **/
	private Integer id;
	/** 权限组ID **/
	private Integer roleGroupId;
	/** 用户ID **/
	private Integer userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleGroupId() {
		return roleGroupId;
	}

	public void setRoleGroupId(Integer roleGroupId) {
		this.roleGroupId = roleGroupId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}