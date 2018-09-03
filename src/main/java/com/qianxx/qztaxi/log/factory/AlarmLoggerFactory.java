package com.qianxx.qztaxi.log.factory;

import com.qianxx.qztaxi.log.logger.AbstractLogger;
import com.qianxx.qztaxi.log.logger.AlarmLogger;

/**
 * 告警日志工程
 * <p>Title: AlarmLoggerFactory</p>
 * <p>Description: </p>
 * <p>Company: anjie</p> 
 * <p>Copyright: Copyright (c) 2018</p>

 * @author zhangqinghe
 * @date 2018年4月24日 下午3:08:52
 * @version 1.0.0
 */
public class AlarmLoggerFactory extends AbstractLoggerFactory {

	private static final AlarmLoggerFactory INSTANCE = new AlarmLoggerFactory(new AlarmLogger());

	private AlarmLoggerFactory(AbstractLogger logger) {
		super(logger);
	}

	public static AlarmLoggerFactory log() {
		return INSTANCE;
	}
}
