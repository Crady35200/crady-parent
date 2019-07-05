package com.crady.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class UserEntity extends BaseEntity {

    private Integer id;
    private String name;
    private String password;
    private Integer age;
    private String sex;
    private UserAccountEntity userAccountEntity;
    private List<JobEntity> jobEntities;

}