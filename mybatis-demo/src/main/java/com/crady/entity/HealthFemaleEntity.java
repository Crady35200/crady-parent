package com.crady.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class HealthFemaleEntity extends BaseEntity {
    private Integer id;
    private Integer userId;
    private BigDecimal bust;
    private BigDecimal waistLine;
    private BigDecimal hipLine;
    private Date crtTime;
}