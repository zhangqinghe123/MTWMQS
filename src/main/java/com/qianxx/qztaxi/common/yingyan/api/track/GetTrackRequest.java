package com.qianxx.qztaxi.common.yingyan.api.track;


import com.qianxx.qztaxi.common.yingyan.model.BaseRequest;
import com.qianxx.qztaxi.common.yingyan.model.TrackParam;
import com.qianxx.qztaxi.common.yingyan.model.YingYanConstants;

/**
 * 获取指定实体的轨迹
 * 
 * @author baidu
 *
 */
public class GetTrackRequest extends BaseRequest {

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
	private TrackParam trackParam = new TrackParam();
	/**
	 * 里程补偿方式
	 */
	private String supplementMode = "driving";

	private Integer pageIndex;
	private Integer pageSize = YingYanConstants.DEFAULT_PAGE_SIZE_MANAGER;

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

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
