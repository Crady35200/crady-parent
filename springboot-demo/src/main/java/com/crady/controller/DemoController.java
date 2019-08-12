package com.crady.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * author:Crady
 * date:2019/1/19 14:49
 * desc:
 **/
@RestController
@Validated
//@Scope("prototype")
@RequestMapping("demo")
public class DemoController{
    private AtomicInteger count=new AtomicInteger(0);


    ThreadLocal<String> name = new ThreadLocal<>();

    @RequestMapping("hi")
    public String hi(){
        return "hi,nice to meet you !";
    }


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

    @RequestMapping("jmdemo")
    public String jmdemo(){
        count.incrementAndGet();
        System.out.println("jmeter demo=" + count);
        return  "jmeter demo";
    }
}
