package com.crady.designpattern.commanddesign;

/**
 * author:Crady
 * date:2019/1/18 15:34
 * desc:
 **/
public class MyCommand implements Command {
    private Receiver executor;

    public MyCommand(Receiver executor) {
        this.executor = executor;
    }

    @Override
    public void dosth() {
        executor.exec();
    }
}
