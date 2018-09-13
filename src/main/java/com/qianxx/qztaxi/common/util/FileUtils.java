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

    /**
     * 原图文件夹名
     **/
    public final static String FOLDER_FULL = "apk";

    public static String uploadApp(MultipartFile file) {
        // 对象文件名
        String targetFileName = file.getOriginalFilename();
        if (targetFileName.indexOf(".") < 0) {
            return null;
        }
        targetFileName = targetFileName.substring(targetFileName.lastIndexOf(".")).toLowerCase();
        if (".apk".toLowerCase().indexOf(targetFileName) < 0) {
            return null;
        }
        // 建立原图上传目录
        String dirPath = getTomcatPath() + File.separator + FOLDER_FULL
                + File.separator;
        File dirFile = new File(dirPath);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        SimpleDateFormat dateFmt = new SimpleDateFormat("yyyyMMdd");
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
        } catch (IOException e) {
            log.debug("文件上传服务器失败：" + e.getMessage());
            return null;
        }

        return "/" + FOLDER_FULL + "/" + fileName;
    }

    protected static String getTomcatPath() {
        return FileUtils.class.getResource("/").getPath().substring(0, FileUtils.class.getResource("/").getPath().indexOf("WEB-INF") - 1);
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
}
