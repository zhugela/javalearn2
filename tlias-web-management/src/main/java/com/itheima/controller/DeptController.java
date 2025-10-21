package com.itheima.controller;


import com.itheima.anno.LogOperation;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@RequestMapping("/depts")
@RestController

public class DeptController {

    @Autowired
    private DeptService deptService;
/**
 * 查询所有部门
 */
//    @RequestMapping(value = "/depts",method = RequestMethod.GET)
@GetMapping
    public Result list() {
    System.out.println("查询所有部门");
         List<Dept> deptlist = deptService.findAll();
         return Result.success(deptlist);

    }
    /**
     * 删除部门
     */
//    @DeleteMapping("/depts")
//    public Result delete(HttpServletRequest request) {
//        String idstr = request.getParameter("id");
//        Integer id = Integer.parseInt(idstr);
//        System.out.println("根据ID删除部门"+id);
//        return Result.success();
//    }
//    @DeleteMapping("/depts")
//    //注意事项：一旦我们声明了@RequestParam注解，该参数在传递请求时必须传递id值
//    public Result delete(@RequestParam(value ="id",required = false) Integer deptID) {
//        System.out.println("根据ID删除部门:"+deptID);
//        return Result.success();
//    }
    @LogOperation
    @DeleteMapping
    public Result delete( Integer id) {
        System.out.println("根据ID删除部门:"+id);
        deptService.deleteById(id);
        return Result.success();
    }
    /**
     * 新增部门
     */
    @LogOperation
    @PostMapping
    public Result add(@RequestBody Dept dept) {

        System.out.println("新增部门："+dept);
        deptService.add(dept);
        return Result.success();

    }
    /**
     * 根据ID查询部门
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        System.out.println("根据ID查询部门："+id);
    Dept dept = deptService.getById(id);
    return Result.success(dept);
    }
    /**
     * 修改部门 - PUT http://localhost:8080/depts  请求参数：{"id":1,"name":"研发部"}
     */
    @LogOperation
    @PutMapping
    public Result update(@RequestBody Dept dept){
        System.out.println("修改部门, dept=" + dept);
        deptService.update(dept);
        return Result.success();
    }
}
