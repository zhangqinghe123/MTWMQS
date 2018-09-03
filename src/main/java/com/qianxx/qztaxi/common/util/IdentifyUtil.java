package com.qianxx.qztaxi.common.util;

import java.util.Random;

/**
 * 生成验证码Util.
 * 
 * @author SummerSoft
 *
 */
public class IdentifyUtil {
	/**
	 * 生成验证码.
	 * 
	 * @return 4位数字随机验证码
	 */
	public static String getIdentifyCode() {

		Random random = new Random();

		int x = random.nextInt(8999);

		x = x + 1000;

		return String.valueOf(x);
	}
}
