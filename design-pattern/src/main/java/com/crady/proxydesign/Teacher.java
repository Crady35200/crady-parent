package com.crady.proxydesign;

/**
 * author:Crady
 * date:2019/1/15 11:27
 * desc:
 **/
public class Teacher implements Person {
    @Override
    public void say(String words) {
        System.out.println("teacher say:" + words);
    }
}
