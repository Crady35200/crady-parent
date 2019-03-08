package com.crady.boot.springbootdemo.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * author:Crady
 * date:2019/1/24 10:58
 * desc:
 **/
@Order(1)
@WebFilter(urlPatterns = "/*",filterName = "demoFilter")
public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("**********DemoFilter init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("**********DemoFilter doFilter start...");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("**********DemoFilter doFilter end...");
    }

    @Override
    public void destroy() {
        System.out.println("**********DemoFilter destroy...");
    }
}
