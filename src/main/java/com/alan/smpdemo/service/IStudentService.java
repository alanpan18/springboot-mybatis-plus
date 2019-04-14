package com.alan.smpdemo.service;

import com.alan.smpdemo.entity.Student;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author alanpan
 * @title: IStudentService
 * @projectName springboot-mybatis-plus
 * @description: 学生接口
 * @date 2019/4/1415:55
 */
public interface IStudentService extends IService<Student> {

    public IPage<Student> getUserPage();
}
