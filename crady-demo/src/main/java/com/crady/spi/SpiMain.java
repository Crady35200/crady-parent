package com.crady.spi;

import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author :Crady
 * date :2019/8/28 17:18
 * desc :  SPI 方式，很好的设计模式，易扩展
 * 步骤：1、创建接口和对应的实现类。
 *       2、在resources/META-INF/services/目录下创建接口全路径文件如：com.crady.spi.People
 *       3、在com.crady.spi.People中填入需要调用的实现类的全路径，如：com.crady.spi.service.CradyService
 **/
public class SpiMain {

    public static void main(String[] args) {
        System.out.println("**************************方式一*********************************");
        test1();
        System.out.println("**************************方式二*********************************");
        test2();
    }

    private static void test1(){
        ServiceLoader<People> services = ServiceLoader.load(People.class);
        Iterator<People> iterator = services.iterator();
        while (iterator.hasNext()){
            People people = iterator.next();
            people.hello(" nice to meet you !");
        }
    }

    private static void test2(){
        Iterator<People> services = Service.providers(People.class);
        while (services.hasNext()){
            People people = services.next();
            people.hello(" nice to meet you !");
        }
    }
}
