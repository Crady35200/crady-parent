package com.crady.designpattern.observerDesign;

/**
 * @author :Crady
 * date :2019/7/18 16:39
 * desc :
 **/
public class Teacher extends Observable {

    public void come(){
        System.out.println("老师来了");
        super.notifyObservers();
    }
}
