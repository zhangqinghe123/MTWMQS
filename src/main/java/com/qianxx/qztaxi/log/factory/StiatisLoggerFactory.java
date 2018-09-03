package com.qianxx.qztaxi.log.factory;

import com.qianxx.qztaxi.log.logger.AbstractLogger;
import com.qianxx.qztaxi.log.logger.StatisLogger;

/**
 * 统计日志工程
 * <p>Title: StiatisLoggerFactory</p>
 * <p>Description: </p>
 * <p>Company: anjie</p> 
 * <p>Copyright: Copyright (c) 2018</p>

 * @author zhangqinghe
 * @date 2018年3月8日 上午11:00:13
 * @version 1.0.0
 */
public class StiatisLoggerFactory extends AbstractLoggerFactory {

	private static final StiatisLoggerFactory INSTANCE = new StiatisLoggerFactory(new StatisLogger());

	private StiatisLoggerFactory(AbstractLogger logger) {
		super(logger);
	}

	public static StiatisLoggerFactory log() {
		return INSTANCE;
	}
	
	/**
	 * 接口名称|总消息数|成功数量|失败数量|成功率|最大时延|最小时延|平均时延
	 * @param info
	 */
	public void statisMemberSysInfo(Object... infos) {
		logger.statis("statisMemberSys", infos);
	}
	
	public void statisApiInfo(Object... infos) {
		logger.statis("statisApi", infos);
	}
	
	public void statisThreadPool(Object... infos) {
		logger.statis("threadPool", infos);
	}
}
