package com.crady.annotation.beanCycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * author:Crady
 * date:2019/08/01 23:47
 * desc:
 **/
@Slf4j
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("****************BeanPostProcessor-postProcessBeforeInitialization********************");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("****************BeanPostProcessor-postProcessAfterInitialization********************");
        return bean;
    }
}
