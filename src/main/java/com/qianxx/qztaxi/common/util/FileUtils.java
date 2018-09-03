package com.qianxx.qztaxi.common.util;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


public class FileUtils {

	private static Logger log = Logger.getLogger(FileUtils.class);

	/** 原图文件夹名 **/
	public final static String FOLDER_FULL = "full";
	/** 缩略图 **/
	public final static String FOLDER_THUM = "thum";

	public static String uploadImages(MultipartFile file, String folderName) {
		// 对象文件名
		String targetFileName = file.getOriginalFilename();
		if (targetFileName.indexOf(".") < 0){
			return null;
		}
		targetFileName = targetFileName.substring(targetFileName.lastIndexOf(".")).toLowerCase();
		if(".GIF,.JPG,.JPEG,.PNG".toLowerCase().indexOf(targetFileName) < 0){
			return null;
		}
		// 建立原图上传目录
		String filePath =  File.separator + folderName
				+ File.separator;

		// 如果该用户已上传过图片，删除对应图片
		//deleteFile(new File(Constants.FILE_UPLOAD_PATH + filePath));

		String dirPath = Constants.FILE_UPLOAD_PATH + filePath + FOLDER_FULL
				+ File.separator;
		File dirFile = new File(dirPath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}

		// 上传文件名
		SimpleDateFormat dateFmt = new SimpleDateFormat("yyyyMMdd");
		// 文件格式，缩略图生成
		String fileName = dateFmt.format(new Date())
				+ UUID.randomUUID()
				+ targetFileName.substring(targetFileName.lastIndexOf("."))
						.toLowerCase();

		try {
			InputStream inputStream;
			inputStream = file.getInputStream();
			byte[] b = new byte[Constants.UPLOAD_FILE_SIZE];
			int length = inputStream.read(b);
			dirPath += fileName;
			// 文件流写到服务器端
			FileOutputStream outputStream = new FileOutputStream(dirPath);
			outputStream.write(b, 0, length);
			inputStream.close();
			outputStream.close();
		}
		catch (IOException e) {
			log.debug("文件上传服务器失败：" + e.getMessage());
			return null;
		}

		// 生成缩略图
		try {
			File uploadImage = new File(dirPath);

			String thumPath = Constants.FILE_UPLOAD_PATH + filePath + FOLDER_THUM
					+ File.separator;

			dirFile = new File(thumPath);
			if (!dirFile.exists()) {
				dirFile.mkdirs();
			}

			thumPath += fileName;
			File thumImage = new File(thumPath);

			// 生成[200x200]的缩略图
			ImageUtil.createZoomImage(uploadImage, thumImage, 200, 200);
		}
		catch (IOException e) {
			log.debug("缩略图生成失败：" + e.getMessage());
			return null;
		}

		return "/"+folderName+"/"+FOLDER_FULL+"/"+fileName;
	}
	
	
	public static String uploadImages(byte[] data, String userId,
			String folderName) {
		// 建立原图上传目录
		String filePath = File.separator + userId + File.separator + folderName
				+ File.separator;

		// 如果该用户已上传过图片，删除对应图片
		deleteFile(new File(Constants.FILE_UPLOAD_PATH + filePath));

		String dirPath = Constants.FILE_UPLOAD_PATH + filePath + FOLDER_FULL
				+ File.separator;
		File dirFile = new File(dirPath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}

		// 上传文件名
		SimpleDateFormat dateFmt = new SimpleDateFormat("yyyyMMdd");
		// 文件格式，缩略图生成
		String fileName = dateFmt.format(new Date())
				+ UUID.randomUUID();

		try {
			dirPath += fileName;
			// 文件流写到服务器端
			FileOutputStream outputStream = new FileOutputStream(dirPath);
			// 写入数据
			outputStream.write(data);
			// 关闭输出流
			outputStream.close();
		}
		catch (IOException e) {
			log.debug("文件上传服务器失败：" + e.getMessage());
			return null;
		}

		// 生成缩略图
		try {
			File uploadImage = new File(dirPath);

			String thumPath = Constants.FILE_UPLOAD_PATH + filePath + FOLDER_THUM
					+ File.separator;

			dirFile = new File(thumPath);
			if (!dirFile.exists()) {
				dirFile.mkdirs();
			}

			thumPath += fileName;
			File thumImage = new File(thumPath);

			// 生成[200x200]的缩略图
			ImageUtil.createZoomImage(uploadImage, thumImage, 200, 200);
		}
		catch (IOException e) {
			log.debug("缩略图生成失败：" + e.getMessage());
			return null;
		}

		return fileName;
	}
	
	

