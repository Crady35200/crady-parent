package com.crady.singledesign;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * author:Crady
 * date:2019/1/4 16:17
 * desc:
 **/
public class SingleDesignTest {

    @Test
    public void singleDesign8Test(){
        SingleDesign8.INSTANCE.hello();
    }
}