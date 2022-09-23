package com.aleecoder.ioc.xml.dao.impl;

import com.aleecoder.ioc.xml.dao.EmpDao;

/**
 * @author HuanyuLee
 * @date 2022/3/30
 */
public class EmpDaoImpl implements EmpDao {

    @Override
    public int addEmp() {
        System.out.println("addEmp invoked...");
        return 0;
    }
}
