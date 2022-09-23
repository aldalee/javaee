package com.aleecoder.aop.proxy.test2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * JDK Proxy 在不修改原有代码的基础上进行功能的增强
 * @author HuanyuLee
 * @date 2022/4/2
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
//        Dinner dinner = new Person("张三");
        Dinner dinner = new Student("小明");

        // 通过Proxy动态代理获得代理对象，在代理对象中对某个方法进行增加
        // ClassLoader loader, 被代理对象的类加载器
        // Class<?>[] interfaces, 被代理对象所实现的所有接口
        // InvocationHandler h 执行处理器对象，专门用于定义增强的规则
        ClassLoader loader = dinner.getClass().getClassLoader();
        Class<?>[] interfaces = dinner.getClass().getInterfaces();
        InvocationHandler handler = new InvocationHandler() {
            /**
             * 策略模式
             * @param proxy 代理对象
             * @param method 被代理的方法、要增强的方法
             * @param args 被代理方法运行时的实参
             * @return java.lang.Object*/
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object res;
                if (method.getName().equals("eat")) {
                    // 功能增强
                    System.out.println("饭前洗手......");
                    res = method.invoke(dinner, args);
                    System.out.println("饭后刷碗......");
                } else {
                    // 使用原始功能
                    res = method.invoke(dinner, args);
                }
                return res;
            }
        };

        // 策略模式
        Dinner dinnerProxy = (Dinner) Proxy.newProxyInstance(loader, interfaces, handler);
        dinnerProxy.eat("包子");
        int n = dinnerProxy.drink("coffee");
    }
}


interface Dinner {
    void eat(String food);

    int drink(String water);
}

//
class Person implements Dinner {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void sleep(){
        // JDK Proxy 无法增强此方法
    }

    @Override
    public void eat(String food) {
        System.out.println(this.getName() + "正在公司吃" + food);
    }

    @Override
    public int drink(String water) {
        System.out.println(this.getName() + "正在公司喝" + water);
        return 2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Student implements Dinner {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void eat(String food) {
        System.out.println(this.getName() + "正在食堂吃" + food);
    }

    @Override
    public int drink(String water) {
        System.out.println(this.getName() + "正在食堂喝" + water);
        return 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
