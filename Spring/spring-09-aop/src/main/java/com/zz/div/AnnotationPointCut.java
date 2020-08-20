package com.zz.div;

//使用注解实现AOP

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//标注这个类是一个切面
@Aspect
public class AnnotationPointCut {
    @Before("execution(* com.zz.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("=======before======");
    }
    @After("execution(* com.zz.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("=======after======");
    }
    //在环绕增强中，我们可以给定一个参数，代表要获取处理切入的点
    @Around("execution(* com.zz.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前");

        Signature signature = joinPoint.getSignature();
        System.out.println(signature);
        //执行方法
        Object proceed = joinPoint.proceed();
        System.out.println("环绕后");
    }
}
