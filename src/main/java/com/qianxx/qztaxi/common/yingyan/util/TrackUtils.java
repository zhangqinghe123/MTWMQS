package com.qianxx.qztaxi.common.yingyan.util;

import com.qianxx.qztaxi.common.yingyan.api.track.IllegalTrackArgumentException;
import com.qianxx.qztaxi.common.yingyan.model.LatLng;
import com.qianxx.qztaxi.common.yingyan.model.TrackPoint;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * track工具类
 * 
 * @author baidu
 *
 */
public class TrackUtils {

	/**
	 * 检查经纬度
	 * 
	 * @param latLng
	 * @return
	 */
	public static boolean checkLatLng(LatLng latLng) {
		if (null == latLng) {
			throw new IllegalTrackArgumentException("latLng can not be null");
		}

		if (Math.abs(latLng.getLatitude()) > 90 || Math.abs(latLng.getLongitude()) > 180) {
			throw new IllegalTrackArgumentException("latLng is invalid value");
		}

		return true;
	}

	/**
	 * 组装单个轨迹点
	 * 
	 * @param trackPoint
	 * @param parameters
	 */
	public static void packPoint(TrackPoint trackPoint, StringBuilder parameters) {
		LatLng location = trackPoint.getLocation();
		if (TrackUtils.checkLatLng(location)) {
			parameters.append("&latitude=").append(location.getLatitude());
			parameters.append("&longitude=").append(location.getLongitude());
		}
		parameters.append("&loc_time=").append(trackPoint.getLocTime());
		if (null == trackPoint.getCoordType()) {
			throw new IllegalTrackArgumentException("coordType can not be null.");
		}
		parameters.append("&coord_type_input=").append(trackPoint.getCoordType().name());
		if (!CommonUtils.isNullOrEmpty(trackPoint.getObjectKey())) {
			parameters.append("&_obejct_key=").append(HttpUtils.urlEncode(trackPoint.getObjectKey()));
		}
		if (null != trackPoint.getColumns()) {
			packColumns(trackPoint.getColumns(), parameters);
		}
	}

	/**
	 * 组装轨迹点列表
	 *
	 * @param points 轨迹点列表，Map中key为entityName， value为轨迹点集
	 * @param parameters json格式轨迹点信息
	 */
	public static void packPoints(Map<String, List<TrackPoint>> points, StringBuilder parameters) {
		if (null == points) {
			throw new IllegalTrackArgumentException("track points can not be null.");
		}
		JSONArray jsonArray = new JSONArray();

		try {
			Set<Map.Entry<String, List<TrackPoint>>> entries = points.entrySet();
			for (Map.Entry<String, List<TrackPoint>> entry : entries) {
				String entityName = entry.getKey();
				List<TrackPoint> trackPoints = entry.getValue();
				if (null == trackPoints) {
					continue;
				}
				for (TrackPoint trackPoint : trackPoints) {
					if (null == trackPoint) {
						continue;
					}

					JSONObject jsonObject = new JSONObject();
					jsonObject.put("entity_name", entityName);
					jsonObject.put("loc_time", trackPoint.getLocTime());

					LatLng location = trackPoint.getLocation();
					if (TrackUtils.checkLatLng(location)) {
						jsonObject.put("latitude", location.getLatitude());
						jsonObject.put("longitude", location.getLongitude());
					}

					if (null == trackPoint.getCoordType()) {
						throw new IllegalTrackArgumentException("coordType can not be null.");
					}
					jsonObject.put("coord_type_input", trackPoint.getCoordType().name());

					Map<String, String> columns = trackPoint.getColumns();
					if (null != columns) {
						packColumns(columns, jsonObject);
					}
					jsonArray.add(jsonObject);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		parameters.append("&point_list=").append(jsonArray.toString());

	}

	/**
	 * 组装自定义属性（单个轨迹点）
	 * 
	 * @param columns
	 * @param parameters
	 */
	public static void packColumns(Map<String, String> columns, StringBuilder parameters) {
		for (Map.Entry<String, String> entry : columns.entrySet()) {
			parameters.append("&").append(entry.getKey()).append("=").append(HttpUtils.urlEncode(entry.getValue()));
		}
	}

	/**
	 * 组装自定义属性（批量轨迹点）
	 *
	 * @param columns 自定义属性
	 * @param jsonObject json对象
	 *
	 * @return
	 */
	private static void packColumns(Map<String, String> columns, JSONObject jsonObject) {
		for (Map.Entry<String, String> column : columns.entrySet()) {
			if (StringUtils.isEmpty(column.getKey()) || StringUtils.isEmpty(column.getValue())) {
				continue;
			}
			try {
				jsonObject.put(column.getKey(), HttpUtils.urlEncode(column.getValue()));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
