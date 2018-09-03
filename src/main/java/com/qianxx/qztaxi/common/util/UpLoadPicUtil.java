package com.qianxx.qztaxi.common.util;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.qianxx.qztaxi.common.exception.RestServiceException;

/**
 * 上传服务器图片
 * <p>Title: UpLoadPicUtil</p>
 * <p>Description: </p>
 * <p>Company: anjie</p> 
 * <p>Copyright: Copyright (c) 2018</p>

 * @author zhangqinghe
 * @date 2018年5月2日 上午10:58:09
 * @version 1.0.0
 */
public abstract class UpLoadPicUtil {

	/**
	 * 上传文件信息
	 * @param fileName 上传文件名称，用于抛异常用
	 * @param pic 图片
	 * @param path 上传服务器 地址
	 * @return 文件名称
	 */
	public static String upLoadPic(String fileName, MultipartFile pic, String path) {
		String file = "";
		// 上传个人头像图片文件
		if ((pic != null && !pic.isEmpty())) {
			file = FileUtils.uploadImages(pic, path);
		}
		if (StringUtils.isEmpty(file)) {
			throw new RestServiceException(fileName + "上传失败");
		}
		return file;
	}
}
