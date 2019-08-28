package com.crady.spi.service;

import com.crady.spi.People;
import lombok.extern.slf4j.Slf4j;

/**
 * @author :Crady
 * date :2019/8/28 17:17
 * desc :
 **/
@Slf4j
public class ChouService implements People {

    @Override
    public void hello(String msg) {
        log.info("Chou say : {}",msg);
    }
}
