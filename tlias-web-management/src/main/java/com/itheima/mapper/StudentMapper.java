package com.itheima.mapper;

import com.itheima.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    /**
     * 学生分页查询
     */
    List<Student> list(String name, String degree, Integer clazzId);
}
