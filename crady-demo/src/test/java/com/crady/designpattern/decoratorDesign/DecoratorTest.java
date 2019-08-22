package com.crady.designpattern.decoratorDesign;

import org.junit.Test;

/**
 * @author :Crady
 * date :2019/7/17 16:58
 * desc :装饰器模式主要只为了增强被装饰着功能，有四个角色，被装饰者接口或者抽象类，被装饰者实现类，
 * 装饰着接口或抽象类，装饰者实现类
 * JDK中的InputStream,OutputStream,Reader,Writer接口，还有Mybatis中的缓存都是装饰器中的经典应用。
 **/
public class DecoratorTest {

    @Test
    public void DecoratorTest(){
        ISource iSource = new SourceImpl();
        iSource.hello();
        System.out.println("**************************************************************");
        iSource = new MorningDecorator(iSource);
        iSource.hello();
        System.out.println("**************************************************************");
        iSource = new EatDecorator(iSource);
        iSource.hello();
    }

}