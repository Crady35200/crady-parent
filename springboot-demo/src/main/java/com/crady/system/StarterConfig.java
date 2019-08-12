package com.crady.system;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * author:Crady
 *  * date:2019/5/7 11:33
 *  * desc:启动的时候运行自定义代码有两种方式,并通过Order 控制启动顺序，数值越小越先执行
 *  * 一、实现ApplicationRunner接口
 *  * 二、实现CommandLineRunner接口
 **/
@Component
@Slf4j
@Order(1)
public class StarterConfig implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("=======自定义启动代码=======");
    }
}
