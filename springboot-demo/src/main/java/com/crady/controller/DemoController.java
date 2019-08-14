package com.crady.controller;

import com.crady.pojo.User;
import com.crady.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

    @Autowired
    RedisService redisService;


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

    @RequestMapping("redisObjectSet")
    public String redisObjectSet(String key){
        User user = User.builder().id(88).name("redis object 刘德华").password("a123321").age(18).sex("0").build();
        redisService.setObject(key,user);
        return "添加到redis成功,key=" + key + ",value=" + user;
    }
    @RequestMapping("redisObjectGet")
    public String redisObjectGet(String key){
        Object value = redisService.getObject(key);
        return "从redis获取成功,key=" + key + ",value=" + value;
    }
    @RequestMapping("redisObjectRemove")
    public String redisObjectRemove(String key){
        Object value = redisService.removeObject(key);
        return "从redis删除成功,key=" + key;
    }

    @RequestMapping("redisSet")
    public String redisSet(String key,String value){
        redisService.set(key,value);
        return "添加到redis成功,key=" + key + ",value=" + value;
    }
    @RequestMapping("redisGet")
    public String redisGet(String key){
        String value = redisService.get(key);
        return "从redis获取成功,key=" + key + ",value=" + value;
    }
    @RequestMapping("redisListGet")
    public String redisListGet(String key){
        List<String> value = redisService.getList(key);
        return "从redis获取成功,key=" + key + ",value=" + value;
    }
    @RequestMapping("redisHashGet")
    public String redisHashGet(String key){
        Map<Object, Object> value = redisService.getHash(key);
        return "从redis获取成功,key=" + key + ",value=" + value;
    }
    @RequestMapping("redisSetGet")
    public String redisSetGet(String key){
        Set<String> value = redisService.getSet(key);
        return "从redis获取成功,key=" + key + ",value=" + value;
    }
    @RequestMapping("redisZsetGet")
    public String redisZsetGet(String key){
        Set<ZSetOperations.TypedTuple<String>> value = redisService.getZset(key);
        return "从redis获取成功,key=" + key + ",value=" + value;
    }
}
