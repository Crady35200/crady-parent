package com.crady;

import com.crady.plugin.SlowSqlInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Slf4j
@SpringBootApplication
@EnableCaching
@EnableAsync
//@EnableScheduling
@MapperScan(basePackages = "com.crady.mapper",annotationClass = Repository.class)
@ServletComponentScan(basePackages = "com.crady.filter")
public class SpringbootDemoApplication implements WebMvcConfigurer {

    @Autowired
    private HandlerInterceptor demoInterceptor;
    @Autowired
    private HandlerInterceptor aInterceptor;
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    RedisTemplate redisTemplate;



    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }


    @PostConstruct
    public void init(){
        initRedisTemplate();
        initMybatisPlugin();
    }

    /**
     * 初始化mybatis插件
     */
    public void initMybatisPlugin(){
        Interceptor plugin = new SlowSqlInterceptor();
        Properties properties = new Properties();
        properties.setProperty("threshold","500");
        plugin.setProperties(properties);
        sqlSessionFactory.getConfiguration().addInterceptor(plugin);
    }

    /**
     * 初始化redisTemplate使其可以存储对象
     */
    public void initRedisTemplate(){
        redisTemplate.setKeySerializer(redisTemplate.getStringSerializer());
        /**
         * 使用JdkSerializationRedisSerializer实体类必须实现Serializable接口
         * JDK自带的序列化方式、存储的字符串内容在序列化的情况下偏长，会占用过多的内存
         */
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        redisObjectTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
//        redisObjectTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Object.class));
    }

    /**
     * 注入redisStringTemplate用户字符串操作
     * @return
     */
    @Bean
    public RedisTemplate<String,Object> redisStringTemplate(){
        RedisTemplate<String,Object> redisStringTemplate = new RedisTemplate<>();
        redisStringTemplate.setConnectionFactory(redisTemplate.getConnectionFactory());
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        redisStringTemplate.setKeySerializer(stringSerializer);
        redisStringTemplate.setValueSerializer(stringSerializer);
        return redisStringTemplate;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(aInterceptor).addPathPatterns("/**");
        registry.addInterceptor(demoInterceptor).addPathPatterns("/demo/**");
    }

}

