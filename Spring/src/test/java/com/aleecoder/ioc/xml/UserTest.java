package com.aleecoder.ioc.xml;

import com.aleecoder.ioc.xml.bean.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author HuanyuLee
 * @date 2022/3/30
 */
public class UserTest {
    private ApplicationContext ac;
    @Before
    public void init(){
        ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    @Test
    public void getBean(){
        User user = ac.getBean("user", User.class);
        User user2 = ac.getBean("user", User.class);
        System.out.println(user == user2);
        System.out.println(user);
    }

    @Test
    public void testLifeCycle(){
        User user = ac.getBean("user", User.class);
    }

    @After
    public void close(){

    }
}
