package com.crady.annotation.assignValue.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * author:Crady
 * date:2019/08/03 10:27
 * desc:
 **/
@Data
public class Crady {

    @Value("Crady")
    private String name;
    @Value("#{30-2}")
    private int age;
    @Value("${crady.addr}")
    private String addr;
}
