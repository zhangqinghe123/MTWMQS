package com.qianxx.qztaxi.log.logger;

import org.apache.log4j.Logger;

/**
 * 告警日志记录
 * <p>Title: AlarmLogger</p>
 * <p>Description: </p>
 * <p>Company: anjie</p> 
 * <p>Copyright: Copyright (c) 2018</p>

 * @author zhangqinghe
 * @date 2018年4月24日 下午3:06:43
 * @version 1.0.0
 */
public class AlarmLogger extends AbstractLogger {

	private Logger STITIS_LOGGER = Logger.getLogger("alarmlog");

	@Override
	public <T> void info(Class<T> className, String methodName, String transactionId, String... infos) {
		// TODO Auto-generated method stub
	}

	@Override
	public <T> void error(Class<T> className, String methodName, String transactionId, String... infos) {
		// TODO Auto-generated method stub
		STITIS_LOGGER.error(infos[0]);
	}

	@Override
	public <T> void statis(String statisType, Object... infos) {
		// TODO Auto-generated method stub
		
	}
}
