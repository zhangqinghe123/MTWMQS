package com.qianxx.qztaxi.log.factory;

import com.qianxx.qztaxi.log.logger.AbstractLogger;
import com.qianxx.qztaxi.log.logger.MongonLogger;
/**
 * Mongo日志工厂
 * <p>Title: MongoLoggerFactory</p>
 * <p>Description: </p>
 * <p>Company: anjie</p> 
 * <p>Copyright: Copyright (c) 2018</p>

 * @author zhangqinghe
 * @date 2018年2月2日 下午2:32:36
 * @version 1.0.0
 */
public class MongoLoggerFactory extends AbstractLoggerFactory {

	private static final MongoLoggerFactory INSTANCE = new MongoLoggerFactory(new MongonLogger());

	private MongoLoggerFactory(AbstractLogger logger) {
		super(logger);
	}

	public static MongoLoggerFactory log() {
		return INSTANCE;
	}
}
