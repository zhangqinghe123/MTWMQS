package com.qianxx.qztaxi.datebase;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import java.util.logging.Logger;
/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/4 09:46
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    public Logger getParentLogger() {
        return null;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDbType();
    }
}
