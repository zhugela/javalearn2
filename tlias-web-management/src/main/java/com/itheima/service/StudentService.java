package com.itheima.service;


import com.itheima.pojo.PageResult;

public interface StudentService {
    /**
     * 学生分页查询
     */
     PageResult page(String name, Integer clazzId, String degree, Integer page, Integer pageSize);
}
