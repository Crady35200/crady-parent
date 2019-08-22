package com.crady.designpattern.delegateDesign;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :Crady
 * date :2019/5/16 11:23
 * desc :
 **/
@Slf4j
public class Manager implements IExecute {

    private Map<String,IExecute> targets = new HashMap<String,IExecute>();
    public Manager() {
        targets.put("order",new ExecuteA());
        targets.put("pay",new ExecuteB());
    }

    @Override
    public void execute(String function) {
        if ("order".equalsIgnoreCase(function) || "pay".equalsIgnoreCase(function)){
            targets.get(function).execute(function);
        }else {
            log.info("非法参数");
        }
    }
}
