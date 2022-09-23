package com.aleecoder.jdbc.service.impl;

import com.aleecoder.jdbc.dao.AccountDao;
import com.aleecoder.jdbc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * @author HuanyuLee
 * @date 2022/4/4
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional
    public int transMoney(int from, int to, int money) {
        int rows = 0;
        // 转出操作
        rows += accountDao.transMoney(from, -money);
        // 模拟异常
//        int error = 1/0;

        // 转入操作
        rows += accountDao.transMoney(to, money);
        return rows;
    }
}
