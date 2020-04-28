package com.crady.annotation.transaction.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author :Crady
 * date :2020/04/28 21:48
 * desc :
 **/
@Repository
@Slf4j
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public int update(int id,String name){
        String sql = "update t_user set name = '" + name + "' where id = " + id;
        return jdbcTemplate.update(sql);
    }

}
