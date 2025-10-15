package com.itheima.mapper;

import com.itheima.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentMapper {
    /**
     * 学生分页查询
     */
    List<Student> list(String name, String degree, Integer clazzId);
    /**
     * 添加学生
     */
    @Insert("INSERT INTO student(name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id, create_time, update_time) VALUES (#{name}, #{no}, #{gender}, #{phone}, #{idCard}, #{isCollege}, #{address}, #{degree}, #{graduationDate}, #{clazzId},  #{createTime}, #{updateTime})")
    void insert(Student student);
     /**
      * 根据id查询学生信息
      */
     @Select("SELECT * FROM student WHERE id = #{id}")
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
    @Update("UPDATE student SET violation_count = violation_count + 1, violation_score = violation_score + #{score}, update_time = now() WHERE id = #{id}")
    void violationHandle(Integer id, Integer score);
}
