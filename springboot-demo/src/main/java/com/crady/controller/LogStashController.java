package com.crady.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :Crady
 * date :2019/9/4 11:53
 * desc :
 **/
@RestController("logstash")
@Slf4j
public class LogStashController {

    @GetMapping("demo/{n}")
    public void logstashDemo(@PathVariable Integer n){
        log.info("循环次数:{}",n);
        new Thread(() -> {
            for (int i = 0;i < n;i++){
                log.info("*********[{}]***********",i);
            }
        }).start();
    }
}
