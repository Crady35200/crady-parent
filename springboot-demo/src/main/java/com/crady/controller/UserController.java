package com.crady.controller;

import com.crady.pojo.User;
import com.crady.service.IUserService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author :Crady
 * date :2019/8/12 15:08
 * desc :
 **/
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping("getAllUsers")
    public List<User> getAllUsers(Integer startPage, Integer pageSize){
        PageHelper.startPage(startPage,pageSize);
        List<User> users = userService.queryAllUsers();
        log.info("users={}",users);
        return users;
    }

    @RequestMapping("getUserById")
    public Object getUserById(@Valid Integer id){
        User user = userService.queryUserById(id);
        log.info("add user ={}",user);
        return user;
    }

    @RequestMapping("addUser")
    public String addUser(){
        User user = User.builder().name("john").password("j1232").age(18).sex("0").build();
        userService.createUser(user);
        log.info("add user ={}",user);
        return "add success";
    }

    @RequestMapping("addUserNameById")
    public String addUserNameById(Integer id,String name){
        User user = User.builder().name("john").password("j1232").age(18).sex("0").build();
        userService.createUser(user);
        log.info("add user ={}",user);
        return "add success";
    }
}
