package com.aleecoder.ioc.xml;

import com.aleecoder.ioc.xml.bean.Emp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author HuanyuLee
 * @date 2022/3/31
 */
public class EmpTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Emp emp = ac.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}
