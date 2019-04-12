package com.crady.boot.springbootdemo.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;

/**
 * author:Crady
 * date:2019/1/19 14:49
 * desc:
 **/
@RestController
@Validated
//@Scope("prototype")
public class DemoController{


    ThreadLocal<String> name = new ThreadLocal<>();

    @RequestMapping("hello")
    public String hello(String words){
        try {
            name.set(words);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = "Hi," + name.get() + ",nice to meet you !" + this;
        return result;
    }

    @RequestMapping("a/valid")
    public String valid(@Size(min = 6,max = 12) String name){
//        Assert.hasText(name,"不合法");
        return "I am " + name + " ,nice to meet you !";
    }
}
