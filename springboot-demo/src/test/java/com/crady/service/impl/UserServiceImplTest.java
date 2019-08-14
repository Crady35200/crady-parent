package com.crady.service.impl;

import com.crady.pojo.User;
import com.crady.service.IUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author :Crady
 * date :2019/8/14 16:57
 * desc :
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    IUserService userService;

    @Test
    public void createUser() {
    }

    @Test
    public void queryUserById() {
        User user = userService.queryUserById(8);
        System.out.println("**********user=" + user);
        Assert.assertNotNull(user);
    }

    @Test
    public void queryAllUsers() {
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void updateUserNameById() {
    }
}