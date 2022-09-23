package com.aleecoder.jdbc;

import com.aleecoder.config.SpringConfig;
import com.aleecoder.jdbc.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author HuanyuLee
 * @date 2022/4/4
 */
public class TransactionTest {
    @Test
    public void transaction(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = ac.getBean(AccountService.class);
        int rows = accountService.transMoney(1, 2, 100);
        System.out.println("rows = " + rows);
    }

    @Test
    public void transaction2(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = ac.getBean(AccountService.class);
        int rows = accountService.transMoney(1, 2, 100);
        System.out.println("rows = " + rows);
    }
}
