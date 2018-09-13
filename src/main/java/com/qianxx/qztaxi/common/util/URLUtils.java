package com.qianxx.qztaxi.common.util;

import org.springframework.util.StringUtils;



public class URLUtils {
	public static String getMYPICFullImagesURL(String fileName) {
		if (StringUtils.isEmpty(fileName)) {
			return "";
		}
		StringBuffer ret = new StringBuffer();
		ret.append(Sysutils.getWebSite());
		ret.append(fileName);

		return ret.toString();
	}

	public static String getMYPICThumImagesURL(Integer userId, String fileName) {
		if (StringUtils.isEmpty(fileName)) {
			return "";
		}
		StringBuffer ret = new StringBuffer();

		ret.append(Sysutils.getWebSite());
		ret.append("/");
		ret.append(userId);
		ret.append("/");
		ret.append(Constants.UPLOAD_FOLDER_MYPIC);
		ret.append("/");
		ret.append(fileName);

		return ret.toString();
	}

	public static String getIDFullImagesURL(Integer userId, String fileName) {
		if (StringUtils.isEmpty(fileName)) {
			return "";
		}
		StringBuffer ret = new StringBuffer();

		ret.append(Sysutils.getWebSite());
		ret.append("/");
		ret.append(userId);
		ret.append("/");
		ret.append(Constants.UPLOAD_FOLDER_IDCARD);
		ret.append("/");
		ret.append(FileUtils.FOLDER_FULL);
		ret.append("/");
		ret.append(fileName);

		return ret.toString();
	}

	public static String getIDThumImagesURL(Integer userId, String fileName) {
		if (StringUtils.isEmpty(fileName)) {
			return "";
		}
		StringBuffer ret = new StringBuffer();

		ret.append(Sysutils.getWebSite());
		ret.append("/");
		ret.append(userId);
		ret.append("/");
		ret.append(Constants.UPLOAD_FOLDER_IDCARD);
		ret.append("/");
		ret.append(fileName);

		return ret.toString();
	}

	public static String getLICFullImagesURL(Integer userId, String fileName) {
		if (StringUtils.isEmpty(fileName)) {
			return "";
		}
		StringBuffer ret = new StringBuffer();

		ret.append(Sysutils.getWebSite());
		ret.append("/");
		ret.append(userId);
		ret.append("/");
		ret.append(Constants.UPLOAD_FOLDER_VEHICLELIC);
		ret.append("/");
		ret.append(FileUtils.FOLDER_FULL);
		ret.append("/");
		ret.append(fileName);

		return ret.toString();
	}

	public static String getLICThumImagesURL(Integer userId, String fileName) {
		if (StringUtils.isEmpty(fileName)) {
			return "";
		}
		StringBuffer ret = new StringBuffer();

		ret.append(Sysutils.getWebSite());
		ret.append("/");
		ret.append(userId);
		ret.append("/");
		ret.append(Constants.UPLOAD_FOLDER_VEHICLELIC);
		ret.append("/");
		ret.append(fileName);

		return ret.toString();
	}
}
