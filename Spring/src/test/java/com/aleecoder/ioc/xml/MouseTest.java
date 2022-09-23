package com.aleecoder.ioc.xml;

import com.aleecoder.ioc.xml.bean.Cat;
import com.aleecoder.ioc.xml.bean.Mouse;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author HuanyuLee
 * @date 2022/3/30
 */
public class MouseTest {
    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Mouse mouse = ac.getBean("mouse", Mouse.class);
        Cat cat = ac.getBean("cat", Cat.class);
        System.out.println(cat);
    }
}
