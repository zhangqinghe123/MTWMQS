package com.qianxx.qztaxi.common.util;

public class Sysutils {

	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader propertiesLoader;

	/**
	 * 获取配置
	 */
	public static String getConfig(String key) {
		if (propertiesLoader == null) {
			propertiesLoader = new PropertiesLoader("resources.properties");
		}
		return propertiesLoader.getProperty(key);
	}

	public static String getWebServerindex() {
		return getConfig("websrverPath");
	}

	public static String getWebSite() {
		return getConfig("website");
	}

	public static String getUpdateSite() {
		return getConfig("updatesite");
	}
}
