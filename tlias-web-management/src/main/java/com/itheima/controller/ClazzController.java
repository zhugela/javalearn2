package com.itheima.controller;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j

@RestController
@RequestMapping("/clazzs")
 public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    /**
     * 根据条件分页查询
     */
    @GetMapping
    public Result page(String name ,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin ,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,
                       @RequestParam(defaultValue = "1") Integer page ,
                       @RequestParam(defaultValue = "10")Integer pageSize){
        PageResult pageResult = clazzService.page(name , begin , end , page , pageSize);
        return  Result.success(pageResult);
    }
    /*
       新增班级
     */
    @PostMapping
    public Result save(@RequestBody Clazz clazz){
        log.info("新增班级：{}", clazz);
        clazzService.save(clazz);
        return Result.success();
    }
    /**
     * 根据id查询
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据id查询：{}",id);
        Clazz clazz = clazzService.getInfo(id);
        return Result.success(clazz);
    }
    /*
     * 修改班级
     *
     */
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("修改班级：{}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }
    /**
     * 删除班级
     * 在页面原型中，要求如果该班级下关联的有学生，是不允许删除的，并提示错误信息："对不起, 该班级下有学生, 不能直接删除"。 (提示：可以通过自定义异常 + 全局异常处理器实现)
     */
     @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除班级：{}", id);
        clazzService.delete(id);
        return Result.success();
    }

}
