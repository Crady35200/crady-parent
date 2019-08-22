package com.crady.designpattern.delegateDesign;

import lombok.extern.slf4j.Slf4j;

/**
 * @author :Crady
 * date :2019/5/16 11:21
 * desc :
 **/
@Slf4j
public class ExecuteA implements IExecute {

    @Override
    public void execute(String function) {
      log.info("执行者A,{}功能开发...",function);
    }
}
