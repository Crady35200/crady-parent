package com.crady.factorydesign;

import com.crady.factorydesign.simplefactory.SimpleFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * author:Crady
 * date:2019/1/16 13:50
 * desc:
 **/
public class FactoryDesignTest {

    @Test
    public void simpleFactoryTest(){
        SimpleFactory simpleFactory = new SimpleFactory();
        Car car = simpleFactory.createCar("BMW");
        car.run();
    }

}