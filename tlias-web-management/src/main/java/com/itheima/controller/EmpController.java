package com.itheima.controller;


import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;
/**
 * 分页查询
 */
    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("查询请求参数： {}", empQueryParam);
        PageResult pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);

    }
    /**
     * 添加员工
     */
    @PostMapping
    public Result save(@RequestBody Emp emp) throws Exception {
        log.info("请求参数emp: {}", emp);
        empService.save(emp);
        return Result.success();
    }
    /*
    删除员工
     */
    /**
     * 批量删除员工
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("批量删除部门: ids={} ", ids);
        empService.deleteByIds(ids);
        return Result.success();
    }
    /*
    查询回显
     */
    @GetMapping("/{id}")
    public Result getinfo(@PathVariable Integer id){
        log.info("查询回显: id={} ", id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }
    /**
     * 更新员工信息
     */
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工信息, {}", emp);
        empService.update(emp);
        return Result.success();
    }
    /**
     * 查询所有员工
     */
    @GetMapping("/list")
    public Result list(){
        log.info("查询所有员工");
        List<Emp> list = empService.list();
        return Result.success(list);
    }
}



