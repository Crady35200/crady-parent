package com.crady.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserAccountEntity extends BaseEntity {
    private Integer id;
    private Integer userId;
    private String accountNo;
    private Date crtTime;
    private Date updTime;
}