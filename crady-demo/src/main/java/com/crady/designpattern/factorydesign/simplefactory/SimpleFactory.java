package com.crady.designpattern.factorydesign.simplefactory;

import com.crady.designpattern.factorydesign.BenzCar;
import com.crady.designpattern.factorydesign.BmwCar;
import com.crady.designpattern.factorydesign.Car;

/**
 * author:Crady
 * date:2019/1/16 13:47
 * desc:简单工厂的优点：
 *      通过使用工厂类,外界可以从直接创建具体产品对象的尴尬局面摆脱出来,仅仅需要负责“消费”对象就可以了。而不必管这些对象究竟如何创建及如何组织的；
 *      明确了各自的职责和权利，有利于整个软件体系结构的优化；
 *  简单工厂的缺点：
 * 1：扩展性差，增加不同的子类还需要修改工厂方法；
 * 2：不同的产品需要不同的额外参数的时候不支持；
 **/
public class SimpleFactory {

    public Car createCar(String type){
        if("BMW".equalsIgnoreCase(type)){
            return new BmwCar();
        }else if ("Benz".equalsIgnoreCase(type)){
            return new BenzCar();
        }else{
            System.out.println("type error");
            return null;
        }
    }
}
