package com.crady.service.impl;

import com.crady.mapper.UserMapper;
import com.crady.pojo.User;
import com.crady.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author :Crady
 * date :2019/8/12 15:09
 * desc :
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    public UserMapper userMapper;

    @Transactional
    @Override
    public void createUser(User user) {
        if(null != user){
            userMapper.insert(user);
            int i = 1/0;//测试事务用
        }
    }

    @Override
    public User queryUserById(Integer id) {
        if(id != null){
            return userMapper.selectByPrimaryKey(id);
        }
        return null;
    }

    @Override
    public List<User> queryAllUsers() {
        return userMapper.selectAll();
    }
}
