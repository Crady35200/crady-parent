package com.crady.service.impl;

import com.crady.mapper.UserMapper;
import com.crady.pojo.User;
import com.crady.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

    @Cacheable(value = "redisCache",key = "'user_' + #id")
    @Override
    public User queryUserById(Integer id) {
        if(id != null){
            return userMapper.selectByPrimaryKey(id);
        }
        return null;
    }

    @CachePut
    @Override
    public List<User> queryAllUsers() {
        return userMapper.selectAll();
    }

    @Override
    public void updateUser(User user) {
        if(null != user && user.getId() != null){
            userMapper.updateByPrimaryKeySelective(user);
        }
    }

    @Override
    public User updateUserNameById(Integer id, String name) {
        User user = this.queryUserById(id);
        user.setName(name);
        this.updateUser(user);
        return user;
    }
}
