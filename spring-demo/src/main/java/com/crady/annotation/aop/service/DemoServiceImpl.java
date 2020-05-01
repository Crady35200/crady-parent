package com.crady.annotation.aop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author :Crady
 * date :2019/8/12 12:08
 * desc :
 **/
@Slf4j
@Service
public class DemoServiceImpl implements DemoService{

    @Override
    public void hello(){
        log.info("*********************hello********************");
    }
}
