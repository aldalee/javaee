package com.aleecoder.aop.proxy.test3;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib Proxy 在不修改原有代码的基础上进行功能的增强
 * @author HuanyuLee
 * @date 2022/4/2
 */
public class DynamicProxyTest {
    @Test
    public void testCglib(){
        Person person = new Person();

        // 获取Person的代理对象
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(person.getClass());
        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            /**
             * 策略模式
             * @param o 生成之后的代理对象
             * @param method 父类中原本要执行的方法
             * @param objects 方法在调用时传入的实参数组
             * @param methodProxy 子类中重写父类的方法
             * @return java.lang.Object
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object res;
                if (method.getName().equals("eat")){
                    // 功能增强
                    System.out.println("洗手");
                    res = methodProxy.invokeSuper(o,objects);
                    System.out.println("饭后刷碗");
                }else {
                    // 正常运行其他方法
                    res = methodProxy.invokeSuper(o,objects);
                }
                return res;
            }
        };
        // 设置回调
        enhancer.setCallback(methodInterceptor);
        Person personProxy = (Person) enhancer.create();
        personProxy.setName("张三");
        personProxy.eat("烤冷面");
    }
}

class Person {
    private String name;
    // cglib 底层反射调用无参构造方法，因此必须实现！
    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void sleep(){

    }

    public void eat(String food) {
        System.out.println(this.getName() + "正在公司吃" + food);
    }

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

class Son extends Person{

    public Son(String name) {
        super(name);
    }
    @Override
    public void eat(String food){
        System.out.println("洗手");
        super.eat(food);
    }
}
