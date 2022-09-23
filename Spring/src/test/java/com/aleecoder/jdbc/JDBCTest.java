package com.aleecoder.jdbc;

import com.aleecoder.jdbc.pojo.Dept;
import com.aleecoder.jdbc.pojo.Emp;
import com.aleecoder.jdbc.service.DeptService;
import com.aleecoder.jdbc.service.EmpService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author HuanyuLee
 * @date 2022/4/3
 */
public class JDBCTest {
    EmpService empService;
    DeptService deptService;

    @Before
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        empService = context.getBean(EmpService.class);
        deptService = context.getBean(DeptService.class);
    }


    //=======================CRUD=================================
    @Test
    public void findEmpCount() {
        // 查询员工个数
        int empCount = empService.findEmpCount();
        System.out.println(empCount);
    }

    @Test
    public void findByEmpno() {
        // 根据员工编号查询员工对象
        Emp byEmpno = empService.findByEmpno(7521);
        System.out.println(byEmpno);
    }

    @Test
    public void findByDeptno() {
        // 根据部门编号查询多个员工对象集合
        List<Emp> emps = empService.findByDeptno(20);
        emps.forEach(System.out::println);
    }

    @Test
    public void addEmp() {
        // 增加员工信息
        int rows = empService.addEmp(new Emp(null, "TOM", "SALESMAN", 7521, new Date(), 2000.0, 100.0, 10));
        System.out.println(rows);
    }

    @Test
    public void updateEmp() {
        // 根据员工编号修改员工信息
        int rows = empService.updateEmp(new Emp(7959, "JERRY", "MANAGER", 7839, new Date(), 3000.0, 0.0, 20));
        System.out.println(rows);
    }

    @Test
    public void deleteEmp() {
        // 根据员工编号删除员工信息
        int rows2 = empService.deleteEmp(7959);
        System.out.println(rows2);
    }


    //=======================Batch=================================

    @Test
    public void testBatchAdd() {
        List<Dept> depts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            depts.add(new Dept(null, "name" + i, "loc" + i));
        }
        int[] ints = deptService.deptBatchAdd(depts);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void testBatchUpdate() {
        List<Dept> depts = new ArrayList<>();
        for (int i = 114070; i <= 114079; i++) {
            depts.add(new Dept(i, "newname", "newLoc"));
        }
        int[] ints = deptService.deptBatchUpdate(depts);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void testBatchDelete() {
        List<Integer> deptnos = new ArrayList<>();
        for (int i = 114070; i <= 114079; i++) {
            deptnos.add(i);
        }
        int[] ints = deptService.deptBatchDelete(deptnos);
        System.out.println(Arrays.toString(ints));
    }
}
