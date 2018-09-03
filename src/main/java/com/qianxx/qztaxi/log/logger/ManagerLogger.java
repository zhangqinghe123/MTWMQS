package com.qianxx.qztaxi.log.logger;

import org.apache.log4j.Logger;

/**
 * manager模块记录日志类
 * <p>Title: ManagerLogger</p>
 * <p>Description: </p>
 * <p>Company: AnJie</p> 
 * <p>Copyright: Copyright (c) 2018</p>

 * @author zhangqinghe
 * @date 2018年2月2日 上午8:37:28
 * @version 1.0.0
 */
public class ManagerLogger extends AbstractLogger {

	private Logger MANAGER_LOGGER = Logger.getLogger("managerlog");

	@Override
	public <T> void info(Class<T> className, String methodName, String transactionId, String... infos) {
		// TODO Auto-generated method stub
		MANAGER_LOGGER.info(buildMessage(className, methodName, transactionId, infos));
	}

	@Override
	public <T> void error(Class<T> className, String methodName, String transactionId, String... infos) {
		// TODO Auto-generated method stub
		MANAGER_LOGGER.error(buildMessage(className, methodName, transactionId, infos));
	}

	@Override
	public <T> void statis(String statisType, Object... infos) {
		// TODO Auto-generated method stub
		
	}

}
