package com.qianxx.qztaxi.log.factory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.qianxx.qztaxi.log.logger.AbstractLogger;

/**
 * 日志工厂类，初始化后可直接打印日志
 * <p>Title: AbstractLoggerFactory</p>
 * <p>Description: </p>
 * <p>Company: anjie</p> 
 * <p>Copyright: Copyright (c) 2018</p>

 * @author zhangqinghe
 * @date 2018年2月2日 上午10:07:03
 * @version 1.0.0
 */
public abstract class AbstractLoggerFactory {

	public AbstractLogger logger = null;

	public static final Map<String, Date> SUPPRESS_INFO_MAP = new HashMap<>();

	/**
	 * 构造函数，需要传入
	 * @param logger
	 */
	public AbstractLoggerFactory(AbstractLogger logger) {
		this.logger = logger;
	}

	/**
	 * 记录error级别日志
	 * @param className 类名
	 * @param methodName 方法名
	 * @param transactionId 流水号
	 * @param infos 需要记录的日志
	 */
	public <T> void error(Class<T> className, String methodName, String transactionId, String... infos) {
		logger.error(className, methodName, transactionId, infos);
	}

	/**
	 * 记录info级别日志
	 * @param className 类名
	 * @param methodName 方法名
	 * @param transactionId 流水号
	 * @param infos 需要记录的日志
	 */
	public <T> void info(Class<T> className, String methodName, String transactionId, String... infos) {
		logger.info(className, methodName, transactionId, infos);
	}

	public <T> void suppressInfo(Class<T> className, String methodName, String suppressFactor, String transactionId, String... infos) {
		Date lastRecord = SUPPRESS_INFO_MAP.get(suppressFactor);
		final int oneMinute = 60000;
		if (lastRecord != null && (new Date().getTime() - lastRecord.getTime() < oneMinute)) {
			return;
		}
		SUPPRESS_INFO_MAP.put(suppressFactor, new Date());
		logger.info(className, methodName, transactionId, infos);
	}

	/**
	 * 外部消息入口日志
	 * @param className 类名
	 * @param methodName 方法名
	 * @param transactionId 流水号
	 */
	public <T> void enter(Class<T> className, String methodName, String transactionId) {
		logger.info(className, methodName, transactionId, "消息开始处理");
	}

	/**
	 * 外部消息入口日志
	 * @param className 类名
	 * @param methodName 方法名
	 * @param transactionId 流水号
	 * @param resultValue 返回值
	 */
	public <T> void exit(Class<T> className, String methodName, String transactionId, String resultValue) {
		logger.info(className, methodName, transactionId, "消息处理完成", "结果:[" + resultValue + "]");
	}

}
