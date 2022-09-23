package com.aleecoder.jdbc.dao.impl;

import com.aleecoder.jdbc.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author HuanyuLee
 * @date 2022/4/2
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public int addUser(int userid, String username) {
        System.out.println("UserDao add invoke ......");
//        throw new RuntimeException();
        return 0;
    }
}
