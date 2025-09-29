package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import lombok.Data;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobOption {
    private List jobList;
    private List dataList;
}
