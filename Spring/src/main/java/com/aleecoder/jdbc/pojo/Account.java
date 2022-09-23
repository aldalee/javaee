package com.aleecoder.jdbc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author HuanyuLee
 * @date 2022/4/4
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {
    private Integer aid;
    private String username;
    private String password;
    private Integer money;
}
