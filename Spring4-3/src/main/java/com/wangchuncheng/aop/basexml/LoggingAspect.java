package com.wangchuncheng.aop.basexml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

public class LoggingAspect {
//    @Pointcut("execution(public int com.wangchuncheng.aop.basexml.ArithmeticCalculator.*(..))")
    public void declareJointPointExpression() {
    }

//    @Before("declareJointPointExpression()")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("The method "
                + joinPoint.getSignature().getName()
                + " begins with "
                + Arrays.asList(joinPoint.getArgs()));
    }

//    @After("declareJointPointExpression()")
    public void afterMethod(JoinPoint joinPoint) {
        System.out.println("The method " + joinPoint.getSignature().getName() + " ends");
    }

//    @AfterReturning(value = "declareJointPointExpression()", returning = "result")
    public void afterRunningMethod(JoinPoint joinPoint, Object result) {
        System.out.println("The method " + joinPoint.getSignature().getName() + " returns with " + result);
    }

//    @AfterThrowing(value = "declareJointPointExpression()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        System.out.println("The method " + joinPoint.getSignature().getName() + " throws " + e.getStackTrace());
    }

    /**
     * 环绕通知需要携带 ProceedingJoinPoint 类型的参数.
     * 环绕通知类似于动态代理的全过程: ProceedingJoinPoint 类型的参数可以决定是否执行目标方法.
     * 且环绕通知必须有返回值, 返回值即为目标方法的返回值
     */
//    @Around("declareJointPointExpression()")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        String methodName = proceedingJoinPoint.getSignature().getName();

        try {
            //前置通知
            System.out.println("The method " + methodName + " begins with " + Arrays.asList(proceedingJoinPoint.getArgs()));
            //执行目标方法
            result = proceedingJoinPoint.proceed();
            //返回通知
            System.out.println("The method " + methodName + " ends with " + result);
        } catch (Throwable e) {
            //异常通知
            System.out.println("The method " + methodName + " occurs exception:" + e);
            throw new RuntimeException(e);
        }
        //后置通知
        System.out.println("The method " + methodName + " ends");
        return result;
    }
}
