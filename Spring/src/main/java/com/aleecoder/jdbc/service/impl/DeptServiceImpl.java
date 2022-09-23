package com.aleecoder.jdbc.service.impl;

import com.aleecoder.jdbc.dao.DeptDao;
import com.aleecoder.jdbc.pojo.Dept;
import com.aleecoder.jdbc.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HuanyuLee
 * @date 2022/4/3
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    @Override
    public int[] deptBatchAdd(List<Dept> depts) {
        return deptDao.deptBatchAdd(depts);
    }

    @Override
    public int[] deptBatchUpdate(List<Dept> depts) {
        return deptDao.deptBatchUpdate(depts);
    }

    @Override
    public int[] deptBatchDelete(List<Integer> deptnos) {
        return deptDao.deptBatchDelete(deptnos);
    }
}
