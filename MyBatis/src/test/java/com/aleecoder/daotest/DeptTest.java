package com.aleecoder.daotest;

import com.aleecoder.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author HuanyuLee
 * @date 2022/3/26
 */
public class DeptTest {
    private SqlSession sqlSession;

    @Before
    public void init() {
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory = ssfb.build(resourceAsStream);
        sqlSession = factory.openSession();
    }

    @Test
    public void findAll() {
        final List<Dept> list = sqlSession.selectList("com.aleecoder.mapper.DeptMapper.findAll");
        list.forEach(System.out::println);
    }

    @After
    public void release() {
        sqlSession.close();
    }
}
