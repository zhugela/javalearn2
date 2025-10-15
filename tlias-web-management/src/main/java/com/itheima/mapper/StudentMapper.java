package com.itheima.mapper;

import com.itheima.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

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

    /**
     * 查询班级名称数量和班级人数
     * @return
     */
    @Select("select c.name cname , count(s.id) scount from clazz c  left join student s on s.clazz_id = c.id group by c.name order by count(s.id) desc ")
    List<Map<String, Object>> getStudentCount();
    /**
     * 查询学员学历信息
     * @return
     */

    List<Map> getStudentDegreeData();
}
