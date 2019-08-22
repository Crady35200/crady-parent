package com.crady.designpattern.singledesign;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * author:Crady
 * date:2019/1/4 16:17
 * desc:
 **/
@Slf4j
public class SingleDesignTest {

    @Test
    public void singleDesign8Test(){
        SingleDesign8.INSTANCE.hello();
    }
    @Test
    public void singleDesign9Test(){
        SingleDesign9.getInstance().hello();
        System.out.println(SingleDesign9.getInstance());
        System.out.println(SingleDesign9.getInstance());
        log.info("{}",SingleDesign9.getInstance());
        log.debug("{}",SingleDesign9.getInstance());
    }



}