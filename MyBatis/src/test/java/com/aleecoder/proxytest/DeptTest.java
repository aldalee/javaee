package com.aleecoder.proxytest;

import com.aleecoder.mapper.DeptMapper;
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

/**
 * @author HuanyuLee
 * @date 2022/3/27
 */
public class DeptTest {
    private SqlSession sqlSession;
    private DeptMapper deptMapper;

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
        sqlSession = factory.openSession(true);
        deptMapper = sqlSession.getMapper(DeptMapper.class);
    }

    @Test
    public void addDept(){
        Dept dept = new Dept(null,"人力资源部","北京");
        deptMapper.addDept(dept);
        System.out.println(dept.getDeptno());
    }


    @Test
    public void findDeptJoinEmpsByDeptno(){
        final Dept dept = deptMapper.findDeptJoinEmpsByDeptno(20);
        System.out.println(dept);
        dept.getEmps().forEach(System.out::println);
    }

    @Test
    public void findByDeptno(){
        System.out.println(deptMapper.findByDeptno(20));
    }

    @After
    public void release() {
        sqlSession.close();
    }
}
