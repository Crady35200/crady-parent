package com.crady.util;


import com.crady.pojo.User;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :Crady
 * date :2019/8/13 10:05
 * desc : Map操作工具类
 **/
public class MapUtil {

    public static void main(String[] args) {
        User user = User.builder().id(1).name("cat").password("a222").age(30).sex("0").build();
        System.out.println(user);
        Map<String,Object> map = objectToMap(user);
        System.out.println(map);
        System.out.println(mapToObject(map,User.class));

    }


    /**
     * 把一个对象转为MAP
     * @param obj
     * @return
     */
    public static Map<String,Object> objectToMap(Object obj){
        Map<String,Object> map = new HashMap<>();
        if(null == obj){
            return map;
        }
        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        for(Field field : fields){
            try {
                field.setAccessible(true);
                map.put(field.getName(),field.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    /**
     * 讲一个Map转为指定类型对象
     * @param map
     * @param cls
     * @return
     */
    public static Object mapToObject(Map<String,Object> map,Class<?> cls){
        Object o = null;
        try {
             o = cls.newInstance();
            Field[] fields = cls.getDeclaredFields();
            for(Field field : fields){
                field.setAccessible(true);
                field.set(o,map.get(field.getName()));
            }
            return o;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return o;
    }
}
