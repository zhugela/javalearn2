package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl  implements DeptService
{
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }
    /**- 删除部门时：如果部门下有员工，则不允许删除该部门，并给前端提示错误信息：对不起，当前部门下有员工，不能直接删除！
     */
    @Override
    public void deleteById(Integer id) {
        //1.判断当前部门下是否有员工
        Integer count = empMapper.countEmpByDeptId(id);
        if(count > 0){
            //2.如果有员工，则不允许删除该部门
            throw new RuntimeException("对不起，当前部门下有员工，不能直接删除！");
        }
        //3.如果没有员工，则允许删除该部门
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        //1.补全基础属性
        dept.setUpdateTime(LocalDateTime.now());
        //2.调用mapper
            deptMapper.update(dept);
    }
}