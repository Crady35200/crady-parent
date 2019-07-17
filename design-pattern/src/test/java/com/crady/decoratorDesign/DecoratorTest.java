package com.crady.decoratorDesign;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author :Crady
 * date :2019/7/17 16:58
 * desc :装饰器模式主要有两个个角色，被装饰者(包含接口和实现)，装饰器(包含抽象类和实现,如果确定只有一个装饰类，则可以不需要抽象类)
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