package com.crady;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author :Crady
 * date :2019/5/29 17:48
 * desc :
 **/
public class Demo {

    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("5","5");
        hashMap.put("1","1");
        hashMap.put("4","4");
        hashMap.put("2","2");
        hashMap.put("3","3");
        System.out.println(hashMap);
        printMap(hashMap);
//        TreeMap<String,String> treeMap = new TreeMap<>(hashMap);
//        System.out.println(treeMap);
    }
    public static void printMap(Map<String,String> map){
        System.out.println("***********************************");
        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            String it = iterator.next();
            System.out.println("key=" + it + ",value=" + map.get(it));
        }
        System.out.println("***********************************");
    }
}
