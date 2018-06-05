package com.wangchuncheng.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ArithmeticCalculator calculator =  ctx.getBean(ArithmeticCalculator.class);
        ArithmeticCalculator calculator =  ctx.getBean(ArithmeticCalculator.class);

        int result = calculator.add(3, 6);
        System.out.println(result);

        result = calculator.mul(2,3);
        System.out.println(result);
    }

}
