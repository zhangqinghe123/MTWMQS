package com.qianxx.qztaxi.log.structure;

/**
 * 统计日志使用的数据结构
 * <p>Title: StatisInterface</p>
 * <p>Description: </p>
 * <p>Company: anjie</p> 
 * <p>Copyright: Copyright (c) 2018</p>

 * @author zhangqinghe
 * @date 2018年3月28日 上午9:47:47
 * @version 1.0.0
 */
public class StatisInterface {

	// 方法名称
	private String methodName;
	// 返回码
	private String resultCode;
	// 耗时
	private long costTime = 0;

	public StatisInterface(String methodName, String resultCode, long costTime) {
		this.methodName = methodName;
		this.resultCode = resultCode;
		this.costTime = costTime;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public long getCostTime() {
		return costTime;
	}

	public void setCostTime(long costTime) {
		this.costTime = costTime;
	}
}
