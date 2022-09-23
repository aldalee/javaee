package com.aleecoder.junit4;

import com.aleecoder.jdbc.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author HuanyuLee
 * @date 2022/4/4
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JunitTest {
    @Resource
    private AccountService accountService;

    @Test
    public void transaction() {
        int rows = accountService.transMoney(1, 2, 100);
        System.out.println("rows = " + rows);
    }
}
