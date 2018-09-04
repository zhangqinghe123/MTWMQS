package com.qianxx.qztaxi.datebase;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/4 09:45
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
    public static void setDbType(String dbType) {
        contextHolder.set(dbType);
    }
    //获取当前Thread的数据库类型
    public static String getDbType() {
        return contextHolder.get();
    }

    public static void clearDbType() {
        contextHolder.remove();
    }
}
