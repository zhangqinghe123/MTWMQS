package com.qianxx.qztaxi.log.factory;

import com.qianxx.qztaxi.log.logger.AbstractLogger;
import com.qianxx.qztaxi.log.logger.ManagerLogger;

/**
 * <p>Title: ManagerLoggerFactory</p>
 * <p>Description: </p>
 * <p>Company: anjie</p> 
 * <p>Copyright: Copyright (c) 2018</p>

 * @author zhangqinghe
 * @date 2018年2月9日 下午2:18:12
 * @version 1.0.0
 */
public class ManagerLoggerFactory extends AbstractLoggerFactory {

	private static final ManagerLoggerFactory INSTANCE = new ManagerLoggerFactory(new ManagerLogger());

	private ManagerLoggerFactory(AbstractLogger logger) {
		super(logger);
	}

	public static ManagerLoggerFactory getInstance() {
		return INSTANCE;
	}
}
