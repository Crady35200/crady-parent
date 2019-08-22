package com.crady.designpattern.factorydesign.factoryMethod;

import com.crady.designpattern.factorydesign.BenzCar;
import com.crady.designpattern.factorydesign.Car;

/**
 * author:Crady
 * date:2019/5/15 9:38
 * desc:
 **/
public class BenzFactory implements ICarFacrory {
    @Override
    public Car getCar() {
        return new BenzCar();
    }
}