	public static void deleteFile(File file) {
		if (file.exists()) { // 判断文件是否存在
			if (file.isFile()) { // 判断是否是文件
				file.delete(); // delete()方法 你应该知道 是删除的意思;
			}
			else if (file.isDirectory()) { // 否则如果它是一个目录
				File files[] = file.listFiles(); // 声明目录下所有的文件 files[];
				for (int i = 0; i < files.length; i++) { // 遍历目录下所有的文件
					deleteFile(files[i]); // 把每个文件 用这个方法进行迭代
				}
			}
			file.delete();
		}
		else {
			log.debug("所删除的文件不存在！" + '\n');
		}
	}

	public static byte[] readInputStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		// 创建一个Buffer字符串
		byte[] buffer = new byte[1024];
		// 每次读取的字符串长度，如果为-1，代表全部读取完毕
		int len = 0;
		// 使用一个输入流从buffer里把数据读取出来
		while ((len = inStream.read(buffer)) != -1) {
			// 用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
			outStream.write(buffer, 0, len);
		}
		// 关闭输入流
		inStream.close();
		// 把outStream里的数据写入内存
		return outStream.toByteArray();
	}

	/** 从文件读取工作簿 */
	public static Workbook getWorkBook(MultipartFile file) throws Exception{
		Workbook work = null;
		try {
			String fileName = file.getOriginalFilename();
			if(fileName.toLowerCase().endsWith("xls")){
				work = new HSSFWorkbook(file.getInputStream());
			}else if(fileName.toLowerCase().endsWith("xlsx")){
				work = new XSSFWorkbook(file.getInputStream());
			}else{
				throw new Exception("格式不对！");
			}
		} catch (IOException e) {
			throw new Exception("格式不对！");
		}
		return work;
	}
	/**
	 * 获取上传单个文件的MD5值！
	 * @param file
	 * @return
	 */
	public static String getFileMD5(MultipartFile file) {
		MessageDigest digest = null;
		InputStream in=null;
		byte buffer[] = new byte[1024];
		int len;
		try {
			digest = MessageDigest.getInstance("MD5");
			in = file.getInputStream();
			while ((len = in.read(buffer, 0, 1024)) != -1) {
				digest.update(buffer, 0, len);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		BigInteger bigInt = new BigInteger(1, digest.digest());
		return bigInt.toString(16);
	}

	/** 保存文件 */
	public static void SaveFile(String path, Workbook work, String fileName) {
		//保存导入结果
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String date = fmt.format(new Date());
		File dir = new File(path+"/"+date);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dir, fileName);
		try{
			OutputStream output = new FileOutputStream(file);
			work.write(output);
			output.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 导出EXCEL
	 *
	 * @param workbook
	 * @param codedFileName
	 */
	public static void exportFile(HSSFWorkbook workbook, String codedFileName,HttpServletResponse response) {
		OutputStream fOut = null;
		try {
			// 生成提示信息，
			response.setContentType("application/vnd.ms-excel");
			// 进行转码，使其支持中文文件名
			codedFileName = java.net.URLEncoder.encode(
					codedFileName +DateUtil.TimeToForDay(DateUtil.getSystemTime()), "UTF-8");
			response.setHeader("content-disposition", "attachment;filename="
					+ codedFileName + ".xls");

			fOut = response.getOutputStream();
			workbook.write(fOut);
		}
		catch (UnsupportedEncodingException e1) {
		}
		catch (Exception e) {
		}
		finally {
			try {
				if (fOut != null) {
					fOut.flush();
					fOut.close();
				}
				if (workbook != null) {
					workbook.close();
				}
			}
			catch (IOException e) {
			}
		}
	}

	/** 输出信息 */
	public static void outMessage(String message,HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(message);
			response.getWriter().flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
