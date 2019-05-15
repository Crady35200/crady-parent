package com.crady.factorydesign.factoryMethod;

import com.crady.factorydesign.BmwCar;
import com.crady.factorydesign.Car;

/**
 * author:Crady
 * date:2019/5/15 9:39
 * desc:
 **/
public class BmwFactory implements ICarFacrory {
    @Override
    public Car getCar() {
        return new BmwCar();
    }
}
