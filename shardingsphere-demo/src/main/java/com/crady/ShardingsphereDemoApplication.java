package com.crady;

import com.crady.service.common.CommonService;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
@MapperScan(basePackages = "com.crady.repository.mybatis",annotationClass = Mapper.class)
public class ShardingsphereDemoApplication {

    public static void main(String[] args) throws SQLException {
//        SpringApplication.run(ShardingsphereDemoApplication.class, args);
        try (ConfigurableApplicationContext applicationContext = SpringApplication.run(ShardingsphereDemoApplication.class, args)) {
            System.out.println("=========================" + applicationContext.getBean("dataSource"));
            ExampleExecuteTemplate.run(applicationContext.getBean(CommonService.class));
         }
    }

}
