package com.crady.designpattern.factorydesign;

/**
 * author:Crady
 * date:2019/1/16 13:46
 * desc:
 **/
public class BenzCar implements Car {
    @Override
    public void run() {
        System.out.println("Benz is running ...");
    }
}
