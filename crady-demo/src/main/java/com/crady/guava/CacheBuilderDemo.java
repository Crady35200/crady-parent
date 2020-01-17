package com.crady.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

/**
 * @author :Crady
 * date :2020/1/17 16:10
 * desc : guava使用缓存
 **/
public class CacheBuilderDemo {

    public static void main(String[] args) {
        LoadingCache<String,Object> cache = new CacheBuilderDemo().cacheBuilder();
        cache.put("1","one");
        cache.put("2","two");
        try {
            System.out.println(cache.get("1"));
            //清空指定key
            cache.invalidate("1");
            //获取不到会抛异常
            System.out.println(cache.get("1"));
            cache.put("1","one");
            //清空所有可以
            cache.invalidateAll();
            System.out.println(cache.get("1"));
            cache.put("1","one");
            //超时清空key
            TimeUnit.SECONDS.sleep(5);
            System.out.println(cache.get("1"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public LoadingCache<String,Object> cacheBuilder(){
        LoadingCache<String, Object> cacheBuilder = CacheBuilder.newBuilder()
                .expireAfterWrite(3, TimeUnit.SECONDS)
                .build(new CacheLoader<String, Object>() {
                    @Override
                    public Object load(String key) throws Exception {
                        return null;
                    }
                });
        return cacheBuilder;
    }


}
