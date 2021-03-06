package com.qianxx.qztaxi.common.util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


public class FileUtils {

    private static Logger log = Logger.getLogger(FileUtils.class);

    /**
     * 原图文件夹名
     **/
    public final static String FOLDER_APK = "apk";
    public final static String FOLDER_PATROL = "patrol";

    public static String uploadApp(MultipartFile file) {
        // 对象文件名
        String targetFileName = file.getOriginalFilename();
        if (!targetFileName.contains(".")) {
            return null;
        }
        targetFileName = targetFileName.substring(targetFileName.lastIndexOf(".")).toLowerCase();
        if (!".apk".toLowerCase().contains(targetFileName)) {
            return null;
        }
        // 建立原图上传目录
        String dirPath = getTomcatPath() + File.separator + FOLDER_APK + File.separator;
        File dirFile = new File(dirPath);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        SimpleDateFormat dateFmt = new SimpleDateFormat("yyyyMMdd");
        String fileName = dateFmt.format(new Date())
                + UUID.randomUUID()
                + targetFileName.substring(targetFileName.lastIndexOf("."))
                .toLowerCase();

        if (writeFile(file, dirPath, fileName)) {
            return null;
        }
        return "/" + FOLDER_APK + "/" + fileName;
    }

    public static String uploadPatrol(MultipartFile file) {
        // 对象文件名
        String targetFileName = file.getOriginalFilename();
        if (!targetFileName.contains(".")) {
            return null;
        }
        targetFileName = targetFileName.substring(targetFileName.lastIndexOf(".")).toLowerCase();
        if (!".JPG,.JPEG,.PNG".toLowerCase().contains(targetFileName)) {
            return null;
        }
        // 建立原图上传目录
        String dirPath = getTomcatPath() + File.separator + FOLDER_PATROL + File.separator;

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

        if (writeFile(file, dirPath, fileName)) {
            return null;
        }
        return "/" + FOLDER_PATROL + "/" + fileName;
    }

    protected static String getTomcatPath() {
        return FileUtils.class.getResource("/").getPath().substring(0, FileUtils.class.getResource("/").getPath().indexOf("WEB-INF") - 1);
    }

    public static void downloadApp(String filePath, HttpServletResponse response, String fileName)
            throws Exception {
        //设置响应头和客户端保存文件名
        String suffix = filePath.substring(filePath.lastIndexOf(".")).toLowerCase();
        fileName = fileName + "." + suffix;
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        //用于记录以完成的下载的数据量，单位是byte
        try {
            //打开本地文件流
            InputStream inputStream = new FileInputStream(getTomcatPath() + filePath);
            //激活下载操作
            OutputStream os = response.getOutputStream();
            //循环写入输出流
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
            // 这里主要关闭。
            os.close();
            inputStream.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void deleteFile(File file) {
        if (file.exists()) { // 判断文件是否存在
            if (file.isFile()) { // 判断是否是文件
                file.delete(); // delete()方法 你应该知道 是删除的意思;
            } else if (file.isDirectory()) { // 否则如果它是一个目录
                File files[] = file.listFiles(); // 声明目录下所有的文件 files[];
                for (int i = 0; i < files.length; i++) { // 遍历目录下所有的文件
                    deleteFile(files[i]); // 把每个文件 用这个方法进行迭代
                }
            }
            file.delete();
        } else {
            log.debug("所删除的文件不存在！" + '\n');
        }
    }

    private static boolean writeFile(MultipartFile file, String dirPath, String fileName) {
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
        } catch (IOException e) {
            log.debug("文件上传服务器失败：" + e.getMessage());
            return true;
        }
        return false;
    }

}
