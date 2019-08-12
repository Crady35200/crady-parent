package com.crady.service;

import com.crady.pojo.User;
import org.apache.ibatis.plugin.Intercepts;

import java.util.List;

/**
 * @author :Crady
 * date :2019/8/12 15:09
 * desc :
 **/
public interface IUserService {

    void createUser(User user);

    User queryUserById(Integer id);

    List<User> queryAllUsers();

}
