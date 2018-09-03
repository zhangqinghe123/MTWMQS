package com.qianxx.qztaxi.common;

import java.io.Serializable;

public class HttpModel implements Serializable {

	private static final long serialVersionUID = 1L;

	public static class Code {
		public static int CODE_200 = 200; // 成功
		public static int CODE_404 = 404; // 未找到
		public static int CODE_403 = 403; // 该账号未绑定
		public static int CODE_405 = 405; // 事物未定义
		public static int CODE_500 = 500; // 未知错误
	}

	private int code;

	private String result;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}