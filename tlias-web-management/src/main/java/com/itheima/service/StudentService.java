package com.itheima.service;


import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;

import java.util.List;

public interface StudentService {
    /**
     * 学生分页查询
     */
     PageResult page(String name, Integer clazzId, String degree, Integer page, Integer pageSize);
    /**
     * 添加学生
     */
    void add(Student student);
    /**
     * 根据id查询学生信息
     */
    Student getById(Integer id);
    /**
     * 更新学生信息
     */
    void update(Student student);
    /**
     * 根据id批量删除学生
     */
    void deleteById(List<Integer> ids);
    /**
     * 违纪处理
     */
    void violationHandle(Integer id, Integer score);
}
