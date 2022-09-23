package com.aleecoder.jdbc.service;

import com.aleecoder.jdbc.pojo.Dept;

import java.util.List;

/**
 * @author HuanyuLee
 * @date 2022/4/3
 */
public interface DeptService {
    int[] deptBatchAdd(List<Dept> depts);

    int[] deptBatchUpdate(List<Dept> depts);

    int[] deptBatchDelete(List<Integer> deptnos);
}
