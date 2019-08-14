package com.crady.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author :Crady
 * date :2019/8/13 9:56
 * desc : redis操作工具类
 **/
@Component
public class RedisService {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //object类型操作
    public void setObject(String key,Object value){
        redisTemplate.opsForValue().set(key,value);
    }
    public Object getObject(String key){
        return redisTemplate.opsForValue().get(key);
    }
    public Object removeObject(String key){
        return redisTemplate.opsForValue().getOperations().delete(key);
    }

    //string类型操作
    public void set(String key,String value){
        stringRedisTemplate.opsForValue().set(key,value);
    }
    public String get(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }
    //list类型操作
    public List<String> getList(String key){
        return stringRedisTemplate.opsForList().range(key,0,-1);
    }
    public void setList(String key,String value){
        stringRedisTemplate.opsForList().rightPush(key,value);
    }
    //hash类型操作
    public Map<Object, Object> getHash(String key){
        return stringRedisTemplate.opsForHash().entries(key);
    }
    public void setHash(String key, Map<String,String> map){
        stringRedisTemplate.opsForHash().putAll(key,map);
    }
    //set 类型操作
    public Set<String> getSet(String key){
        return stringRedisTemplate.opsForSet().members(key);
    }
    //zset 类型操作
    public Set<ZSetOperations.TypedTuple<String>> getZset(String key){
        return stringRedisTemplate.opsForZSet().rangeWithScores(key,0,-1);
//        return stringRedisTemplate.opsForZSet().range(key,0,-1);
    }



}
