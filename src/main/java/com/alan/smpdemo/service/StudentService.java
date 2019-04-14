package com.alan.smpdemo.service;

import com.alan.smpdemo.entity.Student;
import com.alan.smpdemo.mapper.StudentMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author alanpan
 * @title: StudentService
 * @projectName springboot-mybatis-plus
 * @description: TODO
 * @date 2019/4/1415:56
 */
@Service
public class StudentService extends ServiceImpl<StudentMapper,Student> implements IStudentService{

    @Override
    public Page<Student> getUserPage() {
        return (Page<Student>) page(new Page<>(1,5));
    }
}
