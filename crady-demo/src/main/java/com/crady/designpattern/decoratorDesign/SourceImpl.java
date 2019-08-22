package com.crady.designpattern.decoratorDesign;

/**
 * @author :Crady
 * date :2019/7/17 16:53
 * desc :
 **/
public class SourceImpl implements ISource {

    @Override
    public void hello() {
        System.out.println("hello,nice to meet you !");
    }
}
