package com.qianxx.qztaxi.common.yingyan.util;


import com.qianxx.qztaxi.common.yingyan.api.track.IllegalTrackArgumentException;
import com.qianxx.qztaxi.common.yingyan.model.BaseRequest;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 通用工具类
 * 
 * @author baidu
 *
 */
public class CommonUtils {

    /**
     * 将异常信息转成字符串
     * 
     * @param ex
     * @return
     */
    public static String transExceptionToString(Exception ex) {
        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }

    /**
     * 字符串是否为null或空串
     * 
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str) {
        if (null == str || "".equals(str)) {
            return true;
        }
        return false;
    }

    /**
     * 组装公共请求
     * 
     * @param parameters
     */
    public static void packCommonRequest(StringBuilder parameters) {
        if (CommonUtils.isNullOrEmpty(BaseRequest.getAk())) {
            throw new IllegalTrackArgumentException("ak can not be null or empty string.");
        }

        if (BaseRequest.getServiceId() <= 0) {
            throw new IllegalTrackArgumentException("serviceId is lower than 0.");
        }
        parameters.append("ak=").append(BaseRequest.getAk());
        parameters.append("&service_id=").append(BaseRequest.getServiceId());
    }
}
