package com.itheima.service;

import com.itheima.pojo.PageResult;

import java.time.LocalDate;

public interface ClazzService {
    /**
     * 条件分页查询
     */
    PageResult page(String namem,LocalDate begin,LocalDate end,Integer page,Integer pageSize);
}
