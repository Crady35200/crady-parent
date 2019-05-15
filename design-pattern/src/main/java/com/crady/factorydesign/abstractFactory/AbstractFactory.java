package com.crady.factorydesign.abstractFactory;

import com.crady.factorydesign.Car;
import com.crady.factorydesign.factoryMethod.BenzFactory;
import com.crady.factorydesign.factoryMethod.BmwFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * author:Crady
 * date:2019/5/15 10:35
 * desc:
 **/
@Slf4j
public abstract class AbstractFactory {
    public abstract Car getCar();
    public Car getCar(String type){
        if("BENZ".equalsIgnoreCase(type)){
            return new BenzFactory().getCar();
        }else if("BMW".equalsIgnoreCase(type)){
            return new BmwFactory().getCar();
        }else{
            log.info("非法参数");
        }
        return null;
    }
}
