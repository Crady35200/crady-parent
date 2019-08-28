package com.crady.designpattern.commanddesign;

/**
 * author:Crady
 * date:2019/1/18 15:38
 * desc:
 **/
public class CatReceiver implements Receiver{
    @Override
    public void exec(){
        System.out.println("CatReceiver do sth");
    }
}
