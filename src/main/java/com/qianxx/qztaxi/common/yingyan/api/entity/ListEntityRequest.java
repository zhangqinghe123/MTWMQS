package com.qianxx.qztaxi.common.yingyan.api.entity;

import com.qianxx.qztaxi.common.yingyan.model.BaseRequest;
import com.qianxx.qztaxi.common.yingyan.model.CoordType;
import com.qianxx.qztaxi.common.yingyan.model.YingYanConstants;
import org.springframework.util.StringUtils;

/**
 * 管理后台获取
 * <p>Title: ListEntityRequest</p>
 * <p>Description: </p>
 * <p>Company: anjie</p> 
 * <p>Copyright: Copyright (c) 2018</p>

 * @author zhangqinghe
 * @date 2018年6月4日 下午1:54:13
 * @version 1.0.0
 */

public class ListEntityRequest extends BaseRequest {
	private String entityNames;
	private String carType;
	private Long activeTime;
	private Long inactiveTime;
	private String companyId;
	private Integer pageIndex;
	private Integer pageSize = YingYanConstants.DEFAULT_PAGE_SIZE_MANAGER;
	private CoordType coordTypeOutput = CoordType.bd09ll;

	public String getEntityNames() {
		return entityNames;
	}

	public void setEntityNames(String entityNames) {
		this.entityNames = entityNames;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public Long getInactiveTime() {
		return inactiveTime;
	}

	public void setInactiveTime(Long inactiveTime) {
		this.inactiveTime = inactiveTime;
	}

	public String getFilter() {
		StringBuffer builder = new StringBuffer();
		if (StringUtils.isEmpty(entityNames)) {
			builder.append("driverType:").append(carType).append("|");
			if (activeTime == null) {
				builder.append("inactive_time:").append(inactiveTime);
			} else {
				builder.append("active_time:").append(activeTime);
			}
			if (!StringUtils.isEmpty(companyId)) {
				builder.append("|").append("companyId:").append(companyId);
			}
		} else {
			builder.append("entity_names:").append(entityNames);
		}
		return builder.toString();
	}

	public CoordType getCoordTypeOutput() {
		return coordTypeOutput;
	}

	public void setCoordTypeOutput(CoordType coordTypeOutput) {
		this.coordTypeOutput = coordTypeOutput;
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

	public Long getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(Long activeTime) {
		this.activeTime = activeTime;
	}
}
