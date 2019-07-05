package com.crady;

import static org.junit.Assert.assertTrue;

import com.crady.entity.UserEntity;
import com.crady.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AppTest 
{
    private static final Logger logger = LoggerFactory.getLogger(AppTest.class);

    @Autowired
    private UserMapper userMapper;
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void simpleQueryTest(){
        UserEntity userEntity = userMapper.selectByPrimaryKey(3);
        logger.info("【根据主键查询结果】:{}",userEntity);
        List<UserEntity> userEntities = userMapper.selectAll();
        logger.info("【全表查询结果】:{}",userEntities);

        List<Integer> ids_list = new ArrayList<>();
        ids_list.add(1);
        ids_list.add(3);
        ids_list.add(5);
        List<UserEntity> userList = userMapper.selectByIdList(ids_list);
        logger.info("【根据List查询-selectByIdList查询结果】:{}",userList);

        Integer[] ids_array = new Integer[]{2,4,6};
        List<UserEntity> userArray = userMapper.selectByIdArray(ids_array);
        logger.info("【根据数组查询-selectByIdArray查询结果】:{}",userArray);

        List<UserEntity> userChooseDemo = userMapper.selectChooseDemo("",null);
        logger.info("【根据Choose查询-selectChooseDemo查询结果】:{}",userChooseDemo);

    }

    /**
     * 嵌套查询1：1
     */
    @Test
    public void complexQueryTest(){
        logger.info("【嵌套结果查询(1:1)】开始...");
        UserEntity userEntity = userMapper.selectUserAccount1(null,"crady");
        logger.info("【嵌套结果查询(1:1)-selectUserAccount查询结果】:{}",userEntity);
        logger.info("【嵌套结果查询(1:1)】结束");

        logger.info("【嵌套SQL查询(1:1) + 懒加载】开始...");
        List<UserEntity> userEntitys = userMapper.selectUserAccount2(new Integer[]{1,3,5});
//        logger.info("【嵌套SQL查询(1:1)+延时加载-selectUserAccount2查询结果】:{}",userEntitys);
        for(UserEntity ue : userEntitys){
//            logger.info("{}",ue.getUserAccountEntity());
            logger.info("{}",ue.getName());//如此次为关联对象 ue.getUserAccountEntity() 则会打印SQL语句
        }
        logger.info("【嵌套SQL查询(1:1) + 懒加载】结束");
    }
    /**
     * 嵌套查询1：N
     */
    @Test
    public void complexQueryTest2(){
        logger.info("【嵌套结果查询(1:N)】开始...");
        UserEntity userEntity = userMapper.selectUserJob1(1);
        logger.info("【嵌套结果查询(1:N)-selectUserJob1查询结果】:{}",userEntity);
        logger.info("【嵌套结果查询(1:N)】结束");

        logger.info("【嵌套SQL查询(1:N) + 懒加载】开始...");
        List<UserEntity> userEntities = userMapper.selectUserJob2(new Integer[]{1,3,5});
        for (UserEntity ue : userEntities){
//            logger.info("{}",ue.getJobEntities());
            logger.info("{}",ue.getName());//如此次为关联对象 ue.getJobEntities() 则会打印SQL语句
        }
        logger.info("【嵌套SQL查询(1:N) + 懒加载】结束");
    }

    @Test
    public void descriminatorTest(){
        List<UserEntity> userEntities = userMapper.selectUserHealth(new Integer[]{1,2,3,4});
        for (UserEntity userEntity : userEntities){
            logger.info("============={}",userEntity);
        }
    }

    @Test
    public void cacheTest(){
        UserEntity userEntity1 = userMapper.selectByPrimaryKey(3);
        logger.info("userEntity1={}",userEntity1);
        UserEntity userEntity2 = userMapper.selectByPrimaryKey(3);
        logger.info("userEntity2={}",userEntity2);
    }

    @Test
    public void insertTest(){
/*        UserEntity userEntity = new UserEntity();
        userEntity.setName("pig");
        userEntity.setPassword("666555");
        userEntity.setSex("0");
        userMapper.insertSelectiveGetId(userEntity);
        logger.info("【插入获取ID-insertSelective 查询结果】:{}",userEntity);*/

       List<UserEntity> userEntities = new ArrayList<>();
       UserEntity userEntity1= new UserEntity();
       userEntity1.setName("batch01");
       userEntity1.setPassword("password01");
       userEntity1.setAge(10);
       UserEntity userEntity2= new UserEntity();
       userEntity2.setName("batch01");
       userEntity2.setPassword("password01");
       userEntity2.setAge(10);
       userEntities.add(userEntity1);
       userEntities.add(userEntity2);
       userMapper.insertBatchGetId(userEntities);
        logger.info("【批量插入获取ID-insertBatchGetId 查询结果】:{}",userEntities);

    }

}
