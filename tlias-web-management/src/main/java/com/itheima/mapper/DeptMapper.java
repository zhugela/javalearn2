package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询所有部门信息
     *
     */
    //方式一
    @Results(
            {
                    @Result( column = "create_time", property = "createTime"),
                    @Result( column = "update_time", property = "updateTime")
            }
    )
    @Select("select id, name, create_time createtime, update_time from dept order by update_time desc")
    List<Dept> findAll();

    /**
     *
     * 根据id删除部门
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);
    /**
     * 添加部门
     */
    @Insert("INSERT  INTO dept(name,create_time,update_time) VALUES (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);
    /**
     * 根据id查询部门
     */
    @Select("select id, name, create_time createtime, update_time from dept where id = #{id}")
    Dept getById(Integer id);
    /**
     * 更新部门
     */
    @Update("update dept set name = #{name},update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}