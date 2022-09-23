package com.aleecoder.jdbc.service.impl;

import com.aleecoder.jdbc.dao.UserDao;
import com.aleecoder.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HuanyuLee
 * @date 2022/4/2
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public int addUser(int userid, String username) {
        System.out.println("UserService add invoke ......");
        return userDao.addUser(userid,username);
    }
}
