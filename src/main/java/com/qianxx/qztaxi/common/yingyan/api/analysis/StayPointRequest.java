package com.qianxx.qztaxi.common.yingyan.api.analysis;

import com.qianxx.qztaxi.common.yingyan.model.BaseRequest;

/**
 * <p>Title: AddEntityRequest</p>
 * <p>Description: </p>
 * <p>Company: anjie</p> 
 * <p>Copyright: Copyright (c) 2018</p>

 * @author zhangqinghe
 * @date 2018年5月7日 下午4:08:31
 * @version 1.0.0
 */
public class StayPointRequest extends BaseRequest {
	private String entityName;
	// 开始时间
	private Long startTime;
	// 结束时间
	private Long endTime;
	// 单位：秒，默认值：600。该字段用于设置停留点判断规则，即若系统判断在半径为stay_radius的圆形范围内停留时间超过stay_time，则被认为是一次停留
	private int stayTime = 15;
	// 单位：米，取值范围：[1,500]，默认值：20。该字段用于设置停留点判断规则，即若系统判断在半径为stay_radius的圆形范围内停留时间超过stay_time，则被认为是一次停留
	private int stayRadius = 50;

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getEntityName() {
		return entityName;
	}

	public StayPointRequest(String entityName) {
		this.entityName = entityName;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	public int getStayTime() {
		return stayTime;
	}

	public void setStayTime(int stayTime) {
		this.stayTime = stayTime;
	}

	public int getStayRadius() {
		return stayRadius;
	}

	public void setStayRadius(int stayRadius) {
		this.stayRadius = stayRadius;
	}

	/**
	 * 构造函数
	 * @param ak
	 * @param serviceId
	 * @param entityName
	 * @param startTime
	 * @param endTime
	 */
	public StayPointRequest(String entityName, Long startTime, Long endTime) {
		this.entityName = entityName;
		this.startTime = startTime;
		this.endTime = endTime;
	}
}
