package com.aleecoder.jdbc.dao;

import com.aleecoder.jdbc.pojo.Dept;

import java.util.List;

/**
 * @author HuanyuLee
 * @date 2022/4/3
 */
public interface DeptDao {
    int[] deptBatchAdd(List<Dept> depts);

    int[] deptBatchUpdate(List<Dept> depts);

    int[] deptBatchDelete(List<Integer> deptnos);
}
