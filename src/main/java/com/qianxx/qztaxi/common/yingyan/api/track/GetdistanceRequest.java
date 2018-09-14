package com.qianxx.qztaxi.common.yingyan.api.track;


import com.qianxx.qztaxi.common.yingyan.model.BaseRequest;
import com.qianxx.qztaxi.common.yingyan.model.TrackParam;

/**
 * 添加单个轨迹点请求
 * 
 * @author baidu
 *
 */
public class GetdistanceRequest extends BaseRequest {

	/**
	 * entity标识
	 */
	private String entityName;
	/**
	 * 开始时间
	 */
	private Long startTime;
	/**
	 * 结束时间
	 */
	private Long endTime;
	/**
	 * 是否返回纠偏后里程
	 */
	private int isProcessed = 1;
	/**
	 * 纠偏选项
	 */
	private TrackParam trackParam = null;
	/**
	 * 里程补偿方式
	 */
	private String supplementMode = "driving";

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
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

	public int getIsProcessed() {
		return isProcessed;
	}

	public void setIsProcessed(int isProcessed) {
		this.isProcessed = isProcessed;
	}

	public TrackParam getTrackParam() {
		return trackParam;
	}

	public void setTrackParam(TrackParam trackParam) {
		this.trackParam = trackParam;
	}

	public String getSupplementMode() {
		return supplementMode;
	}

	public void setSupplementMode(String supplementMode) {
		this.supplementMode = supplementMode;
	}

	/**
	 * 
	 * @param ak 服务端AK
	 * @param serviceId 轨迹服务ID
	 * @param entityName entity标识
	 * @param startTime 开始时间
	 * @param endTime 终止时间
	 * @param trackParam 轨迹查询参数
	 */
	public GetdistanceRequest(String entityName, Long startTime, Long endTime, TrackParam trackParam) {
		this.entityName = entityName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.trackParam = trackParam;
	}

	/**
	 * 
	 * @param ak 服务端AK
	 * @param serviceId 轨迹服务ID
	 * @param entityName entity标识
	 * @param startTime 开始时间
	 * @param endTime 终止时间
	 */
	public GetdistanceRequest(String entityName, Long startTime, Long endTime) {
		this.entityName = entityName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.trackParam = new TrackParam();
	}

}
