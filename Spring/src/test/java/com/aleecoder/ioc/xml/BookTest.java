package com.aleecoder.ioc.xml;

import com.aleecoder.ioc.xml.bean.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 工厂方式获取bean
 * @author HuanyuLee
 * @date 2022/3/30
 */
public class BookTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Book book = ac.getBean("bookFactory", Book.class);
        System.out.println(book);
    }
}
