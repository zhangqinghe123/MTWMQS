package com.qianxx.qztaxi.log.factory;

import com.qianxx.qztaxi.log.logger.AbstractLogger;
import com.qianxx.qztaxi.log.logger.MemberFailedLogger;

/**
 * 记录调用会员系统失败的消息信息，以便人工处理
 * <p>Title: MemberFailedLoggerFactory</p>
 * <p>Description: </p>
 * <p>Company: anjie</p> 
 * <p>Copyright: Copyright (c) 2018</p>

 * @author zhangqinghe
 * @date 2018年2月8日 上午11:05:55
 * @version 1.0.0
 */
public class MemberFailedLoggerFactory extends AbstractLoggerFactory {

	private static final MemberFailedLoggerFactory INSTANCE = new MemberFailedLoggerFactory(new MemberFailedLogger());

	private MemberFailedLoggerFactory(AbstractLogger logger) {
		super(logger);
	}

	public static MemberFailedLoggerFactory getInstance() {
		return INSTANCE;
	}
}
