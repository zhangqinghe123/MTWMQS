package com.qianxx.qztaxi.log.logger;

/**
 * <p>日志记录抽象类</p>
 * <p>Description: </p>
 * <p>Company: AnJie</p> 
 * <p>Copyright: Copyright (c) 2018</p>

 * @author zhangqinghe
 * @date 2018年2月2日 上午8:14:15
 * @version 1.0.0
 */
public abstract class AbstractLogger {

	/**
	 * 记录info级别日志
	 * @param className 记录消息的类
	 * @param methodName 方法名称
	 * @param transactionId 流水号
	 * @param infos 需要记录
	 */
	public abstract <T> void info(Class<T> className, String methodName, String transactionId, String... infos);
	
	/**
	 * 统计日志
	 * @param className
	 * @param methodName
	 * @param transactionId
	 * @param infos
	 */
	public abstract <T> void statis(String statisType, Object... infos);

	/**
	 * 记录error级别日志
	 * @param className 记录消息的类
	 * @param methodName 方法名称
	 * @param transactionId 流水号
	 * @param infos 需要记录
	 */
	public abstract <T> void error(Class<T> className, String methodName, String transactionId, String... infos);

	/**
	 * 构造消息内容，必选字段用|拼接，可选字段用_拼接
	 * @param className 记录消息的类
	 * @param methodName 方法名称
	 * @param transactionId 流水号
	 * @param infos 需要记录
	 * @return
	 */
	public <T> String buildMessage(Class<T> className, String methodName, String transactionId, String... infos) {
		StringBuilder builder = new StringBuilder();
		builder.append(transactionId).append("|");
		builder.append(className.getSimpleName()).append("|");
		builder.append(methodName).append("|");

		for (String info : infos) {
			builder.append(info).append("_");
		}
		if (builder.length() != 0 && builder.length() == builder.lastIndexOf("_") + 1) {
			builder.deleteCharAt(builder.lastIndexOf("_"));
		}
		return builder.toString();
	}

}
