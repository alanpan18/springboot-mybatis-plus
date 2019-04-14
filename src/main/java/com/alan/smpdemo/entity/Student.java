package com.alan.smpdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author alanpan
 * @title: School
 * @projectName springboot-mybatis-plus
 * @description: TODO 学生实体
 * @date 2019/4/1414:03
 */
@Data
@TableName("student")
public class Student implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField("name")
    private String name;

    @TableField("school")
    private String school;

    @TableField("city")
    private String city;

    @TableField("address")
    private String address;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private Timestamp createTime;

}
