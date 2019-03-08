package com.crady.commanddesign;

/**
 * author:Crady
 * date:2019/1/18 15:34
 * desc:
 **/
public class MyCommand implements Command {
    private Executor executor;

    public MyCommand(Executor executor) {
        this.executor = executor;
    }

    @Override
    public void dosth() {
        executor.exec();
    }
}
