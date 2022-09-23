package com.aleecoder.ioc.xml;

import com.aleecoder.ioc.xml.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author HuanyuLee
 * @date 2022/3/30
 */
public class StudentTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = ac.getBean("student", Student.class);
        System.out.println(Arrays.toString(student.getBooks()));
        System.out.println(student.getBookSet());
        System.out.println(student.getBookList());
        System.out.println(student.getBookMap());
        System.out.println(student.getBookLists());
    }
}
