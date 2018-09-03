package com.qianxx.qztaxi.log.logger;

import org.apache.log4j.Logger;

/**
 * 记录统计日志类
 * <p>Title: ApiLogger</p>
 * <p>Description: </p>
 * <p>Company: AnJie</p> 
 * <p>Copyright: Copyright (c) 2018</p>

 * @author zhangqinghe
 * @date 2018年2月2日 上午8:37:28
 * @version 1.0.0
 */
public class StatisLogger extends AbstractLogger {

	private Logger STITIS_LOGGER = Logger.getLogger("statisticslog");

	@Override
	public <T> void info(Class<T> className, String methodName, String transactionId, String... infos) {
		// TODO Auto-generated method stub
	}

	@Override
	public <T> void error(Class<T> className, String methodName, String transactionId, String... infos) {
		// TODO Auto-generated method stub

	}

	public <T> String buildMessage(String statisType, Object... infos) {
		StringBuilder builder = new StringBuilder();
		builder.append(statisType).append("|");
		for (Object info : infos) {
			builder.append(String.valueOf(info)).append("|");
		}
		if (builder.length() != 0 && builder.length() == builder.lastIndexOf("|") + 1) {
			builder.deleteCharAt(builder.lastIndexOf("|"));
		}
		return builder.toString();
	}

	@Override
	public <T> void statis(String statisType, Object... infos) {
		// TODO Auto-generated method stub
		STITIS_LOGGER.info(buildMessage(statisType, infos));
	}
}
