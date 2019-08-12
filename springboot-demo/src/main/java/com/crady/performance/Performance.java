package com.crady.performance;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author:Crady
 * date:2019/1/18 10:09
 * desc:
 **/
@RestController
@RequestMapping("pfm")
public class Performance {
    @RequestMapping("cpu")
    public void cpuPfm(){
        while (true){

        }
    }
}
