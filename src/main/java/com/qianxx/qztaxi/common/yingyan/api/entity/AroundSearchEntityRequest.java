package com.qianxx.qztaxi.common.yingyan.api.entity;

import com.qianxx.qztaxi.common.yingyan.model.BaseRequest;
import com.qianxx.qztaxi.common.yingyan.model.CoordType;
import com.qianxx.qztaxi.common.yingyan.model.YingYanConstants;
import org.springframework.util.StringUtils;

/**
 * 更新实体
 * <p>Title: UpdateEntityRequest</p>
 * <p>Description: </p>
 * <p>Company: anjie</p> 
 * <p>Copyright: Copyright (c) 2018</p>

 * @author zhangqinghe
 * @date 2018年5月21日 下午3:18:12
 * @version 1.0.0
 */
public class AroundSearchEntityRequest extends BaseRequest {
	// 格式为：纬度,经度 示例：36.20,116.30
	private String center;
	// 单位：米，取值范围[1,5000]
	private Integer radius;
	private CoordType coordTypeInput = CoordType.bd09ll;
	private CoordType coordTypeOutput = CoordType.bd09ll;
	private Integer pageIndex;
	private Integer pageSize = YingYanConstants.DEFAULT_PAGE_SIZE;

	private Long activeTime;
	private Integer carType;
	private String companyId;

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public Long getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(Long activeTime) {
		this.activeTime = activeTime;
	}

	public Integer getCarType() {
		return carType;
	}

	public void setCarType(Integer carType) {
		this.carType = carType;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public Integer getRadius() {
		return radius;
	}

	public void setRadius(Integer radius) {
		this.radius = radius;
	}

	public String getFilter() {
		StringBuffer builder = new StringBuffer();
		builder.append("active_time:").append(activeTime).append("|");
		builder.append(YingYanConstants.KEY_DRIVER_TYPE).append(":").append(carType);
		if (!StringUtils.isEmpty(companyId)) {
			builder.append("|").append(YingYanConstants.KEY_COMPANY_ID).append(":").append(companyId);
		}
		return builder.toString();
	}

	public CoordType getCoordTypeInput() {
		return coordTypeInput;
	}

	public CoordType getCoordTypeOutput() {
		return coordTypeOutput;
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

}
