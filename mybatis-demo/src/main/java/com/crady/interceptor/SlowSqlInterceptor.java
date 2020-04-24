package com.crady.interceptor;

import com.alibaba.druid.pool.DruidPooledPreparedStatement;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.jdbc.PreparedStatementLogger;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Statement;
import java.util.Properties;

/**
 * @author :Crady
 * date :2019/7/10 13:50
 * desc :
 **/
@Intercepts({@Signature(type = StatementHandler.class,method = "query",args = {Statement.class, ResultHandler.class})})
@Slf4j
public class SlowSqlInterceptor implements Interceptor {

    private static final long THRESHOLD_TIME = 500;
    private long threshold;

    /**
     * 拦截器代理执行的方法
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        long begin = System.currentTimeMillis();
        Object result = invocation.proceed();
        long time = System.currentTimeMillis() - begin;
        if(time > threshold){
            Object [] args = invocation.getArgs();
            Statement stat = (Statement) args[0];
            MetaObject metaObject = SystemMetaObject.forObject(stat);
            PreparedStatementLogger preparedStatementLogger = (PreparedStatementLogger) metaObject.getValue("h");
            DruidPooledPreparedStatement statement = (DruidPooledPreparedStatement) preparedStatementLogger.getPreparedStatement();
            log.info("慢查询,sql={},耗时：{}ms",statement.getSql(),time);
        }
        return result;
    }

    /**
     * 用于拦截器代理生成
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    /**
     * 用于拦截器属性设置
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {
        String time = properties.getProperty("threshold");
        if(null == time){
            this.threshold = THRESHOLD_TIME;
        }
        this.threshold = Long.valueOf(time);
    }
}
