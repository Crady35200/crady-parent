package com.crady.commanddesign;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * author:Crady
 * date:2019/1/18 15:41
 * desc:优点： 1、降低了系统耦合度。 2、新的命令可以很容易添加到系统中去。
 * 缺点：使用命令模式可能会导致某些系统有过多的具体命令类。
 **/
public class CommandDesignTest {

    @Test
    public void test(){
        Executor executor = new Executor();
        MyCommand myCommand = new MyCommand(executor);
        Invoker invoker = new Invoker(myCommand);
        invoker.invoke();
    }
}