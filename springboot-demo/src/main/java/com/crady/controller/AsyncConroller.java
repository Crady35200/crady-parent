package com.crady.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * author:Crady
 * date:2019/09/06 23:03
 * desc:
 **/
@RestController("async")
@Slf4j
public class AsyncConroller {

    @GetMapping("demo")
    @Async
    public String asyncDemo(){
        String msg = "异步调用...";
        try {
            TimeUnit.SECONDS.sleep(5);
            log.info(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return msg;
    }
}
