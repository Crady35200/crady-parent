package com.crady.factorydesign.factoryMethod;

import com.crady.factorydesign.BenzCar;
import com.crady.factorydesign.Car;

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
