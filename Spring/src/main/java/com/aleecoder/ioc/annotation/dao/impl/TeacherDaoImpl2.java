package com.aleecoder.ioc.annotation.dao.impl;

import com.aleecoder.ioc.annotation.dao.TeacherDao;
import org.springframework.stereotype.Repository;

/**
 * @author HuanyuLee
 * @date 2022/3/31
 */
//@Repository
public class TeacherDaoImpl2 implements TeacherDao {
    @Override
    public int add() {
        System.out.println("TeacherDaoImpl2 add......");
        return 0;
    }
}
