package com.crady.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class HealthMaleEntity extends BaseEntity {
    private Integer id;
    private Integer userId;
    private BigDecimal height;
    private BigDecimal weight;
    private BigDecimal eyesight;
    private Date crtTime;
}