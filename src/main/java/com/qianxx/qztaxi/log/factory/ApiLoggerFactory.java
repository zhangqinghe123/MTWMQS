package com.qianxx.qztaxi.log.factory;

import com.qianxx.qztaxi.log.logger.AbstractLogger;
import com.qianxx.qztaxi.log.logger.ApiInterfaceLogger;
/**
 * API日志工厂
 * <p>Title: ApiLoggerFactory</p>
 * <p>Description: </p>
 * <p>Company: anjie</p> 
 * <p>Copyright: Copyright (c) 2018</p>

 * @author zhangqinghe
 * @date 2018年2月2日 下午2:32:36
 * @version 1.0.0
 */
public class ApiLoggerFactory extends AbstractLoggerFactory {

	private static final ApiLoggerFactory INSTANCE = new ApiLoggerFactory(new ApiInterfaceLogger());

	private ApiLoggerFactory(AbstractLogger logger) {
		super(logger);
	}

	public static ApiLoggerFactory log() {
		return INSTANCE;
	}
}
