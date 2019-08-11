package com.crady.demo.service.impl;

import com.crady.demo.service.UserService;
import com.crady.framework.annotation.CradyService;
import lombok.extern.slf4j.Slf4j;

/**
 * author:Crady
 * date:2019/08/10 16:06
 * desc:
 **/
@CradyService
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public void register(){
        log.info("register....");
    }

}
