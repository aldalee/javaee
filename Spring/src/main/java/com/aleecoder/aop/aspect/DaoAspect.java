package com.aleecoder.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 切面类
 *
 * @author HuanyuLee
 * @date 2022/4/3
 */
@Aspect
@Component
//@Order(1)       // 手动设置代理对象的优先级，数字越小优先级越高
public class DaoAspect {

    // 定义一个公共切点 切点表达式直接指向接口
//    @Pointcut("execution(* com.aleecoder.aop.dao.UserDao.addUser(..))")
    @Pointcut("execution(* com.aleecoder.aop.dao.*.add*(..))")
    public void addPointCut() {
    }

    /**
     * 前置通知：切点方法执行之前先执行的功能
     *
     * @param joinPoint 封装了Spring AOP中切面方法的信息，在切面方法中添加JoinPoint参数，可以获得封装了该方法信息的JoinPoint对象
     */
    @Before("addPointCut()")
    public void methodBefore(JoinPoint joinPoint) {
        System.out.println("methodBefore invoked...");

        Object[] args = joinPoint.getArgs();    // userDao.addUser传入的实参

        System.out.println(Arrays.toString(args));
    }

    /**
     * 最终通知：切点方法无论是否出现异常，都会执行的方法
     */
    @After("addPointCut()")
    public void methodAfter() {
        System.out.println("methodAfter invoked...");
    }

    /**
     * 返回通知：在切点方法返回结果之后增强的功能
     * 切点方法如果出现异常，则不执行
     *
     * @param joinPoint 参数列表用JointPoint接收切点对象，获取方法执行的参数
     * @param res       返回值
     */
    @AfterReturning(value = "addPointCut()", returning = "res")
    public void methodAfterReturning(JoinPoint joinPoint, Object res) {
        System.out.println("methodAfterReturning invoked...");
        System.out.println("res = " + res);
    }

    /**
     * 异常通知：只有切点方法产生异常才执行，否则不执行
     *
     * @param exception 接收异常的对象
     */
    @AfterThrowing(value = "addPointCut()", throwing = "exception")
    public void methodAfterThrowing(Exception exception) {
        System.out.println("methodAfterThrowing invoked...");
        System.out.println(exception.getMessage());
    }

    /**
     * 环绕通知：切点方法之前和之后都进行功能的增强
     * 切点方法有异常也会执行；先于前置通知执行 → proceedingJoinPoint → 后于最终通知执行
     *
     * @param proceedingJoinPoint 代表切点 手动控制切点方法执行的位置
     * @return java.lang.Object 返回切点方法的返回值
     */
    @Around("addPointCut()")
    public Object methodAround(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("methodAround1 invoked...");
        Object res = null;
        // 控制切点方法在这里执行
        try {
            res = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("methodAround2 invoked...");
        System.out.println("res = " + res);
        return res;
    }
}
