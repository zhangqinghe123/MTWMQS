package com.qianxx.qztaxi.common.yingyan.model;

public class YingYanConstants {

	// 用在百度鹰眼检索的Key
	// 司机类型
	public static final String KEY_DRIVER_TYPE = "driverType";
	// 监听类型,实时#预约#距离#专车类型
	public static final String KEY_LISTEN_MODE = "listenMode";
	// 是否有订单进行中
	public static final String KEY_ORDER_RUNNING = "orderRunning";
	// 公司ID
	public static final String KEY_COMPANY_ID = "companyId";
	// 是否出车
	public static final String KEY_TURN_OUT = "turnOut";
	// 默认请求一次司机数量
	public static final Integer DEFAULT_PAGE_SIZE = 40;
	// 默认请求一次司机数量
	public static final Integer DEFAULT_PAGE_SIZE_MANAGER = 1000;
	// 默认查询范围半径
	public static final int DEFAULT_SEARCH_RADIUS = 5000;
	// 调用鹰眼接口的时候 1小时片段
	public static final int FRAGMENT_FIVE_HOURS = 3600;
}
