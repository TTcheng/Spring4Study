package com.wangchuncheng.spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//把这个类声明为一个切面：先放到IOC容器中，再声明为一个切面
@Aspect
@Component
public class LoggingAspect {
    //前置通知：在目标方法开始之前执行
    @Before("execution(public int ArithmeticCalculator.*(int ,int ))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method "
                + methodName
                + " begins with "
                + args);
    }

    //前置通知：在目标方法结束之时执行
    @After("execution(public int ArithmeticCalculator.*(int,int))")
    public void afterMethod(JoinPoint joinPoint) {

        System.out.println("The method "
                + joinPoint.getSignature().getName()
                + " ended");
    }

}
