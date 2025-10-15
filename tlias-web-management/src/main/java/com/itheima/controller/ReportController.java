package com.itheima.controller;

import com.itheima.pojo.ClazzCountOption;
import com.itheima.pojo.JobOption;
import com.itheima.pojo.Result;
import com.itheima.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;
    @Autowired
    private ListableBeanFactory listableBeanFactory;

    /**
     * 统计各个职位的员工人数
     */

    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计各个职位的员工人数");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }
    /*
    统计各个部门的性别信息
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计各个部门的性别信息");
        List<Map> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }
    /**
     * 统计班级人数
     */
    @GetMapping("/studentCountData")
    public Result getStudentCountDate(){
        log.info("统计班级人数");
        ClazzCountOption studentCountList = reportService. getStudentCountData();
        return Result.success(studentCountList);
    }
    /*
     * 统计学员学历信息
     */
     @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
        log.info("统计学员学历信息");
       List<Map> dataList = reportService. getStudentDegreeData();
        return Result.success(dataList);
    }


}
