package com.aleecoder.jdbc.service;

import com.aleecoder.jdbc.pojo.Emp;

import java.util.List;

/**
 * @author HuanyuLee
 * @date 2022/4/3
 */
public interface EmpService {

    int findEmpCount();

    Emp findByEmpno(int empno);

    List<Emp> findByDeptno(int deptno);

    int addEmp(Emp emp);

    int updateEmp(Emp emp);

    int deleteEmp(int empno);
}
