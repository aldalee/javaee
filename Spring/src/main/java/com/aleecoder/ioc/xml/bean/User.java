package com.aleecoder.ioc.xml.bean;

/**
 * @author HuanyuLee
 * @date 2022/3/30
 */
public class User {
    private Integer userId;
    private String name;
    private String password;

    public User() {
        System.out.println("NoArgConstructor");
    }

    public User(Integer userId, String name, String password) {
        System.out.println("AllArgConstructor");
        this.userId = userId;
        this.name = name;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
