package com.crady.demo.controller;

import com.crady.demo.service.UserService;
import com.crady.framework.annotation.CradyAutowire;
import com.crady.framework.annotation.CradyController;
import com.crady.framework.annotation.CradyRequestMapping;
import com.crady.framework.annotation.CradyRequestParam;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author:Crady
 * date:2019/08/10 16:06
 * desc:
 **/
@CradyController
@CradyRequestMapping("user")
@Slf4j
public class UserController {

    @CradyAutowire
    UserService userService;

    @CradyRequestMapping("register")
    public void register(HttpServletRequest request, HttpServletResponse response,
                         @CradyRequestParam("name")String name,@CradyRequestParam("age")Integer age){
        log.info("UserController............register..............");
        userService.register();
        out(response,"用户注册成功,姓名：" + name + ",年龄：" + age);
    }
    @CradyRequestMapping("login.*")
    public void login(HttpServletRequest request, HttpServletResponse response){
        log.info("UserController............login..............");
        out(response,"登录成功");
    }

    private void out(HttpServletResponse response,String msg){
        try {
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
