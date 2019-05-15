package com.crady.factorydesign;

import com.crady.factorydesign.abstractFactory.AbstractFactory;
import com.crady.factorydesign.abstractFactory.DefaultFactory;
import com.crady.factorydesign.factoryMethod.BenzFactory;
import com.crady.factorydesign.factoryMethod.BmwFactory;
import com.crady.factorydesign.simplefactory.SimpleFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * author:Crady
 * date:2019/1/16 13:50
 * desc:
 **/
@Slf4j
public class FactoryDesignTest {

    /**
     * 根据简单工厂的定义，用户只要产品而不在乎产品如何生产，
     * 看起来好像很完美的样子。但大家想想，这个世界存在什么都生产的工厂吗？
     * 显然是不存在的，每一个汽车品牌都有自己的生产工厂，都有自己生产技术。映射到spring框架中，
     * 我们有很多很多种的bean需要生产，如果只依靠一个简单工厂来实现，
     * 那么我们得在工厂类中嵌套多少个if..else if啊？
     * 而且我们在代码中生产一辆汽车只是new一下就出来了，但实际操作中却不知道需要进行多少操作，
     * 加载、注册等操作都将体现在工厂类中，那么这个类就会变得紊乱，管理起来也很不方便，
     * 所以说每个品牌应该有自己的生产类。
     * 因为专一，所以专业嘛，这个时候工厂方法就出现了。
     */
    @Test
    public void simpleFactoryTest(){
        SimpleFactory simpleFactory = new SimpleFactory();
        Car car = simpleFactory.createCar("BMW");
        car.run();
    }

    /**
     * desc:根据上述代码可以看出，不同品牌的汽车是由不同的工厂生产的，
     * 貌似又是很完美的。但大家看一下测试类，当一个人想要去买一辆宝马
     * 汽车的时候（假设没有销售商），那么他就要去找宝马工厂给他生产一
     * 辆，过几天又想要买一辆奔驰汽车的时候，又得跑到奔驰工厂请人生产，
     * 这无疑就增加了用户的操作复杂性。所以有没有一种方便用户操作的方
     * 法呢？这个时候抽象工厂模式就出现了。
     */
    @Test
    public void testFacoryMethod(){
        Car benz = new BenzFactory().getCar();
        log.info("benz:{}",benz);
        Car bmw = new BmwFactory().getCar();
        log.info("bmw:{}",bmw);

    }

    /**
     * 根据上述代码可以看出，用户需要一辆汽车，只需要去找默认的工厂提出自己的需求（传入参数），
     * 便能得到自己想要产品，而不用根据产品去寻找不同的生产工厂，方便用户操作。
     */
    @Test
    public void testAbstractFactory(){
        AbstractFactory defaultFactory = new DefaultFactory();
        log.info("bmw:{}",defaultFactory.getCar());
        log.info("bmw:{}",defaultFactory.getCar("BMW"));
    }

}