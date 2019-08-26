package com.crady.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :Crady
 * date :2019/8/26 17:18
 * desc :
 **/
@RestController
@RequestMapping("demo")
public class DemoController {

    @RequestMapping("hello")
    public String hello(){
        return "Hello,nice to meet you !";
    }
}
