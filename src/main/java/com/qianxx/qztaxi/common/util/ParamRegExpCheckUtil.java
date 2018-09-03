package com.qianxx.qztaxi.common.util;

import java.util.regex.Pattern;

/**
 * <p>参数检查工具类</p>
 * <p>Description: </p>
 * <p>Company: AnJie</p> 
 * <p>Copyright: Copyright (c) 2018</p>

 * @author zhangqinghe
 * @date 2018年1月30日 上午10:16:47
 * @version 1.0.0
 */
public abstract class ParamRegExpCheckUtil {

	private static final String MOBILE_REGEXP = "^1([3458][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$";
	
	private static final String CAR_PLATES = "^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[a-zA-Z0-9]{4,5}[a-zA-Z0-9挂学警港澳]{1}$";

	private static final String BANK_CARD = "^[1-9]{1}\\d{14,29}$";
	
	/**
	 * 检查电话号码
	 * @param mobile
	 * @return
	 */
	public static boolean checkMobile(String mobile) {
		return checkParam(MOBILE_REGEXP, mobile);
	}
	
	public static boolean checkCarPlates(String carPlates) {
		return checkParam(CAR_PLATES, carPlates);
	}
	
	public static boolean checkBankCard(String bankCardNum) {
		return checkParam(BANK_CARD, bankCardNum);
	}

	/**
	 * 正则匹配检查
	 * @param patten 正则表达式
	 * @param param 参数值
	 * @return
	 */
	private static boolean checkParam(String patten, String param) {
		return Pattern.matches(patten, param);
	}

}
