package com.aleecoder.mapper;

import com.aleecoder.pojo.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author HuanyuLee
 * @date 2022/3/26
 */
public interface DeptMapper {
    /**
     * 增加部门
     *
     * @param dept 部门对象
     * @return int 对数据库产生影响的行数
     */
    @Insert("insert into dept values (default,#{dname},#{loc})")
    int addDept(Dept dept);

    /**
     * 根据部门号查询部门信息及该部门的所有员工信息
     *
     * @param deptno 部门号
     * @return com.aleecoder.pojo.Dept
     */
    Dept findDeptJoinEmpsByDeptno(int deptno);

    /**
     * 根据部门编号查看部门信息
     *
     * @param deptno 部门编号
     * @return com.aleecoder.pojo.Dept
     */
    @Select("select * from dept where deptno = #{deptno}")
    Dept findByDeptno(int deptno);

    /**
     * 修改部门信息
     *
     * @param dept 部门对象
     * @return int 对数据库产生影响的行数
     */
    @Update("update dept set dname = #{dname},loc = #{loc} where deptno = #{deptno}")
    int updateDeptno(Dept dept);

}
