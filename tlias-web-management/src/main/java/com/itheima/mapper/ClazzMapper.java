package com.itheima.mapper;

import com.itheima.pojo.Clazz;

import java.time.LocalDate;
import java.util.List;

public interface ClazzMapper {
    /**
     * 动态条件查询
     */
    List<Clazz> list(String name, LocalDate begin, LocalDate end);
}
