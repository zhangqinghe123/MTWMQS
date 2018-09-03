package com.qianxx.qztaxi.log.logger;

import org.apache.log4j.Logger;

/**
 * 记录记录重要的调用 会员系统失败日志类
 * <p>Title: MemberFailedLogger</p>
 * <p>Description: </p>
 * <p>Company: anjie</p> 
 * <p>Copyright: Copyright (c) 2018</p>

 * @author zhangqinghe
 * @date 2018年2月8日 上午11:04:02
 * @version 1.0.0
 */
public class MemberFailedLogger extends AbstractLogger {

	private Logger logger = Logger.getLogger("memberfailedlog");

	@Override
	public <T> void info(Class<T> className, String methodName, String transactionId, String... infos) {
		// TODO Auto-generated method stub
		logger.info(buildMessage(className, methodName, transactionId, infos));
	}

	@Override
	public <T> void error(Class<T> className, String methodName, String transactionId, String... infos) {
		// TODO Auto-generated method stub
		logger.error(buildMessage(className, methodName, transactionId, infos));
	}

	@Override
	public <T> void statis(String statisType, Object... infos) {
		// TODO Auto-generated method stub
		
	}
}
