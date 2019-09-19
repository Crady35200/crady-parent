package com.crady.annotation.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author :Crady
 * date :2019/8/12 11:43
 * desc :
 **/
@Aspect
@Slf4j
@Component
public class MyAspect{


    @Pointcut("execution(* com.crady.annotation.aop..*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void before(){
        log.info("************before**************");
    }
    @After("pointcut()")
    public void after(){
        log.info("************after**************");
    }
    @AfterThrowing("pointcut()")
    public void afterThrowing(){
        log.info("************afterThrowing**************");
    }

    @AfterReturning("pointcut()")
    public void afterReturning(){
        log.info("************afterReturning**************");
    }
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint){
        log.info("************around before**************");
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        log.info("************around after**************");
        return result;
    }



}
