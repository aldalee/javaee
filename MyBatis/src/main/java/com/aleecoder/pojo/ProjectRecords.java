package com.aleecoder.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ProjectRecords 项目记录实体类
 * @author HuanyuLee
 * @date 2022/3/29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRecords implements Serializable {
    private Integer empno;
    private Integer pid;
    private Emp emp;
}
