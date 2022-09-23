package com.aleecoder.jdbc.service.impl;

import com.aleecoder.jdbc.dao.EmpDao;
import com.aleecoder.jdbc.pojo.Emp;
import com.aleecoder.jdbc.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HuanyuLee
 * @date 2022/4/3
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Override
    public int findEmpCount() {
        return empDao.findEmpCount();
    }

    @Override
    public Emp findByEmpno(int empno) {
        return empDao.findByEmpno(empno);
    }

    @Override
    public List<Emp> findByDeptno(int deptno) {
        return empDao.findByDeptno(deptno);
    }

    @Override
    public int addEmp(Emp emp) {
        return empDao.addEmp(emp);
    }

    @Override
    public int updateEmp(Emp emp) {
        return empDao.updateEmp(emp);
    }

    @Override
    public int deleteEmp(int empno) {
        return empDao.deleteEmp(empno);
    }
}
