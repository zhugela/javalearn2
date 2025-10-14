package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.ClazzMapper;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.PageResult;
import com.itheima.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class ClazzSeviceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;
    @Override
    public PageResult page(String name, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);

        List<Clazz> dataList = clazzMapper.list(name,begin,end);
        Page<Clazz> p = (Page<Clazz>) dataList;

        return new PageResult(p.getTotal(), p.getResult());
    }

    @Override
    public void save(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);

    }

    @Override
    public Clazz getInfo(Integer id) {
        return clazzMapper.getInfo(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }
    /**
     * 删除班级
     * 在页面原型中，要求如果该班级下关联的有学生，是不允许删除的，并提示错误信息："对不起, 该班级下有学生, 不能直接删除"。 (提示：可以通过自定义异常 + 全局异常处理器实现)
     */
    @Override
    public void delete(Integer id) {
        clazzMapper.delete(id);
    }
    /**
     * 查询所有班级
     */
    @Override
    public List<Clazz> findAll(){
        return clazzMapper.findAll();
    }
}
