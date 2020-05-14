package com.crady.annotation.autowired.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author :Crady
 * date :2020/05/14 14:50
 * desc :
 **/
@Service
public class ServiceA {

    @Autowired
    ServiceB serviceB;

    public void hello(){
        System.out.println("hello A");
        serviceB.say();
    }
}
