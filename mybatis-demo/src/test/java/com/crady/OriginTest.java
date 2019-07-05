package com.crady;

import com.crady.entity.UserEntity;
import com.crady.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * author:Crady
 * date:2019/07/05 23:25
 * desc:
 **/
public class OriginTest {
    Logger logger = LoggerFactory.getLogger(OriginTest.class);

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-origin-config.xml"));
        return build;
    }

    /**
     * 一级缓存测试，sqlSession级别
     * @throws IOException
     */
    @Test
    public void cacheOneLevelTest() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        List<UserEntity> userEntities1 = userMapper.selectAll();
        logger.info("**********userEntities1={}",userEntities1);

        List<UserEntity> userEntities2 = userMapper.selectAll();
        logger.info("**********userEntities2={}",userEntities2);

        UserEntity ue = new UserEntity();
        ue.setId(4);
        ue.setName("Four");
        userMapper.updateByPrimaryKeySelective(ue);

        List<UserEntity> userEntities3 = userMapper.selectAll();
        logger.info("**********userEntities3={}",userEntities3);
    }

    /**
     * 二级缓存，sqlSessionFactory级别
     * @throws IOException
     */
    @Test
    public void cacheTwoLevelTest() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        UserMapper userMapper1= sqlSession1.getMapper(UserMapper.class);
        List<UserEntity> userEntities1 = userMapper1.selectAll();
        logger.info("**********userEntities1={}",userEntities1);

        List<UserEntity> userEntities11 = userMapper1.selectAll();
        logger.info("**********userEntities11={}",userEntities11);

        sqlSession1.close();//不关闭sqlSession1的话，sqlSession2不会走缓存

        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        UserMapper userMapper2= sqlSession2.getMapper(UserMapper.class);
        List<UserEntity> userEntities2 = userMapper2.selectAll();
        logger.info("**********userEntities2={}",userEntities2);

        UserEntity ue = new UserEntity();
        ue.setId(4);
        ue.setName("Four");
        userMapper2.updateByPrimaryKeySelective(ue);

        sqlSession2.close();

        SqlSession sqlSession3 = sqlSessionFactory.openSession(true);
        UserMapper userMapper3= sqlSession3.getMapper(UserMapper.class);
        List<UserEntity> userEntities3= userMapper3.selectAll();
        logger.info("**********userEntities3={}",userEntities3);
    }
}
