package com.itheima.controller;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    /**
     * 学生分页查询
     * @param name  姓名
     * @param clazzId 班级id
     * @param degree  学历
     * @param page  页码
     * @param pageSize 每页显示条数
     * @return 分页结果
     */
     @GetMapping
     public Result Page(
             @RequestParam(required = false) String name,
             @RequestParam(required = false) Integer clazzId,
             @RequestParam(required = false) String degree,
             @RequestParam(defaultValue = "1") Integer page,
             @RequestParam(defaultValue = "10") Integer pageSize
     ){
         PageResult pageResult = studentService.page(name, clazzId, degree, page, pageSize);
         return Result.success(pageResult);
     }



}
