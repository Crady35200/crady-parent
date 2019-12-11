package com.crady.annotation.threadPool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author :Crady
 * date :2019/12/11 10:02
 * desc :
 **/
@Configuration
@PropertySource("spring-threadpool.properties")
public class SpringThreadPoolConfiguration{
    @Value("${spring.threadpool.corePoolSize}")
    private int corePoolSize;
    @Value("${spring.threadpool.maxPoolSize}")
    private int maxPoolSize;
    @Value("${spring.threadpool.keepAliveSeconds}")
    private int keepAliveSeconds;
    @Value("${spring.threadpool.queueCapacity}")
    private int queueCapacity;
    @Value("${spring.threadpool.allowCoreThreadTimeOut}")
    private boolean allowCoreThreadTimeOut;

    @Bean
    public ThreadPoolTaskExecutor executor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setQueueCapacity(queueCapacity);
        executor.setAllowCoreThreadTimeOut(allowCoreThreadTimeOut);
        return executor;
    }

}
