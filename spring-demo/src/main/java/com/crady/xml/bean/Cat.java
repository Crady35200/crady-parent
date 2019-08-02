package com.crady.xml.bean;

import lombok.extern.slf4j.Slf4j;

/**
 * author:Crady
 * date:2019/08/01 23:08
 * desc:
 **/
@Slf4j
public class Cat {
    public Cat() {
        log.info("***********Cat construction********************");
    }

    public void init(){
        log.info("***********Cat init********************");
    }
    public void destroy(){
        log.info("***********Cat destroy********************");
    }
}
