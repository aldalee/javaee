package com.aleecoder.jdbc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author HuanyuLee
 * @date 2022/4/3
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dept implements Serializable {
    private Integer deptno;
    private String dname;
    private String loc;
}
