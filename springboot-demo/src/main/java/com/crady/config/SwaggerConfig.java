package com.crady.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author :Crady
 * date :2019/9/2 17:59
 * desc : Swagger配置
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // 扫描的包路径
                .apis(RequestHandlerSelectors.basePackage("com.crady.controller"))
//                .apis(RequestHandlerSelectors.any())
                // 定义要生成文档的Api的url路径规则
                .paths(PathSelectors.any())
                .build().apiInfo(metaData());
    }
    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                // 标题
                .title("SpringBoot集成Swagger2")
                // 描述
                .description("springboot-demo项目集成swagger")
                // 文档版本
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
}
