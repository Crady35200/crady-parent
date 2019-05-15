package com.crady.proxydesign;

import lombok.extern.slf4j.Slf4j;

/**
 * author:Crady
 * date:2019/1/15 11:27
 * desc:
 **/
@Slf4j
public class Teacher implements IPerson {
    @Override
    public void say(String words) {
        log.info("teacher say:" + words);
    }
}
