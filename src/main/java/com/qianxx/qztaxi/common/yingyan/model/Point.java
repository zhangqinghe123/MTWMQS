package com.qianxx.qztaxi.common.yingyan.model;

/**
 * 坐标点信息
 * 
 * @author baidu
 *
 */
public class Point {

	/**
	 * 位置坐标
	 */
	private LatLng location;

	/**
	 * 坐标类型
	 */
	private CoordType coordType;

	/**
	 * 定位时间
	 */
	protected long locTime;

	/**
	 * 获取位置坐标
	 * 
	 * @return
	 */
	public LatLng getLocation() {
		return location;
	}

	/**
	 * 设置位置坐标
	 * 
	 * @param location
	 */
	public void setLocation(LatLng location) {
		this.location = location;
	}

	/**
	 * 获取坐标类型
	 * 
	 * @return
	 */
	public CoordType getCoordType() {
		return coordType;
	}

	/**
	 * 设置坐标类型
	 * 
	 * @param coordType
	 */
	public void setCoordType(CoordType coordType) {
		this.coordType = coordType;
	}

	/**
	 * 获取定位时间
	 * 
	 * @return
	 */
	public long getLocTime() {
		return locTime;
	}

	/**
	 * 设置定位时间
	 * 
	 * @param locTime
	 */
	public void setLocTime(long locTime) {
		this.locTime = locTime;
	}

	public Point() {
		super();
	}

	public Point(LatLng location, CoordType coordType, long locTime) {
		super();
		this.location = location;
		this.coordType = coordType;
		this.locTime = locTime;
	}

}
