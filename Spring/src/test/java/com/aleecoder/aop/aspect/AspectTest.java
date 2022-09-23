package com.aleecoder.aop.aspect;

import com.aleecoder.aop.dao.UserDao;
import com.aleecoder.aop.service.UserService;
import com.aleecoder.config.SpringConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author HuanyuLee
 * @date 2022/4/3
 */
public class AspectTest {


    @Test
    public void getBean() {
        // 通过配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = ac.getBean(UserDao.class);
        userDao.addUser(1, "Tom");
        System.out.println(userDao.getClass().getSimpleName());
    }

    @Test
    public void getBean2() {
        // 通过配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserDao userDao = context.getBean(UserDao.class);
        userDao.addUser(1, "Tom");
        System.out.println(userDao.getClass().getSimpleName());
    }

}
