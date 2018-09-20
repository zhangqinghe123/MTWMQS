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
        if (path.contains("user")) {
            DataSourceContextHolder.setDbType(DataSourceName.DATASOURCE_USER);
        } else {
            DataSourceContextHolder.setDbType(DataSourceName.DATASOURCE_SERVICE);
        }
        return pjp.proceed();
    }
}
