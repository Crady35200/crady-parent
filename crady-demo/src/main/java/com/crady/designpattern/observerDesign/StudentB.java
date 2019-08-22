package com.crady.designpattern.observerDesign;

/**
 * @author :Crady
 * date :2019/7/18 16:40
 * desc :
 **/
public class StudentB implements Observer {

    @Override
    public void update() {
        System.out.println("StudentB stop talking...");
    }
}
