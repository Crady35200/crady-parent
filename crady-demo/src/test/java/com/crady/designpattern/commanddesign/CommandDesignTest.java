package com.crady.designpattern.commanddesign;

import org.junit.Test;

/**
 * author:Crady
 * date:2019/1/18 15:41
 * desc:
 * 特点：经典的命令模式包括3个角色：
 * Command角色：Command：定义命令的统一接口 MyCommand：Command接口的实现者，用来执行具体的命令，某些情况下可以直接用来充当Receiver。
 * Receiver角色：Receiver接口，Receiver实现类-命令的实际执行者
 * Invoker角色-Invoker：命令的请求者，是命令模式中最重要的角色。这个角色用来对各个命令进行控制。
 *
 * 优点： 1、降低了系统耦合度。 2、新的命令可以很容易添加到系统中去。
 * 缺点：使用命令模式可能会导致某些系统有过多的具体命令类。
 *
 **/
public class CommandDesignTest {

    @Test
    public void test(){
        Receiver executor = new CatReceiver();
        MyCommand myCommand = new MyCommand(executor);
        Invoker invoker = new Invoker(myCommand);
        invoker.invoke();
        System.out.println("******************************************");
        Receiver exe = new DogReceiver();
        MyCommand cmd = new MyCommand(exe);
        Invoker ivk = new Invoker(cmd);
        ivk.invoke();
    }
}