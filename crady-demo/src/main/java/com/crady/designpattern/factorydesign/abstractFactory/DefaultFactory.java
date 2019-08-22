package com.crady.designpattern.factorydesign.abstractFactory;

import com.crady.factorydesign.Car;
import com.crady.factorydesign.factoryMethod.BenzFactory;

/**
 * author:Crady
 * date:2019/5/15 10:38
 * desc:
 **/
public class DefaultFactory extends AbstractFactory {
    @Override
    public Car getCar() {
        return new BenzFactory().getCar();
    }
}
