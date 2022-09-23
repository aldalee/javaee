package com.aleecoder.aop.proxy.test1;

/**
 * 测试代理模式
 * 静态代理
 * @author HuanyuLee
 * @date 2022/4/2
 */
public class StaticProxyTest {
    public static void main(String[] args) {
//        Court court = new Person("张三");
        Person person = new Person("张三");
        Court court = new Lawyer(person);
        court.doCourt();
    }
}

interface Court {
    void doCourt();
}
// 代理类 在被代理对象的基础上进行功能的扩充，而不必修改被代理类的任何代码
class Lawyer implements Court {
    private Person person;

    Lawyer() {
    }

    public Lawyer(Person person) {
        this.person = person;
    }

    @Override
    public void doCourt() {
        person.doCourt();
        // 功能的扩充
        System.out.println("律师取证：视频证明" + person.getName() + "当时正在旅游，不在案发现场......");
        System.out.println("律师总结：" + person.getName() + "不可能杀人。");
    }
}
// 被代理类
class Person implements Court {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void doCourt() {
        System.out.println(this.getName() + "说：我没有杀人......");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
