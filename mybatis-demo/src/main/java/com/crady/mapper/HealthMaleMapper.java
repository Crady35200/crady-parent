package com.crady.mapper;

import com.crady.entity.HealthMaleEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HealthMaleMapper {

    List<HealthMaleMapper> selectByUserId(@Param("userId")String userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_male
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_male
     *
     * @mbg.generated
     */
    int insert(HealthMaleEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_male
     *
     * @mbg.generated
     */
    int insertSelective(HealthMaleEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_male
     *
     * @mbg.generated
     */
    HealthMaleEntity selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_male
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(HealthMaleEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_male
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(HealthMaleEntity record);
}