package com.aleecoder.ioc.xml;

import com.aleecoder.ioc.xml.dao.EmpDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author HuanyuLee
 * @date 2022/3/30
 */
public class ContainerTest {
    @Test
    public void getBean(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmpDao empDao = ac.getBean("empDao", EmpDao.class);
        empDao.addEmp();
    }
}
