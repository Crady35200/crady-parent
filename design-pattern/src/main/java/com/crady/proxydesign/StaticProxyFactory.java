package com.crady.proxydesign;

/**
 * author:Crady
 * date:2019/1/15 13:46
 * desc:静态代理
 **/
public class StaticProxyFactory implements Person{

    private Teacher teacher;

    public StaticProxyFactory(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public void say(String words) {
        System.out.println("static invoke start ...");
        this.teacher.say(words);
        System.out.println("static invoke end ...");
    }
}
