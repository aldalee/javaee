package com.aleecoder.ioc.xml.bean;

/**
 * @author HuanyuLee
 * @date 2022/3/31
 */
public class Emp {
    private Dept dept;

    public Emp() {
    }

    public Emp(Dept dept) {
        this.dept = dept;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                '}';
    }
}
