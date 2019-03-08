package com.crady.commanddesign;

/**
 * author:Crady
 * date:2019/1/18 15:35
 * desc:
 **/
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }
    public void invoke(){
        command.dosth();
    }
}
