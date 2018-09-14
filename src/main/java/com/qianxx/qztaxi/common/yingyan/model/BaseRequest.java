package com.qianxx.qztaxi.common.yingyan.model;

/**
 * 基础请求信息类
 * 
 * @author baidu
 *
 */
public abstract class BaseRequest {

	/**
	 * 服务端ak
	 */
	private static String AK = "sA85emPOmdhtikFDCmEq1uRaWV2qI5F5";

	/**
	 * 轨迹服务ID
	 */
	private static long SERVICE_ID = 204921;

	public static String getAk() {
		return AK;
	}

	public static long getServiceId() {
		return SERVICE_ID;
	}

	public BaseRequest() {
		super();
	}
}
