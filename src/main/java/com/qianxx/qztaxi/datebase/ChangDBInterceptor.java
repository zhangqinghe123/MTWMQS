package com.qianxx.qztaxi.datebase;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/4 09:47
 */
public class ChangDBInterceptor {
    public Object changeDB(ProceedingJoinPoint pjp) throws Throwable {
        //AOP切点在Service的 包名.类名
        String path = pjp.getTarget().getClass().getName();
        //如果servcie的 包名.类名 包含 agency，那说明需要切换为mysql数据源
        if (path.indexOf("user") != -1) {
            DataSourceContextHolder.setDbType(DataSourceName.DATASOURCE_USER);
        } else {
            DataSourceContextHolder.setDbType(DataSourceName.DATASOURCE_SERVICE);
        }
        return pjp.proceed();
    }
}
