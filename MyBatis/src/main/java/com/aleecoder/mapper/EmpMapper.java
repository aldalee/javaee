package com.aleecoder.mapper;

import com.aleecoder.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * MyBatis代理模式开发、动态SQL
 * @author HuanyuLee
 * @date 2022/3/26
 */
public interface EmpMapper {
    /**
     * 查询全部员工的信息
     *
     * @return java.util.List<com.aleecoder.pojo.Emp> 全部员工信息封装的Emp对象的List集合
     */
    List<Emp> findAll();

    /**
     * 根据员工编号查询单个员工的信息
     *
     * @param empno 员工编号
     * @return com.aleecoder.pojo.Emp 单个员工信息封装的Emp对象
     */
    Emp findByEmpno(int empno);

    /**
     * 根据多个员工编号查询多个员工的信息
     * @param empnos 员工编号的数组
     * @return java.util.List<com.aleecoder.pojo.Emp> 多个员工信息封装的Emp对象集合
     */
    List<Emp> findByEmpnos(int[] empnos);

    /**
     * 根据部门编号和薪资下限查询员工信息
     *
     * @param deptno 员工编号
     * @param sal    薪资下限
     * @return java.util.List<com.aleecoder.pojo.Emp> 多个Emp对象的List集合
     */
    List<Emp> findByDeptnoSal(@Param("deptno") int deptno, @Param("sal") double sal);

    /**
     * 根据部门编号和薪资下限查询员工信息
     *
     * @param map map参数
     * @return java.util.List<com.aleecoder.pojo.Emp>
     */
    List<Emp> findByDeptnoSal2(Map<String, Object> map);

    /**
     * 根据部门编号和薪资下限查询员工信息
     *
     * @param emp 对象
     * @return java.util.List<com.aleecoder.pojo.Emp>
     */
    List<Emp> findByDeptnoSal3(Emp emp);

    /**
     * 根据部门编号和薪资下限查询员工信息
     *
     * @param emp1 对象1
     * @param emp2 对象2
     * @return java.util.List<com.aleecoder.pojo.Emp>
     */
    List<Emp> findByDeptnoSal4(@Param("emp1") Emp emp1, @Param("emp2") Emp emp2);

    /**
     * 根据员工名字模糊匹配多个员工信息
     *
     * @param name 员工名字片段
     * @return java.util.List<com.aleecoder.pojo.Emp> 多个员工对象集合
     */
    List<Emp> findByEname(String name);

    /**
     * 增加员工信息
     *
     * @param emp 员工对象
     * @return int 对数据库产生影响的行数
     */
    int addEmp(Emp emp);

    /**
     * 根据员工编号更新员工姓名
     *
     * @param empno 员工编号
     * @param ename 员工姓名
     * @return int 对数据库产生影响的行数
     */
    int updateEnameByEmpno(@Param("empno") int empno, @Param("ename") String ename);

    /**
     * 根据员工编号删除单个员工
     *
     * @param empno 员工编号
     * @return int 对数据库产生影响的行数
     */
    int deleteByEmpno(int empno);

    /** ============================ 动态SQL ==================================*/

    /**
     * 根据条件进行查询
     * @param emp Emp对象
     * @return java.util.List<com.aleecoder.pojo.Emp>
     */
    List<Emp> findByCondition(Emp emp);


    /**
     * 根据条件跟心员工信息
     * @param emp Emp对象
     * @return int 对数据库产生影响的行数
     */
    int updateByCondition(Emp emp);
    /**
     * 根据条件跟心员工信息
     * @param emp Emp对象
     * @return int 对数据库产生影响的行数
     */
    int updateByCondition2(Emp emp);

    /**
     * 根据员工编号查询员工信息及所在的部门信息
     * @param empno 员工编号
     * @return com.aleecoder.pojo.Emp 员工对象
     */
    Emp findEmpJoinDeptByEmpno(int empno);
}
