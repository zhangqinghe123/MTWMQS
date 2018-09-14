package com.qianxx.qztaxi.common.yingyan.model;


import com.qianxx.qztaxi.common.yingyan.util.HttpUtils;

/**
 * 查询轨迹时使用的参数
 * <p>Title: TrackPatam</p>
 * <p>Description: </p>
 * <p>Company: anjie</p> 
 * <p>Copyright: Copyright (c) 2018</p>

 * @author zhangqinghe
 * @date 2018年5月7日 下午9:08:15
 * @version 1.0.0
 */
public class TrackParam {

	// 1.去噪
	private int needDenoise = 1;

	// 2.绑路
	private int needMapmatch = 1;

	// 3. 定位精度过滤，用于过滤掉定位精度较差的轨迹点
	private int radiusThreshold = 100;

	// 4.交通方式，鹰眼将根据不同交通工具选择不同的纠偏策略，目前支持：自动（即鹰眼自动识别的交通方式）、驾车、骑行和步行
	private String transportMode = "driving";

	public int getNeedDenoise() {
		return needDenoise;
	}

	public void setNeedDenoise(int needDenoise) {
		this.needDenoise = needDenoise;
	}

	public int getNeedMapmatch() {
		return needMapmatch;
	}

	public void setNeedMapmatch(int needMapmatch) {
		this.needMapmatch = needMapmatch;
	}

	public int getRadiusThreshold() {
		return radiusThreshold;
	}

	public void setRadiusThreshold(int radiusThreshold) {
		this.radiusThreshold = radiusThreshold;
	}

	public String getTransportMode() {
		return transportMode;
	}

	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode;
	}

	public TrackParam() {

	}

	public TrackParam(int needDenoise, int needMapmatch, int radiusThreshold) {
		this.needDenoise = needDenoise;
		this.needMapmatch = needMapmatch;
		this.radiusThreshold = radiusThreshold;
	}

	public String getUrlParam() {
		StringBuffer builder = new StringBuffer();
		builder.append("need_denoise=").append(needDenoise).append(",");
		builder.append("need_mapmatch=").append(needMapmatch).append(",");
		builder.append("adius_threshold=").append(radiusThreshold).append(",");
		builder.append("transport_mode=").append(transportMode);
		return HttpUtils.urlEncode(builder.toString());
	}

}
