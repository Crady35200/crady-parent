package com.crady.designpattern.observerDesign;

import org.junit.Test;

/**
 * @author :Crady
 * date :2019/7/18 16:42
 * desc : 观察者模式，一般应用于订阅-发布，触发器类似场景。
 * 主要有四个角色：被观察者抽象类(Observable),被观察者实现类(Teacher)，观察者接口(Observer)，观察者实现类(StudentA,StudentB)
 * 优点：1、观察者和被观察者之间是抽象耦合
 *       2、建立了一套触发机制
 * 缺点：性能问题，多个观察者时如果一个观察者卡主，后面的都会卡住(可以通过异步来实现)
 * 经典应用：
 **/
public class ObserverTest {

    @Test
    public void observerTest(){
        Observer studentA = new StudentA();
        Observer studentB = new StudentB();
        Teacher teather = new Teacher();
        teather.addObserver(studentA);
        teather.addObserver(studentB);
        teather.come();
    }
}