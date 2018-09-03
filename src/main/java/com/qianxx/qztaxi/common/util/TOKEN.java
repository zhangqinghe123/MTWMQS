package com.qianxx.qztaxi.common.util;

import java.util.Date;

import org.apache.commons.lang.time.FastDateFormat;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

public class TOKEN {

	private static final String privateKey = "fd12adsfwe34sadfk;ljgzcvm aqweri的kjhgafs阿模型;akfjsa342";

	public static String getToken(String userId, String date) {
		return Hashing.md5().newHasher().putString(userId, Charsets.UTF_8)
				.putString(privateKey, Charsets.UTF_8)
				.putString(date, Charsets.UTF_8).hash().toString();
	}

	public static String getToken(String userId, Date date) {
		return Hashing.md5().newHasher().putString(userId, Charsets.UTF_8)
				.putString(privateKey, Charsets.UTF_8)
				.putString(getDate(date), Charsets.UTF_8).hash().toString();
	}

	public static String getToken(String userId) {
		return Hashing.md5().newHasher().putString(userId, Charsets.UTF_8)
				.putString(privateKey, Charsets.UTF_8)
				.putString(getDate(), Charsets.UTF_8).hash().toString();
	}

	public static boolean validToken(String token, String password) {
		String confirm = getToken(password);
		if (confirm.equals(token)) {
			return true;
		} else {
			return false;
		}
	}

	public static String getDate() {
		Date date = new Date(System.currentTimeMillis());
		return FastDateFormat.getInstance("yyyyMMddHHmmss.SSS").format(date);
	}

	public static String getDate(Date now) {
		return FastDateFormat.getInstance("yyyyMMddHHmmss.SSS").format(now);
	}

	public static String getNextHour(Date now) {
		Date date = new Date(now.getTime() + 60 * 60 * 1000);

		return FastDateFormat.getInstance("yyyyMMddHHmmss.SSS").format(date);
	}

	public static void main(String arugs[]) {
		System.out.println(getToken("user"));
	}
}