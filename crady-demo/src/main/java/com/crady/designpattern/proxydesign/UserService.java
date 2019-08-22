package com.crady.designpattern.proxydesign;

import lombok.extern.slf4j.Slf4j;

/**
 * author:Crady
 * date:2019/1/15 14:13
 * desc:
 **/
@Slf4j
public class UserService {
    public void say(String words){
        log.info("userService say:{}",words);
    }
}
