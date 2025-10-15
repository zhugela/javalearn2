package com.itheima.controller;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.pojo.Student;
import com.itheima.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    /**
     * 学生分页查询
     * @param name  姓名
     * @param clazzId 班级id
     * @param degree  学历
     * @param page  页码
     * @param pageSize 每页显示条数
     * @return 分页结果
     */
     @GetMapping
     public Result Page(
             @RequestParam(required = false) String name,
             @RequestParam(required = false) Integer clazzId,
             @RequestParam(required = false) String degree,
             @RequestParam(defaultValue = "1") Integer page,
             @RequestParam(defaultValue = "10") Integer pageSize
     ){
         PageResult pageResult = studentService.page(name, clazzId, degree, page, pageSize);
         return Result.success(pageResult);
     }

    /**
     * 添加学生
     *
     */
     @PostMapping
     public Result add(@RequestBody Student student){
         studentService.add(student);
         return Result.success();
     }
     /**
      * 根据id查询学生信息
      */
     @GetMapping("/{id}")
     public Result getById(@PathVariable Integer id){
         Student student = studentService.getById(id);
         return Result.success(student);
     }
     /**
      * 修改学生信息
      */
     @PutMapping
     public Result update(@RequestBody Student student){
         studentService.update(student);
         return Result.success();
     }
     /**
      * 删除学生
      */
     @DeleteMapping("/{ids}")
     public Result deleteById(@PathVariable List<Integer> ids){
         studentService.deleteById(ids);
         return Result.success();
     }
     /**
      * 违纪处理
      */
     @PostMapping("/students/violation/{id}/{score}")
     public Result discipline(@PathVariable Integer id, @PathVariable Integer score){
         studentService.violationHandle(id, score);
         return Result.success();
     }

}
