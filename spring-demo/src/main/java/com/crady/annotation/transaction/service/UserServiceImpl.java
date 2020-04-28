package com.crady.annotation.transaction.service;

import com.crady.annotation.transaction.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author :Crady
 * date :2020/04/28 21:48
 * desc :  测试用例，用于spring事务源码阅读
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    @Transactional
    public void updateUserName(int id,String name){
        int result = userDao.update(id,name);
        log.info("更新成功");
        throw new RuntimeException("模拟报错");
    }
}
