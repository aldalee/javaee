package com.aleecoder.ioc.xml.bean;


import org.springframework.beans.factory.FactoryBean;

/**
 * @author HuanyuLee
 * @date 2022/3/30
 */
public class BookFactory implements FactoryBean<Book> {

    @Override
    public Book getObject() throws Exception {
        return new Book("Spring从入门到精通","Fw");
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
