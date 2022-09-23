package com.aleecoder.mapper;

import com.aleecoder.pojo.Project;

/**
 * @author HuanyuLee
 * @date 2022/3/29
 */
public interface ProjectMapper {
    /**
     * 根据项目编号查询项目信息,以及参与到该项目之中的所有的员工信息
     * @param pid 项目编号
     * @return com.aleecoder.pojo.Project
     */
    Project findProjectJoinEmpsByPid(int pid);
}
