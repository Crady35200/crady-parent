package com.crady;

import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.junit.Test;

/**
 * @author :Crady
 * date :2019/12/5 10:25
 * desc :
 * 执行顺序：@BeforeClass>@Before>@Test>@After>@AfterClass
 * @AfterClass、@AfterClass修饰的方法必须为静态方法，且只会执行一次。
 * @Before、@After修饰的方法只能是非静态方法，执行一次@Test就会执行一次。
 **/
@Slf4j
public class JUnitAnnotationTest {


    @Test
    public void test(){
        log.info("*******************Test***********************");
    }

    @BeforeClass
    public static void beforeClass(){
        log.info("*******************BeforeClass***********************");
    }

    @Before
    public void before(){
        log.info("*******************Before***********************");
    }

    @AfterClass
    public static void afterClass(){
        log.info("*******************AfterClass***********************");
    }

    @After
    public void after(){
        log.info("*******************After***********************");
    }

}
