package com.aleecoder.proxytest;

import com.aleecoder.mapper.EmpMapper;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HuanyuLee
 * @date 2022/3/27
 */
public class EmpTest {
    private SqlSession sqlSession;
    private EmpMapper empMapper;

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
        // 代理模式
        empMapper = sqlSession.getMapper(EmpMapper.class);
    }

    @Test
    public void findAll() {
        List<Emp> emps = empMapper.findAll();
        emps.forEach(System.out::println);
    }

    @Test
    public void findByEmpno() {
        Emp emp = empMapper.findByEmpno(7499);
        System.out.println(emp);
    }
    @Test
    public void findByEmpnos() {
        List<Emp> empnos = empMapper.findByEmpnos(new int[]{7521, 7839});
        empnos.forEach(System.out::println);

    }
    @Test
    public void findByDeptnoSal() {
        List<Emp> emps = empMapper.findByDeptnoSal(20, 3000.1);
        emps.forEach(System.out::println);
    }

    @Test
    public void findByDeptnoSal2() {
        Map<String, Object> map = new HashMap<>();
        map.put("deptno", 20);
        map.put("sal", 1500);
        List<Emp> emps = empMapper.findByDeptnoSal2(map);
        emps.forEach(System.out::println);
    }

    @Test
    public void findByDeptnoSal3() {
        Emp emp = new Emp();
        emp.setDeptno(20);
        emp.setSal(2000.0);
        List<Emp> emps = empMapper.findByDeptnoSal3(emp);
        emps.forEach(System.out::println);
    }

    @Test
    public void findByDeptnoSal4() {
        Emp emp1 = new Emp();
        Emp emp2 = new Emp();
        emp1.setDeptno(20);
        emp2.setSal(2000.0);
        List<Emp> emps = empMapper.findByDeptnoSal4(emp1, emp2);
        emps.forEach(System.out::println);
    }

    @Test
    public void findByEname() {
        List<Emp> emps = empMapper.findByEname("a");
        emps.forEach(System.out::println);
    }

    @Test
    public void addEmp() {
        Emp emp = new Emp(null, "按住啦Baby", "SALESMAN", 7839, new Date(), 3100.0, 200.0, 10);
        empMapper.addEmp(emp);
    }

    @Test
    public void updateEnameByEmpno() {
        empMapper.updateEnameByEmpno(7958, "炎龙侠");
    }

    @Test
    public void deleteByEmpno() {
        empMapper.deleteByEmpno(7958);
    }

    // =================================== 动态SQL ==========================================
    @Test
    public void findByCondition() throws ParseException {
        Emp emp = new Emp();
        emp.setEmpno(7521);
//        emp.setEname("a");
//        emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("2022-3-27"));
//        emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").format());
        List<Emp> emps = empMapper.findByCondition(emp);
        emps.forEach(System.out::println);
    }

    @Test
    public void updateByCondition() throws ParseException {
        Emp emp = new Emp();
        emp.setEmpno(7954);
        emp.setSal(10000.1);
        emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("1999-05-01"));
//        empMapper.updateByCondition(emp);
        empMapper.updateByCondition2(emp);
    }


    @Test
    public void findEmpJoinDeptByEmpno(){
        final Emp emp = empMapper.findEmpJoinDeptByEmpno(7499);
        System.out.println(emp);
    }

    @After
    public void release() {
        sqlSession.close();
    }
}
