package com.qianxx.qztaxi.vo;


/**
 * <p>
 * 字段IDValueObject.
 * </p>
 */
public class RoleMenu implements java.io.Serializable {
	/**
     *
     */
	private static final long serialVersionUID = 1L;

	/** ID **/
	private Integer id;
	/** 权限组ID **/
	private Integer roleGroupId;
	/** 权限资源ID **/
	private Integer roleResouceId;

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

	public Integer getRoleResouceId() {
		return roleResouceId;
	}

	public void setRoleResouceId(Integer roleResouceId) {
		this.roleResouceId = roleResouceId;
	}

}