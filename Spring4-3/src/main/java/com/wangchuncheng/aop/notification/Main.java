package com.wangchuncheng.aop.notification;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
        ArithmeticCalculator calculator = ctx.getBean(ArithmeticCalculator.class);

        int result = calculator.add(56, 34);
        System.out.println(result);
    }
}
