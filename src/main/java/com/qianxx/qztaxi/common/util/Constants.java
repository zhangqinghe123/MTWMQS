package com.qianxx.qztaxi.common.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {
	public final static String PRODUCT_ENV_TAG = "product";
	public final static String API_SYSTEM_TYPE = "api";
	/** 环境类型，是生产还是测试 **/
	public static String ENV_TYPE = PRODUCT_ENV_TAG;
	/** 系统类型，是管理还是API **/
	public static String SYSTEM_TYPE = API_SYSTEM_TYPE;

	/** 常量0 **/
	public final static String SPECIFC_ZERO = "0";
	/** 常量1 **/
	public final static String SPECIFC_ONE = "1";

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

	/** OS平台（Android） **/
	public final static String OS_ANDROID = "1";
	/** OS平台（IOS） **/
	public final static String OS_IOS = "2";

	/** 乘客端（ **/
	public final static int PASSENGER = 0;
	/** 司机端 **/
	public final static int Driver = 1;

	/** App软件包状态 - 0：无效 **/
	public final static String APP_PKG_STATUS_INVALID = "0";
	/** App软件包状态 - 1：有效 **/
	public final static String APP_PKG_STATUS_VALID = "1";

	// 订单小状态
	/** 订单状态 - 1：等待应答 **/
	public final static String ORDER_STATUS_WAIT = "1";
	/** 订单状态 - 2：行程已确定 **/
	public final static String ORDER_STATUS_CONFIRM = "2";
	/** 订单状态 - 3：司机已到达 **/
	public final static String ORDER_STATUS_ARRIVE = "3";
	/** 订单状态 - 4：行程已开始 **/
	public final static String ORDER_STATUS_START = "4";
	/** 订单状态 - 5：已送达 等待付款 **/
	public final static String ORDER_STATUS_ARRIVED = "5";

	/** 订单状态 - 10：行程已完成 付款完成 **/
	public final static String ORDER_STATUS_COMPLETE = "10";
	/** 订单状态 - 11：完成对车主评价 **/
	public final static String ORDER_STATUS_COMMENTED = "11";

	/** 订单状态 - 21：无人抢单，行程已取消 **/
	public final static String ORDER_STATUS_NO_ANSWER = "21";
	/** 订单状态 - 22：行程确定后乘客已取消 **/
	public final static String ORDER_STATUS_PASSENGER_CANCEL = "22";
	/** 订单状态 - 23：行程关闭 **/
	public final static String ORDER_STATUS_CLOSE = "23";
	/** 订单状态 - 24：司机取消 **/
	public final static String ORDER_STATUS_DRIVER_CANCEL = "24";

	// 订单大状态
	/** 订单状态 - 1：订单初识化 **/
	public final static String ORDER_STATUS_INITIAL = "1";
	/** 订单状态 - 2：订单进行中 **/
	public final static String ORDER_STATUS_DOING = "2";
	/** 订单状态 - 3：订单结束 **/
	public final static String ORDER_STATUS_DONE = "3";
	/** 订单状态 - 4：取消 **/
	public final static String ORDER_STATUS_CANCEL = "4";

	// 公告类型
	/** 公告类型 - 1：全部 **/
	public final static String NOTICE_ALL = "3";
	/** 公告类型 - 2：司机 **/
	public final static String NOTICE_DRIVER = "1";
	/** 公告类型 - 3：乘客 **/
	public final static String NOTICE_PASSENGER = "0";

	/** 消息状态 - 新消息 消息状态 0：新消息，1：已阅读 **/
	public final static String MESSAGE_STATUS_NEW = "0";
	/** 消息状态 - 已阅读  消息状态 0：新消息，1：已阅读**/
	public final static String MESSAGE_STATUS_READED = "1";

	/** 公告类型2：指定人公告，1：司机公告，0：乘客公告 **/
	public final static String notice_type_driver = "1";
	/** 公告类型2：指定人公告，1：司机公告，0：乘客公告 **/
	public final static String notice_type_passager = "0";

	/** 反馈状态状态 - 0：未处理 **/
	public final static String FEED_STATUS_WAIT = "1";

	/** 反馈状态状态 - 1：处理中 **/
	public final static String FEED_STATUS_DOING = "2";

	/** 反馈状态状态 - 3：处理完成 **/
	public final static String FEED_STATUS_SUCCESS = "3";

	/** 失物状态状态 - 0：未找到 **/
	public final static String LOST_STATUS_WAIT = "0";

	/** 失物状态状态 - 1：已找到 **/
	public final static String LOST_STATUS_SUCCESS = "1";

	/** 失物状态状态 - 2：已关闭 **/
	public final static String LOST_STATUS_CLOSE = "2";

	/** 一页显示件数 **/
	public final static int ORDER_LIST_PAGES = 5;

	/** 一页显示件数 **/
	public final static int ORDER_LIST_MAXPAGES = 10;

	/** 上传文件夹（个人头像） **/
	public final static String UPLOAD_FOLDER_MYPIC = "myPic";
	/** 上传文件夹（文章图片） **/
	public final static String UPLOAD_FOLDER_ARITCLE = "articlePic";
	/** 上传文件夹（失物图片） **/
	public final static String UPLOAD_FOLDER_LOST = "lost";
	/** 上传文件夹（身份证） **/
	public final static String UPLOAD_FOLDER_IDCARD = "idCard";
	/** 上传文件夹（银行卡） **/
	public final static String UPLOAD_FOLDER_BANKCARD = "bankCard";
	/** 上传文件夹（行驶证） **/
	public final static String UPLOAD_FOLDER_VEHICLELIC = "vehicleLic";
	/** 上传文件夹（驾驶证） **/
	public final static String UPLOAD_FOLDER_DRIVER_LICENSE = "driverLic";
	/**
	 * 上传文件夹（汽车和车主合照）
	 */
	public final static String UPLOAD_FOLDER_GROUP_PHOTO = "groupPhoto";
	/**
	 * 出租车准驾证照片
	 */
	public final static String UPLOAD_FOLDER_TAXI_DRIVER_CARDPIC = "taxiDriverCard";
	/**
	 * 从业资格证照片
	 */
	public final static String UPLOAD_FOLDER_TAXI_CERTIFICATION_PIC = "taxiCertification";
	/** 文件上传路径 **/
	public final static String FILE_UPLOAD_PATH = "/usr/www/images";

	/** excel文件上传路径 **/
	public final static String EXCEL_PATH = "/usr/www/images";

	/** 上传文件大小 **/
	public final static int UPLOAD_FILE_SIZE = 1024 * 1024 * 10;

	/** 订单删除状态 司机删除 **/
	public final static Integer ORDER_ISDELETE_DRIVER = 1;
	/** 订单删除状态 乘客删除 **/
	public final static Integer ORDER_ISDELETE_PASSENGER = 2;
	/** 订单删除状态 司机和乘客都删除 **/
	public final static Integer ORDER_ISDELETE_ALL = 3;

	/** 投诉信息状态码 - 1：待处理 **/
	public final static String COMPLAINT_STATUS_NEW = "1";
	/** 投诉信息状态码 - 2：正在处理 **/
	public final static String COMPLAINT_STATUS_HANDLING = "2";
	/** 投诉信息状态码 - 3：已处理 **/
	public final static String COMPLAINT_STATUS_COMPLETED = "3";

	/** 优惠券信息状态码 - 0：无效 **/
	public final static String COUPON_STATUS_NOVALID = "0";
	/** 优惠券信息状态码 - 1：有效 **/
	public final static String COUPON_STATUS_VALID = "1";
	/** 优惠券信息状态码 - 2：已使用 **/
	public final static String COUPON_STATUS_USERED = "2";
	/** 优惠券信息状态码 - 3：已占用 **/
	public final static String COUPON_STATUS_TAKEUP = "3";
	/** 优惠券信息状态码 - 4：已过期 **/
	public final static String COUPON_STATUS_OVERDUE = "4";

	/** 推送类型 - 1: 推送新建订单 **/
	public final static String PUSH_STATUS_CREATEORDER = "1";
	/** 推送类型 - 2: 乘客取消订单 **/
	public final static String PUSH_STATUS_CANCEL = "2";
	/** 推送类型 - 3: 司机抢单成功 **/
	public final static String PUSH_STATUS_SUCCESS = "3";
	/** 推送类型 - 4: 司机已到达 **/
	public final static String PUSH_STATUS_ARRIVE = "4";
	/** 推送类型 - 5: 支付成功 **/
	public final static String PUSH_STATUS_PAY = "5";
	/** 推送类型 - 6: 失物中心 **/
	public final static String PUSH_STATUS_ARTICLE = "6";
	/** 推送类型 - 7: 系统消息 **/
	public final static String PUSH_STATUS_MESSAGE = "7";
	/** 推送类型 - 8: 预约订单前30分钟 **/
	public final static String PUSH_STATUS_ORDER = "8";
	/** 推送类型 - 9: 强制出车 **/
	public final static String PUSH_STATUS_FORCE = "9";
	/** 推送类型 - 10: 预约订单前10分钟 **/
	public final static String PUSH_STATUS_ORDER10 = "10";
	/** 推送类型 - 10: 预约订单前10分钟 **/
	public final static String PUSH_STATUS_DRIVER_CANCEL = "24";

	/** 推送类型 - 11: 乘客已上车 **/
	public final static String PUSH_STATUS_GETBUS = "11";
	/** 推送类型 - 12: 后台关闭订单 **/
	public final static String PUSH_STATUS_CLOSE = "12";
	/** 推送类型 - 13: 审核 **/
	public final static String PUSH_STATUS_CHECK = "13";

	/** 推送类型 - 100: 推送到达目的地 **/
	public final static String PUSH_STATUS_ORDER100 = "100";

	/** 用户验证状态 - 0：未验证 **/
	public final static String USER_VALIDATED_WAIT = "0";
	/** 用户验证状态 - 2：验证已通过 **/
	public final static String USER_VALIDATED_PASS = "1";

	// 支付券类型
	/** 支付券 无效 **/
	public final static String COUPON_INVALID = "0";
	/** 支付券 有效 **/
	public final static String COUPON_VALID = "1";
	/** 支付券 已使用 **/
	public final static String COUPON_USED = "2";
	/** 支付券 已被占用 **/
	public final static String COUPON_USING = "3";

	// 付款状态
	/** 未付款 **/
	public final static String PAY_STATUS_NO = "0";
	/** 已付款 **/
	public final static String PAY_STATUS_OK = "1";

	// 支付类别
	/** 线下支付 **/
	public final static String OFFLINE_PAY = "0";
	/** 线上支付 **/
	public final static String ONLINE_PAY = "1";

	// 付款|收款类型
	/** 现金支付支付 **/
	public final static String CASH = "0";
	/** 支付宝支付 **/
	public final static String ALIPAY = "1";
	/** 微信支付 **/
	public final static String WXPAY = "2";
	/** 翼支付 **/
	public final static String BESTPAY = "3";
	/** 优惠券全额支付 **/
	public final static String COUPONPAY = "4";
	/** 余额支付 **/
	public final static String BALANCE = "5";

	/** 1：账单类型：收入 **/
	public final static String PAYMENT_INCOMESUM = "1";
	/** 2：账单类型：提现（成功+等待中） **/
	public final static String PAYMENT_CASHINSUM = "2";
	/** 3：账单类型：提现失败 **/
	public final static String PAYMENT_CASHIN_FAIL = "3";
	/** 4：账单类型：系统提成 **/
	public final static String PAYMENT_COMMISSION = "4";
	/** 8：发票邮费 **/
	public final static String PAYMENT_INVOICE = "8";
	/** 9：余额充值 **/
	public final static String PAYMENT_YUE = "9";
	/** 10：司机个人充值 **/
	public final static String PAYMENT_DRIVER_YUE = "10";

	/** 银行卡类型 1：银联卡 **/
	public final static String BANK_CARD_TYPE_BANK = "1";
	/** 银行卡类型 2：翼支付 **/
	public final static String BANK_CARD_TYPE_YZFPAY = "2";

	/** 提现：提交申请 **/
	public final static int CASH_APPLY = 1;
	/** 提现：提现成功 **/
	public final static int CASH_APPLY_SUCCESS = 2;
	/** 提现：提现失败 **/
	public final static int CASH_APPLY_FAILED = 3;

	/** 收款账户名称 **/
	public final static String COLLECT_NAME = "大连鼎骏";

	/** 系统用户 **/
	public final static Integer SYS_USER = 999999999;

	/** 订单提醒开关 - 0：关 **/
	public final static String REMIND_CLOSE = "0";
	/** 订单提醒开关 - 1：开 **/
	public final static String REMIND_OPEN = "1";

	/** 验证码状态 - 1：待验证 **/
	public final static String IDENTIFYCODE_STATUS_VALID = "1";
	/** 验证码状态 - 0：失效 **/
	public final static String IDENTIFYCODE_STATUS_NOVALID = "0";

	// 撤销发起方
	/** 乘客 **/
	public final static String OPERATOR_PASSENGER = "1";
	/** 驾驶员 **/
	public final static String OPERATOR_DRIVER = "2";
	/** 平台公司 **/
	public final static String OPERATOR_PLATFORM = "3";
	// 撤销类型代码
	/** 乘客提前撤销 **/
	public final static String CANCELTYPECODE_PASSENGER = "1";
	/** 平台公司撤销 **/
	public final static String CANCELTYPECODE_PLATFORM = "3";
	/** 乘客违约撤销 **/
	public final static String CANCELTYPECODE_PASSENGER_DEFAULT = "4";

	public final static String FARE_TYPE = "10";// 运价编码,固定为10
	// 接口状态
	public final static Long STATE_VALID = 0L;// 有效
	public final static Long STATE_INVALID = 1L;// 失效
	// 操作标识
	public final static Long FLAG_ADD = 1L;// 添加
	// 上传标识
	public final static String AUDIT_FLAG_NOT = "-1";// 未通过,不上传
	public final static String AUDIT_FLAG_TODO = "0";// 待上传
	public final static String AUDIT_FLAG_DONE = "1";// 上传完毕

	public final static String DEFAULT_PASSWORD = "123456";// 默认密码

	public final static Integer ROLE_ADMIN_ROOT_ID = 0;// 菜单根节点id

	public final static Integer CAR_TYPE_TAXI = 1;// 出租车
	public final static Integer CAR_TYPE_ZHUANCHE = 2;// 专车
	public final static Integer CAR_TYPE_PINCHE = 3;// 拼车
	public final static Integer CAR_TYPE_BAOCHE = 4;// 包车
	public final static Integer CAR_TYPE_XIAOJIANKUAIDI = 5;// 小件快递

	public final static Long COMMERCIAL_TYPE = 1L;// 服务类型,网络预约出租汽车

	public final static String USE_TYPE_INVOICE = "8";// 发票运费
	public final static String USE_TYPE_CHARGE_PASSENGER = "9";// 乘客充值
	public final static String USE_TYPE_CHARGE_DRIVER = "10";// 司机充值

	public final static String TAXI_FARE_TYPE = "1";// 出租车运价编码
	public final static String ZHUANCHE_JINGJI_FARE_TYPE = "2_1";// 专车经济型运价编码
	public final static String ZHUANCHE_SHUSHI_FARE_TYPE = "2_2";// 专车舒适型运价编码
	public final static String ZHUANCHE_QIZUO_FARE_TYPE = "2_3";// 专车七座商务运价编码
	public final static String KUACHENG_FARE_TYPE = "3";// 跨城拼车运价编码
	public final static String XIAOJIAN_FARE_TYPE = "4";// 小件快递运价编码

	public final static String TESTDEPARTMENT = "鼎骏出行";// 服务质量信誉考核机构

	public final static String OUTSIDE_LEAGUER_SYS = "会员系统";

	// 司机类型，出租车司机
	public final static Integer DRIVER_TYPE_TAXI = 1;
	// 司机类型，专车司机
	public final static Integer DRIVER_TYPE_ZHUANCEH = 2;
	// 司机类型，拼车司机
	public final static Integer DRIVER_TYPE_PINCHE = 3;

	// 0正常，1长期封号 2.短期封号，3审核中,4审核不通过,5删除账号
	public final static String DRIVER_ACCOUNT_NORMAL = "0";
	// 0正常，1长期封号 2.短期封号，3审核中,4审核不通过,5删除账号
	public final static String DRIVER_ACCOUNT_LONG_CLOSURE = "1";
	// 0正常，1长期封号 2.短期封号，3审核中,4审核不通过,5删除账号
	public final static String DRIVER_ACCOUNT_TEMPORARY_CLOSURE = "2";
	// 0正常，1长期封号 2.短期封号，3审核中,4审核不通过,5删除账号
	public final static String DRIVER_ACCOUNT_AUDIT = "3";
	// 0正常，1长期封号 2.短期封号，3审核中,4审核不通过,5删除账号
	public final static String DRIVER_ACCOUNT_AUDIT_FAIL = "4";
	// 0正常，1长期封号 2.短期封号，3审核中,4审核不通过,5删除账号
	public final static String DRIVER_ACCOUNT_DISCARD = "5";

	// 记录MongoDB中超时日志的阈值，默认10S.
	public final static long COSTTIME_LOG_THRESHOLD = 100;
	// 会员系统消费记录，操作类型0:充值，1:扣费，2:积分
	public final static Integer MEMBER_BALACE_RECHARGE = 0;
	// 会员系统消费记录，操作类型0:充值，1:扣费，2:积分
	public final static Integer MEMBER_BALACE_DEDUCT = 1;
	// 会员系统消费记录，操作类型0:充值，1:扣费，2:积分
	public final static Integer MEMBER_BALACE_HORSESHOE = 2;
	// 号码白名单
	public final static List<String> WHITE_LIST_PHONE = new ArrayList<>(Arrays.asList("14200000000"));
	// 0:已经过期的银行卡，1:正在使用的银行卡，2：审核中的银行卡
	public final static Integer BANKCARD_OBSOLETE = 0;
	public final static Integer BANKCARD_IN_USE = 1;
	public final static Integer BANKCARD_AUDIT = 2;
	public final static Integer BANKCARD_AUDIT_FAILED = 3;

	// car_type_special_time表中的类型，1：行驶费 2：慢速费
	// 类型(1:里程费 2:低速费,3:起价费,4:起价里程,5:等时费,6:远途费,7:远途里程)
	public final static Integer SPECIAL_TIME_TYPE_MILE_FARE = 1;
	public final static Integer SPECIAL_TIME_TYPE_SLOW_SPEED = 2;
	public final static Integer SPECIAL_TIME_TYPE_START_FARE = 3;
	public final static Integer SPECIAL_TIME_TYPE_START_TRIP_MILE = 4;
	public final static Integer SPECIAL_TIME_TYPE_WAITING_FARE = 5;
	public final static Integer SPECIAL_TIME_TYPE_LONG_TRIP_FARE = 6;
	public final static Integer SPECIAL_TIME_TYPE_LONG_TRIP_MILE = 7;

	// 鹰眼订单实体名称前缀，后面拼接订单ID
	public final static String YINGYAN_ENTITY_PREFIX = "driver_";

	// 废弃司机账号时:1.待定时器到时废弃，2.已经废弃了。
	public final static String DRIVER_DISCARDED_RECORD_DISCARDING = "1";
	public final static String DRIVER_DISCARDED_RECORD_DISCARDED = "2";

	// 专车计费区间，如行驶0.2KM，算0.5
	public final static BigDecimal PRICE_MILE_SECTION = new BigDecimal("0.5");
	// 最多推送司机数量
	public final static int MAX_PUSH_DRIVER_NUM = 30;
	// 实时订单
	public final static String ORDER_TYPE_CURRENT = "0";
	// 预约订单
	public final static String ORDER_TYPE_BOOKING = "1";
}
