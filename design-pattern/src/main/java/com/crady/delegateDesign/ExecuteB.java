package com.crady.delegateDesign;

import lombok.extern.slf4j.Slf4j;

/**
 * @author :Crady
 * date :2019/5/16 11:22
 * desc :
 **/
@Slf4j
public class ExecuteB implements IExecute {

    @Override
    public void execute(String function) {
        log.info("执行者B,{}功能开发...",function);
    }
}
