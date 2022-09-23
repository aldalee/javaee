package com.aleecoder.jdbc.dao.impl;

import com.aleecoder.jdbc.dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author HuanyuLee
 * @date 2022/4/4
 */
@Repository
public class AccountDaoImpl implements AccountDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public int transMoney(int aid, int money) {
        String sql = "update account set money = money + ? where aid = ?";
        return jdbcTemplate.update(sql, money, aid);
    }
}
