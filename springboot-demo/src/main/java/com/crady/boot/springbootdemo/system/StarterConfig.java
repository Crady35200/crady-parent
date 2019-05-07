package com.crady.boot.springbootdemo.system;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * author:Crady
 * date:2019/5/7 11:33
 * desc:启动的时候运行自定义代码有两种方式
 * 一、实现ApplicationRunner接口
 * 二、实现CommandLineRunner接口
 **/
@Component
public class StarterConfig implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("==============================================================================");
        System.out.println("========================mingzhou==============================================");
        System.out.println("==============================================================================");
    }
}
