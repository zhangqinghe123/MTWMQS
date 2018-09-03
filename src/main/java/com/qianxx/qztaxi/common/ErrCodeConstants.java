package com.qianxx.qztaxi.common;

public class ErrCodeConstants {

    // 1：访问成功 [0~999]
    /** 访问成功 **/
    public final static int ERR_0_SUCCESS = 0;

    /** 访问失败 **/
    public final static int ERR_1_ERROR = 1;

    // 2：请求参数非法 [1000~1999]
    /** 参数错误 **/
    public final static int ERR_1000_PARAMS_ERR = 1000;

    /** 没有访问权限 **/
    public final static int ERR_401_FAIL_KEY = 401;

    /** 非法访问 **/
    public final static int ERR_403_FAIL_KEY = 403;

    /** 用户不存在 **/
    public final static int ERR_410_FAIL_KEY = 410;

    /** TOKEN失效 **/
    public final static int ERR_2000_TOKEN_ERR = 2000;

    /** 无效用户 **/
    public final static int ERR_2001_INVALID_USER = 2001;

    /** 密码错误 **/
    public final static int ERR_2002_WRONG_PASSWORD = 2002;

    /** 验签失败 **/
    public final static int ERR_2003_FAIL_TOKEN = 2003;

    /** 账号被封 **/
    public final static int ERR_2004_FAIL_SEAL = 2004;

    // 4：服务器系统异常 [3000~9999]
    /** 服务器异常 **/
    public final static int ERR_3000_SERVER_ERR = 3000;

    /** SMS服务器错误 **/
    public final static int ERR_3001_SMS_API_ERR = 3001;

    /** 百度地图Api服务异常 **/
    public final static int ERR_3002_BAIDUMAP_API_ERR = 3002;
}
