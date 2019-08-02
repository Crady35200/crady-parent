package com.crady.mapper;

import com.crady.entity.HealthFemaleEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthFemaleMapper {

    List<HealthFemaleMapper> selectByUserId(@Param("userId")String userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_female
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_female
     *
     * @mbg.generated
     */
    int insert(HealthFemaleEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_female
     *
     * @mbg.generated
     */
    int insertSelective(HealthFemaleEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_female
     *
     * @mbg.generated
     */
    HealthFemaleEntity selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_female
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(HealthFemaleEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_female
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(HealthFemaleEntity record);
}