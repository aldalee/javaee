package com.aleecoder.daotest;

import com.aleecoder.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author HuanyuLee
 * @date 2022/3/26
 */
public class EmpTest {
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
        // 增删改 要提交事务
        // sqlSession.commit();手动提交事务
        // sqlSession = factory.openSession(true); 设置事务自动提交
        sqlSession = factory.openSession(true);
    }

    @Test
    public void selectEmp() {
        Emp emp = sqlSession.selectOne("findByEmpno",7521);
        System.out.println(emp);
    }

    @Test
    public void selectList() {
        List<Emp> list = sqlSession.selectList("com.aleecoder.mapper.EmpMapper.findAll");
        list.forEach(System.out::println);
    }

    @Test
    public void selectMap() {
        // empno参数作为Map的key
        Map<Integer, Emp> empMap = sqlSession.selectMap("findEmpMap", "empno");
        Set<Integer> empnos = empMap.keySet();
        for (Integer empno : empnos) {
            System.out.println(empno + ":" + empMap.get(empno));
        }
    }

    @Test
    public void selectMapArgs(){
        // Map集合作为参数
        Map<String,Object> args = new HashMap<>();
        args.put("deptno",20);
        args.put("sal",1500.0);
        final List<Object> list = sqlSession.selectList("findEmpByDS",args);
        list.forEach(System.out::println);
    }

    @Test
    public void selectMapArgs2(){
        // Emp对象作为参数
        Emp emp = new Emp();
        emp.setDeptno(10);
        emp.setSal(1500.0);
        final List<Object> list = sqlSession.selectList("findEmpByDS",emp);
        list.forEach(System.out::println);
    }


    @Test
    public void insertEmp(){
        Emp emp =new Emp(null,"按住啦Baby","SALESMAN",7839,new Date(),3100.0, 200.0,10 );
        sqlSession.insert("insertEmp",emp);
    }

    @Test
    public void updateEmp(){
        Emp emp = new Emp();
        emp.setEmpno(7953);
        emp.setEname("黄咲明");
        sqlSession.update("updateEmp",emp);
    }

    @Test
    public void deleteEmp(){
        sqlSession.delete("deleteEmp",7955);
    }

    @After
    public void release() {
        sqlSession.close();
    }
}
