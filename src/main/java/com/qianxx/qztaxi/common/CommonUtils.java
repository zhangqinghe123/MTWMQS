package com.qianxx.qztaxi.common;

import java.math.BigDecimal;

public abstract class CommonUtils {

	/**
	 * 将数据四舍五入
	 * @param mathDate
	 * @return
	 */
	public static <T extends Object> double roundingData(T mathDate){
		return new BigDecimal(mathDate.toString()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
