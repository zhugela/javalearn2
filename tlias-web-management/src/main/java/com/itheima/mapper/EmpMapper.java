package com.itheima.mapper;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

        /**
         * 查询所有的员工及其对应的部门名称
         */
//    @Select("select e.*, d.name as deptName from emp e left join dept d on e.dept_id = d.id")
//    public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);

        /**
         * 根据查询条件查询员工
         */
        List<Emp> list(EmpQueryParam empQueryParam);
        /**
         * 新增员工数据postsave emp @Requestbody serviceservice shixianzhege save fangfa jibenxingxi yuangongde gongzuojingli xingxi tiaoyongmapper zhijiejiangyuangongduixiangde yuangongxingxizhuanjinqu baochunduixxiangzhiqian localdatetime zhuangjianjiekoufangfa insert zhujie de fbianxieduiyingde insert yuju daijle
         * fenhao username duide duixiangde shuxingzhi linpingzhishanganzhoawanle
         *
         */
        @Options(useGeneratedKeys = true, keyProperty = "id")
        @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
                "values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
        void insert(Emp emp);

        /**
         * 批量删除员工信息
         */
        /**
         * 批量删除员工信息
         */
        void deleteByIds(List<Integer> ids);

        Emp getById(Integer id);

        void updateById(Emp emp);
        /**
         * 统计各个部门的员工数量
         */


        /**
         * 统计各个职位的员工人数
         */
        @MapKey("pos")
        List<Map<String,Object>> countEmpJobData();
        @MapKey("name")
        List<Map> countEmpGenderData();
}

