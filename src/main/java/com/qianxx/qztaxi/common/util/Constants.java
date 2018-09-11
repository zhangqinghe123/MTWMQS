package com.qianxx.qztaxi.common.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {

	/** JSON 默认返回值 DOUBLE **/
	public final static Double JSON_DEFAULT_DOUBLE = 0d;
	/** JSON 默认返回值 INTEGER **/
	public final static Integer JSON_DEFAULT_INTEGER = 0;

	/** Api访问返回状态码 - 0：访问成功 **/
	public final static String API_STATUS_SUCCESS = "0";
	/** Api访问返回状态码 - 1：访问失败 **/
	public final static String API_STATUS_ERROR = "1";
	/** Api访问返回状态码 - 2：请求参数非法 **/
	public final static String API_STATUS_PARAMS_ERR = "2";
	/** Api访问返回状态码 - 3：权限校验失败 **/
	public final static String API_STATUS_VALID_ERR = "3";
	/** Api访问返回状态码 - 4：服务器系统异常 **/
	public final static String API_STATUS_SERVER_SYSTEM_ERR = "4";
	/** Api访问返回状态码 - 5：服务器业务异常 **/
	public final static String API_STATUS_SERVER_BUSINESS_ERR = "5";


	public final static String UPLOAD_FOLDER_MYPIC = "myPic";
	public final static String UPLOAD_FOLDER_IDCARD = "idCard";
	public final static String UPLOAD_FOLDER_VEHICLELIC = "vehicleLic";
	public final static String FILE_UPLOAD_PATH = "/usr/www/images";
	public final static int UPLOAD_FILE_SIZE = 1024 * 1024 * 10;



	/**
	 * 站点类型 PP 雨量站
	 */
	public static final String STATION_TYPE_RAIN = "PP";
	/**
	 * 站点类型 RR 水库
	 */
	public static final String STATION_TYPE_RESERVOIR = "RR";
	/**
	 * 站点类型 ZQ 河道水文站
	 */
	public static final String STATION_TYPE_HYDROLOGY = "ZQ";
	/**
	 * 站点类型 ZZ 河道水位站
	 */
	public static final String STATION_TYPE_WATER_LEVEL = "ZZ";
}
