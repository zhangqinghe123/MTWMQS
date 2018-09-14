package com.qianxx.qztaxi.common.yingyan.model;

import java.util.Map;

/**
 * 轨迹点信息
 * 
 * @author baidu
 *
 */
public class TrackPoint extends Point {

	/**
	 * 对象数据名称
	 */
	private String objectKey;

	/**
	 * track自定义字段
	 */
	private Map<String, String> columns;

	/**
	 * 获取对象数据名称
	 * 
	 * @return
	 */
	public String getObjectKey() {
		return objectKey;
	}

	/**
	 * 设置对象数据名称
	 * 
	 * @param objectKey
	 */
	public void setObjectKey(String objectKey) {
		this.objectKey = objectKey;
	}

	/**
	 * 获取自定义属性
	 * 
	 * @return
	 */
	public Map<String, String> getColumns() {
		return columns;
	}

	/**
	 * 设置自定义属性
	 * 
	 * @param columns
	 */
	public void setColumns(Map<String, String> columns) {
		this.columns = columns;
	}

	public TrackPoint() {
		super();
	}

	/**
	 * 
	 * @param location 经纬度坐标
	 * @param coordType 坐标类型
	 * @param locTime 定位时间
	 * @param objectKey 对象数据名称
	 * @param columns 自定义属性
	 */
	public TrackPoint(LatLng location, CoordType coordType, long locTime, String objectKey, Map<String, String> columns) {
		super(location, coordType, locTime);
		this.objectKey = objectKey;
		this.columns = columns;
	}

}
