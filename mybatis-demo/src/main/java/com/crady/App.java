package com.crady;

import com.crady.mapper.UserMapper;
import com.crady.pojo.User;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        String path = App.class.getResource("/").getPath() + "mybatis-config.xml";
        Reader reader = new FileReader(path);
        //        InputStream inputStream = Resources.getResourceAsStream(path);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PageHelper.startPage(2,3);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAllUsers();
        users.forEach(System.out::println);
    }
}
