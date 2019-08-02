package com.crady.xml;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * author:Crady
 * date:2019/08/03 00:40
 * desc:
 **/
@Slf4j
public class XmlBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("******************postProcessBeforeInitialization************************");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("******************postProcessAfterInitialization************************");
        return bean;
    }
}
