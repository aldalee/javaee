package com.aleecoder.jdbc.dao;

import com.aleecoder.jdbc.pojo.Emp;

import java.util.List;

/**
 * @author HuanyuLee
 * @date 2022/4/3
 */
public interface EmpDao {
    /**
     * 查询员工个数的方法
     *
     * @return int 查询数字类型
     */
    int findEmpCount();

    Emp findByEmpno(int empno);

    List<Emp> findByDeptno(int deptno);

    int addEmp(Emp emp);

    int updateEmp(Emp emp);

    int deleteEmp(int empno);
}
