package com.crady.mapper;

import com.crady.pojo.Job;
import org.springframework.stereotype.Repository;

@Repository
public interface JobMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_job
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_job
     *
     * @mbg.generated
     */
    int insert(Job record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_job
     *
     * @mbg.generated
     */
    int insertSelective(Job record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_job
     *
     * @mbg.generated
     */
    Job selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_job
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Job record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_job
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Job record);
}