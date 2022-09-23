package com.aleecoder.ioc.annotation.service.impl;

import com.aleecoder.ioc.annotation.dao.TeacherDao;
import com.aleecoder.ioc.annotation.dao.impl.TeacherDaoImpl1;
import com.aleecoder.ioc.annotation.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author HuanyuLee
 * @date 2022/3/31
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired    // 推荐使用，降低Spring和JDK的耦合度
//    @Qualifier("teacherDaoImpl2")

//    @Resource(name = "teacherDaoImpl1")     // JDK自带的
    private TeacherDao teacherDao;

    // 普通数据类型属性的赋值 8+String
    @Value("${name}")
    private String sname;
    @Value("${gender}")
    private String sgender;
    @Value("${age}")
    private Integer sage;


    @Override
    public void add() {
        teacherDao.add();
        System.out.println("TeacherServiceImpl add......");
        System.out.println("sname = " + sname);
        System.out.println("sgender = " + sgender);
        System.out.println("sage = " + sage);
    }

}
