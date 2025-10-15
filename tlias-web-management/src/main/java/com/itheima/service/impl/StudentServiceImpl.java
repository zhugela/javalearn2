package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl  implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    /**
     * 学生分页查询
     */
    @Override
    public PageResult page(String name, Integer clazzId, String degree, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);

        List<Student> studentList = studentMapper.list(name, degree,clazzId);
        Page<Student> p = (Page<Student>) studentList;
        return new PageResult(p.getTotal(), p.getResult());
    }
    /**
     * 添加学生
     */
    @Override
    public void add(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insert(student);
    }
    /**
     * 根据id查询学生信息
     */
    @Override
    public Student getById(Integer id) {
        return studentMapper.getById(id);
    }
     /**
      * 更新学生信息
      */
    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Override
    public void deleteById(List<Integer> ids) {
        studentMapper.deleteById(ids);
    }
    /**
     * 违纪处理
     */
    @Override
    public void violationHandle(Integer id, Integer score) {
        studentMapper.violationHandle(id, score);
    }
}
