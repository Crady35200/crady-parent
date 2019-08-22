package com.crady.designpattern.factorydesign;

/**
 * author:Crady
 * date:2019/1/16 13:45
 * desc:
 **/
public class BmwCar implements Car {
    @Override
    public void run() {
        System.out.println("BMW is running ...");
    }
}
