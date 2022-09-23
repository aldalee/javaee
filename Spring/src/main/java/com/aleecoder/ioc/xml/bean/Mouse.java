package com.aleecoder.ioc.xml.bean;

import java.util.Date;

/**
 * @author HuanyuLee
 * @date 2022/3/30
 */
public class Mouse {
    private String name;
    private Date birthdate;

    public Mouse() {
    }

    public Mouse(String name, Date birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
