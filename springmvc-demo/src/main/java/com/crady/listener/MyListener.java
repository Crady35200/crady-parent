package com.crady.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * author:Crady
 * date:2019/08/20 22:53
 * desc:
 **/
@Slf4j
public class MyListener implements ServletContextListener {

    private ServletContext context = null;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("****************init MyListener****************************");
        this.context = sce.getServletContext();
        context.setAttribute("title","this is MyListener...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        context = null;
    }
}
