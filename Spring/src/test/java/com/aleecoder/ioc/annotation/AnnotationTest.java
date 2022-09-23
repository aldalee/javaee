package com.aleecoder.ioc.annotation;

import com.aleecoder.config.SpringConfig;
import com.aleecoder.ioc.annotation.bean.Teacher;
import com.aleecoder.ioc.annotation.service.impl.TeacherServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author HuanyuLee
 * @date 2022/3/31
 */
public class AnnotationTest {
    private ApplicationContext ac;

    @Before
    public void init() {
        ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testComponent() {
        Teacher teacher = ac.getBean("teacher", Teacher.class);
        System.out.println(teacher);
    }

    @Test
    public void testController() {
        Teacher teacher = ac.getBean("teacher", Teacher.class);
        System.out.println(teacher);
    }

    @Test
    public void test() {
        TeacherServiceImpl teacherServiceImpl = ac.getBean("teacherServiceImpl", TeacherServiceImpl.class);
        teacherServiceImpl.add();
    }

    @Test
    public void testConfig(){
        // 了解即可
        ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        TeacherServiceImpl teacherServiceImpl = ac.getBean("teacherServiceImpl", TeacherServiceImpl.class);
        teacherServiceImpl.add();
    }
}
