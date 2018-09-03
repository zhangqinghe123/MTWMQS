package com.qianxx.qztaxi.vo;

import java.sql.Timestamp;

/**
 * <p>
 * 字段IDValueObject.
 * </p>
 */
public class OperateLog implements java.io.Serializable {
	/**
     *
     */
	private static final long serialVersionUID = 1L;

	/** ID **/
	private Integer id;
	/** 操作类型 **/
	private String opType;
	/** 操作对象 **/
	private String opObject;
	/** 操作系统 **/
	private String opSys;
	/** 操作IP **/
	private String opIp;
	/** 操作用户ID **/
	private String opUserId;
	/** 操作时间 **/
	private Timestamp opTime;
	/** 内容 **/
	private String content;
	/** 耗时 **/
	private Timestamp costTime;
	/** 操作结果 **/
	private Short opResult;
	/** 备注 **/
	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOpType() {
		return opType;
	}

	public void setOpType(String opType) {
		this.opType = opType;
	}

	public String getOpObject() {
		return opObject;
	}

	public void setOpObject(String opObject) {
		this.opObject = opObject;
	}

	public String getOpSys() {
		return opSys;
	}

	public void setOpSys(String opSys) {
		this.opSys = opSys;
	}

	public String getOpIp() {
		return opIp;
	}

	public void setOpIp(String opIp) {
		this.opIp = opIp;
	}

	public String getOpUserId() {
		return opUserId;
	}

	public void setOpUserId(String opUserId) {
		this.opUserId = opUserId;
	}

	public Timestamp getOpTime() {
		return opTime;
	}

	public void setOpTime(Timestamp opTime) {
		this.opTime = opTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCostTime() {
		return costTime;
	}

	public void setCostTime(Timestamp costTime) {
		this.costTime = costTime;
	}

	public Short getOpResult() {
		return opResult;
	}

	public void setOpResult(Short opResult) {
		this.opResult = opResult;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}