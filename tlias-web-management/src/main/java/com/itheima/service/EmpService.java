package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.LoginInfo;
import com.itheima.pojo.PageResult;

import java.util.List;

public interface EmpService {
    /**
     * 分页查询
     */



        //PageResult page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
        PageResult page(EmpQueryParam empQueryParam);

    void save(Emp emp) throws Exception;
    /*
    删除员工数据
     */

    /**
     * 批量删除员工
     */
    void deleteByIds(List<Integer> ids);

    Emp getInfo(Integer id);

    /**
     * 更新员工信息
     * @param emp
     */
    void update(Emp emp);
/**
 * 查询员工数据
 */
    List<Emp> list();
    /**
     * 员工登录
     */
    LoginInfo login(Emp emp);
}

