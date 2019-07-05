package com.crady.entity;

import lombok.Data;

import java.util.Date;

@Data
public class JobEntity extends BaseEntity {

    private Integer id;
    private String companyName;
    private Date startTime;
    private Date endTime;
    private Integer userId;
}