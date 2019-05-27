package com.crady.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author :Crady
 * date :2019/5/27 14:11
 * desc :
 **/
@Component
@Data
public class User {

    @Value("8")
    private int id;
    @Value("ming")
    private String userName;
}
