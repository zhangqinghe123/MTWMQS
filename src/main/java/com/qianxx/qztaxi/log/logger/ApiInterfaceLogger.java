package com.qianxx.qztaxi.log.logger;

import org.apache.log4j.Logger;

/**
 * Api模块记录日志类
 * <p>Title: ApiLogger</p>
 * <p>Description: </p>
 * <p>Company: AnJie</p> 
 * <p>Copyright: Copyright (c) 2018</p>

 * @author zhangqinghe
 * @date 2018年2月2日 上午8:37:28
 * @version 1.0.0
 */
public class ApiInterfaceLogger extends AbstractLogger {

	private Logger API_LOGGER = Logger.getLogger("apilog");

	@Override
	public <T> void info(Class<T> className, String methodName, String transactionId, String... infos) {
		// TODO Auto-generated method stub
		API_LOGGER.info(buildMessage(className, methodName, transactionId, infos));
	}

	@Override
	public <T> void error(Class<T> className, String methodName, String transactionId, String... infos) {
		// TODO Auto-generated method stub
		API_LOGGER.error(buildMessage(className, methodName, transactionId, infos));
	}

	@Override
	public <T> void statis(String statisType, Object... infos) {
		// TODO Auto-generated method stub
		
	}

}
