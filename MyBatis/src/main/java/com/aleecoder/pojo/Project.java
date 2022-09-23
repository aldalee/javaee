package com.aleecoder.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Project项目实体类
 * @author HuanyuLee
 * @date 2022/3/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project implements Serializable {
    private Integer pid;
    private String pname;
    private Integer money;
    private List<ProjectRecords> projectRecords;


    public String show() {
        return "Project{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", money=" + money +
                '}';
    }
}
