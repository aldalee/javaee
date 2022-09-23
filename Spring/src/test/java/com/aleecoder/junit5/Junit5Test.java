package com.aleecoder.junit5;

import com.aleecoder.config.SpringConfig;
import com.aleecoder.jdbc.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.annotation.Resource;

/**
 * @author HuanyuLee
 * @date 2022/4/4
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Junit5Test {

    @Resource
    private AccountService accountService;

    @Test
    public void transaction() {
        int rows = accountService.transMoney(1, 2, 100);
        System.out.println("rows = " + rows);
    }
}
