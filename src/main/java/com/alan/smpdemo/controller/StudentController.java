package com.alan.smpdemo.controller;

import com.alan.smpdemo.entity.Student;
import com.alan.smpdemo.service.IStudentService;
import com.alan.smpdemo.service.StudentService;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author alanpan
 * @title: StudentControlle
 * @projectName springboot-mybatis-plus
 * @description: TODO
 * @date 2019/4/1415:07
 */
@Controller
public class StudentController {

    @Autowired
    IStudentService iStudentService;

    @GetMapping(value = "student")
    @ResponseBody
    public String list()
    {
       long start = System.currentTimeMillis();
       List<Student> list = iStudentService.getUserPage().getRecords();
       System.currentTimeMillis();
       return JSON.toJSONString(list);
    }
}
