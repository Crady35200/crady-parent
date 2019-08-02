package com.crady.annotation.beanCycle.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * author:Crady
 * date:2019/08/01 23:21
 * desc:
 **/
@Slf4j
public class User implements InitializingBean, DisposableBean, BeanNameAware, ApplicationContextAware, BeanFactoryAware{
    public User() {
        log.info("************User construct*********************");
    }
    public void init(){
        log.info("************init method*********************");
    }
    public void beanDestroy(){
        log.info("************destroy method*********************");
    }

    @Override
    public void afterPropertiesSet() {
        log.info("************InitializingBean-afterPropertiesSet*********************");
    }

    @Override
    public void destroy() {
        log.info("************DisposableBean-destroy*********************");
    }

    //JSR-250规范
    @PostConstruct
    public void postConstruct(){log.info("************JSR-250-postConstruct*********************");}

    //JSR-250规范
    @PreDestroy
    public void preDestroy(){log.info("************JSR-250-PreDestroy *********************");}

    @Override
    public void setBeanName(String name) {
        log.info("*****************BeanNameAware-setBeanName********************************");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("****************ApplicationContextAware-setApplicationContext*****************");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("***********BeanFactoryAware-setBeanFactory*********************");
    }

}
