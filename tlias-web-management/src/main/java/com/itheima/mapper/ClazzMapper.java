package com.itheima.mapper;

import com.itheima.pojo.Clazz;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;
@Mapper
public interface ClazzMapper {
    /**
     * 动态条件查询
     */
    List<Clazz> list(String name, LocalDate begin, LocalDate end);
    /**
     * 新增班级
     */
    @Insert("insert into clazz VALUES (null,#{name},#{room},#{beginDate},#{endDate},#{masterId}, #{subject},#{createTime},#{updateTime})")
    void insert(Clazz clazz);
    /**
     * 根据id查询
     */
    @Select("select * from clazz where id = #{id}")
    Clazz getInfo(Integer id);
    /**
     * 修改班级
     */
    @Insert("update clazz set name = #{name},room = #{room},beginDate = #{beginDate},endDate = #{endDate},masterId = #{masterId},subject = #{subject},updateTime = #{updateTime} where id = #{id}")
    void update(Clazz clazz);
}
